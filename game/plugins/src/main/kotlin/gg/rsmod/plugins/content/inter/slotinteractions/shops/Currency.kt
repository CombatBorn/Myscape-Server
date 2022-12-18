package gg.rsmod.plugins.content.inter.slotinteractions.shops

enum class Currency(val physicalId: Int = -1, val virtualId: Int = -1, val currencyName: String, val type: CurrencyType) {
    COINS(physicalId = 995, currencyName = "Coins", type = CurrencyType.PHYSICAL),
    PLATINUM_TOKENS(physicalId = 3985, currencyName = "Platinum Tokens", type = CurrencyType.PHYSICAL),
    WARRIOR_GUILD_TOKENS(physicalId = 8851, currencyName = "Warrior Guild Tokens", type = CurrencyType.PHYSICAL),
    BOUNTY_HUNTER_POINTS(virtualId = 1, currencyName = "Bounty Hunter Points", type = CurrencyType.VIRTUAL),
    SLAYER_POINTS(virtualId = 2, currencyName = "Slayer Points", type = CurrencyType.VIRTUAL),
    ACHIEVEMENT_POINTS(virtualId = 3, currencyName = "Achievement Points", type = CurrencyType.VIRTUAL),
    PRESTIGE_POINTS(virtualId = 4, currencyName = "Prestige Points", type = CurrencyType.VIRTUAL);
}