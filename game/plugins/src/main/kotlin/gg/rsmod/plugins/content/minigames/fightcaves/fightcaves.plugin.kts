package gg.rsmod.plugins.content.minigames.fightcaves

import gg.rsmod.game.model.attr.JAD_ATTR

import gg.rsmod.game.model.combat.AttackStyle
import gg.rsmod.game.model.combat.CombatClass
import gg.rsmod.game.model.combat.CombatStyle
import gg.rsmod.plugins.content.combat.*
import gg.rsmod.plugins.content.combat.formula.MeleeCombatFormula
import gg.rsmod.plugins.content.combat.strategy.RangedCombatStrategy


set_combat_def(Npcs.TZTOKJAD) {
    configs {
        attackSpeed = 8
        respawnDelay = 50

    }

    aggro {
        radius = 500
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
        attack = 2656
        block = 2653
        death = 2654
    }


}



on_npc_combat(Npcs.TZTOKJAD) {

    npc.queue {
        combat(this)
    }
}

suspend fun combat(it: QueueTask) {
    val npc = it.npc
    var target = npc.getCombatTarget() ?: return


    while (npc.canEngageCombat(target)) {

        npc.resetFacePawn()
        npc.facePawn(target)




        var canAttack = npc.moveToAttackRangeCustom(it, target, distance = 15, projectile = true)
        var npcDelayBool = npc.isAttackDelayReady()

        println("In range? ${canAttack} Is delay ready? {$npcDelayBool}")
        if (canAttack && npcDelayBool) {

            println("Should attack!!!")
            if (world.chance(1, 4) && npc.canAttackMelee(it, target, false)) {
                meleeAttack(npc, target)
            } else {
                when (world.random(1)) {
                    0 -> {
                        rangedAttack(npc, target)
                    }

                    1 -> {
                        magicAttack(npc, target)
                    }
                }

                npc.postAttackLogic(target)
            }
        }

        it.wait(1)
        target = npc.getCombatTarget() ?: break
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

var npce:Npc? = null;


if (if_obj_has_option(Objs.CAVE_ENTRANCE_11833, "Enter")) {
    on_obj_option(Objs.CAVE_ENTRANCE_11833, "Enter") {
        val fighters = Fightcaves(player)
        fighters.startFightCaves()

        val npc = Npc(Npcs.TZTOKJAD, Tile(2401, 5084, 0), world)
        player.message("Good luck")
        world.spawn(npc)


        npc.setActive(true)
        npc.attr[JAD_ATTR] = true;

        npce = npc
    }
}