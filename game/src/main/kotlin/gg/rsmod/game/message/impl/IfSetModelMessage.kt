package gg.rsmod.game.message.impl

import gg.rsmod.game.message.Message

data class IfSetModelMessage(val hash: Int, val model: Int) : Message
