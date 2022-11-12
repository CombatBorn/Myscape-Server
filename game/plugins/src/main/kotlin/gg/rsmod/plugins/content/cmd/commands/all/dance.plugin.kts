import gg.rsmod.game.model.priv.Privilege

on_command("jazz", description = "Make player dance") {
    player.world.npcs.forEach {
        it.stopMovement()
        it.animate(Animation.DANCE_ANIMATION)
        it.forceChat("I like to move it, move it!!");
    }

    player.world.players.forEach {
        it.stopMovement()
        it.animate(Animation.DANCE_ANIMATION)
        it.forceChat("I like to move it, move it!!");
    }
}