package gg.rsmod.game.service.cachemodifier

import com.displee.cache.CacheLibrary
import com.displee.cache.ProgressListener
import com.displee.cache.index.Index
import mu.KLogging
import net.runelite.cache.ConfigType
import net.runelite.cache.IndexType

class NpcCreator(
    private val cacheLibrary: CacheLibrary
) {

    val indexId: Int = IndexType.CONFIGS.number
    val archiveId = ConfigType.NPC.id

    fun pack(index: Index, update: Boolean) {

        val npc = 403
        val npcFile = index.archive(9)?.file(npc)!!

        val associated = determineOpCodeValues(npcFile.data!!)
        displayOpCodeValues(associated)

        val newNpc = 11463
        if (update) cacheLibrary.put(index = indexId, archive = archiveId, file = newNpc, data = npcFile.data!!)

    }

    fun determineOpCodeValues(bytes: ByteArray): HashMap<Int, ArrayList<Int>> {
        /* Byte represents the op code */
        val opCodeValue: HashMap<Int, ArrayList<Int>> = HashMap()
        var index = 0
        while (index < bytes.size) {
            val opCode = bytes[index].toInt()
            val list: ArrayList<Int> = ArrayList()
            when (opCode){
                0 -> {
                    break
                }
                1, 60 -> {
                    val total = bytes[index + 1].toInt()
                    for (i in 0 until total) {
                        list.add(bytes[index + 2 + i * 2].toInt())
                        list.add(bytes[index + 2 + i * 2 + 1].toInt())
                    }
                    opCodeValue[opCode] = list
                    index += total * 2 + 2
                }
                2, 30, 31, 32, 33, 34, 249 -> {
                    for (i in index + 1..bytes.size) {
                        val value = bytes[i].toInt()
                        if (value == 0) {
                            break
                        } else {
                            list.add(value)
                        }
                    }
                    opCodeValue[opCode] = list
                    index += list.size + 2
                }
                12, 100, 101 -> {
                    list.add(bytes[index + 1].toInt())
                    opCodeValue[opCode] = list
                    index += 2
                }
                17, 115, 117 -> {
                    list.add(bytes[index + 1].toInt())
                    list.add(bytes[index + 2].toInt())
                    list.add(bytes[index + 3].toInt())
                    list.add(bytes[index + 4].toInt())
                    list.add(bytes[index + 5].toInt())
                    list.add(bytes[index + 6].toInt())
                    list.add(bytes[index + 7].toInt())
                    list.add(bytes[index + 8].toInt())
                    opCodeValue[opCode] = list
                    index += 9
                }
                13, 14, 15, 16, 18, 95, 97, 98, 102, 103, 114, 116 -> {
                    list.add(bytes[index + 1].toInt())
                    list.add(bytes[index + 2].toInt())
                    opCodeValue[opCode] = list
                    index += 3
                }
                40, 41 -> {
                    val total = bytes[index + 1].toInt()
                    for (i in 0 until total) {
                        list.add(bytes[index + 2 + i * 4].toInt())
                        list.add(bytes[index + 2 + i * 4 + 1].toInt())
                        list.add(bytes[index + 2 + i * 4 + 2].toInt())
                        list.add(bytes[index + 2 + i * 4 + 3].toInt())
                    }
                    opCodeValue[opCode] = list
                    index += total * 4 + 2
                }
                93, 99, 107, 109, 111 -> {
                    opCodeValue[opCode] = arrayListOf(-1)
                    index += 1
                }
                else -> {
                    if (opCode != 106 && opCode != 118) {
                        opCodeValue[opCode] = list
                        index += 1
                    } else {
                        list.add(bytes[index + 1].toInt())
                        list.add(bytes[index + 2].toInt())
                        list.add(bytes[index + 3].toInt())
                        list.add(bytes[index + 4].toInt())
                        index += 4
                        if (opCode == 118) {
                            list.add(bytes[index + 1].toInt())
                            list.add(bytes[index + 2].toInt())
                            index += 2
                        }
                        val total = bytes[index + 1].toInt()
                        for (i in 1..total * 2 + 2) {
                            list.add(bytes[index + 1 + i].toInt())
                        }
                        opCodeValue[opCode] = list
                        index += total * 2 + 2
                    }
                }
            }
        }
        return opCodeValue
    }

    fun displayOpCodeValues(associated: HashMap<Int, ArrayList<Int>>) {
        for (opCode in associated.keys) {
//            println("OpCode #$opCode's values: ${associated[opCode]}")
            val list = associated[opCode]!!
            when (opCode) {
                1, 60 -> {
                    val values: ArrayList<Int> = ArrayList()
                    for (i in 0 until list.size / 2) {
                        if (list[i * 2 + 1] >= 0) values.add(list[i * 2] shl 8 or list[i * 2 + 1])
                        else values.add(list[i * 2 + 1] and 255)
                    }
                    if (opCode == 1)println("Models: $values")
                    else if (opCode == 60)println("Chat Head Models: $values")
                }
                2, 30, 31, 32, 33, 34, 249 -> {
                    var value = ""
                    for (char in list) {
                        value += char.toChar()
                    }
                    if (opCode == 2) println("Npc: `$value`")
                    else println("Right-Click Option #${opCode - 29}: `$value`")
                }
                12, 100, 101 -> {
                    val value = list[0]
                    if (opCode == 12) println("Size: $value")
                    else if (opCode == 100) println("Ambient: $value")
                    else if (opCode == 101) println("Contrast: $value")
                }
                17, 115, 117 -> {
                    val value1 = list[0] shl 8 or list[1]
                    val value2 = list[2] shl 8 or list[3]
                    val value3 = list[4] shl 8 or list[5]
                    val value4 = list[6] shl 8 or list[7]
                    if (opCode == 17) {
                        println("Walk Animation: $value1")
                        println("Walk Back Animation: $value2")
                        println("Walk Left Animation: $value3")
                        println("Walk Right Animation: $value4")
                    } else {
                        println("Opcode $opCode = $list")
                    }
                }
                13, 14, 15, 16, 18, 95, 97, 98, 102, 103, 114, 116 -> {
                    val value = list[0] shl 8 or list[1]
                    if (opCode == 13) println("Idle Animation: $value")
                    else if (opCode == 14) println("Walk Animation: $value")
                    else if (opCode == 15) println("Turn Left Animation: $value")
                    else if (opCode == 16) println("Turn Right Animation: $value")
                    else if (opCode == 18) println("Category: $value")
                    else if (opCode == 95) println("Combat Level: $value")
                    else if (opCode == 97) println("Width Scale: $value")
                    else if (opCode == 98) println("Height Scale: $value")
                    else if (opCode == 102) println("Head Icon Prayer: $value")
                    else if (opCode == 103) println("Rotation: $value")
                    else println("Opcode $opCode = $value")
                }
                40, 41 -> {
                    if (opCode == 40) println("Recolor:")
                    else if (opCode == 41) println("Retexture:")
                    val values: ArrayList<Int> = ArrayList()
                    for (i in 0 until list.size / 2) {
                        val val1 = list[i * 2]
                        val val2 = list[i * 2 + 1]
                        if (val2 >= 0) values.add(val1 shl 8 or val2)
                        else values.add(val2 and 255)
                    }
                    for (i in 0 until values.size / 4) {
                        println(" - [${values[i * 4] shl 8 or values[i * 4 + 1]}] -> [${values[i * 4 + 2] shl 8 or values[i * 4 + 3]}]")
                    }
                }
                93, 99, 107, 109, 111 -> {
                    if (opCode == 93) println("Dot on Map: FALSE")
                    else if (opCode == 99) println("Visible: TRUE")
                    else if (opCode == 107) println("Interactable: FALSE")
                    else if (opCode == 109) println("Clickable: FALSE")
                    else if (opCode == 111) println("Follower: TRUE")
                }
                else -> {
                    println("No display provided for Opcode $opCode.")
                    if (opCode != 106 && opCode != 118) {
                        println("Opcode $opCode = $list")
                    } else {
                        println("Opcode $opCode = $list")
                    }
                }
            }
        }
    }

    companion object : KLogging() {
        @JvmStatic
        fun main(args: Array<String>) {
            val lib = CacheLibrary("./data/cache/")
            val index = lib.index(IndexType.CONFIGS.number)
            val update = false
            NpcCreator(cacheLibrary = lib).pack(index, update)
            if (update) {
                index.update(
                    object : ProgressListener {
                        override fun notify(progress: Double, message: String?) {
                            println("Progress: $progress. Message: $message")
                        }
                    }
                )
            }
        }
    }
}