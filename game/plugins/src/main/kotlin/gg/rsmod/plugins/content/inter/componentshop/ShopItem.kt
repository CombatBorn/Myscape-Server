package gg.rsmod.plugins.content.inter.componentshop

class ShopItem {
    var id = -1
    var amount = 1
    var value = 1
    var currency = Currency.COINS
    constructor(id: Int, amount: Int, value: Int, currency: Currency){
        this.id = id
        this.amount = amount
        this.value = value
        this.currency = currency
    }
    constructor(id: Int, value: Int, currency: Currency){
        this.id = id
        this.value = value
        this.currency = currency
    }
    constructor(id: Int, amount: Int, value: Int){
        this.id = id
        this.amount = amount
        this.value = value
    }
    constructor(id: Int, value: Int){
        this.id = id
        this.value = value
    }
    constructor(id: Int){
        this.id = id
    }
}