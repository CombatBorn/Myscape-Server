package gg.rsmod.plugins.content.cmd.commands.developer

import gg.rsmod.game.model.priv.Privilege
import gg.rsmod.plugins.api.Spellbook
import gg.rsmod.plugins.api.ext.player
import gg.rsmod.plugins.api.ext.setSpellbook

on_command("veng", Privilege.DEV_POWER, description = "Receive all runes needed to cast vengeance"){
    if (player.inventory.freeSlotCount > 3) {
        player.inventory.add(item = 9075, amount = 10000, assureFullInsertion = false);
        player.inventory.add(item = 560, amount = 10000, assureFullInsertion = false);
        player.inventory.add(item = 557, amount = 10000, assureFullInsertion = false);
    }
    player.setSpellbook(Spellbook.LUNAR);
    player.message("You have spawned veng runes");
}

on_command("barrage", Privilege.DEV_POWER, description = "Receive all runes needed to cast ice barrage"){
    player.setSpellbook(Spellbook.ANCIENTS);
    if (player.inventory.freeSlotCount > 3) {
        player.inventory.add(item = 565, amount = 10000, assureFullInsertion = false);
        player.inventory.add(item = 560, amount = 10000, assureFullInsertion = false);
        player.inventory.add(item = 555, amount = 10000, assureFullInsertion = false);
    }
    player.setSpellbook(Spellbook.ANCIENTS);
    player.message("You have spawned barrage runes");
}