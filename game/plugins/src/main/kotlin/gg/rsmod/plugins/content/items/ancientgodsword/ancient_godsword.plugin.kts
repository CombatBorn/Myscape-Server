import gg.rsmod.plugins.content.combat.dealHit
import gg.rsmod.plugins.content.combat.formula.MeleeCombatFormula
import gg.rsmod.plugins.content.combat.specialattack.SpecialAttacks

private val AGS = Items.ANCIENT_GODSWORD

val SPECIAL_REQUIREMENT = 50;

SpecialAttacks.register(AGS, SPECIAL_REQUIREMENT) {

    val maxHit = MeleeCombatFormula.getMaxHit(player, target, specialAttackMultiplier = 1.1)
    val accuracy = MeleeCombatFormula.getAccuracy(player, target, specialAttackMultiplier = 2.0)
    val landHit = accuracy >= world.randomDouble()
    val delay = 1



        player.animate(id = 9171)
        player.graphic(id = 1996)
        world.spawn(AreaSound(tile = player.tile, id = 3869, radius = 10, volume = 1))

        val specTarget = player.getTarget()!!


        player.dealHit(target = target, maxHit = maxHit, landHit = landHit, delay = delay)

        if (landHit && (specTarget is Player)) {
            specTarget.applyTint(start = 0, end = 260, hue = 0, saturation = 6, luminance = 28, recolourAmount = 112)


            val playerToHeal = player
            specTarget.queue {
                wait(8)
                this.player.graphic(377)
                this.player.hit(25)
                healPlayer(playerToHeal)
            }

        }
}

fun healPlayer(player: Player) {
    player.heal(25)
}
