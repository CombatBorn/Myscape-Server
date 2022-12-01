package gg.rsmod.game.model.slayer

import gg.rsmod.game.model.Tile

class SlayerMonster(){
    var npcIds: List<Int>? = null
    var slayerLevelReq = 0
    var minAssigned = 40
    var maxAssigned = 80
    var weight = 10
    var superiorId = -1
    var tp: Tile? = null

    constructor(npcId: Int, slayerLevelReq: Int = 0, minAssigned: Int = 40, maxAssigned: Int = 80, weight: Int = 10, superiorId: Int = -1, tp: Tile) : this() {
        this.npcIds = listOf(npcId)
        this.slayerLevelReq = slayerLevelReq
        this.minAssigned = minAssigned
        this.maxAssigned = maxAssigned
        this.weight = weight
        this.superiorId = superiorId
        this.tp = tp
    }

    constructor(npcIds: List<Int>, slayerLevelReq: Int = 0, minAssigned: Int = 40, maxAssigned: Int = 80, weight: Int = 10, superiorId: Int = -1, tp: Tile) : this() {
        this.npcIds = npcIds
        this.slayerLevelReq = slayerLevelReq
        this.minAssigned = minAssigned
        this.maxAssigned = maxAssigned
        this.weight = weight
        this.superiorId = superiorId
        this.tp = tp
    }

}