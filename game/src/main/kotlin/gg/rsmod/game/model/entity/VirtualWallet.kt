package gg.rsmod.game.model.entity

/**
 * Stores virtual currencies that players can use to make purchases.
 */
class VirtualWallet {

    var bountyHunterPoints: Int = 0
    var slayerPoints: Int = 0
    var achievementPoints: Int = 0
    var prestigePoints: Int = 0

    /** If the amount can be added it will return true, otherwise the amount won't be added and returns false. */
    fun addBountyHunterPoints(amount: Int): Boolean {
        if (!add(bountyHunterPoints, amount)) return false
        bountyHunterPoints += amount
        return true
    }
    /** If the amount can be removed it will return true, otherwise the amount won't be removed and returns false. */
    fun removeBountyHunterPoints(amount: Int): Boolean {
        if (bountyHunterPoints < amount) return false
        bountyHunterPoints -= amount
        return true
    }
    /** If the amount can be added it will return true, otherwise the amount won't be added and returns false. */
    fun addSlayerPoints(amount: Int): Boolean {
        if (!add(slayerPoints, amount)) return false
        slayerPoints += amount
        return true
    }
    /** If the amount can be removed it will return true, otherwise the amount won't be removed and returns false. */
    fun removeSlayerPoints(amount: Int): Boolean {
        if (slayerPoints < amount) return false
        slayerPoints -= amount
        return true
    }
    /** If the amount can be added it will return true, otherwise the amount won't be added and returns false. */
    fun addAchievementPoints(amount: Int): Boolean {
        if (!add(achievementPoints, amount)) return false
        achievementPoints += amount
        return true
    }
    /** If the amount can be removed it will return true, otherwise the amount won't be removed and returns false. */
    fun removeAchievementPoints(amount: Int): Boolean {
        if (achievementPoints < amount) return false
        achievementPoints -= amount
        return true
    }
    /** If the amount can be added it will return true, otherwise the amount won't be added and returns false. */
    fun addPrestigePoints(amount: Int): Boolean {
        if (!add(prestigePoints, amount)) return false
        prestigePoints += amount
        return true
    }
    /** If the amount can be removed it will return true, otherwise the amount won't be removed and returns false. */
    fun removePrestigePoints(amount: Int): Boolean {
        if (prestigePoints < amount) return false
        prestigePoints -= amount
        return true
    }

    /** Check if the 2 ints can be added together. */
    private fun add(owned: Int, add: Int): Boolean {
        val total: Double = owned + add.toDouble()
        if (total > Int.MAX_VALUE) return false
        return true
    }
}