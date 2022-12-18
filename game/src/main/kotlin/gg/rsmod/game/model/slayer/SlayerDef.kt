package gg.rsmod.game.model.slayer

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
        var slayerDataMap: EnumMap<SlayerTaskType, ArrayList<SlayerAssignment>> = EnumMap(SlayerTaskType::class.java)

        fun load() {

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
                SlayerAssignment(id = 0, task = Tasks.CHICKEN, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 1, task = Tasks.GOBLIN, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 2, task = Tasks.MONKEY, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 3, task = Tasks.RAT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 4, task = Tasks.SPIDER, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 5, task = Tasks.BAT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 6, task = Tasks.COW, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 7, task = Tasks.DWARF, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 8, task = Tasks.MINOTAUR, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 9, task = Tasks.SCORPION, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 10, task = Tasks.ZOMBIE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 11, task = Tasks.BEAR, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 12, task = Tasks.GHOST, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 13, task = Tasks.DOG, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 14, task = Tasks.KALPHITE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 15, task = Tasks.SKELETON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 16, task = Tasks.ICEFIEND, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 17, task = Tasks.WOLF, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 18, task = Tasks.CRAWLING_HAND, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 19, task = Tasks.CAVE_CRAWLER, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 20, task = Tasks.BANSHEE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 21, task = Tasks.CAVE_SLIME, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 22, task = Tasks.LIZARD, type = type, min = 40, max = 80, weight = 10)
            )
            assignments[type] = assignmentList

            type = SlayerTaskType.MEDIUM
            assignmentList = arrayListOf(
                SlayerAssignment(id = 23, task = Tasks.MOLANISK, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 24, task = Tasks.COCKATRICE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 25, task = Tasks.EARTH_WARRIOR, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 26, task = Tasks.FLESH_CRAWLER, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 27, task = Tasks.GHOUL, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 28, task = Tasks.HILL_GIANT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 29, task = Tasks.ICE_WARRIOR, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 30, task = Tasks.KILLERWATT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 31, task = Tasks.WATERFIEND, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 32, task = Tasks.MOGRE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 33, task = Tasks.OGRE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 34, task = Tasks.MOSS_GIANT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 35, task = Tasks.CROCODILE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 36, task = Tasks.ICE_GIANT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 37, task = Tasks.GREEN_DRAGON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 38, task = Tasks.WEREWOLF, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 39, task = Tasks.SEASNAKE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 40, task = Tasks.PYREFIEND, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 41, task = Tasks.ROCK_SLUG, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 42, task = Tasks.SHADE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 43, task = Tasks.VAMPYRE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 44, task = Tasks.WHITE_WOLF, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 45, task = Tasks.AVIANSIES, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 46, task = Tasks.LIZARDMAN, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 47, task = Tasks.TZHAAR, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 48, task = Tasks.LESSER_DEMON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 49, task = Tasks.SHADOW_WARRIOR, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 50, task = Tasks.TROLL, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 51, task = Tasks.BLUE_DRAGON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 52, task = Tasks.FIRE_GIANT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 53, task = Tasks.JUNGLE_HORROR, type = type, min = 40, max = 80, weight = 10)
            )
            assignments[type] = assignmentList

            type = SlayerTaskType.HARD
            assignmentList = arrayListOf(
                SlayerAssignment(id = 54, task = Tasks.RED_DRAGON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 55, task = Tasks.ELF, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 56, task = Tasks.BLACK_DRAGON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 57, task = Tasks.BRONZE_DRAGON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 58, task = Tasks.DAGGANOTH, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 59, task = Tasks.HELLHOUND, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 60, task = Tasks.BLACK_DEMON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 61, task = Tasks.IRON_DRAGON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 62, task = Tasks.STEEL_DRAGON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 63, task = Tasks.HARPIE_BUG_SWARM, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 64, task = Tasks.BASILISK, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 65, task = Tasks.FEVER_SPIDER, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 66, task = Tasks.INFERNAL_MAGE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 67, task = Tasks.BRINE_RAT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 68, task = Tasks.BLOODVELD, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 69, task = Tasks.MITHRIL_DRAGON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 70, task = Tasks.ZYGOMITE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 71, task = Tasks.ABERRANT_SPECTRE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 72, task = Tasks.WYRM, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 73, task = Tasks.SPIRITUAL_CREATURE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 74, task = Tasks.DUST_DEVIL, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 75, task = Tasks.FOSSIL_WYVERN, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 76, task = Tasks.KURASK, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 77, task = Tasks.SKELETAL_WYVERN, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 78, task = Tasks.GARGOYLES, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 79, task = Tasks.NECHRYAEL, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 80, task = Tasks.ADAMANT_DRAGON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 81, task = Tasks.DARK_BEAST, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 82, task = Tasks.DRAKE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 83, task = Tasks.RUNE_DRAGON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 84, task = Tasks.SUQAH, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 85, task = Tasks.ABYSSAL_DEMON, type = type, min = 40, max = 80, weight = 10)
            )
            assignments[type] = assignmentList

            type = SlayerTaskType.BOSS
            assignmentList = arrayListOf(
                SlayerAssignment(id = 86, task = Tasks.TZTOK_JAD, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 87, task = Tasks.KING_BLACK_DRAGON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 88, task = Tasks.CORPOREAL_BEAST, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 89, task = Tasks.GIANT_MOLE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 90, task = Tasks.DAGANNOTH_KING, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 91, task = Tasks.KALPHITE_QUEEN, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 92, task = Tasks.COMMANDER_ZILYANA, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 93, task = Tasks.GENERAL_GRAARDOR, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 94, task = Tasks.KREEARA, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 95, task = Tasks.KRIL_TSUTSAROTH, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 96, task = Tasks.ZULRAH, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 97, task = Tasks.VORKATH, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 98, task = Tasks.ABYSSAL_SIRE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 99, task = Tasks.KRAKEN, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 100, task = Tasks.CERBERUS, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 101, task = Tasks.THERMONUCLEAR_SMOKE_DEVIL, type = type, min = 40, max = 80, weight = 10)
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
                SlayerAssignment(id = 102, task = Tasks.RAT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 103, task = Tasks.SPIDER, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 104, task = Tasks.SEWER_CRAB, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 105, task = Tasks.MUTATED_LOBSTER, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 106, task = Tasks.SEWER_DEMON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 107, task = Tasks.SEWER_SNAKE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 108, task = Tasks.SEWER_GIANT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 109, task = Tasks.SEWER_DOG, type = type, min = 40, max = 80, weight = 10)
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
                SlayerAssignment(id = 110, task = Tasks.GOBLIN_VARITY, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 111, task = Tasks.GOBLIN, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 112, task = Tasks.WITCH_DOCTOR, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 113, task = Tasks.PIRATE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 114, task = Tasks.IMP, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 115, task = Tasks.GHOST_WARRIOR, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 116, task = Tasks.BEAR, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 117, task = Tasks.MINOTAUR, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 118, task = Tasks.BARBARIAN_SPIRIT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 119, task = Tasks.BARBARIAN, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 120, task = Tasks.DARK_WIZARD, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 121, task = Tasks.CRAWLING_HAND, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 122, task = Tasks.BANSHEE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 123, task = Tasks.SCORPION, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 124, task = Tasks.WOLF, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 125, task = Tasks.CAVE_SPIRIT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 126, task = Tasks.GHOST, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 127, task = Tasks.GHOUL, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 128, task = Tasks.GHAST, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 129, task = Tasks.DRAGON_SPAWN, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 130, task = Tasks.MOSS_GIANT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 131, task = Tasks.ZYGOMITE, type = type, min = 40, max = 80, weight = 10)
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
                SlayerAssignment(id = 132, task = Tasks.ROCK_CRAB, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 133, task = Tasks.SNOW_MITE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 134, task = Tasks.ICE_BAT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 135, task = Tasks.DARK_WARRIOR, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 136, task = Tasks.BLACK_KNIGHT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 137, task = Tasks.ICE_SPIRIT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 138, task = Tasks.WOLF, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 139, task = Tasks.FROZEN_ARCHER, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 140, task = Tasks.ICEFIEND, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 141, task = Tasks.JELLY, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 142, task = Tasks.POISON_SPIDER, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 143, task = Tasks.BRINE_RAT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 144, task = Tasks.SKELETON_FREMINEK, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 145, task = Tasks.TROLL, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 146, task = Tasks.ICE_WARRIOR, type = type, min = 40, max = 80, weight = 10)
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
                SlayerAssignment(id = 147, task = Tasks.HARPIE_BUG, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 148, task = Tasks.SAND_CRAB, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 149, task = Tasks.CAVE_GOLEM, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 150, task = Tasks.CAVE_CRAWLER, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 151, task = Tasks.ROCK_SLUG, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 152, task = Tasks.FLESH_CRAWLER, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 153, task = Tasks.BASILISK, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 154, task = Tasks.SAND_SNAKE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 155, task = Tasks.LIZARDMEN, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 156, task = Tasks.PYREFIEND, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 157, task = Tasks.ORK, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 158, task = Tasks.JOGRE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 159, task = Tasks.FIRE_GIANT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 160, task = Tasks.KURASK, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 161, task = Tasks.KALPHITE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 162, task = Tasks.TZHAAR, type = type, min = 40, max = 80, weight = 10)
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
                SlayerAssignment(id = 163, task = Tasks.WYRM, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 164, task = Tasks.MUMMY, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 165, task = Tasks.VYREWATCH, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 166, task = Tasks.DEMONIC_GORILLA, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 167, task = Tasks.NECHRYAEL, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 168, task = Tasks.TERROR_CAT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 169, task = Tasks.DRAKE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 170, task = Tasks.CERBERUS, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 171, task = Tasks.ABYSSAL_DEMON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 172, task = Tasks.KRAKEN, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 173, task = Tasks.ABYSSAL_SIRE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 174, task = Tasks.RIVER_TROLL, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 175, task = Tasks.SHADE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 176, task = Tasks.JUNGLE_HORROR, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 177, task = Tasks.DAGANNOTH_KING, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 178, task = Tasks.BLOODVELD, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 179, task = Tasks.HELLHOUND, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 180, task = Tasks.TUROTH, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 181, task = Tasks.DEVIANT_SPECTRE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 182, task = Tasks.AVIANSIES, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 183, task = Tasks.ZAMORAK_WARRIOR, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 184, task = Tasks.LESSER_DEMON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 185, task = Tasks.BLACK_DEMON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 186, task = Tasks.SKELETAL_WYVERN, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 187, task = Tasks.DUST_DEVIL, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 188, task = Tasks.ANKOU, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 189, task = Tasks.SMOKE_DEVIL, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 190, task = Tasks.DARK_BEAST, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 191, task = Tasks.CHRONOZONE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 192, task = Tasks.GREEN_BLUE_RED_BLACK_DRAGON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 193, task = Tasks.METAL_DRAGON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 194, task = Tasks.HYDRA, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 195, task = Tasks.ALCHEMICAL_HYDRA, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 196, task = Tasks.VORKATH, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 197, task = Tasks.LAVA_DRAGON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 198, task = Tasks.SOUL_DRAGON, type = type, min = 40, max = 80, weight = 10)
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
                SlayerAssignment(id = 199, task = Tasks.MEN, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 200, task = Tasks.GUARD, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 201, task = Tasks.PRIEST, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 202, task = Tasks.SHARP_SHOOTER, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 203, task = Tasks.WIZARD, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 204, task = Tasks.CHEF, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 205, task = Tasks.WOODCUTTER, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 206, task = Tasks.FISHERMAN, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 207, task = Tasks.AFFLICTED, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 208, task = Tasks.PLAGUE_FIGHTER, type = type, min = 40, max = 80, weight = 10)
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
                SlayerAssignment(id = 209, task = Tasks.DOG, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 210, task = Tasks.MASTER_FARMER, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 211, task = Tasks.FORRESTER, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 212, task = Tasks.NATURE_MONK, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 213, task = Tasks.EXPLORER, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 214, task = Tasks.BEE_KEEPER, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 215, task = Tasks.SHIP_CREW, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 216, task = Tasks.MARKET_GUARD, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 217, task = Tasks.DRUIDIC_MAGE, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 218, task = Tasks.CHIEF_WARRIOR, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 219, task = Tasks.ARCHER_SOLIDER, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 220, task = Tasks.MASTER_RANGER, type = type, min = 40, max = 80, weight = 10)
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
                SlayerAssignment(id = 221, task = Tasks.DESERT_LOCAL, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 222, task = Tasks.DESERT_GUARD, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 223, task = Tasks.DESERT_BANDIT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 224, task = Tasks.DESERT_DRUID, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 225, task = Tasks.DESERT_ASSASSIN, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 226, task = Tasks.ANIMATED_ARMOR, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 230, task = Tasks.GNOME, type = type, min = 40, max = 80, weight = 10)
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
                SlayerAssignment(id = 231, task = Tasks.GORILLA_GUARD, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 232, task = Tasks.MONKEY_ARCHER, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 233, task = Tasks.NINJA_MONKEY, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 234, task = Tasks.SKELETAL_MONKEY, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 235, task = Tasks.MONKEY_PRIEST, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 236, task = Tasks.MANIACAL_MONKEY, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 237, task = Tasks.ROYAL_MONKEY, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 238, task = Tasks.MONKEY_ELDER, type = type, min = 40, max = 80, weight = 10)
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
                SlayerAssignment(id = 239, task = Tasks.ELF_WARRIOR, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 240, task = Tasks.GRYPHON, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 241, task = Tasks.ETERNAL_WIZARD, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 242, task = Tasks.HOLY_GUARD, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 243, task = Tasks.DEVOUT_PRIEST, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 244, task = Tasks.HOLY_ARCHER, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 245, task = Tasks.GRAND_WIZARD, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 246, task = Tasks.HOLY_GNOME, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 247, task = Tasks.GNOME_AGENT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 248, task = Tasks.HOLY_GIANT, type = type, min = 40, max = 80, weight = 10),
                SlayerAssignment(id = 249, task = Tasks.SPIRITUAL_CREATURE, type = type, min = 40, max = 80, weight = 10)
            )
            assignments[type] = assignmentList

            slayerMasters[slayerMasterId] = SlayerMaster(id = slayerMasterId, rank = slayerMasterRank, slayerAssignments = assignments)

            loadSlayerDataMap()
        }

        /**
         * Loads [slayerDataMap] which stores an alphabetically sorted list of [SlayerAssignment]s for each
         * [SlayerTaskType] This data is used for the Slayer Favorite/Block list interface (#5000).
         */
        private fun loadSlayerDataMap() {
            val map: EnumMap<SlayerTaskType, ArrayList<SlayerAssignment>> = EnumMap(SlayerTaskType::class.java)
            for (slayerMasterId in slayerMasters.keys){
                val master = slayerMasters[slayerMasterId]
                for (taskType in master?.slayerAssignments?.keys!!) {
                    if (map[taskType] == null) map[taskType] = ArrayList()
                    for (assignment in master.slayerAssignments[taskType]!!){
                        map[taskType]!!.add(assignment)
                    }
                }
            }
            for (taskType in SlayerTaskType.values()) {
                map[taskType] = map[taskType]?.sortNamesAlphabetically()
            }
            slayerDataMap = map
        }

        /**
         * Generate the CS2 file configuration for Client Script 30012
         * Output for the generated information is located in ./data/slayer_npcs.txt
         * This can be directly pasted into the CS2
         */
        fun writeCs2SlayerListFile() {
            File("./data/slayer_npcs.txt").bufferedWriter().use { out ->
                out.write("// This file is generated for Client Script 30012\n")
                out.write("// Carefully insert the following into the Client Script:\n\n")
                SlayerTaskType.values().forEach { taskType ->
                    val assignments = slayerDataMap[taskType]
                    if (assignments != null) {
                        if (taskType.order == 1) out.write("\n\tif (arg1 == ${taskType.order}) {\n")
                        else out.write("\n\telse if (arg1 == ${taskType.order}) {\n")
                        var index = 0
                        for (assignment in assignments) {
                            val name = assignment.task.taskName
                            val resizedName = if (name.length <= 18) name else (name.substring(0..17) + "..")
                            out.write("\t\tscript_30011(widget0, $index, \"$resizedName\");\n")
                            index++
                        }
                        out.write("\t\tint4 = ${assignments.size};\n\t}")
                    }
                }
            }
        }

        /**
         * Sorts all Task NPCs for specific [SlayerTaskType] into an [ArrayList]
         */
//        private fun ArrayList<Int>.sortNamesAlphabetically(world: World): ArrayList<Int> {
//            val list: ArrayList<Pair<String, Int>> = ArrayList()
//            this.forEach{id ->
//                list.add(world.definitions.get(NpcDef::class.java, it).name to it)
//            }
//            return ArrayList(list.sortedBy { it.first }.map { it.second })
//        }
        private fun ArrayList<SlayerAssignment>.sortNamesAlphabetically(): ArrayList<SlayerAssignment> {
            val list: ArrayList<Pair<String, SlayerAssignment>> = ArrayList()
            this.forEach{ assignment ->
                list.add(assignment.task.taskName to assignment)
            }
            return ArrayList(list.sortedBy { it.first }.map { it.second })
        }
    }
}