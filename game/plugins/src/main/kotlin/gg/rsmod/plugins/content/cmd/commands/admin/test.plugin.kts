import gg.rsmod.game.model.priv.Privilege
import gg.rsmod.plugins.content.cmd.Commands_plugin
import java.text.DecimalFormat

on_command("tint", Privilege.ADMIN_POWER) {


    val args = player.getCommandArgs()
    Commands_plugin.Command.tryWithUsage(
        player,
        args,
        "Invalid format! Example of proper command <col=801700>::tint 0 100 100 100 100 1</col> or <col=801700>::item 4151</col>"
    ) { values ->
        player.message("Tint applied")
        player.applyTint(args[0].toInt(), args[1].toInt(), args[2].toInt(), args[3].toInt(), args[4].toInt(), args[5].toInt())
    }
}

on_command("jad_size", Privilege.DEV_POWER) {
    val npc = Npc(Npcs.TZTOKJAD, Tile(2401, 5084, 0), world)
    println(npc.getSize())
}
