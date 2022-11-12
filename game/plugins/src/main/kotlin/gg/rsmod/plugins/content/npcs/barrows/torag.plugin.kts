package gg.rsmod.plugins.content.npcs.barrows

spawn_npc(Npcs.TORAG_THE_CORRUPTED, 3552, 3283, 0, 2);
spawn_npc(Npcs.TORAG_THE_CORRUPTED, 3551, 3280, 0, 2);
spawn_npc(Npcs.TORAG_THE_CORRUPTED, 3551, 3285, 0, 2);
spawn_npc(Npcs.TORAG_THE_CORRUPTED, 3554, 3280, 0, 2);
spawn_npc(Npcs.TORAG_THE_CORRUPTED, 3556, 3284, 0, 2);

set_combat_def(Npcs.TORAG_THE_CORRUPTED) {
    configs {
        attackSpeed = 5
        respawnDelay = 50
    }

    stats {
        hitpoints = 100
        magic = 100
        defence = 100

    }
    bonuses {
        attackBonus = 0
        strengthBonus = 72
        attackMagic = -33
        magicDamageBonus = 0
        attackRanged = 11
        rangedStrengthBonus = 0

        defenceStab = 221
        defenceSlash = 235
        defenceCrush = 222
        defenceMagic = 0
        defenceRanged = 221
    }

    anims {
        attack = 2068
        block = 2079
        death = 836
    }
}