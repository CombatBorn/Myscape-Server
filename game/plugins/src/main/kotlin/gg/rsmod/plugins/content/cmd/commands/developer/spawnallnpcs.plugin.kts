package gg.rsmod.plugins.content.cmd.commands.developer

import gg.rsmod.game.model.attr.NO_CLIP_ATTR
import gg.rsmod.game.model.priv.Privilege

on_command("spawnallnpcs", Privilege.DEV_POWER, "Spawns all npcs at a specific tile") {
    var id = 0
    var x = 1921
    var z = 3774
    var tile = Tile(x, z)
    player.attr[NO_CLIP_ATTR] = true
    player.moveTo(tile = tile)
    while (world.definitions.contains(NpcDef::class.java,id)) {
        tile = Tile(x, z)
        val npc = Npc(id, tile, world)
        world.spawn(npc)
        x += 2
        if (x == 2123) {
            x = 1921
            z -= 2
        }
        id++
    }
    player.message("Noclip enabled. Spawned $id Npcs.")
}

on_command("tpnpc", Privilege.DEV_POWER, "Teleport to a specific NPC from all Npcs.") {
    if (player.getCommandArgs().isEmpty()) {
        player.message("Invalid usage! Try ::TpToNpc 1")
        return@on_command
    }
    val id = player.getCommandArgs()[0].toInt()
    if (!world.definitions.contains(NpcDef::class.java, id)) {
        player.message("This Npc doesn't exist (#$id).")
        return@on_command
    }
    if (!world.definitions.get(NpcDef::class.java, id).render) {
        player.message("This NPC does not render.")
    }
    player.moveTo(getNpcPos(id))
}

fun getNpcPos(npc: Int): Tile {
    val x: Int = 1921 + (npc - (npc / 100).toInt() * 100) * 2
    val z: Int = 3774 - (npc / 100).toInt() * 2
    return Tile(x, z, 0)
}