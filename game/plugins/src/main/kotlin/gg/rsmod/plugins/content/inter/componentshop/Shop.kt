package gg.rsmod.plugins.content.inter.componentshop

import InterfaceEvent
import gg.rsmod.game.fs.def.ItemDef
import gg.rsmod.game.model.entity.Player
import gg.rsmod.plugins.api.ext.message

/**
 * @param interfaceId The interface id.
 *
 * @param component The container component which stores all items and their associated components.
 *
 * @param slotsPerItem This represents how many total components an item has associated with it.
 * Every item displayed in an interface may have multiple interface components such as sprites, text,
 * etc.
 *
 * @param name Name of the shop, added for readability purposes.
 *
 * @param items A list of all items found in this interface's container component with their values
 * and currency required to purchase.
 *
 */

class Shop(val interfaceId: Int, val component: Int, val slotsPerItem: Int, val options: List<InterfaceEvent>, val items: List<ShopItem>) {

    fun value(player: Player, slot: Int) {
        val shopItem = getShopItem(slot)
        player.message("<col=801700>${player.world.definitions.get(ItemDef::class.java, shopItem.id).name}</col>: ${shopItem.value} ${shopItem.currency.currencyName}.")
    }

    fun buy(player: Player, slot: Int): Boolean {
        val shopItem = getShopItem(slot)

        var paid = 0

        // attempt to make payment
        if (shopItem.currency.type == CurrencyType.PHYSICAL) {
            paid = player.inventory.remove(shopItem.currency.id, shopItem.value).completed
            if (paid < shopItem.value) {
                player.inventory.add(shopItem.currency.id, paid)
                player.message("You do not have enough ${shopItem.currency.currencyName} for this.")
                return false
            }
        } else if (shopItem.currency.type == CurrencyType.VIRTUAL) {
            // TODO: Add virtual currencies
            player.message("${shopItem.currency.currencyName} are not usable yet.")
            return false
        }
        // payment successfully taken from player

        // attempt to give items to player
        val given = player.inventory.add(shopItem.id, shopItem.amount).completed
        if (given < shopItem.amount) {
            // purchase failed, refund paid amount to player
            player.inventory.remove(shopItem.id, given)
            if (shopItem.currency.type == CurrencyType.PHYSICAL) {
                player.inventory.add(shopItem.currency.id, paid)
            } else if (shopItem.currency.type == CurrencyType.VIRTUAL) {
                player.message("Virtual currencies can not be refunded at this time.")
                return false
            }
            player.message("You do not have enough inventory space for this.")
            return false
        }
        player.message("You purchased x${shopItem.amount} <col=801700>${player.world.definitions.get(ItemDef::class.java, shopItem.id).name}</col>.")
        return true
    }

    fun examine(player: Player, slot: Int) {
        val shopItem = getShopItem(slot)
        player.message("${player.world.definitions.get(ItemDef::class.java, shopItem.id).examine}")
    }

    private fun getShopItem(slot: Int): ShopItem {
        return items[slot / slotsPerItem]
    }

    fun getTotalComponents(): Int{
        return (items.size * slotsPerItem - 3)
    }
}