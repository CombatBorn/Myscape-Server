package gg.rsmod.plugins.content.cmd.commands.developer

import gg.rsmod.game.model.priv.Privilege
import gg.rsmod.game.model.slayer.SlayerDef
import gg.rsmod.game.model.slayer.SlayerTaskType

on_command("sasnpc", Privilege.DEV_POWER, "Spawns all Slayer npcs in the ocean") {
    var x = 1921
    var z = 3774
    var tile = Tile(x, z)
    player.moveTo(tile = tile)

    for (slayerMasterId in listOf(403, 3578, 7483, 2989, 3844, 3995, 3541, 5840, 3515, 6025, 2460)) {
        val master = SlayerDef.slayerMasters[slayerMasterId]
        if (master != null) {
            for (taskType in listOf(
                SlayerTaskType.EASY, SlayerTaskType.MEDIUM, SlayerTaskType.HARD, SlayerTaskType.BOSS,
                SlayerTaskType.WILDERNESS, SlayerTaskType.HEROISM, SlayerTaskType.CORRUPTION
            )) {
                if (!master.slayerAssignments.containsKey(taskType)) {
                    continue
                }
                for (assignment in master.slayerAssignments[taskType]!!) {
                    world.spawn(Npc(slayerMasterId, Tile(x, z), world))
                    z -= 4
                    if (assignment.task.superiorId != -1) {
                        world.spawn(Npc(assignment.task.superiorId, Tile(x, z), world))
                    }
                    z -= 4
                    val npcIds = assignment.task.npcIds
                    for (npcId in npcIds) {
                        world.spawn(Npc(npcId, Tile(x, z), world))
                        z -= 2
                    }
                    z = 3774
                    x += 2
                }
            }
        }
        x += 2
    }
}