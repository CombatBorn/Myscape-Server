package gg.rsmod.plugins.content.cmd.commands.developer

import gg.rsmod.game.model.priv.Privilege

on_command("spawnallslayernpcs", Privilege.DEV_POWER, "Spawns all Slayer npcs at a specific tile") {
    var x = 1921
    var z = 3774
    var tile = Tile(x, z)
    player.moveTo(tile = tile)
    for (masterID in world.slayerMasters.keys) {
        player.message("Spawning NPCs for Slayer Master `$masterID`")
        for (taskType in world.slayerMasters[masterID]?.keys!!) {
            player.message(" Task Type: `$taskType`")
            for (task in world.slayerMasters[masterID]?.get(taskType)?.tasks!!) {
                if (task.superiorId != -1){
                    world.spawn(Npc(task.superiorId, Tile(x, z), world))
                    z -= 3
                }
                for (monsterId in task.npcIds!!) {
                    world.spawn(Npc(monsterId, Tile(x, z), world))
                    z -= 2
                }
                z = 3774
                x += 2
            }
        }
    }
}