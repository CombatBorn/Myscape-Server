import gg.rsmod.game.model.priv.Privilege
import gg.rsmod.plugins.content.inter.attack.AttackTab

on_command("spec", Privilege.DEV_POWER) {
    player.setVarp(300, 1000)
}