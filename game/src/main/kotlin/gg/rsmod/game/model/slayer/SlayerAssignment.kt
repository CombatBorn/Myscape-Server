package gg.rsmod.game.model.slayer

class SlayerAssignment(){
    lateinit var monsters: ArrayList<SlayerMonster>
    var rank = 0
    constructor(monsters: ArrayList<SlayerMonster>) : this() {
        this.monsters = monsters
    }
    constructor(monsters: ArrayList<SlayerMonster>, rank: Int) : this() {
        this.monsters = monsters
        this.rank = rank
    }
}