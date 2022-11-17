package gg.rsmod.plugins.content.cmd.commands.developer

import gg.rsmod.game.model.priv.Privilege

on_command("spawnallnpcs", Privilege.DEV_POWER, "Spawns all npcs at a specific tile") {
    var x = 1921
    var z = 3774
    var tile = Tile(x, z)
    player.moveTo(tile = tile)
    for (id in 1..10000) {
        if (!world.definitions.contains(NpcDef::class.java,id)) break
        tile = Tile(x, z)
        val npc = Npc(id, tile, world)
        world.spawn(npc)
        x += 2
        if (x == 2123) {
            x = 1921
            z -= 2
        }
    }
}