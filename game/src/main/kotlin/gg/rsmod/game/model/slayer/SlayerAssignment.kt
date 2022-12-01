package gg.rsmod.game.model.slayer

class SlayerAssignment(){
    lateinit var tasks: ArrayList<SlayerMonster>
    var rank = 0
    constructor(tasks: ArrayList<SlayerMonster>) : this() {
        this.tasks = tasks
    }
    constructor(monsters: ArrayList<SlayerMonster>, rank: Int) : this() {
        this.tasks = monsters
        this.rank = rank
    }
}