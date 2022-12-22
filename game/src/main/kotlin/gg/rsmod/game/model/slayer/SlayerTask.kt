package gg.rsmod.game.model.slayer

import gg.rsmod.game.fs.def.NpcDef
import gg.rsmod.game.model.entity.Npc
import gg.rsmod.game.model.entity.Player

/**
 * [SlayerTask]s are given by [SlayerMaster]s for [Player]s to complete randomly
 * assigned [Assignments]s.
 * @param slayerMaster The Slayer Master who gave the task.
 * @param assignment The assigned NPC to kill.
 */
class SlayerTask(val slayerMaster: SlayerMaster, val assignment: Assignments, val type: SlayerTaskType) {

    /**
     * The amount of NPCs needed to be killed to complete the [SlayerTask].
     */
    var remaining = assignment.randomAmount()

    /**
     * The amount of times the player has extended the [SlayerTask].
     */
    var extended = 0

    fun extend(): Boolean {
        if (extended == 1) return false
        remaining += assignment.randomAmount()
        extended += 1
        return true
    }

    /**
     * This occurs when an assigned [Assignments] has been defeated.
     */
    fun defeatedTaskMonster(npc: Npc, player: Player) {
        player.addXp(18, npc.combatDef.hitpoints.toDouble())
        remaining -= 1
        if (remaining % 5 == 0) player.writeMessage("You have x${remaining} ${assignment.taskName} remaining.")
        if (player.world.random(150) == 1) summonSuperior(npc, player)
        if (remaining <= 0){
            slayerTaskCompleted(player)
        }
    }

    /**
     * The total [remaining] NPCs have been defeated.
     */
    fun slayerTaskCompleted(player: Player) {
        player.slayerStreak += 1
        player.writeMessage("You're now on a ${player.slayerStreak} Slayer Task Streak.")
        giveTaskRewards(player)
        player.slayerTask = null
    }

    /**
     * Rewards given to the player for completing the [SlayerTask].
     */
    fun giveTaskRewards(player: Player) {
        var slayerPoints = 0
        var corruptionSigils = 0
        var heroismSigils = 0
        when(type) {
            SlayerTaskType.EASY -> { slayerPoints = 5 }
            SlayerTaskType.MEDIUM -> { slayerPoints = 10 }
            SlayerTaskType.HARD -> { slayerPoints = 15 }
            SlayerTaskType.BOSS -> { slayerPoints = 25 }
            SlayerTaskType.HEROISM -> { slayerPoints = 10; heroismSigils = slayerMaster.rank * 20 }
            SlayerTaskType.CORRUPTION -> { slayerPoints = 10; corruptionSigils = slayerMaster.rank * 20 }
            SlayerTaskType.WILDERNESS -> { slayerPoints = 35 }
        }

        when (0) {
            player.slayerStreak % 100 -> slayerPoints *= 25
            player.slayerStreak % 50 -> slayerPoints *= 15
            player.slayerStreak % 25 -> slayerPoints *= 8
            player.slayerStreak % 10 -> slayerPoints *= 3
        }

        player.virtualWallet.addSlayerPoints(slayerPoints)
        player.writeMessage("You earned $slayerPoints from your Slayer Task.")
        // TODO: Add physical currencies (Heroism Sigils and Corruption Sigils).
    }

    /**
     * The odds of a superior spawning are currently 1/150. In the future this will scale depending
     * on the killed NPC's maximum health.
     */
    fun summonSuperior(npc: Npc, player: Player) {
        val superiorId = assignment.superiorId
        if (superiorId == -1){
            return
        }
        val superiorName = player.world.definitions.get(NpcDef::class.java, superiorId).name
        val location = npc.tile
        // TODO: Check if player has superiors unlocked.
        // TODO: Spawn a NPC that only the player can kill.
        if (type == SlayerTaskType.BOSS) {
            player.world.announce("A $superiorName superior NPC has spawned for ${player.username}!")
        }
        player.writeMessage("A $superiorName superior NPC has spawned for you!")
    }

    fun isSlayerTarget(npc: Npc): Boolean {
        return assignment.npcIds.contains(npc.id)
    }

}