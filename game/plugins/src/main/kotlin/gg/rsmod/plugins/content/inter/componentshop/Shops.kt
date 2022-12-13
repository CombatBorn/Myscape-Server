package gg.rsmod.plugins.content.inter.componentshop

import InterfaceEvent

enum class Shops(val shop: Shop) {
    VANNAKA_COIN_SHOP(
        Shop(
            interfaceId = 5000, component = 104, slotsPerItem = 3,
            options = listOf(
                InterfaceEvent.BUTTON1,
                InterfaceEvent.BUTTON2,
                InterfaceEvent.BUTTON10
            ),
            items = listOf(
                ShopItem(id = 4155, value = 1, amount = 2, currency = Currency.COINS),
                ShopItem(id = 4156, value = 1000, currency = Currency.COINS),
                ShopItem(id = 4162, value = 1000, currency = Currency.COINS),
                ShopItem(id = 4164, value = 1000, currency = Currency.COINS),
                ShopItem(id = 4166, value = 1000, currency = Currency.COINS),
                ShopItem(id = 4168, value = 1000, currency = Currency.COINS),
                ShopItem(id = 4170, value = 1000, currency = Currency.COINS),
                ShopItem(id = 4551, value = 1000, currency = Currency.COINS),
                ShopItem(id = 6708, value = 1000, currency = Currency.COINS),
                ShopItem(id = 7159, value = 1000, currency = Currency.COINS),
                ShopItem(id = 23037, value = 1000, currency = Currency.COINS)
            )
        )
    ),
    VANNAKA_REWARDS_SHOP(
        Shop(
            interfaceId = 5000, component = 98, slotsPerItem = 3,
            options = listOf(
                InterfaceEvent.BUTTON1,
                InterfaceEvent.BUTTON2,
                InterfaceEvent.BUTTON10
            ),
            items = listOf(
                ShopItem(id = 11864, value = 200, currency = Currency.SLAYER_POINTS)
            )
        )
    )
}