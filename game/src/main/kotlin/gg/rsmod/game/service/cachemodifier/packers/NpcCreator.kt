package gg.rsmod.game.service.cachemodifier

import com.displee.cache.CacheLibrary
import com.displee.cache.ProgressListener
import gg.rsmod.game.fs.DefinitionSet
import gg.rsmod.game.fs.def.AnimDef
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
        private fun addCustomNpcToCache(customNpc: CustomNpcs) {
            val npcDef = if (customNpc.copyNpc != -1) definitions.get(NpcDef::class.java, customNpc.copyNpc) else NpcDef(customNpc.id)
            if (customNpc.copyNpc == -1) {
                npcDef.render = customNpc.render
                npcDef.isMinimapVisible = customNpc.isMinimapVisible
                npcDef.interactable = customNpc.interactable
                npcDef.pet = customNpc.pet
            }
            if (customNpc.name != "") npcDef.name = customNpc.npcName
            if (customNpc.models != null) npcDef.models = customNpc.models
            if (customNpc.category != -1) npcDef.category = customNpc.category
            if (customNpc.size != 1) npcDef.size = customNpc.size
            if (customNpc.standAnim != -1) npcDef.standAnim = customNpc.standAnim
            if (customNpc.walkAnim != -1) npcDef.walkAnim = customNpc.walkAnim
            if (customNpc.rotateLeftAnim != -1) npcDef.rotateLeftAnim = customNpc.rotateLeftAnim
            if (customNpc.rotateRightAnim != -1) npcDef.rotateRightAnim = customNpc.rotateRightAnim
            if (customNpc.rotate180Anim != -1) npcDef.rotate180Anim = customNpc.rotate180Anim
            if (customNpc.rotate90AnimCW != -1) npcDef.rotate90AnimCW = customNpc.rotate90AnimCW
            if (customNpc.rotate90AnimCCW != -1) npcDef.rotate90AnimCCW = customNpc.rotate90AnimCCW
            if (customNpc.combatLevel != -1) npcDef.combatLevel = customNpc.combatLevel
            if (customNpc.widthScale != -1) npcDef.widthScale = customNpc.widthScale
            if (customNpc.heightScale != -1) npcDef.heightScale = customNpc.heightScale
            if (customNpc.rotation != -1) npcDef.rotation = customNpc.rotation
            if (customNpc.ambient != -1) npcDef.ambient = customNpc.ambient
            if (customNpc.contrast != -1) npcDef.contrast = customNpc.contrast
            if (customNpc.headIcon != -1) npcDef.headIcon = customNpc.headIcon
            if (customNpc.varp != -1) npcDef.varp = customNpc.varp
            if (customNpc.varbit != -1) npcDef.varbit = customNpc.varbit
            if (!customNpc.options.contentEquals(Array(5) { "" })) npcDef.options = customNpc.options
            if (customNpc.recolors != null) npcDef.recolors = customNpc.recolors
            if (customNpc.retextures != null) npcDef.retextures = customNpc.retextures
            if (customNpc.chatHeadModels != null) npcDef.chatHeadModels = customNpc.chatHeadModels
            packNpcToCache(npcDef, customNpc.id)
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
            if (npc.recolors != null) println("recolors: ${npc.recolors}")
            if (npc.retextures != null) println("retextures: ${npc.retextures}")
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
            definitions.load(store, NpcDef::class.java)
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