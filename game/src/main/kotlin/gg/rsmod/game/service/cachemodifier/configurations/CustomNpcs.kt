package gg.rsmod.game.service.cachemodifier

enum class CustomNpcs (
    val copyNpc: Int = -1,
    val id: Int,
    val npcName: String,
    val models: Array<Int>? = null,
    val category: Int = -1,
    val size: Int = 1,
    val standAnim: Int = -1,
    val attackAnim: Int = -1,
    val walkAnim: Int = -1,
    val rotateLeftAnim: Int = -1,
    val rotateRightAnim: Int = -1,
    val rotate180Anim: Int = -1,
    val rotate90AnimCW: Int = -1,
    val rotate90AnimCCW: Int = -1,
    val isMinimapVisible: Boolean = true,
    val combatLevel: Int = -1,
    val widthScale: Int = -1,
    val heightScale: Int = -1,
    val rotation: Int = -1,
    val render: Boolean = true,
    val ambient: Int = -1,
    val contrast: Int = -1,
    val headIcon: Int = -1,
    val varp: Int = -1,
    val varbit: Int = -1,
    val interactable: Boolean = true,
    val pet: Boolean = false,
    val options: Array<String?> = Array(5) { "" },
    val recolors: ArrayList<Pair<Int, Int>>? = null,
    val retextures: ArrayList<Pair<Int, Int>>? = null,
    val chatHeadModels: Array<Int>? = null) {

    /**
     * 11463 is the first available NPC id.
     */

    MOLANISK(
        copyNpc = 1,
        id = 1,
        npcName = "Molanisky"
    ),
    FLESHY_BOI(
        copyNpc = 2498,
        id = 11463,
        npcName = "Fleshy Boi",
        recolors = arrayListOf(Pair(6938, 38839), Pair(7958, 39863), Pair(7068, 38839), Pair(9096, 41911), Pair(6080, 33719), Pair(0, 43957))
    ),
    AIR_GIANT(
        copyNpc = 2085,
        id = 11464,
        npcName = "Air Giant",
        attackAnim = 4652,
        recolors = arrayListOf(Pair(21619, 114), Pair(33075, 55), Pair(33088, 69), Pair(33228, 81), Pair(33112, 91), Pair(51392, 66), Pair(156, 27), Pair(49469, 61), Pair(32951, 58), Pair(32999, 104), Pair(33228, 81), Pair(33088, 69), Pair(33075, 55), Pair(33112, 91), Pair(898, 1))
    ),
    ICE_DRAGON(
        copyNpc = 260,
        id = 11465,
        npcName = "Ice Dragon",
        recolors = arrayListOf(Pair(2469, 38839), Pair(912, 42935), Pair(1938, 41911), Pair(1814, 40887), Pair(2588, 39863), Pair(910, 42935))
    ),
    ROCK_GIANT(
        copyNpc = 2075,
        id = 11466,
        npcName = "Rock Giant",
        recolors = arrayListOf(Pair(1560, 2328), Pair(2853, 2215), Pair(2716, 1192), Pair(2977, 154), Pair(7993, 99), Pair(1556, 19), Pair(262, 1291), Pair(1808, 47), Pair(654, 37), Pair(652, 1189), Pair(4, 1056), Pair(522, 19), Pair(902, 9), Pair(8010, 113), Pair(520, 148), Pair(2714, 61), Pair(10314, 10314), Pair(2857, 45), Pair(70, 70))
    ),
    ICE_JAD(
        copyNpc = 3127,
        id = 11467,
        npcName = "BRANDON",
        recolors = arrayListOf(Pair(62342, 43959), Pair(65426, 42935), Pair(64398, 42935), Pair(55170, 43959), Pair(64400, 42935), Pair(64394, 42935), Pair(64396, 42935), Pair(63368, 43959), Pair(61962, 42935), Pair(4011, 37815), Pair(902, 43959), Pair(900, 43959), Pair(82, 33719), Pair(929, 40887))
    ),
    GEM_CRAB(
            copyNpc = 7576,
            id = 11616,
            npcName = "Gem Crab",
            combatLevel = 47,
            recolors = arrayListOf(Pair(43123, 54265), Pair(127, 127), Pair(28830, 55244), Pair(28727, 55257), Pair(28950, 55240), Pair(28835, 55247), Pair(26669, 55253), Pair(26690, 55264), Pair(29574, 55232), Pair(794, 55241), Pair(32883, 54265), Pair(29194, 55234), Pair(26772, 55239), Pair(26780, 55243), Pair(61, 55260))
    ),
    WATER_GIANT(
            copyNpc = 2099,
            id = 11617,
            npcName = "Water Giant",
            combatLevel = 47,
            recolors = arrayListOf(Pair(8472, 39106), Pair(5578, 39106), Pair(5582, 39106), Pair(5586, 39106), Pair(4556, 39106), Pair(4541, 39106), Pair(156, 39106), Pair(99, 39106), Pair(5446, 39106), Pair(5541, 39106), Pair(3410, 39106), Pair(6554, 39106), Pair(6430, 39106), Pair(8478, 39106), Pair(6435, 39106), Pair(57, 39106), Pair(49, 39106), Pair(66, 39106), Pair(4502, 39106), Pair(4762, 39106), Pair(898, 39106))
    ),
    EARTH_GIANT(
            copyNpc = 2099,
            id = 11618,
            npcName = "Earth Giant",
            combatLevel = 47,
            recolors = arrayListOf(Pair(8472, 7054), Pair(5578, 7054), Pair(5582, 7054), Pair(5586, 7054), Pair(4556, 7054), Pair(4541, 7054), Pair(156, 7054), Pair(99, 7054), Pair(5446, 7054), Pair(5541, 7054), Pair(3410, 7054), Pair(6554, 7054), Pair(6430, 7054), Pair(8478, 7054), Pair(6435, 7054), Pair(57, 7054), Pair(49, 7054), Pair(66, 7054), Pair(4502, 7054), Pair(4762, 7054), Pair(898, 7054))
    ),
    LAVA_GIANT(
            copyNpc = 2099,
            id = 11619,
            npcName = "Lava Giant",
            combatLevel = 47,
            recolors = arrayListOf(Pair(8472, 1968), Pair(5578, 5041), Pair(5582, 5041), Pair(5586, 6064), Pair(4556, 5040), Pair(4541, 4017), Pair(156, 1968), Pair(99, 6064), Pair(5446, 5040), Pair(5541, 2992), Pair(3410, 5041), Pair(6554, 1968), Pair(6430, 1968), Pair(8478, 2988), Pair(6435, 2992), Pair(57, 4012), Pair(49, 2992), Pair(66, 4016), Pair(4502, 1964), Pair(4762, 1968), Pair(898, 65450))
    ),
    MIST_DEMON(
            copyNpc = 7936,
            id = 11620,
            npcName = "Mist Demon",
            combatLevel = 47,
            recolors = arrayListOf(Pair(33, 39106), Pair(43094, 39106), Pair(43100, 39106), Pair(43078, 39106), Pair(45, 39106), Pair(43094, 39106), Pair(43100, 39106), Pair(43084, 39106), Pair(43094, 39106), Pair(43100, 39106), Pair(43094, 39106), Pair(5206, 39106), Pair(7378, 39106), Pair(898, 39106))
    ),
    MUDHOUND(
            copyNpc = 5054,
            id = 11621,
            npcName = "Mudhound",
            combatLevel = 47,
            recolors = arrayListOf(Pair(10287, 7054), Pair(10279, 7054), Pair(10304, 7054), Pair(10295, 7054), Pair(10299, 7054), Pair(10291, 7054), Pair(10308, 7054), Pair(3862, 7054), Pair(2842, 7054))
    ),
    STEAMING_NECHRAEL(
            copyNpc = 8,
            id = 11622,
            npcName = "Steaming Nechrael",
            combatLevel = 47,
            recolors = arrayListOf(Pair(3274, 39106), Pair(198, 39106), Pair(2248, 39106), Pair(2252, 39106), Pair(3404, 39106), Pair(982, 39106), Pair(2981, 39106), Pair(5231, 39106), Pair(1984, 39106), Pair(0, 39106))
    ),
    DUST_DEMON(
            copyNpc = 7936,
            id = 11623,
            npcName = "Dust Demon",
            combatLevel = 47,
            recolors = arrayListOf(Pair(33, 7054), Pair(43094, 7054), Pair(43100, 7054), Pair(43078, 7054), Pair(45, 7054), Pair(43094, 7054), Pair(43100, 7054), Pair(43084, 7054), Pair(43094, 7054), Pair(43100, 7054), Pair(43094, 7054), Pair(5206, 7054), Pair(7378, 7054), Pair(898, 7054))
    ),
    SMOKEVELD(
            copyNpc = 7034,
            id = 11624,
            npcName = "Smokeveld",
            combatLevel = 47,
            recolors = arrayListOf(Pair(61, 60), Pair(44626, 73), Pair(45737, 31), Pair(44482, 57), Pair(45619, 42), Pair(49094, 62), Pair(49081, 45), Pair(44490, 66), Pair(45972, 12), Pair(8, 8))
    ),
    LAVA_DEMON(
            copyNpc = 7038,
            id = 11625,
            npcName = "Lava Demon",
            combatLevel = 47,
            recolors = arrayListOf(Pair(20, 946), Pair(44626, 4016), Pair(45972, 65451), Pair(45737, 943), Pair(49081, 1964), Pair(49094, 2988))
    ),
    ICE_KING(
            copyNpc = 1608,
            id = 11626,
            npcName = "Ice King",
            combatLevel = 546,
            recolors = arrayListOf(Pair(0, 43957), Pair(4550, 34743), Pair(23442, 42935), Pair(8741, 37815), Pair(8078, 40887), Pair(43072, 36791), Pair(908, 42935), Pair(25238, 41911), Pair(61, 36791), Pair(4626, 41911))
    ),
    EARTH_WORM(
            copyNpc = 7536,
            id = 11627,
            npcName = "Earth Worm",
            combatLevel = 452,
            recolors = arrayListOf(Pair(30602, 30602), Pair(29460, 5011), Pair(49672, 49672), Pair(22466, 5011), Pair(49804, 5011), Pair(50830, 7054), Pair(22488, 7054), Pair(4, 5011), Pair(50582, 50582), Pair(10438, 10438), Pair(18659, 18659), Pair(16615, 16615), Pair(10442, 10442), Pair(231, 231), Pair(16617, 16617), Pair(29916, 7054), Pair(43218, 7054))
    ),
    EARTH_WORM2(
            copyNpc = 4796,
            id = 11628,
            npcName = "Earth Worm",
            combatLevel = 452,
            recolors = arrayListOf(Pair(4552, 5011), Pair(6024, 6024), Pair(553, 553), Pair(4416, 5011), Pair(7054, 7054), Pair(561, 561), Pair(4535, 5011), Pair(6806, 6806), Pair(902, 902), Pair(4651, 5011), Pair(6558, 6558), Pair(8646, 22480), Pair(0, 0), Pair(7240, 7240), Pair(8637, 22488), Pair(3608, 3608), Pair(5524, 5524), Pair(5400, 5400), Pair(5648, 5648), Pair(5772, 5772), Pair(662, 662), Pair(443, 443), Pair(5227, 5227), Pair(1843, 5011), Pair(1839, 5011), Pair(1963, 5011), Pair(1959, 5011), Pair(437, 437), Pair(557, 557), Pair(551, 551), Pair(792, 792), Pair(670, 670), Pair(565, 565), Pair(794, 794))
    ),
    NIGHT_STORM(
            copyNpc = 6384,
            id = 11629,
            npcName = "Night Storm",
            combatLevel = 452,
            recolors = arrayListOf(Pair(37402, 26), Pair(8004, 5227), Pair(8136, 5250), Pair(38672, 12), Pair(38305, 32), Pair(38313, 40), Pair(38309, 36), Pair(38424, 12), Pair(38300, 27), Pair(37526, 12), Pair(62371, 12), Pair(62375, 28), Pair(7872, 12), Pair(7995, 5252), Pair(6978, 5220), Pair(7991, 5230), Pair(7110, 5227), Pair(12, 12), Pair(63405, 12), Pair(63411, 33), Pair(33703, 33703), Pair(33690, 33690), Pair(33694, 33694), Pair(63287, 41), Pair(63291, 44), Pair(8119, 5227), Pair(7446, 23), Pair(60312, 12), Pair(62127, 40), Pair(62131, 12))
    ),
    ZAMORAK_DRAGON(
            copyNpc = 2049,
            id = 11630,
            npcName = "Zamorak Dragon",
            combatLevel = 777,
            models = arrayOf(44779, 17392, 17386, 17400, 17390),
            recolors = arrayListOf(Pair(910, 1938), Pair(912, 809), Pair(1938, 1814), Pair(1814, 1814), Pair(1690, 809), Pair(0, 1938))
    ),
    BLIZZARD_ELEMENTAL(
            copyNpc = 2054,
            id = 11631,
            npcName = "Blizzard Elemental",
            combatLevel = 777,
            recolors = arrayListOf(Pair(47657,33703), Pair(466,37526), Pair(47661,33650), Pair(0,35957), Pair(47275,5227))
    ),
    NATURE_ELEMENTAL(
            copyNpc = 2054,
            id = 11632,
            npcName = "Nature Elemental",
            combatLevel = 777,
            recolors = arrayListOf(Pair(47657, 25238), Pair(466, 6741), Pair(47661, 23210), Pair(0, 7690), Pair(47275, 5772))
    ),
    SMOKE_ELEMENTAL(
            copyNpc = 2054,
            id = 11633,
            npcName = "Smoke Elemental",
            combatLevel = 777,
            recolors = arrayListOf(Pair(47657, 926), Pair(466, 794), Pair(47661, 900), Pair(0, 0), Pair(47275, 12))
    ),
    SKY_ELEMENTAL(
            copyNpc = 2054,
            id = 11634,
            npcName = "Sky Elemental",
            combatLevel = 777,
            recolors = arrayListOf(Pair(47657, 43072), Pair(466, 8741), Pair(47661, 43000), Pair(0, 7995), Pair(47275, 43072))
    ),
    KRAWFIE (
            copyNpc = 2267,
            id = 11635,
            npcName = "Krawfie",
            combatLevel = 777,
            models = arrayOf(44780),
            attackAnim = 2853,
            standAnim = 2850,
            walkAnim = 2849
    ),
    SEAGULL (
            copyNpc = 1338,
            id = 11636,
            npcName = "Seagull",
            combatLevel = 2,
            options = arrayOf("","","Catch","",""),
    )
}