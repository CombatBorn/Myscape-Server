package gg.rsmod.plugins.content.inter.slotinteractions.shops

import InterfaceEvent
import gg.rsmod.game.fs.def.ItemDef
import gg.rsmod.game.model.entity.Player
import gg.rsmod.plugins.api.ext.message

/**
 * @param interfaceId The interface id.
 *
 * @param component The container component which stores all items and their associated components.
 *
 * @param componentsPerItem This represents how many total components an item has associated with it.
 * Every item displayed in an interface may have multiple interface components such as sprites, text,
 * etc.
 *
 * @param options Any options added will become clickable in-game. This List of [InterfaceEvent]
 * represents which clickable options are available for each item in this interface.
 * Within Shops, buttons are reserved. Button1 = Value, Button2 = Buy x1, Button 10 = Examine.
 *
 * @param items A list of all items found in this interface's container component with their values
 * and currency required to purchase.
 *
 */

class Shop(val interfaceId: Int, val component: Int, val componentsPerItem: Int, val options: List<InterfaceEvent>, val items: List<ShopItem>) {

    fun value(player: Player, slot: Int) {
        val shopItem = getShopItem(slot)
        player.message("<col=801700>${player.world.definitions.get(ItemDef::class.java, shopItem.id).name}</col>: ${shopItem.value} ${shopItem.currency.currencyName}.")
    }

    fun buy(player: Player, slot: Int): Boolean {
        val shopItem = getShopItem(slot)

        var paid = 0

        // attempt to make payment
        if (shopItem.currency.type == CurrencyType.PHYSICAL) {
            paid = player.inventory.remove(shopItem.currency.physicalId, shopItem.value).completed
            if (paid < shopItem.value) {
                player.inventory.add(shopItem.currency.physicalId, paid)
                player.message("You do not have enough ${shopItem.currency.currencyName} for this.")
                return false
            }
        } else if (shopItem.currency.type == CurrencyType.VIRTUAL) {
            var taken = false
            when (shopItem.currency) {
                Currency.BOUNTY_HUNTER_POINTS -> taken = player.virtualWallet.removeBountyHunterPoints(shopItem.value)
                Currency.SLAYER_POINTS -> taken = player.virtualWallet.removeSlayerPoints(shopItem.value)
                Currency.ACHIEVEMENT_POINTS -> taken = player.virtualWallet.removeAchievementPoints(shopItem.value)
                Currency.PRESTIGE_POINTS -> taken = player.virtualWallet.removePrestigePoints(shopItem.value)
            }
            if (!taken){
                player.message("You do not have enough ${shopItem.currency.currencyName} for this.")
                return false
            }
        }
        // payment successfully taken payment from player

        // attempt to give items to player
        val given = player.inventory.add(item = shopItem.id, amount = shopItem.amount, assureFullInsertion = false).completed
        if (given < shopItem.amount) {
            // purchase failed, refund paid amount to player
            player.inventory.remove(shopItem.id, given)
            if (shopItem.currency.type == CurrencyType.PHYSICAL) {
                player.inventory.add(shopItem.currency.physicalId, paid)
            } else if (shopItem.currency.type == CurrencyType.VIRTUAL) {
                when (shopItem.currency) {
                    Currency.BOUNTY_HUNTER_POINTS -> player.virtualWallet.addBountyHunterPoints(shopItem.value)
                    Currency.SLAYER_POINTS -> player.virtualWallet.addSlayerPoints(shopItem.value)
                    Currency.ACHIEVEMENT_POINTS -> player.virtualWallet.addAchievementPoints(shopItem.value)
                    Currency.PRESTIGE_POINTS -> player.virtualWallet.addPrestigePoints(shopItem.value)
                }
            }
            player.message("You do not have enough inventory space for this.")
            return false
        }
        if (shopItem.currency.type == CurrencyType.VIRTUAL) player.updateInterfaceVirtualCurrencies(shopItem.currency.virtualId)
        player.message("You purchased x${shopItem.amount} <col=801700>${player.world.definitions.get(ItemDef::class.java, shopItem.id).name}</col>.")
        return true
    }
    fun examine(player: Player, slot: Int) {
        val shopItem = getShopItem(slot)
        player.message("${player.world.definitions.get(ItemDef::class.java, shopItem.id).examine}")
    }

    /**
     * @param slot This is equal to the slot that's clicked on in an interface. If an item
     * in the interface consists of multiple components, we can determine which in-game item
     * is being interacted with through dividing the slot by how many components each item in
     * the interface consists of.
     */
    private fun getShopItem(slot: Int): ShopItem {
        return items[slot / componentsPerItem]
    }

    /**
     * This is used to set the interface events for this particular interface.
     * This assumes the component only contains the items, thus setting the events
     * to 0 through getTotalComponents().
     */
    fun getTotalComponents(): Int{
        return (items.size * componentsPerItem - componentsPerItem)
    }
}