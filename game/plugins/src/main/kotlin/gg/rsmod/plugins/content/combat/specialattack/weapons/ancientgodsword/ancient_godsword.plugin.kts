import gg.rsmod.plugins.content.combat.dealHit
import gg.rsmod.plugins.content.combat.formula.MeleeCombatFormula
import gg.rsmod.plugins.content.combat.specialattack.SpecialAttacks

private val AGS = Items.ANCIENT_GODSWORD

val SPECIAL_REQUIREMENT = 50;

SpecialAttacks.register(AGS, SPECIAL_REQUIREMENT) {
    val maxHit = MeleeCombatFormula.getMaxHit(player, target, specialAttackMultiplier = 1.1)
    val accuracy = MeleeCombatFormula.getAccuracy(player, target, specialAttackMultiplier = 2.0)
    val landHit = accuracy >= world.randomDouble()
    player.animate(id = 9171)
    player.graphic(id = 1996)
    world.spawn(AreaSound(tile = player.tile, id = 3869, radius = 10, volume = 1))
    val specTarget = player.getTarget()!!
    player.dealHit(target = target, maxHit = maxHit, setHit = -1, landHit = landHit, delay = 1)
    if (landHit && (specTarget is Player)) {
        specTarget.applyTint(start = 0, end = 260, hue = 0, saturation = 6, luminance = 28, recolourAmount = 112)
        val playerToHeal = player
        specTarget.queue {
            var success = true
            if (!wait_and_check_distance_from_target(8, specTarget, 5)) {
                success = false
            }
            if (success){
                this.player.graphic(377)
                this.player.hit(25)
                playerToHeal.heal(25)
            }
        }

    }
}

suspend fun QueueTask.wait_and_check_distance_from_target(cycles: Int, target: Player, distance: Int): Boolean {
    for (i in 0 until cycles) {
        wait(1)
        if (player.tile.getDistance(target.tile) >= distance) {
            terminate()
            return false
        }
    }
    return true
}
