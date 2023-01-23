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
        var slayerDataMap: EnumMap<SlayerTaskType, ArrayList<Assignments>> = EnumMap(SlayerTaskType::class.java)

        fun load() {

            var assignments: EnumMap<SlayerTaskType, ArrayList<Assignments>>

            /**
             * VANNAKA
             */
            assignments = EnumMap(SlayerTaskType::class.java)
            assignments[SlayerTaskType.EASY] = arrayListOf(
                Assignments.CHICKEN, Assignments.GOBLIN, Assignments.MONKEY, Assignments.RAT,
                Assignments.SPIDER, Assignments.BAT, Assignments.COW, Assignments.DWARF,
                Assignments.MINOTAUR, Assignments.SCORPION, Assignments.ZOMBIE, Assignments.BEAR,
                Assignments.GHOST, Assignments.DOG, Assignments.KALPHITE, Assignments.SKELETON,
                Assignments.ICEFIEND, Assignments.WOLF, Assignments.CRAWLING_HAND,
                Assignments.CAVE_CRAWLER, Assignments.BANSHEE, Assignments.CAVE_SLIME,
                Assignments.LIZARD
            )
            assignments[SlayerTaskType.MEDIUM] = arrayListOf(
                Assignments.MOLANISK, Assignments.COCKATRICE, Assignments.EARTH_WARRIOR,
                Assignments.FLESH_CRAWLER, Assignments.GHOUL, Assignments.HILL_GIANT,
                Assignments.ICE_WARRIOR, Assignments.KILLERWATT, Assignments.WATERFIEND,
                Assignments.MOGRE, Assignments.OGRE, Assignments.MOSS_GIANT,
                Assignments.CROCODILE, Assignments.ICE_GIANT, Assignments.GREEN_DRAGON,
                Assignments.WEREWOLF, Assignments.SEASNAKE, Assignments.PYREFIEND,
                Assignments.ROCK_SLUG, Assignments.SHADE, Assignments.VAMPYRE,
                Assignments.WHITE_WOLF, Assignments.AVIANSIES, Assignments.LIZARDMAN,
                Assignments.TZHAAR, Assignments.LESSER_DEMON, Assignments.SHADOW_WARRIOR,
                Assignments.TROLL, Assignments.BLUE_DRAGON, Assignments.FIRE_GIANT,
                Assignments.JUNGLE_HORROR
            )
            assignments[SlayerTaskType.HARD] = arrayListOf(
                Assignments.RED_DRAGON, Assignments.ELF, Assignments.BLACK_DRAGON,
                Assignments.BRONZE_DRAGON, Assignments.DAGGANOTH, Assignments.HELLHOUND,
                Assignments.BLACK_DEMON, Assignments.IRON_DRAGON, Assignments.STEEL_DRAGON,
                Assignments.HARPIE_BUG_SWARM, Assignments.BASILISK, Assignments.FEVER_SPIDER,
                Assignments.INFERNAL_MAGE, Assignments.BRINE_RAT, Assignments.BLOODVELD,
                Assignments.MITHRIL_DRAGON, Assignments.ZYGOMITE, Assignments.ABERRANT_SPECTRE,
                Assignments.WYRM, Assignments.SPIRITUAL_CREATURE, Assignments.DUST_DEVIL,
                Assignments.FOSSIL_WYVERN, Assignments.KURASK, Assignments.SKELETAL_WYVERN,
                Assignments.GARGOYLES, Assignments.NECHRYAEL, Assignments.ADAMANT_DRAGON,
                Assignments.DARK_BEAST, Assignments.DRAKE, Assignments.RUNE_DRAGON,
                Assignments.SUQAH, Assignments.ABYSSAL_DEMON
            )
            assignments[SlayerTaskType.BOSS] = arrayListOf(
                Assignments.TZTOK_JAD, Assignments.KING_BLACK_DRAGON, Assignments.CORPOREAL_BEAST,
                Assignments.GIANT_MOLE, Assignments.DAGANNOTH_KING, Assignments.KALPHITE_QUEEN,
                Assignments.COMMANDER_ZILYANA, Assignments.GENERAL_GRAARDOR, Assignments.KREEARA,
                Assignments.KRIL_TSUTSAROTH, Assignments.ZULRAH, Assignments.VORKATH,
                Assignments.ABYSSAL_SIRE, Assignments.KRAKEN, Assignments.CERBERUS,
                Assignments.THERMONUCLEAR_SMOKE_DEVIL
            )
            slayerMasters[403] = SlayerMaster(id = 403, rank = 0, assignments = assignments)

            /**
             * RAT MAN
             */
            assignments = EnumMap(SlayerTaskType::class.java)
            assignments[SlayerTaskType.HEROISM] = arrayListOf(
                Assignments.RAT, Assignments.SPIDER, Assignments.SEWER_CRAB,
                Assignments.MUTATED_LOBSTER, Assignments.SEWER_DEMON, Assignments.SEWER_SNAKE,
                Assignments.SEWER_GIANT, Assignments.SEWER_DOG
            )
            slayerMasters[3578] = SlayerMaster(id = 3578, rank = 1, assignments = assignments)

            /**
             * ISLANDER
             */
            assignments = EnumMap(SlayerTaskType::class.java)
            assignments[SlayerTaskType.HEROISM] = arrayListOf(
                Assignments.GOBLIN_VARITY, Assignments.GOBLIN, Assignments.WITCH_DOCTOR,
                Assignments.PIRATE, Assignments.IMP, Assignments.GHOST_WARRIOR, Assignments.BEAR,
                Assignments.MINOTAUR, Assignments.BARBARIAN_SPIRIT, Assignments.BARBARIAN,
                Assignments.DARK_WIZARD, Assignments.CRAWLING_HAND, Assignments.BANSHEE,
                Assignments.SCORPION, Assignments.WOLF, Assignments.CAVE_SPIRIT,
                Assignments.GHOST, Assignments.GHOUL, Assignments.GHAST,
                Assignments.DRAGON_SPAWN, Assignments.MOSS_GIANT, Assignments.ZYGOMITE
            )
            slayerMasters[7483] = SlayerMaster(id = 7483, rank = 2, assignments = assignments)

            /**
             * DWARVEN
             */
            assignments = EnumMap(SlayerTaskType::class.java)
            assignments[SlayerTaskType.HEROISM] = arrayListOf(
                Assignments.ROCK_CRAB, Assignments.SNOW_MITE, Assignments.ICE_BAT,
                Assignments.DARK_WARRIOR, Assignments.BLACK_KNIGHT, Assignments.ICE_SPIRIT,
                Assignments.WOLF, Assignments.FROZEN_ARCHER, Assignments.ICEFIEND,
                Assignments.JELLY, Assignments.POISON_SPIDER, Assignments.BRINE_RAT,
                Assignments.SKELETON_FREMINEK, Assignments.TROLL, Assignments.ICE_WARRIOR
            )
            slayerMasters[2989] = SlayerMaster(id = 2989, rank = 3, assignments = assignments)

            /**
             * KHARID
             */
            assignments = EnumMap(SlayerTaskType::class.java)
            assignments[SlayerTaskType.HEROISM] = arrayListOf(
                Assignments.HARPIE_BUG, Assignments.SAND_CRAB, Assignments.CAVE_GOLEM,
                Assignments.CAVE_CRAWLER, Assignments.ROCK_SLUG, Assignments.FLESH_CRAWLER,
                Assignments.BASILISK, Assignments.SAND_SNAKE, Assignments.LIZARDMEN,
                Assignments.PYREFIEND, Assignments.ORK, Assignments.JOGRE,
                Assignments.FIRE_GIANT, Assignments.KURASK, Assignments.KALPHITE,
                Assignments.TZHAAR
            )
            slayerMasters[3844] = SlayerMaster(id = 3844, rank = 4, assignments = assignments)

            /**
             * ANGELIC NIEVE
             */
            assignments = EnumMap(SlayerTaskType::class.java)
            assignments[SlayerTaskType.HEROISM] = arrayListOf(
                Assignments.WYRM, Assignments.MUMMY, Assignments.VYREWATCH,
                Assignments.DEMONIC_GORILLA, Assignments.NECHRYAEL, Assignments.TERROR_CAT,
                Assignments.DRAKE, Assignments.CERBERUS, Assignments.ABYSSAL_DEMON,
                Assignments.KRAKEN, Assignments.ABYSSAL_SIRE, Assignments.RIVER_TROLL,
                Assignments.SHADE, Assignments.JUNGLE_HORROR, Assignments.DAGANNOTH_KING,
                Assignments.BLOODVELD, Assignments.HELLHOUND, Assignments.TUROTH,
                Assignments.DEVIANT_SPECTRE, Assignments.AVIANSIES, Assignments.ZAMORAK_WARRIOR,
                Assignments.LESSER_DEMON, Assignments.BLACK_DEMON, Assignments.SKELETAL_WYVERN,
                Assignments.DUST_DEVIL, Assignments.ANKOU, Assignments.SMOKE_DEVIL,
                Assignments.DARK_BEAST, Assignments.CHRONOZONE,
                Assignments.GREEN_BLUE_RED_BLACK_DRAGON, Assignments.METAL_DRAGON, Assignments.HYDRA,
                Assignments.ALCHEMICAL_HYDRA, Assignments.VORKATH, Assignments.LAVA_DRAGON,
                Assignments.SOUL_DRAGON
            )
            slayerMasters[3995] = SlayerMaster(id = 3995, rank = 5, assignments = assignments)

            /**
             * EVIL MAN
             */
            assignments = EnumMap(SlayerTaskType::class.java)
            assignments[SlayerTaskType.CORRUPTION] = arrayListOf(
                Assignments.MEN, Assignments.GUARD, Assignments.PRIEST,
                Assignments.SHARP_SHOOTER, Assignments.WIZARD, Assignments.CHEF,
                Assignments.WOODCUTTER, Assignments.FISHERMAN, Assignments.AFFLICTED,
                Assignments.PLAGUE_FIGHTER
            )
            slayerMasters[3541] = SlayerMaster(id = 3541, rank = 1, assignments = assignments)

            /**
             * EVIL PIRATE
             */
            assignments = EnumMap(SlayerTaskType::class.java)
            assignments[SlayerTaskType.CORRUPTION] = arrayListOf(
                Assignments.DOG, Assignments.MASTER_FARMER, Assignments.FORRESTER,
                Assignments.NATURE_MONK, Assignments.EXPLORER, Assignments.BEE_KEEPER,
                Assignments.SHIP_CREW, Assignments.MARKET_GUARD, Assignments.DRUIDIC_MAGE,
                Assignments.CHIEF_WARRIOR, Assignments.ARCHER_SOLIDER, Assignments.MASTER_RANGER
            )
            slayerMasters[5840] = SlayerMaster(id = 5840, rank = 2, assignments = assignments)

            /**
             * EVIL WIZARD
             */
            assignments = EnumMap(SlayerTaskType::class.java)
            assignments[SlayerTaskType.CORRUPTION] = arrayListOf(
                Assignments.DESERT_LOCAL, Assignments.DESERT_GUARD, Assignments.DESERT_BANDIT,
                Assignments.DESERT_DRUID, Assignments.DESERT_ASSASSIN, Assignments.ANIMATED_ARMOR,
                Assignments.GNOME
            )
            slayerMasters[3515] = SlayerMaster(id = 3515, rank = 3, assignments = assignments)

            /**
             * EVIL GNOME
             */
            assignments = EnumMap(SlayerTaskType::class.java)
            assignments[SlayerTaskType.CORRUPTION] = arrayListOf(
                Assignments.GORILLA_GUARD, Assignments.MONKEY_ARCHER, Assignments.NINJA_MONKEY,
                Assignments.SKELETAL_MONKEY, Assignments.MONKEY_PRIEST, Assignments.MANIACAL_MONKEY,
                Assignments.ROYAL_MONKEY, Assignments.MONKEY_ELDER
            )
            slayerMasters[6025] = SlayerMaster(id = 6025, rank = 4, assignments = assignments)

            /**
             * EVIL STEVE
             */
            assignments = EnumMap(SlayerTaskType::class.java)
            assignments[SlayerTaskType.CORRUPTION] = arrayListOf(
                Assignments.ELF_WARRIOR, Assignments.GRYPHON, Assignments.ETERNAL_WIZARD,
                Assignments.HOLY_GUARD, Assignments.DEVOUT_PRIEST, Assignments.HOLY_ARCHER,
                Assignments.GRAND_WIZARD, Assignments.HOLY_GNOME, Assignments.GNOME_AGENT,
                Assignments.HOLY_GIANT, Assignments.SPIRITUAL_CREATURE
            )
            slayerMasters[2460] = SlayerMaster(id = 2460, rank = 5, assignments = assignments)

            loadSlayerDataMap()

        }

        /**
         * Loads [slayerDataMap] which stores an alphabetically sorted list of [Assignments]s for each
         * [SlayerTaskType] This data is used for the Slayer Favorite/Block list interface (#5000).
         */
        private fun loadSlayerDataMap() {
            val map: EnumMap<SlayerTaskType, ArrayList<Assignments>> = EnumMap(SlayerTaskType::class.java)
            for (slayerMasterId in slayerMasters.keys){
                val master = slayerMasters[slayerMasterId]
                for (taskType in master?.assignments?.keys!!) {
                    if (map[taskType] == null) map[taskType] = ArrayList()
                    for (assignment in master.assignments[taskType]!!){
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
                            val name = assignment.taskName
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
        private fun ArrayList<Assignments>.sortNamesAlphabetically(): ArrayList<Assignments> {
            val list: ArrayList<Pair<String, Assignments>> = ArrayList()
            this.forEach{ assignment ->
                list.add(assignment.taskName to assignment)
            }
            return ArrayList(list.sortedBy { it.first }.map { it.second })
        }
    }
}