package gg.rsmod.game.model.slayer

import gg.rsmod.game.model.Tile
import gg.rsmod.game.model.World

class SlayerDefs(world: World) {
    init {
        var monsters: ArrayList<SlayerMonster>
        /**
         * VANNAKA
         */
        lateinit var vannakaTasks: HashMap<SlayerTaskTypes, SlayerAssignment>

        // easy task
        monsters = arrayListOf(
            SlayerMonster(npcId = 1, tp = Tile(0,0)),
            SlayerMonster(npcId = 2, slayerLevelReq = 0, tp = Tile(0,0)),
            SlayerMonster(npcId = 3, slayerLevelReq = 0, minAssigned = 40, tp = Tile(0,0)),
            SlayerMonster(npcId = 4, slayerLevelReq = 0, minAssigned = 40, maxAssigned = 80, tp = Tile(0,0)),
            SlayerMonster(npcId = 5, slayerLevelReq = 0, minAssigned = 40, maxAssigned = 80, weight = 10, tp = Tile(0,0)),
            SlayerMonster(npcId = 6, slayerLevelReq = 0, minAssigned = 40, maxAssigned = 80, weight = 10, superiorId = 7, tp = Tile(0,0))
        )
        vannakaTasks[SlayerTaskTypes.EASY] = SlayerAssignment(monsters = monsters)

        // heroism task
        monsters = arrayListOf(
            SlayerMonster(npcId = 8, slayerLevelReq = 1, minAssigned = 10, maxAssigned = 30, weight = 5, superiorId = 9, tp = Tile(0,0)),
            SlayerMonster(npcId = 10, slayerLevelReq = 1, minAssigned = 10, maxAssigned = 30, weight = 8, superiorId = 11, tp = Tile(0,0))
        )
        vannakaTasks[SlayerTaskTypes.HEROISM] = SlayerAssignment(monsters = monsters, rank = 3)

        // add to memory
        world.slayerMasters[403] = vannakaTasks
        println("Slayer masters initialized")
    }
}