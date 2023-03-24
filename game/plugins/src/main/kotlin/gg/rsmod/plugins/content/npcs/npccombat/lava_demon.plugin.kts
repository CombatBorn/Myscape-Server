
import gg.rsmod.game.model.combat.AttackStyle
import gg.rsmod.game.model.combat.CombatClass
import gg.rsmod.game.model.combat.CombatStyle
import gg.rsmod.game.model.combat.PawnHit
import gg.rsmod.plugins.content.combat.*
import gg.rsmod.plugins.content.combat.formula.CombatFormula
import gg.rsmod.plugins.content.combat.formula.RangedCombatFormula
import gg.rsmod.plugins.content.combat.strategy.RangedCombatStrategy
import kotlin.math.floor

set_combat_def(Npcs.LAVA_DEMON) {
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
        attack = 1537
        block = 1536
        death = 1538
    }


}

on_npc_combat(Npcs.LAVA_DEMON) {

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
            val Lava2MagicAttack = Lava2MagicAttack(npc, target)
            (target as Player).message("test1")
            if (!Lava2MagicAttack.landed) {
                it.wait(2)
                (target as Player).message("test2")
                target.graphic(85)
            } else {
                it.wait(2)
                (target as Player).message("test3")
                target.graphic(357)
            }
            attemptLava2Bomb(target)
            npc.postAttackLogic(target)
        }

        it.wait(1)
        target = npc.getCombatTarget() ?: break
    }
}


fun attemptLava2Bomb(target: Pawn) {
    val originalLocation = Tile(target.tile)
    target.queue {
        if (world.random(10) == 1) {
            target.moveTo(2785,9322)
            when (world.random(5)) {
                1 -> {target.forceChat("Through the fire and the flames..")}
                2 -> {target.forceChat("Why me?!")}
                3 -> {target.forceChat("When will it end?!")}
                4 -> {target.forceChat("Let me out of here!")}
                5 -> {target.forceChat("I'm trapped!")}
            }
            target.doubleHit(world.random(5), world.random(5))
            target.graphic(453)
            wait (1)
            target.moveTo(2788, 9339)
            target.doubleHit(world.random(5), world.random(5))
            target.graphic(453)
            wait (1)
            target.moveTo(2794, 9338)
            target.doubleHit(world.random(5), world.random(5))
            target.graphic(453)
            wait (1)
            target.moveTo(2802, 9331)
            target.doubleHit(world.random(5), world.random(5))
            target.graphic(453)
            wait (1)
            target.moveTo(2793, 9318)
            target.doubleHit(world.random(5), world.random(5))
            target.graphic(453)
            wait (1)
            target.moveTo(2781, 9329)
            target.doubleHit(world.random(5), world.random(5))
            target.graphic(453)
            wait (1)
            target.moveTo(originalLocation)
        }
    }
}

fun Lava2MagicAttack(npc: Npc, target: Pawn) : PawnHit {
    val projectile = npc.createProjectile(
            target, gfx = 660, startHeight = 40, endHeight = 36, delay = 41, angle = 15, steepness = 240
    )
    npc.prepareAttack(CombatClass.MAGIC, CombatStyle.MAGIC, AttackStyle.ACCURATE)
    npc.animate(1537)
    world.spawn(projectile)
    val hit = npc.dealHit(
            target = target,
            Lava_demon_plugin.Lava2RangedAttackFormula(13.0, 0),
            delay = RangedCombatStrategy.getHitDelay(npc.getFrontFacingTile(target), target.getCentreTile()) - 1
    )
    if (hit.landed == false){
        hit.hit.hitmarks = mutableListOf()
    }
    return hit
}

class Lava2RangedAttackFormula(val maxHit: Double, val minHit: Int = 0) : CombatFormula {


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