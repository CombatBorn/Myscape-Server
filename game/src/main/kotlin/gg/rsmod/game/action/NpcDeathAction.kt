package gg.rsmod.game.action

import gg.rsmod.game.fs.def.AnimDef
import gg.rsmod.game.fs.def.ItemDef
import gg.rsmod.game.model.LockState
import gg.rsmod.game.model.Tile
import gg.rsmod.game.model.attr.KILLER_ATTR
import gg.rsmod.game.model.container.ContainerStackType
import gg.rsmod.game.model.container.ItemContainer
import gg.rsmod.game.model.container.key.ContainerKey
import gg.rsmod.game.model.droptable.DropTableItem
import gg.rsmod.game.model.entity.GroundItem
import gg.rsmod.game.model.entity.Npc
import gg.rsmod.game.model.entity.Player
import gg.rsmod.game.model.item.Item
import gg.rsmod.game.model.queue.QueueTask
import gg.rsmod.game.model.queue.TaskPriority
import gg.rsmod.game.plugin.Plugin
import gg.rsmod.game.service.log.LoggerService
import java.lang.ref.WeakReference

/**
 * This class is responsible for handling npc death events.
 *
 * @author Tom <rspsmods@gmail.com>
 */
object NpcDeathAction {

    val deathPlugin: Plugin.() -> Unit = {
        val npc = ctx as Npc

        npc.interruptQueues()
        npc.stopMovement()
        npc.lock()

        npc.queue(TaskPriority.STRONG) {
            death(npc)
        }
    }

    suspend fun QueueTask.death(npc: Npc) {
        val world = npc.world
        val deathAnimation = npc.combatDef.deathAnimation
        val respawnDelay = npc.combatDef.respawnDelay

        var player: Player? = null

        npc.damageMap.getMostDamage()?.let { killer ->
            if (killer is Player) {
                player = killer
                world.getService(LoggerService::class.java, searchSubclasses = true)?.logNpcKill(killer, npc)
            }
            npc.attr[KILLER_ATTR] = WeakReference(killer)
        }

        world.plugins.executeNpcPreDeath(npc)

        npc.resetFacePawn()

        deathAnimation.forEach { anim ->
            val def = npc.world.definitions.get(AnimDef::class.java, anim)
            npc.animate(def.id)
            wait(def.cycleLength + 1)
        }

        if (player != null) {
            player!!.writeMessage("You have killed a ${npc.name}.")
            dropNpcLoot(player!!, npc)
            val slayerTask = player!!.slayerTask
            if (slayerTask != null && slayerTask.isSlayerTarget(npc)) {
                slayerTask.defeatedTaskMonster(npc, player!!)
            }
        }

        npc.animate(-1)
        world.plugins.executeNpcDeath(npc)
        if (npc.respawns) {
            npc.invisible = true
            npc.reset()
            wait(respawnDelay)
            npc.invisible = false
            world.plugins.executeNpcSpawn(npc)
        } else {
            world.remove(npc)
        }
    }

    private fun dropNpcLoot(player: Player, npc: Npc) {
        val drops = npc.world.plugins.npcDropTableDefs[npc.id]?.generateDrops()
        // put all drops into one stack
        val condensedDrops = condenseDrops(drops)
        for (item in condensedDrops.keys) {
            var amount = condensedDrops[item]
            if (amount == null || amount == 0) {
                return
            }
            var location = "ground"
            if (item == 995 && player.equipment.hasAt(12, 20017)) {
                amount *= 2
                location = "inventory"
            }
            if (location == "bank") {
                val transaction = player.bank.add(item, amount)
                if (transaction.hasSucceeded()) {
                    player.writeMessage("x$amount ${ItemDef(item).name} was sent to your bank.")
                    return
                }
            }
            if (location == "inventory") {
                val transaction = player.inventory.add(item, amount)
                if (transaction.hasSucceeded()) {
                    player.writeMessage("x$amount ${ItemDef(item).name} was sent to your inventory.")
                    return
                }
            }
            if (location == "looting bag") {
                val containerKey = ContainerKey("looting_bag", capacity = 28, stackType = ContainerStackType.NORMAL)
                val container = player.containers.computeIfAbsent(containerKey) {
                    ItemContainer(
                        player.world.definitions,
                        containerKey
                    )
                }
                val transferred = player.inventory.transfer(
                    container,
                    item = Item(item, amount).copyAttr(Item(item)),
                    fromSlot = -1
                )?.completed ?: 0
                if (transferred > 0) {
                    return
                }
            }
            // all other possibilities failed, drop on floor
            npc.world.spawn(
                GroundItem(
                    item,
                    amount = amount,
                    tile = Tile(npc.tile),
                    owner = player
                )
            )
        }
    }

    private fun condenseDrops(drops: ArrayList<DropTableItem>?): HashMap<Int, Int> {
        val condensedDrops: HashMap<Int, Int> = HashMap()
        if (drops == null) {
            return condensedDrops
        }
        drops.forEach { drop ->
            if (condensedDrops.containsKey(drop.id)) {
                condensedDrops[drop.id] = condensedDrops[drop.id]!! + drop.randomQuantity()
            } else {
                condensedDrops[drop.id] = drop.randomQuantity()
            }
        }
        return condensedDrops
    }

    private fun Npc.reset() {
        catchable = false
        lock = LockState.NONE
        tile = spawnTile
        setTransmogId(-1)

        damageMap.clear()
        attr.clear()
        timers.clear()
        world.setNpcDefaults(this)
    }
}