package gg.rsmod.plugins.content.inter.slotinteractions.shops

/**
 * [PHYSICAL] currencies are determined by items in a player's inventory (coins, platinum tokens, warrior guild tokens, etc)
 * [VIRTUAL] currencies are stored persistently in the player's save file
 */

enum class CurrencyType {
    PHYSICAL,
    VIRTUAL
}