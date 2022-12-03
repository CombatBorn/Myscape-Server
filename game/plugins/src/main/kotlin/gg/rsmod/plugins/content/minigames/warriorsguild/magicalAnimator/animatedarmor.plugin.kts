import gg.rsmod.game.model.droptable.DropTableItem
import gg.rsmod.plugins.content.minigames.warriorsguild.magicalAnimator.AnimatedArmorSet

private val MAGICAL_ANIMATOR = 23955

private val WARRIOR_GUILD_TOKENS = Items.WARRIOR_GUILD_TOKEN


AnimatedArmorSet.values().forEach { animatedArmorSet ->
    // animated armor drop tables
    val armorSet: ArrayList<DropTableItem> = ArrayList()
    armorSet.add(DropTableItem(WARRIOR_GUILD_TOKENS, animatedArmorSet.tokens))

    // use any armor piece on the magical animator
    animatedArmorSet.armor().forEach{ armor ->
        armorSet.add(DropTableItem(armor))
        on_item_on_obj(MAGICAL_ANIMATOR, armor) {
            activateMagicalAnimator(player, animatedArmorSet, player.getInteractingGameObj())
        }
    }
    add_npc_drop_table(npc = animatedArmorSet.npc, table = 0, items = armorSet.toList())
}

// activate the magical animator
on_obj_option(MAGICAL_ANIMATOR, "Animate") {
    val armorSet = findArmorSet(player)
    if (armorSet == null){
        player.message("You need a set of armor in your inventory to use this animator.")
        return@on_obj_option
    }
    activateMagicalAnimator(player, armorSet, player.getInteractingGameObj())
}

// search player's inventory for any armor sets
fun findArmorSet(player: Player): AnimatedArmorSet? {
    for (animatedArmorSet in AnimatedArmorSet.values()){
        var count = 0
        for (armor in animatedArmorSet.armor()){
            if (!player.inventory.contains(armor)) break
            count++
        }
        if (count == 3){ return animatedArmorSet }
    }
    return null
}

// attempt to spawn in an animated armor set
fun activateMagicalAnimator(player: Player, armorSet: AnimatedArmorSet, gameObject: GameObject) {
    val sacrificed = sacrificeArmorSet(player, armorSet)
    if (!sacrificed) {
        player.message("You need a set of armour in your inventory to use this animator.")
        return
    }
    player.queue(TaskPriority.STRONG) {
        player.lock()
        player.animate(Animation.BEND_TO_FLOOR)
        messageBox("You place your armour on the platform where it disappears....", continues = true)
        wait(5)
        messageBox("The animator hums, something appears to be working. You stand back...", continues = true)
        player.walkTo(tile = Tile(x = gameObject.tile.x, z = gameObject.tile.z + 4), stepType = MovementQueue.StepType.FORCED_WALK)
        wait(5)
        player.closeComponent(parent = 162, child = CHATBOX_CHILD)
        val npc = Npc(id = armorSet.npc, tile = gameObject.tile, world = world)
        npc.attackers.add(player)
        world.spawn(npc = npc)
        npc.respawns = false
        npc.animate(4166)
        npc.forceChat(message = "I'm ALIVE!")
        npc.walkTo(x = gameObject.tile.x, z = gameObject.tile.z + 3, stepType = MovementQueue.StepType.FORCED_WALK, detectCollision = false)
        wait(1)
        npc.attack(player)
        player.unlock()
    }
}

// remove armor from inventory
fun sacrificeArmorSet(player: Player, armorSet: AnimatedArmorSet): Boolean {
    for (item in armorSet.armor()){
        if (!player.inventory.contains(item)) return false
    }
    for (armor in armorSet.armor()){
        player.inventory.remove(armor,1)
    }
    return true
}