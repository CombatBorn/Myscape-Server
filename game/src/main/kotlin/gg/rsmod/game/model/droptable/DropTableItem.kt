package gg.rsmod.game.model.droptable

import kotlin.math.min

/**
 * Stores the item id and min/max quantities dropped
 */
class DropTableItem() {
    var id: Int = 0
    var minQuantity: Int = 0
    var maxQuantity: Int = 0

    constructor(id: Int, minQuantity: Int, maxQuantity: Int ) : this() {
        this.id = id
        this.minQuantity = minQuantity
        this.maxQuantity = maxQuantity
    }

    constructor(id: Int) : this() {
        this.id = id
        this.minQuantity = 1
        this.maxQuantity = 1
    }

    constructor(id: Int, amount: Int) : this() {
        this.id = id
        this.minQuantity = amount
        this.maxQuantity = amount
    }

    fun randomQuantity(): Int {
        return if (minQuantity == maxQuantity) {
            minQuantity
        } else{
            (Math.random() * (maxQuantity - minQuantity + 1)).toInt() + minQuantity
        }
    }
}