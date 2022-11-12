import gg.rsmod.plugins.content.combat.dealHit
import gg.rsmod.plugins.content.combat.formula.MeleeCombatFormula
import gg.rsmod.plugins.content.combat.specialattack.SpecialAttacks

val SPECIAL_REQUIREMENT = 50;
SpecialAttacks.register(Items.DRAGON_CLAWS, SPECIAL_REQUIREMENT) {
    player.animate(7514, 5)
    player.graphic(1171, 0, 10)

    val maxHit = MeleeCombatFormula.getMaxHit(player, target, specialAttackMultiplier = 1.0)
    val accuracy = MeleeCombatFormula.getAccuracy(player, target, specialAttackMultiplier = 1.0)
    val landHit = accuracy >= world.randomDouble()

    val firstHit = null
    val secondHit = null
    val thirdHit = null
    val fourthHit = null

    player.dealHit(target = target, maxHit = maxHit, landHit = landHit, delay = 1)
    player.dealHit(target = target, maxHit = maxHit, landHit = landHit, delay = 1)
    player.dealHit(target = target, maxHit = maxHit, landHit = landHit, delay = 2)
    player.dealHit(target = target, maxHit = maxHit, landHit = landHit, delay = 2)

}