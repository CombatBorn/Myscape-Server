import gg.rsmod.game.model.priv.Privilege

spawn_npc(Npcs.NIPPER, 2847, 3335)

val lastInterface: HashMap<String, Int> = HashMap()
on_npc_option(Npcs.NIPPER, "Talk-to") {
    if (!lastInterface.containsKey(player.username)) lastInterface[player.username] = 0
    val found = lastInterface[player.username]
    if (found != null) {
        player.closeInterface(found)
        lastInterface[player.username] = found + 1
    }
    lastInterface[player.username]?.let { player.openInterface(it, InterfaceDestination.OVERLAY) }
    player.message("Opening interface <col=801700>${lastInterface[player.username]}</col>")
}

on_command("close", Privilege.DEV_POWER, description = "Close last opened interface") {
    val found = lastInterface[player.username]
    if (found != null) {
        player.closeInterface(found)
    }
}