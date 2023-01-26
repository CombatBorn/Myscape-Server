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
        private val index = library.index(indexId)

        private val archiveId = ConfigType.NPC.id
        private val archive = index.archive(archiveId)!!

        private val definitions = DefinitionSet()
        private lateinit var store: Store

        @JvmStatic
        fun main(args: Array<String>) {

            loadDefinitions()

            addAllCustomNpcsToCache()

            updateCache()
        }

        /**
         * Rename a [Npc] and give customized options. This will make the
         * [Npc] no longer attackable.
         * NOTE: This will not update Npcs.kt or the Npcs server data file configuration.
         *
         * WARNING: FIRST OPTION MUST BE BLANK.
         *
         */
        private fun reworkNpc(npcId: Int, name: String, options: Array<String?>) {
            if (!definitions.contains(NpcDef::class.java, npcId)) {
                println("Npc ID #$npcId doesn't exist in the cache or it's not loaded.")
                return
            }
            val npcDef = definitions.get(NpcDef::class.java, npcId)

            npcDef.name = name
            npcDef.options = options
            npcDef.combatLevel = -1

            packNpcToCache(npcDef)
        }

        /**
         * Configure a NPC's Combat Level and Options to include 'Attack', 'Talk-to', and/or 'Pickpocket'.
         * WARNING: This will remove any clickable options the NPC has.
         */
        private fun attackableNpc(npcId: Int, combatLevel: Int, talkTo: Boolean = false, pickpocket: Boolean = false) {
            if (!definitions.contains(NpcDef::class.java, npcId)) {
                println("Npc ID #$npcId doesn't exist in the cache or it's not loaded.")
                return
            }
            val options: ArrayList<String> = arrayListOf("", "Attack")
            if (pickpocket) options.add("Pickpocket")
            if (talkTo) options.add("Talk-to")

            val npcDef = definitions.get(NpcDef::class.java, npcId)

            npcDef.options = options.map { it }.toTypedArray()
            npcDef.combatLevel = combatLevel

            packNpcToCache(npcDef)
        }

        private fun packNpcToCache(npcDef: NpcDef, realId: Int = -1) {
            val encodedData = npcDef.encode()
            val npcId = if (realId != -1) realId else npcDef.id
            library.put(index = indexId, archive = archiveId, file = npcId, data = encodedData)
        }

        /**
         * Add all [CustomNpcs] into the cache.
         */
        fun addAllCustomNpcsToCache() {
            for (customNpc in CustomNpcs.values()) {
                addCustomNpcToCache(customNpc)
            }
        }

        /**
         * Add [CustomNpcs] into the cache using simple configuration.
         */
        private fun addCustomNpcToCache(npc: CustomNpcs) {
            val npcDef = if (npc.copyNpc != -1) definitions.get(NpcDef::class.java, npc.copyNpc) else NpcDef(npc.id)
            if (npc.name != "") npcDef.name = npc.npcName
            if (npc.models != null) npcDef.models = npc.models
            if (npc.category != -1) npcDef.category = npc.category
            if (npc.size != 1) npcDef.size = npc.size
            if (npc.standAnim != -1) npcDef.standAnim = npc.standAnim
            if (npc.walkAnim != -1) npcDef.walkAnim = npc.walkAnim
            if (npc.rotateLeftAnim != -1) npcDef.rotateLeftAnim = npc.rotateLeftAnim
            if (npc.rotateRightAnim != -1) npcDef.rotateRightAnim = npc.rotateRightAnim
            if (npc.rotate180Anim != -1) npcDef.rotate180Anim = npc.rotate180Anim
            if (npc.rotate90AnimCW != -1) npcDef.rotate90AnimCW = npc.rotate90AnimCW
            if (npc.rotate90AnimCCW != -1) npcDef.rotate90AnimCCW = npc.rotate90AnimCCW
            if (npc.isMinimapVisible != true) npcDef.isMinimapVisible = npc.isMinimapVisible
            if (npc.combatLevel != -1) npcDef.combatLevel = npc.combatLevel
            if (npc.widthScale != -1) npcDef.widthScale = npc.widthScale
            if (npc.heightScale != -1) npcDef.heightScale = npc.heightScale
            if (npc.rotation != -1) npcDef.rotation = npc.rotation
            if (npc.render != false) npcDef.render = npc.render
            if (npc.ambient != -1) npcDef.ambient = npc.ambient
            if (npc.contrast != -1) npcDef.contrast = npc.contrast
            if (npc.headIcon != -1) npcDef.headIcon = npc.headIcon
            if (npc.varp != -1) npcDef.varp = npc.varp
            if (npc.varbit != -1) npcDef.varbit = npc.varbit
            if (npc.interactable != true) npcDef.interactable = npc.interactable
            if (npc.pet != false) npcDef.pet = npc.pet
            if (!npc.options.contentEquals(Array(5) { "" })) npcDef.options = npc.options
            if (npc.recolors != null) npcDef.recolors = npc.recolors
            if (npc.retextures != null) npcDef.retextures = npc.retextures
            if (npc.chatHeadModels != null) npcDef.chatHeadModels = npc.chatHeadModels
            packNpcToCache(npcDef, npc.id)
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
            println("render: ${npc.render}")
            if (npc.varp != -1) println("varp: ${npc.varp}")
            if (npc.varbit != -1) println("varbit: ${npc.varbit}")
            println("interactable: ${npc.interactable}")
            println("pet: ${npc.pet}")
            if (npc.transforms != null) println("transforms: ${npc.transforms}")
            if (npc.chatHeadModels != null) println("chatHeadModels: ${npc.chatHeadModels!!.map { it.toString() }.toTypedArray().contentToString()}")
            println("params: ${npc.params}")
        }

        /**
         * Display the [ByteArray] generated by the encoder AND display the
         * [ByteArray] data found within the cache for a chosen Npc ID.
         */
        private fun evaluateEncoder(npcId: Int) {
            if (!definitions.contains(NpcDef::class.java, npcId)) {
                println("Npc ID #$npcId doesn't exist in the cache or it's not loaded.")
                return
            }
            val myEncoder = definitions.get(NpcDef::class.java, npcId).encode()
            println("NEW ByteArray: ${myEncoder.map { it.toString() }.toTypedArray().contentToString()}")

            val npc = archive.file(npcId)!!.data!!
            println("OLD ByteArray: ${npc.map { it.toString() }.toTypedArray().contentToString()}")
        }

        private fun loadDefinitions() {
            store = Store(Paths.get("./data", "cache").toFile())
            store.load()
            definitions.loadAll(store)
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