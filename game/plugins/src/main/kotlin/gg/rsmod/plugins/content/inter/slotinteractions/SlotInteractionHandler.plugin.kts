import gg.rsmod.game.model.slayer.SlayerDef
import gg.rsmod.game.model.slayer.SlayerTaskType
import gg.rsmod.plugins.content.inter.slotinteractions.shops.Shops
import kotlin.math.sign

/**
 * Determine what occurs when an interface component is interacted with.
 */
Shops.values().forEach { indexShop ->
    on_button(indexShop.shop.interfaceId, indexShop.shop.component) {
        val slot = player.getInteractingSlot()
        when (player.getInteractingOption()) {
            1 -> indexShop.shop.value(player, slot)
            2 -> indexShop.shop.buy(player, slot)
            10 -> indexShop.shop.examine(player, slot)
        }
    }
}


/**
 * Select Slayer Task Type, update list on side.
 */
for (taskType in SlayerTaskType.values()) {
    // [Easy: 110, Medium: 112, Hard: 114, Boss: 116, Heroic: 118, Corrupt: 120]
    val component = 110 + (taskType.order - 1) * 2
    // player has interacted assigned a TaskType to their favorite/block list
    on_button(5000, component) {
        val npcs = SlayerDef.slayerDataMap[taskType]
        val totalSlots = (npcs?.size ?: -1) * 4 - 1
        player.lastSelectedSlayerTaskType = taskType
        player.setInterfaceEvents(5000,126,0..4 * totalSlots, InterfaceEvent.BUTTON1)
    }
}

/**
 * Select Favorite or Block on a task in the list.
 */
on_button(5000, 126) {
    val slot = player.getInteractingSlot()
    val npcId = SlayerDef.slayerDataMap[player.lastSelectedSlayerTaskType]?.get(slot / 4)
    val name = npcId?.let { world.definitions.get(NpcDef::class.java, it).name }
    // clicked favorite
    if ((slot + 1) % 4 == 3) {
        player.message("You favorite $name tasks.")
    }
    // clicked block
    else if ((slot + 1) % 4 == 0) {
        player.message("You block $name tasks.")
    }
    player.runClientScript(30013,
        "Favorite #1", "Favorite #2", "Favorite #3", "Favorite #4", "Favorite #5",
        "Block #1", "Block #2", "Block #3", "Block #4", "Block #5")
}