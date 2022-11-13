package gg.rsmod.plugins.content.combat.specialattack.weapons.armadylgodsword

import gg.rsmod.plugins.content.combat.dealHit
import gg.rsmod.plugins.content.combat.formula.MeleeCombatFormula
import gg.rsmod.plugins.content.combat.specialattack.SpecialAttacks

private val AGS = intArrayOf(Items.ARMADYL_GODSWORD, Items.ARMADYL_GODSWORD_OR)

val SPECIAL_REQUIREMENT = 50


AGS.forEach {
    SpecialAttacks.register(it, SPECIAL_REQUIREMENT) {

        val maxHit = MeleeCombatFormula.getMaxHit(player, target, specialAttackMultiplier = 1.375)
        val accuracy = MeleeCombatFormula.getAccuracy(player, target, specialAttackMultiplier = 2.0)
        val landHit = accuracy >= world.randomDouble()
        val delay = 1

        player.animate(id = 7644)
        player.graphic(id = 1211)

        player.dealHit(target = target, maxHit = maxHit, setHit = -1, landHit = landHit, delay = delay)


    }
}
