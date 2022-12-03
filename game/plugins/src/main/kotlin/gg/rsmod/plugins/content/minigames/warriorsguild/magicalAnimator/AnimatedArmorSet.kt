package gg.rsmod.plugins.content.minigames.warriorsguild.magicalAnimator

import gg.rsmod.plugins.api.cfg.Items
import gg.rsmod.plugins.api.cfg.Npcs

enum class AnimatedArmorSet(val npc: Int, val helmet: Int, val platebody: Int, val platelegs: Int, val tokens: Int) {
    RUNE_ARMOR(npc = Npcs.ANIMATED_RUNE_ARMOUR, helmet = Items.RUNE_FULL_HELM, platebody = Items.RUNE_PLATEBODY, platelegs = Items.RUNE_PLATELEGS, tokens = 40),
    ADAMANT_ARMOR(npc = Npcs.ANIMATED_ADAMANT_ARMOUR, helmet = Items.ADAMANT_FULL_HELM, platebody = Items.ADAMANT_PLATEBODY, platelegs = Items.ADAMANT_PLATELEGS, tokens = 30),
    MITHRIL_ARMOR(npc = Npcs.ANIMATED_MITHRIL_ARMOUR, helmet = Items.MITHRIL_FULL_HELM, platebody = Items.MITHRIL_PLATEBODY, platelegs = Items.MITHRIL_PLATELEGS, tokens = 25),
    BLACK_ARMOR(npc = Npcs.ANIMATED_BLACK_ARMOUR, helmet = Items.BLACK_FULL_HELM, platebody = Items.BLACK_PLATEBODY, platelegs = Items.BLACK_PLATELEGS, tokens = 20),
    STEEL_ARMOR(npc = Npcs.ANIMATED_STEEL_ARMOUR, helmet = Items.STEEL_FULL_HELM, platebody = Items.STEEL_PLATEBODY, platelegs = Items.STEEL_PLATELEGS, tokens = 15),
    IRON_ARMOR(npc = Npcs.ANIMATED_IRON_ARMOUR, helmet = Items.IRON_FULL_HELM, platebody = Items.IRON_PLATEBODY, platelegs = Items.IRON_PLATELEGS, tokens = 10),
    BRONZE_ARMOR(npc = Npcs.ANIMATED_BRONZE_ARMOUR, helmet = Items.BRONZE_FULL_HELM, platebody = Items.BRONZE_PLATEBODY, platelegs = Items.BRONZE_PLATELEGS, tokens = 5);

    fun armor(): List<Int>{
        return listOf(helmet, platebody, platelegs)
    }
}