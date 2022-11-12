package gg.rsmod.plugins.content.minigames.fightcaves

import gg.rsmod.game.model.World
import gg.rsmod.game.model.entity.Npc
import gg.rsmod.game.model.entity.Player
import gg.rsmod.plugins.api.cfg.Npcs
import net.runelite.cache.definitions.MapDefinition.Tile

class Fightcaves (val player:Player){

    val jad = 3127

    fun startFightCaves(){
        player.moveTo(2413, 5117, 0);

    }


}