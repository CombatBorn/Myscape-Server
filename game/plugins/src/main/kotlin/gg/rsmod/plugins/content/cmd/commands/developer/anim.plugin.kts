package gg.rsmod.plugins.content.cmd.commands.developer

import gg.rsmod.game.model.priv.Privilege
import gg.rsmod.plugins.content.cmd.Commands_plugin.Command.tryWithUsage

on_command("anim", Privilege.DEV_POWER, description = "Play animation") {
    val args = player.getCommandArgs()
    tryWithUsage(player, args, "Invalid format! Example of proper command <col=801700>::anim 1</col>") { values ->
        val id = values[0].toInt()
        player.animate(id)
        player.message("Animate: $id")
    }
}
on_command("findanim", Privilege.DEV_POWER, description = "Find animations for first item in inventory") {
    var animFound = -1
    val id = if (player.getCommandArgs().isEmpty()) {
        player.inventory.first()?.id ?: 2309
    } else {
        player.getCommandArgs()[0].toInt()
    }
    for (index in 0..world.definitions.getCount(AnimDef::class.java)) {
        if (!world.definitions.contains(AnimDef::class.java, index)) {
            continue
        }
        val animation = world.definitions.get(AnimDef::class.java, index)
        if (animation.leftHandItem == id || animation.rightHandItem == id) {
            player.message("Animation ${animation.id} uses ${world.definitions.get(ItemDef::class.java, id).name} ($id) in the animation")
            if (animFound == -1) animFound = animation.id
        }
    }
    if (animFound == -1) {
        player.message("No animations were found for ${world.definitions.get(ItemDef::class.java, id).name}")
    } else {
        player.message("Playing animation \"$animFound\"")
        player.animate(animFound)
    }
}