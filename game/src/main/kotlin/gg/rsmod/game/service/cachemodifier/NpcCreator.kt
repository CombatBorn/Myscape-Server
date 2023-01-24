package gg.rsmod.game.service.cachemodifier

import com.displee.cache.CacheLibrary
import com.displee.cache.ProgressListener
import gg.rsmod.game.fs.DefinitionSet
import gg.rsmod.game.fs.def.NpcDef
import net.runelite.cache.ConfigType
import net.runelite.cache.IndexType
import net.runelite.cache.fs.Store
import java.nio.file.Paths

class NpcCreator {
    companion object {
        private val library = CacheLibrary("./data/cache/")
        private val indexId = IndexType.CONFIGS.number
        private val archiveId = ConfigType.NPC.id
        private val index = library.index(indexId)
        private val archive = index.archive(archiveId)!!
        private val definitions = DefinitionSet()
        private lateinit var store: Store

        @JvmStatic
        fun main(args: Array<String>) {
            loadDefinitions()
            val encodedBytes = definitions.get(NpcDef::class.java, 1).encode()
            library.put(index = indexId, archive = archiveId, file = 11463, data = encodedBytes)
            updateCache()

//            println("ByteArray: ${encodedBytes.map { it.toString() }.toTypedArray().contentToString()}")
//            displayNpcByteArray(1)

//            create(CustomNpcs.MOLANISK)
        }
        private fun loadDefinitions() {
            store = Store(Paths.get("./data", "cache").toFile())
            store.load()
            definitions.loadAll(store, true)
        }

        private fun create(npc: CustomNpcs) {

//            library.put(index = indexId, archive = archiveId, file = npc.id, data = data)
        }

        private fun stringToInts(string: String): List<Int> {
            return (string.toCharArray()).map { it.toInt() }
        }

        private fun copy(npcId: Int, paste: Int) {
            if (!definitions.contains(NpcDef::class.java, npcId)) {
                println("Npc ID #$npcId doesn't exist in the cache.")
                return
            }
            val data = archive.file(npcId)!!.data!!
            library.put(index = indexId, archive = archiveId, file = paste, data = data)
        }
        private fun displayNpcData(npcId: Int){
            if (!definitions.contains(NpcDef::class.java, npcId)) {
                println("Npc ID #$npcId doesn't exist in the cache.")
                return
            }
            val npc = definitions.get(NpcDef::class.java, npcId)
            if (npc.name != "") println("name: ${npc.name}")
            if (npc.examine != null) println("examine: ${npc.examine}")
            if (npc.models != null) println("models: ${npc.models!!.map { it.toString() }.toTypedArray().contentToString()}")
            println("options: ${npc.options.map { it.toString() }.toTypedArray().contentToString()}")
            if (npc.category != -1) println("category: ${npc.category}")
            if (npc.size != -1) println("size: ${npc.size}")
            if (npc.standAnim != -1) println("standAnim: ${npc.standAnim}")
            if (npc.walkAnim != -1) println("walkAnim: ${npc.walkAnim}")
            if (npc.rotateLeftAnim != -1) println("rotateLeftAnim: ${npc.rotateLeftAnim}")
            if (npc.rotateRightAnim != -1) println("rotateRightAnim: ${npc.rotateRightAnim}")
            if (npc.rotate180Anim != -1) println("rotate180Anim: ${npc.rotate180Anim}")
            if (npc.rotate90AnimCW != -1) println("rotate90AnimCW: ${npc.rotate90AnimCW}")
            if (npc.rotate90AnimCCW != -1) println("rotate90AnimCCW: ${npc.rotate90AnimCCW}")
            println("isMinimapVisible: ${npc.isMinimapVisible}")
            if (npc.combatLevel != -1) println("combatLevel: ${npc.combatLevel}")
            if (npc.widthScale != -1) println("widthScale: ${npc.widthScale}")
            if (npc.heightScale != -1) println("heightScale: ${npc.heightScale}")
            if (npc.length != -1) println("length: ${npc.length}")
            println("render: ${npc.render}")
            if (npc.varp != -1) println("varp: ${npc.varp}")
            if (npc.varbit != -1) println("varbit: ${npc.varbit}")
            println("interactable: ${npc.interactable}")
            println("pet: ${npc.pet}")
            if (npc.transforms != null) println("transforms: ${npc.transforms}")
            if (npc.chatHeadModels != null) println("chatHeadModels: ${npc.chatHeadModels!!.map { it.toString() }.toTypedArray().contentToString()}")
            println("params: ${npc.params}")
        }
        private fun displayNpcByteArray(npcId: Int) {
            if (!definitions.contains(NpcDef::class.java, npcId)) {
                println("Npc ID #$npcId doesn't exist in the cache.")
                return
            }
            val npc = archive.file(npcId)!!.data!!
            println("Npc #$npcId ByteArray: ${npc.map { it.toString() }.toTypedArray().contentToString()}")
        }

        private fun updateCache() {
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