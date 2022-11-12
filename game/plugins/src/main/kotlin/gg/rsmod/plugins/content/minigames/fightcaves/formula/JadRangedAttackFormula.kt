package gg.rsmod.plugins.content.minigames.fightcaves.formula

import gg.rsmod.game.model.entity.Pawn
import gg.rsmod.plugins.api.PrayerIcon
import gg.rsmod.plugins.api.ext.hasPrayerIcon
import gg.rsmod.plugins.content.combat.formula.CombatFormula
import gg.rsmod.plugins.content.combat.formula.RangedCombatFormula
import kotlin.math.floor


class JadRangedAttackFormula(val maxHit: Double, val minHit: Int = 0) : CombatFormula {


    override fun getAccuracy(pawn: Pawn, target: Pawn, specialAttackMultiplier: Double): Double {
        return RangedCombatFormula.getAccuracy(pawn, target, specialAttackMultiplier)
    }

    override fun getMaxHit(
        pawn: Pawn,
        target: Pawn,
        specialAttackMultiplier: Double,
        specialPassiveMultiplier: Double
    ): Int {
        val rangedProtection = target.hasPrayerIcon(PrayerIcon.PROTECT_FROM_MISSILES)

        if (rangedProtection) return 0


        return minHit.coerceAtLeast(floor(maxHit).toInt())
    }
}