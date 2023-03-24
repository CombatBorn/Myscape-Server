
import gg.rsmod.game.model.combat.AttackStyle
import gg.rsmod.game.model.combat.CombatClass
import gg.rsmod.game.model.combat.CombatStyle
import gg.rsmod.game.model.combat.PawnHit
import gg.rsmod.plugins.content.combat.*
import gg.rsmod.plugins.content.combat.formula.CombatFormula
import gg.rsmod.plugins.content.combat.formula.RangedCombatFormula
import gg.rsmod.plugins.content.combat.strategy.RangedCombatStrategy
import kotlin.math.floor

set_combat_def(Npcs.MUDHOUND) {
    configs {
        attackSpeed = 2
        respawnDelay = 50

    }

    aggro {
        radius = 0
        searchDelay = 1
        alwaysAggro()
    }

    stats {
        hitpoints = 250
        attack = 640
        strength = 960
        defence = 480
        magic = 480
        ranged = 960

    }

    bonuses {
        attackBonus = 0
        strengthBonus = 0
        magicDamageBonus = 0
        attackMagic = 60
        attackRanged = 0
        rangedStrengthBonus = 0
        defenceStab = 0
        defenceCrush = 0
        defenceSlash = 0
        defenceMagic = 0
        defenceRanged = 0
    }

    anims {
        attack = 64
        block = 6557
        death = 6558
    }


}

on_npc_combat(Npcs.MUDHOUND) {

    npc.queue {
        combat(this)
    }
}

/**
 * when an air giant is thinking of attacking it runs this method
 */
suspend fun combat(it: QueueTask) {
    val npc = it.npc
    var target = npc.getCombatTarget() ?: return


    while (npc.canEngageCombat(target)) {

        npc.resetFacePawn()
        npc.facePawn(target)




        var canAttack = npc.moveToAttackRangeCustom(it, target, distance = 15, projectile = true)
        var npcDelayBool = npc.isAttackDelayReady()

        if (canAttack && npcDelayBool) {
            val MudMagicAttack = MudMagicAttack(npc, target)
            (target as Player).message("test1")
            if (!MudMagicAttack.landed) {
                it.wait(2)
                (target as Player).message("test2")
                target.graphic(85)
            } else {
                it.wait(2)
                (target as Player).message("test3")
                target.graphic(616)
            }
            attemptMudBomb(target)
            npc.postAttackLogic(target)
        }

        it.wait(1)
        target = npc.getCombatTarget() ?: break
    }
}


fun attemptMudBomb(target: Pawn) {
    if (world.random(10) == 1) {
        target.doubleHit(world.random(10), world.random(40))
        target.graphic(284)
        when (world.random(5)) {
            1 -> {target.forceChat("Gross!")}
            2 -> {target.forceChat("Wait...WHAT?")}
            3 -> {target.forceChat("I'm all mudded now..")}
            4 -> {target.forceChat("Gross..")}
            5 -> {target.forceChat("Now i need another shower..")}
        }
    }
}

fun MudMagicAttack(npc: Npc, target: Pawn) : PawnHit {
    val projectile = npc.createProjectile(
            target, gfx = 286, startHeight = 40, endHeight = 36, delay = 41, angle = 15, steepness = 240
    )
    npc.prepareAttack(CombatClass.MAGIC, CombatStyle.MAGIC, AttackStyle.ACCURATE)
    npc.animate(6559)
    world.spawn(projectile)
    val hit = npc.dealHit(
            target = target,
            Mudhound_plugin.MudRangedAttackFormula(13.0, 0),
            delay = RangedCombatStrategy.getHitDelay(npc.getFrontFacingTile(target), target.getCentreTile()) - 1
    )
    if (hit.landed == false){
        hit.hit.hitmarks = mutableListOf()
    }
    return hit
}

class MudRangedAttackFormula(val maxHit: Double, val minHit: Int = 0) : CombatFormula {


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

        val magicProtection = target.hasPrayerIcon(PrayerIcon.PROTECT_FROM_MAGIC)

        if (magicProtection) return 0


        return minHit.coerceAtLeast(floor(maxHit).toInt())
    }
}