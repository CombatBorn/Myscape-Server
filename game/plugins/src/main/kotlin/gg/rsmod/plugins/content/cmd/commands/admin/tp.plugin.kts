package gg.rsmod.plugins.content.cmd.commands.admin

import gg.rsmod.game.model.priv.Privilege
import gg.rsmod.game.model.slayer.SlayerTaskTypes
import gg.rsmod.plugins.content.cmd.Commands_plugin.Command.tryWithUsage

on_command("tp", Privilege.ADMIN_POWER, description = "Teleport to coordinates") {
    val args = player.getCommandArgs()
    tryWithUsage(player, args, "Invalid format! Example of proper command <col=801700>::tp 3200 3200</col>") { values ->
        val x = values[0].toInt()
        val z = values[1].toInt()
        val height = if (values.size > 2) values[2].toInt() else 0
        player.moveTo(x, z, height)
    }
}
on_command("tps", Privilege.ADMIN_POWER, description = "Teleport to slayer task") {
    val args = player.getCommandArgs()
    if (args.isEmpty()) {
        player.message("Invalid format! Example of proper command <col=801700>::tps 6506</col>")
        return@on_command
    }
    val chosen = args[0].toInt()
    for (masterID in listOf(403, 3578, 7483, 2989, 3844, 3995, 3541, 5840, 3515, 6025, 2460)) {
        for (taskType in listOf(
            SlayerTaskTypes.EASY, SlayerTaskTypes.MEDIUM, SlayerTaskTypes.HARD, SlayerTaskTypes.BOSS,
            SlayerTaskTypes.WILDERNESS, SlayerTaskTypes.HEROISM, SlayerTaskTypes.CORRUPTION
        )) {
            if (world.slayerMasters[masterID]?.containsKey(taskType) == false) {
                continue
            }
            for (task in world.slayerMasters[masterID]?.get(taskType)?.tasks!!) {
                if (task.npcIds!!.contains(chosen)) {
                    player.moveTo(task.tp!!)
                    return@on_command
                }
            }
        }
    }
}
on_command("tpto", Privilege.ADMIN_POWER, description = "Teleport to a player") {
    val args = player.getCommandArgs()
    if (args.isEmpty()) {
        player.message("Invalid format! Example of proper command <col=801700>::tpto player</col>")
        return@on_command
    }
    val username = world.getFullPlayerName(args)
    val target = world.getPlayerInstance(username)
    if (target == null) {
        player.message("$username is not online")
        return@on_command
    }
    if (target.tile.getWildernessLevel() > 0) {
        player.queue(TaskPriority.STRONG) {
            teleportWildernessRequest(player, target)
        }
    } else {
        player.message("Teleported to $username")
        player.moveTo(target.tile)
    }
}
suspend fun QueueTask.teleportWildernessRequest(player: Player, target: Player) {
    when (options(
        "teleport",
        "teleport - invisible",
        "cancel",
        title = "'${target.username}' is in wilderness, tp anyway?"
    )) {
        1 -> {
            player.moveTo(target.tile)
            player.message("Teleported to ${target.username}")
        }

        2 -> {
            player.invisible = true
            player.moveTo(target.tile)
            player.message("Teleported to ${target.username}")
        }

        else -> {
        }
    }
}
on_command("tphere", Privilege.ADMIN_POWER, description = "Teleport a player to you") {
    val args = player.getCommandArgs()
    if (args.isEmpty()) {
        player.message("Invalid format! Example of proper command <col=801700>::tphere player</col>")
        return@on_command
    }
    val username = world.getFullPlayerName(args)
    val target = world.getPlayerInstance(username)
    if (target != null) {
        player.message("Teleported $username to you")
        target.message(player.username + " teleported you to them")
        target.moveTo(player.tile)
    } else {
        player.message("$username is not online")
    }
}
on_command("tphome", Privilege.ADMIN_POWER, description = "Teleport a player home") {
    val args = player.getCommandArgs()
    if (args.isEmpty()) {
        player.message("Invalid format! Example of proper command <col=801700>::tphome player</col>")
        return@on_command
    }
    val username = world.getFullPlayerName(args)
    val target = world.getPlayerForName(username)
    if (target != null) {
        player.message("Teleported $username home")
        target.message(player.username + " teleported you home")
        target.moveTo(Tile(3086, 3500))
    } else {
        player.message("$username is not online")
    }
}
on_command("tpall", Privilege.ADMIN_POWER, description = "Teleport all players to your location") {
    world.players.forEach { person ->
        if (person != player) person.moveTo(player.tile.x, player.tile.z, player.tile.height)
    }
}
on_command("up", Privilege.ADMIN_POWER, description = "Teleport up 1 floor") {
    player.moveTo(player.tile.x, player.tile.z, player.tile.height + 1)
}
on_command("down", Privilege.ADMIN_POWER, description = "Teleport down 1 floor") {
    if (player.tile.height > 0) {
        player.moveTo(player.tile.x, player.tile.z, player.tile.height - 1)
    }
}