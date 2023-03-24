
import gg.rsmod.game.model.combat.AttackStyle
import gg.rsmod.game.model.combat.CombatClass
import gg.rsmod.game.model.combat.CombatStyle
import gg.rsmod.game.model.combat.PawnHit
import gg.rsmod.plugins.content.combat.*
import gg.rsmod.plugins.content.combat.formula.CombatFormula
import gg.rsmod.plugins.content.combat.formula.MeleeCombatFormula
import gg.rsmod.plugins.content.combat.formula.RangedCombatFormula
import gg.rsmod.plugins.content.combat.strategy.RangedCombatStrategy
import gg.rsmod.plugins.content.minigames.fightcaves.JadRangedAttackFormula
import kotlin.math.floor

set_combat_def(Npcs.WATER_GIANT) {
    configs {
        attackSpeed = 8
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
        attack = 4652
        block = 4651
        death = 4650
    }


}

on_npc_combat(Npcs.WATER_GIANT) {

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
            val waterMagicAttack = waterMagicAttack(npc, target)
            (target as Player).message("test1")
            if (!waterMagicAttack.landed) {
                it.wait(2)
                (target as Player).message("test2")
                target.graphic(85)
            } else {
                it.wait(2)
                (target as Player).message("test3")
                target.graphic(122)
            }
            attemptWhirlpool(target)
            npc.postAttackLogic(target)
        }

        it.wait(1)
        target = npc.getCombatTarget() ?: break
    }
}

fun attemptWhirlpool(target: Pawn) {
    if (world.random(10) == 1) {
        target.doubleHit(6,6)
        target.graphic(59)
        when (world.random(5)) {
            1 -> {target.forceChat("Ahhhhhhhh")}
            2 -> {target.forceChat("*gurgle gurgle*!")}
            3 -> {target.forceChat("*Coughcoughcough*..")}
            4 -> {target.forceChat("I can't breathe!")}
            5 -> {target.forceChat("Help I'm drowning!")}
        }
    }
}

fun meleeAttack(npc: Npc, target: Pawn) {

    // Headbutt attack
    npc.prepareAttack(CombatClass.MELEE, CombatStyle.STAB, AttackStyle.ACCURATE)
    npc.animate(2655)

    if (MeleeCombatFormula.getAccuracy(npc, target) >= world.randomDouble()) {
        target.hit(world.random(97), type = HitType.HIT, delay = 0)
    } else {
        target.hit(damage = 0, type = HitType.BLOCK, delay = 0)
    }
}

fun rangedAttack(npc: Npc, target: Pawn) {
    val projectile = npc.createProjectile(
            target, gfx = 451, startHeight = 40, endHeight = 36, delay = 41, angle = 16, steepness = 240
    )

    npc.prepareAttack(CombatClass.RANGED, CombatStyle.RANGED, AttackStyle.ACCURATE)
    npc.animate(2652)
    world.spawn(projectile)
    npc.dealHit(
            target = target,
            JadRangedAttackFormula(97.0, 0),
            delay = RangedCombatStrategy.getHitDelay(npc.getFrontFacingTile(target), target.getCentreTile()) - 1
    )
}

fun magicAttack(npc: Npc, target: Pawn) {
    val projectile = npc.createProjectile(
            target, gfx = 448, startHeight = 40, endHeight = 36, delay = 41, angle = 15, steepness = 240
    )
    npc.prepareAttack(CombatClass.MAGIC, CombatStyle.MAGIC, AttackStyle.ACCURATE)
    npc.animate(2656)
    world.spawn(projectile)

    npc.dealHit(
            target = target,
            JadRangedAttackFormula(97.0, 0),
            delay = RangedCombatStrategy.getHitDelay(npc.getFrontFacingTile(target), target.getCentreTile()) - 1
    )
}
fun waterMagicAttack(npc: Npc, target: Pawn) : PawnHit {
    val projectile = npc.createProjectile(
            target, gfx = 121, startHeight = 40, endHeight = 36, delay = 41, angle = 15, steepness = 240
    )
    npc.prepareAttack(CombatClass.MAGIC, CombatStyle.MAGIC, AttackStyle.ACCURATE)
    npc.animate(4652)
    world.spawn(projectile)
    val hit = npc.dealHit(
            target = target,
            Water_giant_plugin.WaterRangedAttackFormula(13.0, 0),
            delay = RangedCombatStrategy.getHitDelay(npc.getFrontFacingTile(target), target.getCentreTile()) - 1
    )
    if (hit.landed == false){
        hit.hit.hitmarks = mutableListOf()
    }
    return hit
}

class WaterRangedAttackFormula(val maxHit: Double, val minHit: Int = 0) : CombatFormula {


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