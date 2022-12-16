package gg.rsmod.game.model.slayer

import gg.rsmod.game.fs.def.NpcDef
import gg.rsmod.game.model.World
import java.io.File
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class SlayerDef {

    companion object {

        /**
         * Stores data for each slayer master.
         * @param Int Represents the Slayer Master's ID.
         *
         * @param SlayerMaster The [SlayerMaster].
         */
        val slayerMasters: HashMap<Int, SlayerMaster> = HashMap()

        /**
         * An alphabetically sorted [ArrayList] of all NPC Ids for each [SlayerTaskType]
         * This data is used for the Slayer Favorite/Block list interface (#5000).
         */
        var slayerDataMap: EnumMap<SlayerTaskType, ArrayList<Int>> = EnumMap(SlayerTaskType::class.java)

        fun load(world: World) {

            var slayerMasterId: Int
            var slayerMasterRank: Int
            var assignmentList: ArrayList<SlayerAssignment>
            var assignments: EnumMap<SlayerTaskType, ArrayList<SlayerAssignment>>
            var type: SlayerTaskType

            /**
             * VANNAKA
             */

            slayerMasterId = 403
            slayerMasterRank = 0

            assignments = EnumMap(SlayerTaskType::class.java)

            type = SlayerTaskType.EASY
            assignmentList = arrayListOf(
                SlayerAssignment(id = 0, slayerNpc = SlayerNpc.CHICKEN, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 1, slayerNpc = SlayerNpc.GOBLIN, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 2, slayerNpc = SlayerNpc.MONKEY, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 3, slayerNpc = SlayerNpc.RAT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 4, slayerNpc = SlayerNpc.SPIDER, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 5, slayerNpc = SlayerNpc.BAT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 6, slayerNpc = SlayerNpc.COW, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 7, slayerNpc = SlayerNpc.DWARF, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 8, slayerNpc = SlayerNpc.MINOTAUR, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 9, slayerNpc = SlayerNpc.SCORPION, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 10, slayerNpc = SlayerNpc.ZOMBIE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 11, slayerNpc = SlayerNpc.BEAR, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 12, slayerNpc = SlayerNpc.GHOST, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 13, slayerNpc = SlayerNpc.DOG, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 14, slayerNpc = SlayerNpc.KALPHITE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 15, slayerNpc = SlayerNpc.SKELETON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 16, slayerNpc = SlayerNpc.ICEFIEND, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 17, slayerNpc = SlayerNpc.WOLF, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 18, slayerNpc = SlayerNpc.CRAWLING_HAND, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 19, slayerNpc = SlayerNpc.CAVE_CRAWLER, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 20, slayerNpc = SlayerNpc.BANSHEE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 21, slayerNpc = SlayerNpc.CAVE_SLIME, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 22, slayerNpc = SlayerNpc.LIZARD, type = type, min = 40, max = 80, weight = 10)
            )
            assignments[type] = assignmentList

            type = SlayerTaskType.MEDIUM
            assignmentList = arrayListOf(
                SlayerAssignment(id = 23, slayerNpc = SlayerNpc.MOLANISK, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 24, slayerNpc = SlayerNpc.COCKATRICE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 25, slayerNpc = SlayerNpc.EARTH_WARRIOR, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 26, slayerNpc = SlayerNpc.FLESH_CRAWLER, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 27, slayerNpc = SlayerNpc.GHOUL, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 28, slayerNpc = SlayerNpc.HILL_GIANT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 29, slayerNpc = SlayerNpc.ICE_WARRIOR, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 30, slayerNpc = SlayerNpc.KILLERWATT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 31, slayerNpc = SlayerNpc.WATERFIEND, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 32, slayerNpc = SlayerNpc.MOGRE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 33, slayerNpc = SlayerNpc.OGRE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 34, slayerNpc = SlayerNpc.MOSS_GIANT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 35, slayerNpc = SlayerNpc.CROCODILES, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 36, slayerNpc = SlayerNpc.ICE_GIANT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 37, slayerNpc = SlayerNpc.GREEN_DRAGON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 38, slayerNpc = SlayerNpc.WEREWOLF, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 39, slayerNpc = SlayerNpc.SEASNAKE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 40, slayerNpc = SlayerNpc.PYREFIEND, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 41, slayerNpc = SlayerNpc.ROCK_SLUG, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 42, slayerNpc = SlayerNpc.SHADE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 43, slayerNpc = SlayerNpc.VAMPYRE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 44, slayerNpc = SlayerNpc.WHITE_WOLF, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 45, slayerNpc = SlayerNpc.AVIANSIES, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 46, slayerNpc = SlayerNpc.LIZARDMAN, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 47, slayerNpc = SlayerNpc.TZHAAR, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 48, slayerNpc = SlayerNpc.LESSER_DEMON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 49, slayerNpc = SlayerNpc.SHADOW_WARRIOR, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 50, slayerNpc = SlayerNpc.TROLL, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 51, slayerNpc = SlayerNpc.BLUE_DRAGON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 52, slayerNpc = SlayerNpc.FIRE_GIANT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 53, slayerNpc = SlayerNpc.JUNGLE_HORROR, type = type, min = 40, max = 80, weight = 10)
            )
            assignments[type] = assignmentList

            type = SlayerTaskType.HARD
            assignmentList = arrayListOf(
                SlayerAssignment(id = 54, slayerNpc = SlayerNpc.RED_DRAGON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 55, slayerNpc = SlayerNpc.ELF, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 56, slayerNpc = SlayerNpc.BLACK_DRAGON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 57, slayerNpc = SlayerNpc.BRONZE_DRAGON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 58, slayerNpc = SlayerNpc.DAGGANOTH, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 59, slayerNpc = SlayerNpc.HELLHOUND, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 60, slayerNpc = SlayerNpc.BLACK_DEMON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 61, slayerNpc = SlayerNpc.IRON_DRAGON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 62, slayerNpc = SlayerNpc.STEEL_DRAGON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 63, slayerNpc = SlayerNpc.HARPIE_BUG_SWARM, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 64, slayerNpc = SlayerNpc.BASILISK, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 65, slayerNpc = SlayerNpc.FEVER_SPIDER, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 66, slayerNpc = SlayerNpc.INFERNAL_MAGE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 67, slayerNpc = SlayerNpc.BRINE_RAT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 68, slayerNpc = SlayerNpc.BLOODVELD, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 69, slayerNpc = SlayerNpc.MITHRIL_DRAGON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 70, slayerNpc = SlayerNpc.ZYGOMITE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 71, slayerNpc = SlayerNpc.ABERRANT_SPECTRE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 72, slayerNpc = SlayerNpc.WYRM, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 73, slayerNpc = SlayerNpc.SPIRITUAL_CREATURE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 74, slayerNpc = SlayerNpc.DUST_DEVIL, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 75, slayerNpc = SlayerNpc.FOSSIL_WYVERN, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 76, slayerNpc = SlayerNpc.KURASK, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 77, slayerNpc = SlayerNpc.SKELETAL_WYVERN, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 78, slayerNpc = SlayerNpc.GARGOYLES, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 79, slayerNpc = SlayerNpc.NECHRYAEL, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 80, slayerNpc = SlayerNpc.ADAMANT_DRAGON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 81, slayerNpc = SlayerNpc.DARK_BEAST, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 82, slayerNpc = SlayerNpc.DRAKE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 83, slayerNpc = SlayerNpc.RUNE_DRAGON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 84, slayerNpc = SlayerNpc.SUQAH, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 85, slayerNpc = SlayerNpc.ABYSSAL_DEMON, type = type, min = 40, max = 80, weight = 10)
            )
            assignments[type] = assignmentList

            type = SlayerTaskType.BOSS
            assignmentList = arrayListOf(
                SlayerAssignment(id = 86, slayerNpc = SlayerNpc.JAD, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 87, slayerNpc = SlayerNpc.KING_BLACK_DRAGON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 88, slayerNpc = SlayerNpc.CORPOREAL_BEAST, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 89, slayerNpc = SlayerNpc.GIANT_MOLE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 90, slayerNpc = SlayerNpc.DAGANNOTH_KING, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 91, slayerNpc = SlayerNpc.KALPHITE_QUEEN, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 92, slayerNpc = SlayerNpc.COMMANDER_ZILYANA, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 93, slayerNpc = SlayerNpc.GENERAL_GRAARDOR, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 94, slayerNpc = SlayerNpc.KREEARA, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 95, slayerNpc = SlayerNpc.KRIL_TSUTSAROTH, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 96, slayerNpc = SlayerNpc.ZULRAH, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 97, slayerNpc = SlayerNpc.VORKATH, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 98, slayerNpc = SlayerNpc.ABYSSAL_SIRE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 99, slayerNpc = SlayerNpc.KRAKEN, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 100, slayerNpc = SlayerNpc.CERBERUS, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 101, slayerNpc = SlayerNpc.THERMONUCLEAR_SMOKE_DEVIL, type = type, min = 40, max = 80, weight = 10)
            )
            assignments[type] = assignmentList

            slayerMasters[slayerMasterId] = SlayerMaster(id = slayerMasterId, rank = slayerMasterRank, slayerAssignments = assignments)

            /**
             * RAT MAN
             */

            slayerMasterId = 3578
            slayerMasterRank = 1

            assignments = EnumMap(SlayerTaskType::class.java)

            type = SlayerTaskType.HEROISM
            assignmentList = arrayListOf(
                SlayerAssignment(id = 102, slayerNpc = SlayerNpc.RAT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 103, slayerNpc = SlayerNpc.SPIDER, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 104, slayerNpc = SlayerNpc.SEWER_CRAB, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 105, slayerNpc = SlayerNpc.MUTATED_LOBSTER, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 106, slayerNpc = SlayerNpc.SEWER_DEMON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 107, slayerNpc = SlayerNpc.SEWER_SNAKE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 108, slayerNpc = SlayerNpc.SEWER_GIANT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 109, slayerNpc = SlayerNpc.SEWER_DOG, type = type, min = 40, max = 80, weight = 10)
            )
            assignments[type] = assignmentList

            slayerMasters[slayerMasterId] = SlayerMaster(id = slayerMasterId, rank = slayerMasterRank, slayerAssignments = assignments)

            /**
             * ISLANDER
             */

            slayerMasterId = 7483
            slayerMasterRank = 2

            assignments = EnumMap(SlayerTaskType::class.java)

            type = SlayerTaskType.HEROISM
            assignmentList = arrayListOf(
                SlayerAssignment(id = 110, slayerNpc = SlayerNpc.GOBLIN_VARITY, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 111, slayerNpc = SlayerNpc.GOBLIN, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 112, slayerNpc = SlayerNpc.WITCH_DOCTOR, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 113, slayerNpc = SlayerNpc.PIRATE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 114, slayerNpc = SlayerNpc.IMP, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 115, slayerNpc = SlayerNpc.GHOST_WARRIOR, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 116, slayerNpc = SlayerNpc.BEAR, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 117, slayerNpc = SlayerNpc.MINOTAUR, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 118, slayerNpc = SlayerNpc.BARBARIAN_SPIRIT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 119, slayerNpc = SlayerNpc.BARBARIAN, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 120, slayerNpc = SlayerNpc.DARK_WIZARD, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 121, slayerNpc = SlayerNpc.CRAWLING_HAND, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 122, slayerNpc = SlayerNpc.BANSHEE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 123, slayerNpc = SlayerNpc.SCORPION, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 124, slayerNpc = SlayerNpc.WOLF, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 125, slayerNpc = SlayerNpc.CAVE_SPIRIT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 126, slayerNpc = SlayerNpc.GHOST, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 127, slayerNpc = SlayerNpc.GHOUL, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 128, slayerNpc = SlayerNpc.GHAST, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 129, slayerNpc = SlayerNpc.DRAGON_SPAWN, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 130, slayerNpc = SlayerNpc.MOSS_GIANT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 131, slayerNpc = SlayerNpc.ZYGOMITE, type = type, min = 40, max = 80, weight = 10)
            )
            assignments[type] = assignmentList

            slayerMasters[slayerMasterId] = SlayerMaster(id = slayerMasterId, rank = slayerMasterRank, slayerAssignments = assignments)

            /**
             * DWARVEN
             */

            slayerMasterId = 2989
            slayerMasterRank = 3

            assignments = EnumMap(SlayerTaskType::class.java)

            type = SlayerTaskType.HEROISM
            assignmentList = arrayListOf(
                SlayerAssignment(id = 132, slayerNpc = SlayerNpc.ROCK_CRAB, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 133, slayerNpc = SlayerNpc.SNOW_MITE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 134, slayerNpc = SlayerNpc.ICE_BAT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 135, slayerNpc = SlayerNpc.DARK_WARRIOR, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 136, slayerNpc = SlayerNpc.BLACK_KNIGHT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 137, slayerNpc = SlayerNpc.ICE_SPIRIT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 138, slayerNpc = SlayerNpc.WOLF, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 139, slayerNpc = SlayerNpc.FROZEN_ARCHER, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 140, slayerNpc = SlayerNpc.ICEFIEND, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 141, slayerNpc = SlayerNpc.JELLY, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 142, slayerNpc = SlayerNpc.POISON_SPIDER, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 143, slayerNpc = SlayerNpc.BRINE_RAT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 144, slayerNpc = SlayerNpc.SKELETON_FREMINEK, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 145, slayerNpc = SlayerNpc.TROLL, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 146, slayerNpc = SlayerNpc.ICE_WARRIOR, type = type, min = 40, max = 80, weight = 10)
            )
            assignments[type] = assignmentList

            slayerMasters[slayerMasterId] = SlayerMaster(id = slayerMasterId, rank = slayerMasterRank, slayerAssignments = assignments)

            /**
             * KHARID
             */

            slayerMasterId = 3844
            slayerMasterRank = 4

            assignments = EnumMap(SlayerTaskType::class.java)

            type = SlayerTaskType.HEROISM
            assignmentList = arrayListOf(
                SlayerAssignment(id = 147, slayerNpc = SlayerNpc.HARPIE_BUG, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 148, slayerNpc = SlayerNpc.SAND_CRAB, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 149, slayerNpc = SlayerNpc.CAVE_GOLEM, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 150, slayerNpc = SlayerNpc.CAVE_CRAWLER, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 151, slayerNpc = SlayerNpc.ROCK_SLUG, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 152, slayerNpc = SlayerNpc.FLESH_CRAWLER, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 153, slayerNpc = SlayerNpc.BASILISK, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 154, slayerNpc = SlayerNpc.SAND_SNAKE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 155, slayerNpc = SlayerNpc.LIZARDMEN, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 156, slayerNpc = SlayerNpc.PYREFIEND, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 157, slayerNpc = SlayerNpc.ORK, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 158, slayerNpc = SlayerNpc.JOGRE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 159, slayerNpc = SlayerNpc.FIRE_GIANT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 160, slayerNpc = SlayerNpc.KURASK, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 161, slayerNpc = SlayerNpc.KALPHITE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 162, slayerNpc = SlayerNpc.TZHAAR, type = type, min = 40, max = 80, weight = 10)
            )
            assignments[type] = assignmentList

            slayerMasters[slayerMasterId] = SlayerMaster(id = slayerMasterId, rank = slayerMasterRank, slayerAssignments = assignments)

            /**
             * ANGELIC NIEVE
             */

            slayerMasterId = 3995
            slayerMasterRank = 5

            assignments = EnumMap(SlayerTaskType::class.java)

            type = SlayerTaskType.HEROISM
            assignmentList = arrayListOf(
                SlayerAssignment(id = 163, slayerNpc = SlayerNpc.WYRM, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 164, slayerNpc = SlayerNpc.MUMMY, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 165, slayerNpc = SlayerNpc.VYREWATCH, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 166, slayerNpc = SlayerNpc.DEMONIC_GORILLA, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 167, slayerNpc = SlayerNpc.NECHRYAEL, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 168, slayerNpc = SlayerNpc.TERROR_CAT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 169, slayerNpc = SlayerNpc.DRAKE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 170, slayerNpc = SlayerNpc.CERBERUS, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 171, slayerNpc = SlayerNpc.ABYSSAL_DEMON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 172, slayerNpc = SlayerNpc.KRAKEN, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 173, slayerNpc = SlayerNpc.ABYSSAL_SIRE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 174, slayerNpc = SlayerNpc.RIVER_TROLL, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 175, slayerNpc = SlayerNpc.SHADE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 176, slayerNpc = SlayerNpc.JUNGLE_HORROR, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 177, slayerNpc = SlayerNpc.DAGANNOTH_KING, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 178, slayerNpc = SlayerNpc.BLOODVELD, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 179, slayerNpc = SlayerNpc.HELLHOUND, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 180, slayerNpc = SlayerNpc.TUROTH, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 181, slayerNpc = SlayerNpc.DEVIANT_SPECTRE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 182, slayerNpc = SlayerNpc.AVIANSIES, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 183, slayerNpc = SlayerNpc.ZAMORAK_WARRIOR, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 184, slayerNpc = SlayerNpc.LESSER_DEMON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 185, slayerNpc = SlayerNpc.BLACK_DEMON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 186, slayerNpc = SlayerNpc.SKELETAL_WYVERN, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 187, slayerNpc = SlayerNpc.DUST_DEVIL, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 188, slayerNpc = SlayerNpc.ANKOU, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 189, slayerNpc = SlayerNpc.SMOKE_DEVIL, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 190, slayerNpc = SlayerNpc.DARK_BEAST, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 191, slayerNpc = SlayerNpc.CHRONOZONE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 192, slayerNpc = SlayerNpc.GREEN_BLUE_RED_BLACK_DRAGON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 193, slayerNpc = SlayerNpc.METAL_DRAGON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 194, slayerNpc = SlayerNpc.HYDRA, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 195, slayerNpc = SlayerNpc.ALCHEMICAL_HYDRA, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 196, slayerNpc = SlayerNpc.VORKATH, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 197, slayerNpc = SlayerNpc.LAVA_DRAGON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 198, slayerNpc = SlayerNpc.SOUL_DRAGON, type = type, min = 40, max = 80, weight = 10)
            )
            assignments[type] = assignmentList

            slayerMasters[slayerMasterId] = SlayerMaster(id = slayerMasterId, rank = slayerMasterRank, slayerAssignments = assignments)

            /**
             * EVIL MAN
             */

            slayerMasterId = 3541
            slayerMasterRank = 1

            assignments = EnumMap(SlayerTaskType::class.java)

            type = SlayerTaskType.CORRUPTION
            assignmentList = arrayListOf(
                SlayerAssignment(id = 199, slayerNpc = SlayerNpc.HUMAN, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 200, slayerNpc = SlayerNpc.GUARD, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 201, slayerNpc = SlayerNpc.PRIEST, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 202, slayerNpc = SlayerNpc.SHARP_SHOOTER, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 203, slayerNpc = SlayerNpc.WIZARD, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 204, slayerNpc = SlayerNpc.CHEF, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 205, slayerNpc = SlayerNpc.WOODCUTTER, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 206, slayerNpc = SlayerNpc.FISHERMEN, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 207, slayerNpc = SlayerNpc.AFFLICTED, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 208, slayerNpc = SlayerNpc.PLAGUE_FIGHTER, type = type, min = 40, max = 80, weight = 10)
            )
            assignments[type] = assignmentList

            slayerMasters[slayerMasterId] = SlayerMaster(id = slayerMasterId, rank = slayerMasterRank, slayerAssignments = assignments)

            /**
             * EVIL PIRATE
             */

            slayerMasterId = 5840
            slayerMasterRank = 2

            assignments = EnumMap(SlayerTaskType::class.java)

            type = SlayerTaskType.CORRUPTION
            assignmentList = arrayListOf(
                SlayerAssignment(id = 209, slayerNpc = SlayerNpc.DOG, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 210, slayerNpc = SlayerNpc.MASTER_FARMER, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 211, slayerNpc = SlayerNpc.FORRESTER, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 212, slayerNpc = SlayerNpc.NATURE_MONK, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 213, slayerNpc = SlayerNpc.EXPLORER, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 214, slayerNpc = SlayerNpc.BEE_KEEPER, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 215, slayerNpc = SlayerNpc.SHIP_CREW, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 216, slayerNpc = SlayerNpc.MARKET_GUARD, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 217, slayerNpc = SlayerNpc.DRUIDIC_MAGE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 218, slayerNpc = SlayerNpc.CHIEF_WARRIOR, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 219, slayerNpc = SlayerNpc.ARCHER_SOLIDER, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 220, slayerNpc = SlayerNpc.MASTER_RANGER, type = type, min = 40, max = 80, weight = 10)
            )
            assignments[type] = assignmentList

            slayerMasters[slayerMasterId] = SlayerMaster(id = slayerMasterId, rank = slayerMasterRank, slayerAssignments = assignments)

            /**
             * EVIL WIZARD
             */

            slayerMasterId = 3515
            slayerMasterRank = 3

            assignments = EnumMap(SlayerTaskType::class.java)

            type = SlayerTaskType.CORRUPTION
            assignmentList = arrayListOf(
                SlayerAssignment(id = 221, slayerNpc = SlayerNpc.DESERT_LOCAL, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 222, slayerNpc = SlayerNpc.DESERT_GUARD, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 223, slayerNpc = SlayerNpc.DESERT_BANDIT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 224, slayerNpc = SlayerNpc.DESERT_DRUID, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 225, slayerNpc = SlayerNpc.DESERT_ASSASSIN, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 226, slayerNpc = SlayerNpc.BRONZE_IRON_KNIGHT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 227, slayerNpc = SlayerNpc.STEEL_BLACK_KNIGHT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 228, slayerNpc = SlayerNpc.MITHRIL_ADAMANT_KNIGHT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 229, slayerNpc = SlayerNpc.RUNE_DRAGON_KNIGHT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 230, slayerNpc = SlayerNpc.GNOME, type = type, min = 40, max = 80, weight = 10)
            )
            assignments[type] = assignmentList

            slayerMasters[slayerMasterId] = SlayerMaster(id = slayerMasterId, rank = slayerMasterRank, slayerAssignments = assignments)

            /**
             * EVIL GNOME
             */

            slayerMasterId = 6025
            slayerMasterRank = 4

            assignments = EnumMap(SlayerTaskType::class.java)

            type = SlayerTaskType.CORRUPTION
            assignmentList = arrayListOf(
                SlayerAssignment(id = 231, slayerNpc = SlayerNpc.GORILLA_GUARD, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 232, slayerNpc = SlayerNpc.MONKEY_ARCHER, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 233, slayerNpc = SlayerNpc.NINJA_MONKEY, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 234, slayerNpc = SlayerNpc.SKELETAL_MONKEY, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 235, slayerNpc = SlayerNpc.MONKEY_PRIEST, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 236, slayerNpc = SlayerNpc.MANIACAL_MONKEY, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 237, slayerNpc = SlayerNpc.ROYAL_MONKEY, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 238, slayerNpc = SlayerNpc.MONKEY_ELDER, type = type, min = 40, max = 80, weight = 10)
            )
            assignments[type] = assignmentList

            slayerMasters[slayerMasterId] = SlayerMaster(id = slayerMasterId, rank = slayerMasterRank, slayerAssignments = assignments)

            /**
             * EVIL STEVE
             */

            slayerMasterId = 2460
            slayerMasterRank = 5

            assignments = EnumMap(SlayerTaskType::class.java)

            type = SlayerTaskType.CORRUPTION
            assignmentList = arrayListOf(
                SlayerAssignment(id = 239, slayerNpc = SlayerNpc.ELF_WARRIOR, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 240, slayerNpc = SlayerNpc.GRYPHON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 241, slayerNpc = SlayerNpc.ETERNAL_WIZARD, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 242, slayerNpc = SlayerNpc.HOLY_GUARD, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 243, slayerNpc = SlayerNpc.DEVOUT_PRIEST, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 244, slayerNpc = SlayerNpc.HOLY_ARCHER, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 245, slayerNpc = SlayerNpc.GRAND_WIZARD, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 246, slayerNpc = SlayerNpc.HOLY_GNOME, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 247, slayerNpc = SlayerNpc.GNOME_AGENT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 248, slayerNpc = SlayerNpc.HOLY_GIANT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 249, slayerNpc = SlayerNpc.SPIRITUAL_CREATURE, type = type, min = 40, max = 80, weight = 10)
            )
            assignments[type] = assignmentList

            slayerMasters[slayerMasterId] = SlayerMaster(id = slayerMasterId, rank = slayerMasterRank, slayerAssignments = assignments)

            loadSlayerDataMap(world)
        }

        /**
         * Loads [slayerDataMap] which stores an alphabetically sorted list of NPC Ids for each
         * [SlayerTaskType] This data is used for the Slayer Favorite/Block list interface (#5000).
         */
        private fun loadSlayerDataMap(world: World) {
            val map: EnumMap<SlayerTaskType, ArrayList<Int>> = EnumMap(SlayerTaskType::class.java)
            for (slayerMasterId in slayerMasters.keys){
                val master = slayerMasters[slayerMasterId]
                for (taskType in master?.slayerAssignments?.keys!!) {
                    if (map[taskType] == null) map[taskType] = ArrayList()
                    for (assignment in master.slayerAssignments[taskType]!!){
                        var npcName = ""
                        for (npcId in assignment.slayerNpc.npcIds){
                            val name = world.definitions.get(NpcDef::class.java, npcId).name
                            if (name != "") {
                                npcName = name
                                break
                            }
                        }
                        if (npcName == "") {
                            println("SlayerDef Error: Assignment ID #${assignment.id} doesn't have any valid names.")
                            continue
                        }
                        map[taskType]!!.add(assignment.slayerNpc.npcIds[0])
                    }
                }
            }
            for (taskType in SlayerTaskType.values()) {
                map[taskType] = map[taskType]?.sortNamesAlphabetically(world)
            }
            slayerDataMap = map
        }

        /**
         * Generate the CS2 file configuration for Client Script 30012
         * Output for the generated information is located in ./data/slayer_npcs.txt
         * This can be directly pasted into the CS2
         */
        fun writeCs2SlayerListFile(world: World) {
            File("./data/slayer_npcs.txt").bufferedWriter().use { out ->
                out.write("// This file is generated for Client Script 30012\n")
                out.write("// Carefully insert the following into the Client Script:\n\n")
                SlayerTaskType.values().forEach { taskType ->
                    val npcList = slayerDataMap[taskType]
                    if (npcList != null) {
                        if (taskType.order == 1) out.write("\n\tif (arg1 == ${taskType.order}) {\n")
                        else out.write("\n\telse if (arg1 == ${taskType.order}) {\n")
                        var index = 0
                        for (id in npcList) {
                            val name = world.definitions.get(NpcDef::class.java, id).name
                            val resizedName = if (name.length <= 18) name else (name.substring(0..17) + "..")
                            out.write("\t\tscript_30011(widget0, $index, \"$resizedName\");\n")
                            index++
                        }
                        out.write("\t\tint4 = ${npcList.size};\n\t}")
                    }
                }
            }
        }

        /**
         * Sorts all Task NPCs for specific [SlayerTaskType] into an [ArrayList]
         */
        private fun ArrayList<Int>.sortNamesAlphabetically(world: World): ArrayList<Int> {
            val list: ArrayList<Pair<String, Int>> = ArrayList()
            this.forEach{
                list.add(world.definitions.get(NpcDef::class.java, it).name to it)
            }
            return ArrayList(list.sortedBy { it.first }.map { it.second })
        }
    }
}