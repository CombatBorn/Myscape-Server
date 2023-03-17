package gg.rsmod.plugins.content.minigames.warriorsguild

/**
 * This is the woman found on the top floor of the Warriors' Guild
 */
val KAMFREENA = Npcs.KAMFREENA
private val WARRIOR_GUILD_TOKENS = Items.WARRIOR_GUILD_TOKEN
private val KICKED_OUT_TILE = Tile(2844, 3540, 2)

val WARRIOR_GUILD_CYCLOPS_ROOM = TimerKey()

spawn_npc(KAMFREENA, Tile(2845, 3539, 2))

on_npc_option(KAMFREENA, "talk-to") {
    player.queue {
        chatNpc("Welcome to the top floor of the Warriors' Guild.", KAMFREENA)
        doubleItemMessageBox(
            "You can earn any defender on this floor as long as you have a defender with you.",
            item1 = Items.RUNE_DEFENDER,
            item2 = Items.DRAGON_DEFENDER
        )
        chatNpc("You need 100 Warrior Guild Tokens to fight my cyclops.")
    }
}

//

listOf(24306, 24309).forEach {
    on_obj_option(it, "Open") {
        if (player.tile.height != 2) {
            return@on_obj_option
        }
        // enter door
        if (player.tile.x == 2846) {
            player.queue {
                if (this.player.inventory.getItemCount(Items.WARRIOR_GUILD_TOKEN) >= 100) {
                    player.message("You pass the doors.")
                    payCyclopsRoomFee(player)
                    player.moveTo(x = player.tile.x + 1, z = player.tile.z, height = 2)
                    player.inWarriorGuildCyclopsRoom = true
                    player.timers[WARRIOR_GUILD_CYCLOPS_ROOM] = 100
                } else {
                    messageBox("You need 100 Warrior Guild Tokens to pass this door.")
                }
            }
        }
        // exit door
        else {
            player.moveTo(x = player.tile.x - 1, z = player.tile.z, height = 2)
            player.inWarriorGuildCyclopsRoom = false
        }
    }
}

on_timer(WARRIOR_GUILD_CYCLOPS_ROOM) {
    if (player.inWarriorGuildCyclopsRoom && payCyclopsRoomFee(player)){
        player.timers[WARRIOR_GUILD_CYCLOPS_ROOM] = 100
    }
}

fun payCyclopsRoomFee(player: Player): Boolean {
    if (!player.isOnline) {
        return false
    }
    if (!player.inWarriorGuildCyclopsRoom) {
        return false
    }
    val removed = player.inventory.remove(Items.WARRIOR_GUILD_TOKEN, 10).completed
    player.message("Some of your Warrior Guild Tokens crumbled..")
    return if (removed < 10) {
        kickOutOfCyclopsRoom(player)
        false
    }else{
        true
    }
}

on_logout {
    if (player.inWarriorGuildCyclopsRoom) {
        kickOutOfCyclopsRoom(player)
    }
}

fun kickOutOfCyclopsRoom(player: Player) {
    player.inWarriorGuildCyclopsRoom = false
    player.moveTo(KICKED_OUT_TILE)
    if (player.isOnline) {
        player.queue { messageBox("You were removed from the Cyclops room.") }
    }
}