import gg.rsmod.plugins.content.combat.dealHit
import gg.rsmod.plugins.content.combat.formula.MeleeCombatFormula
import gg.rsmod.plugins.content.combat.specialattack.SpecialAttacks
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap
import kotlin.math.roundToInt

val SPECIAL_REQUIREMENT = 50;
SpecialAttacks.register(Items.DRAGON_CLAWS, SPECIAL_REQUIREMENT) {
    player.animate(7514, 5)
    player.graphic(1171, 0, 10)
    val maxHit = MeleeCombatFormula.getMaxHit(player, target, specialAttackMultiplier = 1.0)
    val accuracy = MeleeCombatFormula.getAccuracy(player, target, specialAttackMultiplier = 1.0)
    var firstSuccessfulHit = 0
    for (hit in 1..4) {
        if (accuracy >= world.randomDouble()) {
            firstSuccessfulHit = hit
            break
        }
    }
    val damageMap = Int2ObjectOpenHashMap<Int>()
    if (firstSuccessfulHit == 1) {
        // 0.5 to maxhit - 1
        damageMap[0] = ((maxHit + (Math.random() * maxHit - 1)) * 0.5).toInt()
        damageMap[1] = damageMap[0] / 2
        damageMap[2] = damageMap[1] / 2
        // equal to third hit with 50% chance at +1
        damageMap[3] = damageMap[2] + Math.random().roundToInt()
    } else if (firstSuccessfulHit == 2) {
        damageMap[0] = 0
        // 0.375 to 0.875 maxhit
        damageMap[1] = ((maxHit * 0.375) + (Math.random() * maxHit * 0.875)).toInt()
        damageMap[2] = damageMap[1] / 2
        // equal to third hit with 50% chance at +1
        damageMap[3] = damageMap[2] + Math.random().roundToInt()
    } else if (firstSuccessfulHit == 3) {
        damageMap[0] = 0
        damageMap[1] = 0
        // x0.25 to x0.75 maxhit
        damageMap[2] = ((maxHit * 0.25) + (Math.random() * maxHit * 0.5)).toInt()
        damageMap[3] = damageMap[2]
    } else if (firstSuccessfulHit == 4) {
        damageMap[0] = 0
        damageMap[1] = 0
        damageMap[2] = 0
        // x0.25 to x1.25 max hit
        damageMap[3] = (Math.random() + 0.25 * maxHit).toInt()
    } else if (firstSuccessfulHit == 0) {
        damageMap[0] = 0
        damageMap[1] = 0
        // random number from 0 to 1
        damageMap[2] = Math.random().roundToInt()
        damageMap[3] = damageMap[2]
    }
//    player.message("Maximum hit: $maxHit")
    var delay = 1
    var landHit: Boolean
    for (index in 0 .. 3) {
        if (index == 2) delay = 2
        landHit = damageMap[index] > 0
        player.dealHit(target = target, maxHit = -1, setHit = damageMap[index], landHit = landHit, delay = delay)
//        player.message("Hit #${index + 1} = ${damageMap[index]}")
    }

}