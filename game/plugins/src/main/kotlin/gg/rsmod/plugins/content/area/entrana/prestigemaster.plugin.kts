spawn_npc(Npcs.PRESTIGE_MASTER, 2853, 3340, 0, 0)


on_npc_option(Npcs.PRESTIGE_MASTER, "Talk-to") {
//on_npc_option(Npcs.PRESTIGE_MASTER, "Prestige-info") {
    player.runClientScript(
        30004,
        player.getPrestigeSpriteId(0), player.getPrestigeSpriteId(2), player.getPrestigeSpriteId(1), player.getPrestigeSpriteId(4),
        player.getPrestigeSpriteId(5), player.getPrestigeSpriteId(6), player.getPrestigeSpriteId(3), player.getPrestigeSpriteId(16),
        player.getPrestigeSpriteId(15), player.getPrestigeSpriteId(17), player.getPrestigeSpriteId(12), player.getPrestigeSpriteId(9),
        player.getPrestigeSpriteId(14), player.getPrestigeSpriteId(13), player.getPrestigeSpriteId(10), player.getPrestigeSpriteId(7),
        player.getPrestigeSpriteId(11), player.getPrestigeSpriteId(8), player.getPrestigeSpriteId(20), player.getPrestigeSpriteId(18),
        player.getPrestigeSpriteId(19), player.getPrestigeSpriteId(21), player.getPrestigeSpriteId(22)
    )
    player.openInterface(interfaceId = 5001, InterfaceDestination.MAIN_SCREEN)
}
