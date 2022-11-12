//import gg.rsmod.plugins.content.combat.Combat
//import gg.rsmod.plugins.content.combat.strategy.magic.CombatSpell
//
//// select offensive magic auto-cast
//on_button(593, 26) {
//    openAutoCastInterface(player)
//    player.setVarbit(Combat.DEFENSIVE_MAGIC_CAST_VARBIT,0)
//
//}
//// select defensive magic auto-cast
//on_button(593, 21) {
//    openAutoCastInterface(player)
//    player.setVarbit(Combat.DEFENSIVE_MAGIC_CAST_VARBIT,1)
//}
//
//fun openAutoCastInterface(player: Player){
//    player.setInterfaceEvents(interfaceId = 201, component = 1, from = 0, to = 58, setting = 1 shl 1)
//    player.openInterface(interfaceId = 201, dest = InterfaceDestination.ATTACK)
//    player.focusTab(GameframeTab.ATTACK)
//
//    // declare spells to display ancient spellbook
//    if (player.getSpellbook() == Spellbook.ANCIENTS){
//        player.setVarp(664, Items.ANCIENT_STAFF)
//    }
//    // declare spells to display standard spellbook
//    else{
//        player.setVarp(664, -1)
//    }
//}
//
//// autocast interface buttons
//on_button(201, 1) {
//    val slot = player.getInteractingSlot()
//    if (slot == 0) {
//        player.setVarbit(Combat.SELECTED_AUTOCAST_VARBIT, 0)
//        player.attr.remove(Combat.CASTING_SPELL)
//    } else {
//        var spell: CombatSpell? = null
//        // loop through all CombatSpell enums, find which spell's autocast id matches the clicked slot
//        for (spellIndex in CombatSpell.values) {
//            if (spellIndex.autoCastId == slot) {
//                spell = spellIndex
//                break
//            }
//        }
//        if (spell != null) {
//            // autocasted spell
//            player.setVarbit(Combat.SELECTED_AUTOCAST_VARBIT, spell.id)
//
//            // player is now casting spells
//            player.attr[Combat.CASTING_SPELL] = spell
//            // spell icon in combat tab changes to correct spell
//            player.setVarbit(276, slot)
//            // bash/pound/focus are no longer selected
//            player.setVarp(43, 4)
//        }
//
//    }
//    player.openInterface(InterfaceDestination.ATTACK)
//    // display weapon name within the combat tab after selecting auto cast
//    val weapon = player.equipment[EquipmentType.WEAPON.id]?.let { world.definitions.get(ItemDef::class.java, it.id) }
//    if (weapon != null) {
//        player.setComponentText(593, 1, weapon.name)
//    }
//}