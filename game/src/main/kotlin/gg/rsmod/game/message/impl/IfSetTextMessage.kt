package gg.rsmod.game.message.impl

import gg.rsmod.game.message.Message

/**
 * @author Tom <rspsmods@gmail.com>
 */
data class IfSetTextMessage(val interfaceId: Int, val componentId: Int, val text: String) : Message