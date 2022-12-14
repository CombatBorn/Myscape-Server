package gg.rsmod.plugins.content.cmd.commands.developer

import gg.rsmod.game.model.priv.Privilege
import gg.rsmod.game.model.slayer.SlayerTaskType

on_command("sasnpc", Privilege.DEV_POWER, "Spawns all Slayer npcs in the ocean") {
    var x = 1921
    var z = 3774
    var tile = Tile(x, z)
    player.moveTo(tile = tile)
//    for (masterID in world.slayerMasters.keys) {
    for (masterID in listOf(403, 3578, 7483, 2989, 3844, 3995, 3541, 5840, 3515, 6025, 2460)) {
        player.message("Slayer Master `$masterID`")
//        for (taskType in world.slayerMasters[masterID]?.keys!!) {
        for (taskType in listOf(SlayerTaskType.EASY, SlayerTaskType.MEDIUM, SlayerTaskType.HARD, SlayerTaskType.BOSS,
            SlayerTaskType.WILDERNESS, SlayerTaskType.HEROISM, SlayerTaskType.CORRUPTION)) {
            if (world.slayerMasters[masterID]?.containsKey(taskType) == false){
                continue
            }
            player.message(" Task Type: `$taskType`")
            for (task in world.slayerMasters[masterID]?.get(taskType)?.tasks!!) {
                world.spawn(Npc(masterID, Tile(x, z), world))
                z -= 4
                if (task.superiorId != -1){
                    world.spawn(Npc(task.superiorId, Tile(x, z), world))
                }
                z -= 4
                for (monsterId in task.npcIds!!) {
                    world.spawn(Npc(monsterId, Tile(x, z), world))
                    z -= 2
                }
                z = 3774
                x += 2
            }
            x += 2
        }
    }
}