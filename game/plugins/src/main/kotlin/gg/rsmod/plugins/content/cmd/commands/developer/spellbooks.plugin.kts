package gg.rsmod.plugins.content.cmd.commands.developer

import gg.rsmod.game.model.priv.Privilege

on_command("lunars", Privilege.DEV_POWER, description = "Swap spellbook to lunar"){
    player.setSpellbook(Spellbook.LUNAR);
}

on_command("ancients", Privilege.DEV_POWER, description = "Swap spellbook to ancients"){
    player.setSpellbook(Spellbook.ANCIENTS);
}

on_command("normal", Privilege.DEV_POWER, description = "Swap spellbook to standard"){
    player.setSpellbook(Spellbook.NORMAL);
}