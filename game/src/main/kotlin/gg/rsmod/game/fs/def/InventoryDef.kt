package gg.rsmod.game.fs.def

import gg.rsmod.game.fs.Definition
import io.netty.buffer.ByteBuf
import io.netty.buffer.Unpooled

/**
 * @author CombatBorn
 */
class InventoryDef(id: Int) : Definition(id) {
    var capacity: Int = 0
    override fun decode(buf: ByteBuf, opcode: Int) {
        when (opcode) {
            2 -> capacity = buf.readUnsignedShort()
        }
    }

    fun encode(): ByteArray {
        val buf = Unpooled.buffer(4)
        if (capacity != 0) {
            buf.writeByte(2)
            buf.writeShort(capacity)
        }
        buf.writeByte(0)
        val data = ByteArray(buf.readableBytes())
        buf.readBytes(data)
        return data
    }

}