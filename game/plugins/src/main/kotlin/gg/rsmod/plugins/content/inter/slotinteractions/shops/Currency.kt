package gg.rsmod.plugins.content.inter.slotinteractions.shops

enum class Currency(val id: Int, val currencyName: String, val type: CurrencyType) {
    COINS(id = 995, currencyName = "Coins", type = CurrencyType.PHYSICAL),
    PLATINUM_TOKENS(id = 3985, currencyName = "Platinum Tokens", type = CurrencyType.PHYSICAL),
    SLAYER_POINTS(id = -1, currencyName = "Slayer Points", type = CurrencyType.VIRTUAL),
    WARRIOR_GUILD_TOKENS(id = 8851, currencyName = "Warrior Guild Tokens", type = CurrencyType.PHYSICAL);
}