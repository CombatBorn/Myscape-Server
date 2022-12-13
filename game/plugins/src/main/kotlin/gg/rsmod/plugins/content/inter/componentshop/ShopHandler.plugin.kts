import gg.rsmod.plugins.content.inter.componentshop.Shops

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