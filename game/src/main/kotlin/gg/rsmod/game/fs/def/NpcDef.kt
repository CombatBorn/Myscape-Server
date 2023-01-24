package gg.rsmod.game.fs.def

import gg.rsmod.game.fs.Definition
import gg.rsmod.util.io.BufferUtils.readString
import io.netty.buffer.ByteBuf
import io.netty.buffer.Unpooled
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap

/**
 * @author Tom <rspsmods@gmail.com>
 */
class NpcDef(override val id: Int) : Definition(id) {

    var name = ""
    var models: Array<Int>? = null
    var category = -1
    var size = 1
    var standAnim = -1
    var walkAnim = -1
    var rotateLeftAnim = -1
    var rotateRightAnim = -1
    var rotate180Anim = -1
    var rotate90AnimCW = -1
    var rotate90AnimCCW = -1
    var isMinimapVisible = true
    var combatLevel = -1
    var widthScale = -1
    var heightScale = -1
    var length = -1
    var render = false
    var ambient = -1
    var contrast = -1
    var headIcon = -1
    var varp = -1
    var varbit = -1
    var interactable = true
    var pet = false
    var options: Array<String?> = Array(5) { "" }
    var transforms: Array<Int>? = null
    var chatHeadModels: Array<Int>? = null
    val params = Int2ObjectOpenHashMap<Any>()
    var examine: String? = null

    fun encode(): ByteArray {
        val buf = Unpooled.buffer(1)
        if (walkAnim != -1) {
            buf.writeByte(14)
            buf.writeShort(walkAnim)
        }
        if (standAnim != -1) {
            buf.writeByte(13)
            buf.writeShort(standAnim)
        }
        if (options.isNotEmpty()) {
            for (index in options.indices) {
                if (options[index]!! == "") continue
                buf.writeByte(30 + index)
                buf.writeBytes(options[index]!!.encodeToByteArray())
                buf.writeByte(0)
            }
        }
        if (ambient != -1) {
            buf.writeByte(100)
            buf.writeByte(ambient)
        }
        if (contrast != -1) {
            buf.writeByte(101)
            buf.writeByte(contrast)
        }
        if (render) {
            buf.writeByte(99)
        }
        if (combatLevel != -1) {
            buf.writeByte(95)
            buf.writeShort(combatLevel)
        }
        if (name != "") {
            buf.writeByte(2)
            buf.writeBytes(name.encodeToByteArray())
            buf.writeByte(0)
        }
        if (models != null) {
            buf.writeByte(1)
            buf.writeByte(models!!.size)
            for (model in models!!) {
                if (model != 0) buf.writeShort(model)
            }
        }
        buf.writeByte(0)
        val data = ByteArray(buf.readableBytes())
        buf.readBytes(data)
        return data
    }

    fun isAttackable(): Boolean = combatLevel > 0 && options.any { it == "Attack" }

    override fun decode(buf: ByteBuf, opcode: Int) {
        when (opcode) {
            1 -> {
                val count = buf.readUnsignedByte()
                models = Array(count + 2) { 0 }
                for (i in 0 until count) {
                    models!![i] = buf.readUnsignedShort()
                }
            }
            2 -> name = buf.readString()
            12 -> size = buf.readUnsignedByte().toInt()
            13 -> standAnim = buf.readUnsignedShort()
            14 -> walkAnim = buf.readUnsignedShort()
            15 -> rotateLeftAnim = buf.readUnsignedShort()
            16 -> rotateRightAnim = buf.readUnsignedShort()
            17 -> {
                walkAnim = buf.readUnsignedShort()
                rotate180Anim = buf.readUnsignedShort()
                rotate90AnimCW = buf.readUnsignedShort()
                rotate90AnimCCW = buf.readUnsignedShort()
            }
            18 -> category = buf.readUnsignedShort()
            in 30 until 35 -> {
                options[opcode - 30] = buf.readString()
                if (options[opcode - 30].equals("null", true)
                    || options[opcode - 30].equals("hidden", true)) {
                    options[opcode - 30] = null
                }
            }
            40 -> {
                val count = buf.readUnsignedByte()
                for (i in 0 until count) {
                    buf.readUnsignedShort()
                    buf.readUnsignedShort()
                }
            }
            41 -> {
                val count = buf.readUnsignedByte()
                for (i in 0 until count) {
                    buf.readUnsignedShort()
                    buf.readUnsignedShort()
                }
            }
            60 -> {
                val count = buf.readUnsignedByte().toInt()
                chatHeadModels = Array(count){
                    buf.readUnsignedShort()
                }
            }
            93 -> isMinimapVisible = false
            95 -> combatLevel = buf.readUnsignedShort()
            97 -> widthScale = buf.readUnsignedShort()
            98 -> heightScale = buf.readUnsignedShort()
            99 -> render = true
            100 -> ambient = buf.readUnsignedByte().toInt()
            101 -> contrast = buf.readUnsignedByte().toInt()
            102 -> headIcon = buf.readUnsignedShort()
            103 -> buf.readUnsignedShort()
            106, 118 -> {
                varbit = buf.readUnsignedShort()
                if (varbit == 65535) {
                    varbit = -1
                }

                varp = buf.readUnsignedShort()
                if (varp == 65535) {
                    varp = -1
                }

                var terminatingTransform = -1
                if (opcode == 118) {
                    terminatingTransform = buf.readUnsignedShort()
                    if (terminatingTransform == 65535) {
                        terminatingTransform = -1
                    }
                }

                val count = buf.readUnsignedByte().toInt()
                transforms = Array(count + 2) { 0 }

                for (i in 0..count) {
                    var transform = buf.readUnsignedShort()
                    if (transform == 65535) {
                        transform = -1
                    }
                    transforms!![i] = transform
                }

                transforms!![count + 1] = terminatingTransform
            }
            107 -> interactable = false
            111 -> pet = true
            249 -> params.putAll(readParams(buf))
        }
    }
}