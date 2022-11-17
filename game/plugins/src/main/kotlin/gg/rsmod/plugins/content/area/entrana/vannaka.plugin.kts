import gg.rsmod.game.model.priv.Privilege

spawn_npc(Npcs.VANNAKA, 2848, 3341, 0, 2)

val lastInterface: HashMap<String, Int> = HashMap()

on_npc_option(Npcs.VANNAKA,"Talk-to"){
    if (!lastInterface.containsKey(player.username)) lastInterface[player.username] = 0
    val found = lastInterface[player.username]
    if (found != null) {
        player.closeInterface(found)
        lastInterface[player.username] = found + 1
    }
    lastInterface[player.username]?.let { player.openInterface(it, InterfaceDestination.OVERLAY) }
    player.message("Opening interface <col=801700>${lastInterface[player.username]}</col>")
}
on_npc_option(Npcs.VANNAKA,"Assignment"){
    player.queue {
        chatNpc("You have been assigned to kill x${(Math.random() * 20 + 30).toInt()} ${world.definitions.get(NpcDef::class.java,(Math.random() * 8000).toInt()).name}", Npcs.VANNAKA)
    }
}
on_npc_option(Npcs.VANNAKA,"Trade"){
    player.queue {
        chatNpc("I see you wanna look at my goodies? ;)", Npcs.VANNAKA)
        chatPlayer("Yes daddy.")
        player.openInterface(parent = 161, child = 16, interfaceId = 426, isModal = true)
    }
}
on_command("close", Privilege.DEV_POWER, description = "Close last opened interface") {
    val found = lastInterface[player.username]
    if (found != null) {
        player.closeInterface(found)
    }
}