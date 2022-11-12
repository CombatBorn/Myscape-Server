package gg.rsmod.plugins.content.cmd.commands.admin

import gg.rsmod.game.model.priv.Privilege
import gg.rsmod.plugins.content.cmd.Commands_plugin.Command.tryWithUsage
import gg.rsmod.plugins.content.magic.TeleportType
import gg.rsmod.plugins.content.magic.teleport

on_command("tele", Privilege.ADMIN_POWER, description = "Teleport to coordinates") {
    val args = player.getCommandArgs()
    tryWithUsage(player, args, "Invalid format! Example of proper command <col=801700>::tele 3200 3200</col>") { values ->
        val x = values[0].toInt()
        val z = values[1].toInt()
        val height = if (values.size > 2) values[2].toInt() else 0
        player.moveTo(x, z, height)
    }
}

on_command("telealltome", Privilege.ADMIN_POWER, description = "") {
    world.players.forEach { person ->
        person.moveTo(player.tile.x, player.tile.z, player.tile.height)
    }
}

on_command("up", Privilege.ADMIN_POWER) {
    val height = player.getCommandArgs()[0].toInt() + player.tile.height
    player.moveTo(player.tile.x, player.tile.z, height)

}

on_command("teleup", Privilege.ADMIN_POWER) {
    player.teleport(Tile(player.tile.x, player.tile.z, 20), TeleportType.MODERN)
}