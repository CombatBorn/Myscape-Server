package gg.rsmod.game.service.cachemodifier.packers

import com.displee.cache.CacheLibrary
import com.displee.cache.ProgressListener
import gg.rsmod.game.fs.DefinitionSet
import gg.rsmod.game.fs.def.NpcDef
import gg.rsmod.game.service.cachemodifier.configurations.CustomNpcs
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

//            evaluateEncoder(2005)

            displayNpcData(2005)
//            displayNpcData(240)

//            reworkNpc(1880, "Prestige Master", arrayOf("Talk-to", "", "Prestige-Info"))
//
//            updateCache()
        }

        /**
         * Rename a [Npc] and give customized options. This will make the
         * [Npc] no longer attackable.
         * NOTE: This will not update Npcs.kt or the Npcs server data file configuration.
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

        private fun packNpcToCache(npcDef: NpcDef) {
            val encodedData = npcDef.encode()
            library.put(index = indexId, archive = archiveId, file = npcDef.id, data = encodedData)
        }

        /**
         * Add [CustomNpcs] into the cache using simple configuration.
         */
        private fun addNpcToCache(npc: CustomNpcs) {
            val npcDef = NpcDef(npc.id)
            npcDef.name = npc.npcName
            npcDef.models = npc.models
            npcDef.category = npc.category
            npcDef.size = npc.size
            npcDef.standAnim = npc.standAnim
            npcDef.walkAnim = npc.walkAnim
            npcDef.rotateLeftAnim = npc.rotateLeftAnim
            npcDef.rotateRightAnim = npc.rotateRightAnim
            npcDef.rotate180Anim = npc.rotate180Anim
            npcDef.rotate90AnimCW = npc.rotate90AnimCW
            npcDef.rotate90AnimCCW = npc.rotate90AnimCCW
            npcDef.isMinimapVisible = npc.isMinimapVisible
            npcDef.combatLevel = npc.combatLevel
            npcDef.widthScale = npc.widthScale
            npcDef.heightScale = npc.heightScale
            npcDef.length = npc.length
            npcDef.rotation = npc.rotation
            npcDef.render = npc.render
            npcDef.ambient = npc.ambient
            npcDef.contrast = npc.contrast
            npcDef.headIcon = npc.headIcon
            npcDef.varp = npc.varp
            npcDef.varbit = npc.varbit
            npcDef.interactable = npc.interactable
            npcDef.pet = npc.pet
            npcDef.options = npc.options
            npcDef.recolors = npc.recolors
            npcDef.retextures = npc.retextures
            npcDef.chatHeadModels = npc.chatHeadModels

            packNpcToCache(npcDef)
        }

        private fun displayNpcData(npcId: Int){
            if (!definitions.contains(NpcDef::class.java, npcId)) {
                println("Npc ID #$npcId doesn't exist in the cache.")
                return
            }
            val npc = definitions.get(NpcDef::class.java, npcId)
            if (npc.models != null) println("models: ${npc.models!!.map { it }.toTypedArray().contentToString()}")
            if (npc.name != "") println("name: ${npc.name}")
            if (npc.size != -1) println("size: ${npc.size}")
            if (npc.standAnim != -1) println("standAnim: ${npc.standAnim}")
            if (npc.walkAnim != -1) println("walkAnim: ${npc.walkAnim}")
            if (npc.rotateLeftAnim != -1) println("rotateLeftAnim: ${npc.rotateLeftAnim}")
            if (npc.rotateRightAnim != -1) println("rotateRightAnim: ${npc.rotateRightAnim}")
            if (npc.rotate180Anim != -1) println("rotate180Anim: ${npc.rotate180Anim}")
            if (npc.rotate90AnimCW != -1) println("rotate90AnimCW: ${npc.rotate90AnimCW}")
            if (npc.rotate90AnimCCW != -1) println("rotate90AnimCCW: ${npc.rotate90AnimCCW}")
            if (npc.category != -1) println("category: ${npc.category}")
            if (npc.options.isNotEmpty()) println("options: ${npc.options.map { it }.toTypedArray().contentToString()}")
            if (npc.recolors != null) {
                println("recolors: ${npc.recolors!!.map { it }.toTypedArray().contentToString()}")
                displayRecolors(npc.recolors!!)
            }
            if (npc.retextures != null) println("retextures: ${npc.retextures!!.map { it }.toTypedArray().contentToString()}")
            if (npc.chatHeadModels != null) println("chatHeadModels: ${npc.chatHeadModels!!.map { it }.toTypedArray().contentToString()}")
            println("isMinimapVisible: ${npc.isMinimapVisible}")
            if (npc.combatLevel != -1) println("combatLevel: ${npc.combatLevel}")
            if (npc.widthScale != -1) println("widthScale: ${npc.widthScale}")
            if (npc.heightScale != -1) println("heightScale: ${npc.heightScale}")
            println("render: ${npc.render}")
            if (npc.ambient != -1) println("ambient: ${npc.ambient}")
            if (npc.contrast != -1) println("contrast: ${npc.contrast}")
            if (npc.headIcon != -1) println("headIcon: ${npc.headIcon}")
            if (npc.rotation != -1) println("rotation: ${npc.rotation}")
            if (npc.varbit != -1) println("varbit: ${npc.varbit}")
            if (npc.varp != -1) println("varp: ${npc.varp}")
            if (npc.transforms != null) println("transforms: ${npc.transforms!!.map { it }.toTypedArray().contentToString()}")
            println("interactable: ${npc.interactable}")
            println("pet: ${npc.pet}")
            println("params: ${npc.params}")
        }

        private fun displayRecolors(colorPairs: ArrayList<Pair<Int, Int>>) {
            for (pair in colorPairs) {
                print("[${Integer.toHexString(pair.first)} and ${Integer.toHexString(pair.second)}] ")
            }
            println()
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