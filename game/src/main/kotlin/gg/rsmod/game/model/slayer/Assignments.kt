package gg.rsmod.game.model.slayer

import gg.rsmod.game.model.Tile

/**
 * @param slayerLevel Slayer level required to fight this [Assignments].
 * @param npcIds A list of IDs for each monster classified as this [Assignments].
 * @param superiorId The ID for the monster's Superior version.
 * @param teleport The location where the standard NPCs assigned are located.
 */
enum class Assignments(
    val taskName: String,
    val slayerLevel: Int,
    val npcIds: List<Int>,
    val superiorId: Int = -1,
    val min: Int,
    val max: Int,
    val weight: Int,
    val teleport: Tile
) {

    NONE(
        "None",
        slayerLevel = -1, 
        npcIds = listOf(-1), 
        superiorId = -1, 
        teleport = Tile(-1, -1),
        min = -1,
        max = -1,
        weight = -1
    ),
    CHICKEN(
        "Chicken",
        slayerLevel = 0,
        npcIds = listOf(
            1173, 1174, 2804, 2805, 2806, 3316, 3661, 3662, 9488, 10494, 10495, 10496, 10497, 10498, 10499
        ),
        superiorId = 6367,
        teleport = Tile(3234, 3295),
        min = 40,
        max = 80,
        weight = 10
    ),
    GOBLIN(
        "Goblin",
        slayerLevel = 0,
        npcIds = listOf(
            655, 656, 657, 658, 659, 660, 661, 662, 663, 664, 665, 666, 667, 668, 674, 677, 678, 2245, 2246, 2247, 2248, 2249, 2484, 2485, 2486, 2487, 2488, 2489, 3028, 3029, 3030, 3031, 3032, 3033, 3034, 3035, 3036, 3037, 3038, 3039, 3040, 3041, 3042, 3043, 3044, 3045, 3046, 3047, 3048, 3051, 3052, 3053, 3054, 3073, 3074, 3075, 3076, 4902, 4903, 4904, 4905, 4906, 5152, 5153, 5154, 5192, 5193, 5195, 5196, 5197, 5198, 5199, 5200, 5201, 5202, 5203, 5204, 5205, 5206, 5207, 5208, 5376, 5377, 5508, 5509, 10566, 10567, 11322, 11323, 11324, 11325, 11326, 11327, 11328, 11329, 11330, 11331, 11332, 11333, 11334, 11335, 11336, 11337, 11338, 11339, 11340, 11341, 11342, 11343, 11344, 11345, 11346, 11347, 11348, 11349, 11350, 11351, 11352, 11353, 11354, 11355, 11356, 11357, 11358, 11359, 11360, 11361, 11362, 11363, 11364, 11365, 11366, 11367, 11368, 11369, 11370, 11371, 11372, 11373, 11374, 11375, 11376, 11377, 11378, 11379, 11380, 11381
        ),
        superiorId = 2241,
        teleport = Tile(3246, 3241),
        min = 40,
        max = 80,
        weight = 10
    ),
    MONKEY("Monkey", slayerLevel = 0, npcIds = listOf(1038, 2848), superiorId = 5271, teleport = Tile(2916, 3156), min = 40, max = 80, weight = 10),
    RAT(
        "Rat",
        slayerLevel = 0,
        npcIds = listOf(
            2492, 2513, 2854, 2855
        ),
        superiorId = 2510,
        teleport = Tile(3237, 9867),
        min = 40,
        max = 80,
        weight = 10
    ),
    SPIDER("Spider", slayerLevel = 0, npcIds = listOf(2478), superiorId = 134, teleport = Tile(3180, 3221), min = 40, max = 80, weight = 10),
    BAT("Bat", slayerLevel = 0, npcIds = listOf(2827), superiorId = 2834, teleport = Tile(3110, 3318), min = 40, max = 80, weight = 10),
    COW(
        "Cow",
        slayerLevel = 0,
        npcIds = listOf(6401, 5842, 2801, 2791, 2792, 2793, 2794, 2795),
        superiorId = 5816,
        teleport = Tile(3257, 3279),
        min = 40,
        max = 80,
        weight = 10
    ),
    DWARF("Dwarf", slayerLevel = 0, npcIds = listOf(290, 8496), superiorId = 291, teleport = Tile(3015, 3450), min = 40, max = 80, weight = 10),
    MINOTAUR(
        "Minotaur",
        slayerLevel = 0,
        npcIds = listOf(2481, 2482, 2483),
        superiorId = 7021,
        teleport = Tile(1879, 5217),
        min = 40,
        max = 80,
        weight = 10
    ),
    SCORPION(
        "Scorpion",
        slayerLevel = 0,
        npcIds = listOf(2479, 2480, 3024, 5242),
        superiorId = 7022,
        teleport = Tile(3057, 9777),
        min = 40,
        max = 80,
        weight = 10
    ),
    ZOMBIE(
        "Zombie",
        slayerLevel = 0,
        npcIds = listOf(
            26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 880, 2501, 2502, 2503, 2504, 2505, 2506, 2507, 2508, 2509, 3980, 3981, 5583, 5647, 6449, 6450, 6451, 6452, 6453, 6454, 6455, 6456, 6457, 6458, 6459, 6460, 6461, 6462, 6463, 6464, 6465, 6466, 6596, 6597, 6598, 6741, 7485, 7486, 7487, 7488, 8067, 8068, 8069
        ),
        superiorId = 3359,
        teleport = Tile(3126, 9863),
        min = 40,
        max = 80,
        weight = 10
    ),
    BEAR(
        "Bear",
        slayerLevel = 0,
        npcIds = listOf(2838, 2839, 3423, 3424, 3425, 3908, 3909),
        superiorId = 7023,
        teleport = Tile(3289, 3351),
        min = 40,
        max = 80,
        weight = 10
    ),
    GHOST(
        "Ghost",
        slayerLevel = 0,
        npcIds = listOf(
            85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 472, 473, 474, 505, 506, 507, 2527, 2528, 2529, 2530, 2531, 2532, 2533, 2534, 3625, 3975, 3976, 3977, 3978, 3979, 5370, 7263, 7264
        ),
        superiorId = 2999,
        teleport = Tile(2910, 9830),
        min = 40,
        max = 80,
        weight = 10
    ),
    DOG(
        "Dog",
        slayerLevel = 0,
        npcIds = listOf(7209, 112, 113, 114, 131),
        superiorId = 3999,
        teleport = Tile(2635, 3300),
        min = 40,
        max = 80,
        weight = 10
    ),
    KALPHITE(
        "Kalphite",
        slayerLevel = 0,
        npcIds = listOf(138, 955, 956, 957, 958, 959, 960, 961, 962, 966),
        superiorId = 7032,
        teleport = Tile(3485, 9509, 2),
        min = 40,
        max = 80,
        weight = 10
    ),
    SKELETON(
        "Skeleton",
        slayerLevel = 0,
        npcIds = listOf(
            70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 130, 680, 681, 924, 1685, 1686, 1687, 1688, 2520, 2521, 2522, 2523, 2524, 2525, 2526, 3565, 3972, 3973, 3974, 4491, 4492, 4493, 4494, 4495, 4496, 4497, 4498, 4499, 5054, 5237, 6326, 6387, 6440, 6441, 6442, 6443, 6444, 6445, 6446, 6447, 6448, 6467, 6468, 6613, 6614, 7265, 8070, 8071, 8072, 10717, 10718, 10719, 10720, 10721
        ),
        superiorId = 3358,
        teleport = Tile(3097, 9909),
        min = 40,
        max = 80,
        weight = 10
    ),
    ICEFIEND(
        "Icefiend",
        slayerLevel = 0,
        npcIds = listOf(3140, 4813),
        superiorId = 778,
        teleport = Tile(3007, 3478),
        min = 40,
        max = 80,
        weight = 10
    ),
    WOLF(
        "Wolf",
        slayerLevel = 0,
        npcIds = listOf(106, 109, 110, 115, 116, 117, 231, 232, 2490, 2491, 3912, 4649, 4650, 4651, 9181, 10522, 10533),
        superiorId = 7620,
        teleport = Tile(2834, 3508),
        min = 40,
        max = 80,
        weight = 10
    ),
    CRAWLING_HAND(
        "Crawling Hand",
        slayerLevel = 0,
        npcIds = listOf(448, 449, 450, 451, 452, 453, 454, 455, 456, 457),
        superiorId = 1077,
        teleport = Tile(3420, 3535),
        min = 40,
        max = 80,
        weight = 10
    ),
    CAVE_CRAWLER(
        "Cave Crawler",
        slayerLevel = 0,
        npcIds = listOf(406, 407, 408, 409),
        superiorId = 7389,
        teleport = Tile(3190, 9570),
        min = 40,
        max = 80,
        weight = 10
    ),
    BANSHEE("Banshee", slayerLevel = 0, npcIds = listOf(414), superiorId = 7391, teleport = Tile(3440, 3543), min = 40, max = 80, weight = 10),
    CAVE_SLIME("Cave Slime", slayerLevel = 0, npcIds = listOf(480), superiorId = 488, teleport = Tile(3250, 9575), min = 40, max = 80, weight = 10),
    LIZARD(
        "Lizard",
        slayerLevel = 0,
        npcIds = listOf(459, 460, 461, 462, 463),
        superiorId = 458,
        teleport = Tile(3320, 2900),
        min = 40,
        max = 80,
        weight = 10
    ),
    MOLANISK("Molanisk", slayerLevel = 0, npcIds = listOf(1), superiorId = 3449, teleport = Tile(2713, 5225), min = 40, max = 80, weight = 10),
    COCKATRICE(
        "Cockatrice",
        slayerLevel = 0,
        npcIds = listOf(419, 420),
        superiorId = 7393,
        teleport = Tile(2619, 10265),
        min = 40,
        max = 80,
        weight = 10
    ),
    EARTH_WARRIOR(
        "Earth Warrior",
        slayerLevel = 0,
        npcIds = listOf(2840),
        superiorId = 3328,
        teleport = Tile(3121, 9991),
        min = 40,
        max = 80,
        weight = 10
    ),
    FLESH_CRAWLER(
        "Flesh Crawler",
        slayerLevel = 0,
        npcIds = listOf(2498, 2499, 2500),
        superiorId = 483,
        teleport = Tile(1991, 5237),
        min = 40,
        max = 80,
        weight = 10
    ),
    GHOUL("Ghoul", slayerLevel = 0, npcIds = listOf(289), superiorId = 6344, teleport = Tile(3438, 3461), min = 40, max = 80, weight = 10),
    HILL_GIANT(
        "Hill Giant",
        slayerLevel = 0,
        npcIds = listOf(2098, 2099, 2100, 2101, 2102, 2103, 10374, 10375, 10376),
        superiorId = 7261,
        teleport = Tile(3115, 9843),
        min = 40,
        max = 80,
        weight = 10
    ),
    ICE_WARRIOR(
        "Ice Warrior",
        slayerLevel = 0,
        npcIds = listOf(2841, 2842, 2851),
        superiorId = 2085,
        teleport = Tile(3050, 9585),
        min = 40,
        max = 80,
        weight = 10
    ),
    KILLERWATT("Killerwatt", slayerLevel = 0, npcIds = listOf(469), superiorId = 470, teleport = Tile(2661, 5209, 2), min = 40, max = 80, weight = 10),
    WATERFIEND(
        "Waterfiend",
        slayerLevel = 0,
        npcIds = listOf(2916, 2917),
        superiorId = 1370,
        teleport = Tile(1740, 5353),
        min = 40,
        max = 80,
        weight = 10
    ),
    MOGRE("Mogre", slayerLevel = 0, npcIds = listOf(2592), superiorId = 4817, teleport = Tile(3000, 3121), min = 40, max = 80, weight = 10),
    OGRE(
        "Ogre",
        slayerLevel = 0,
        npcIds = listOf(136, 865, 1225, 2095, 2096, 2233),
        superiorId = 7028,
        teleport = Tile(2505, 3115),
        min = 40,
        max = 80,
        weight = 10
    ),
    MOSS_GIANT(
        "Moss Giant",
        slayerLevel = 0,
        npcIds = listOf(2090, 2091, 2092, 2093, 3851, 3852, 7262),
        superiorId = 8736,
        teleport = Tile(2700, 3206),
        min = 40,
        max = 80,
        weight = 10
    ),
    CROCODILE(
        "Crocodile",
        slayerLevel = 0,
        npcIds = listOf(4184, 11581, 11582),
        superiorId = 11513,
        teleport = Tile(3217, 3179),
        min = 40,
        max = 80,
        weight = 10
    ),
    ICE_GIANT(
        "Ice Giant",
        slayerLevel = 0,
        npcIds = listOf(2085, 2086, 2087, 2088, 2089, 7878, 7879, 7880),
        superiorId = 882,
        teleport = Tile(3050, 9585),
        min = 40,
        max = 80,
        weight = 10
    ),
    GREEN_DRAGON(
        "Green Dragon",
        slayerLevel = 0,
        npcIds = listOf(260, 261, 262, 263, 264, 5194, 5872, 5873, 7868, 7869, 7870),
        superiorId = 2918,
        teleport = Tile(2012, 9003, 1),
        min = 40,
        max = 80,
        weight = 10
    ),
    WEREWOLF(
        "Werewolf",
        slayerLevel = 0,
        npcIds = listOf(
            2593, 2594, 2595, 2596, 2597, 2598, 2599, 2600, 2601, 2602, 2603, 2604, 2605, 2606, 2607, 2608, 2609, 2610, 2611, 2612, 3135, 3136, 5928
        ),
        superiorId = 1377,
        teleport = Tile(3500, 3500),
        min = 40,
        max = 80,
        weight = 10
    ),
    SEASNAKE("Seasnake", slayerLevel = 0, npcIds = listOf(1098), superiorId = 1097, teleport = Tile(2619, 10265), min = 40, max = 80, weight = 10),
    ROCK_SLUG("Rock Slug", slayerLevel = 0, npcIds = listOf(421, 422), superiorId = 7392, teleport = Tile(2800, 10016), min = 40, max = 80, weight = 10),
    SHADE("Shade", slayerLevel = 0, npcIds = listOf(5633), superiorId = 6740, teleport = Tile(1605, 10040), min = 40, max = 80, weight = 10),
    VAMPYRE(
        "Vampyre",
        slayerLevel = 0,
        npcIds = listOf(
            3137, 3234, 3237, 3239, 3690, 3691, 3692, 3693, 3694, 3695, 3707, 3708, 4427, 4428, 4429, 4430, 4431, 4436, 4437, 4438, 4442, 4443, 4486, 4487, 5634, 5635, 5636, 5640, 5641, 5642, 9615, 9727, 9728, 9731, 9732
        ),
        superiorId = 6393,
        teleport = Tile(3600, 3188),
        min = 40,
        max = 80,
        weight = 10
    ),
    WHITE_WOLF(
        "White Wolf",
        slayerLevel = 0,
        npcIds = listOf(107, 108),
        superiorId = 9181,
        teleport = Tile(2811, 3509),
        min = 40,
        max = 80,
        weight = 10
    ),
    AVIANSIES(
        "Aviansies",
        slayerLevel = 0,
        npcIds = listOf(3169, 3170, 3171, 3172, 3173, 3174, 3175, 3176, 3177, 3178, 3179, 3180, 3182, 3183),
        superiorId = 7037,
        teleport = Tile(2883, 5301, 2),
        min = 40,
        max = 80,
        weight = 10
    ),
    LIZARDMAN(
        "Lizardman",
        slayerLevel = 0,
        npcIds = listOf(
            6766, 6767, 6914, 6915, 6916, 6917, 6918, 6919, 7744, 7745, 8563, 8564, 8565, 10947, 10948
        ),
        superiorId = 8565,
        teleport = Tile(1330, 10085),
        min = 40,
        max = 80,
        weight = 10
    ),
    TZHAAR(
        "Tzhaar",
        slayerLevel = 0,
        npcIds = listOf(
            2154, 2155, 2156, 2157, 2158, 2159, 2160, 2161, 2162, 2163, 2164, 2165, 2166, 2167, 2168, 2169, 2170, 2171, 2172, 2173, 2174, 2175, 2176, 2177, 2178, 2179, 7679, 7682, 7683, 7684, 7685, 7686, 7687
        ),
        superiorId = 7035,
        teleport = Tile(2451, 5146),
        min = 40,
        max = 80,
        weight = 10
    ),
    LESSER_DEMON(
        "Lesser Demon",
        slayerLevel = 0,
        npcIds = listOf(2005, 2006, 2007, 2008, 2018, 3982, 7247, 7248, 7656, 7657, 7664, 7865, 7866, 7867),
        superiorId = 2028,
        teleport = Tile(2935, 9793),
        min = 40,
        max = 80,
        weight = 10
    ),
    SHADOW_WARRIOR(
        "Shadow Warrior",
        slayerLevel = 0,
        npcIds = listOf(2853),
        superiorId = 2843,
        teleport = Tile(2728, 9774),
        min = 40,
        max = 80,
        weight = 10
    ),
    TROLL(
        "Troll",
        slayerLevel = 0,
        npcIds = listOf(
            133, 648, 649, 650, 651, 652, 653, 654, 699, 700, 701, 702, 703, 704, 705, 931, 932, 933, 934, 935, 936, 937, 938, 939, 940, 941, 942, 1874, 1875, 1876, 1877, 4120, 4121, 4122, 4123, 4124, 4125, 4126, 4127, 4128, 4129, 4135, 4136, 4137, 4138, 4139, 4143, 4308, 4309, 4310, 4311, 5822, 5823, 5824, 5825, 5826, 5828, 5829, 5830, 5831, 6294, 6356, 6732, 6733, 6734, 6735, 6736, 6737
        ),
        superiorId = 4130,
        teleport = Tile(2850, 3675),
        min = 40,
        max = 80,
        weight = 10
    ),
    BLUE_DRAGON(
        "Blue Dragon",
        slayerLevel = 0,
        npcIds = listOf(241, 242, 243, 265, 266, 267, 268, 269, 4385, 5878, 5879, 5880, 5881, 5882, 8083),
        superiorId = 7273,
        teleport = Tile(2922, 9803),
        min = 40,
        max = 80,
        weight = 10
    ),
    FIRE_GIANT(
        "Fire Giant",
        slayerLevel = 0,
        npcIds = listOf(2075, 2076, 2077, 2078, 2079, 2080, 2081, 2082, 2083, 2084, 7251, 7252),
        superiorId = 3448,
        teleport = Tile(2575, 9875),
        min = 40,
        max = 80,
        weight = 10
    ),
    JUNGLE_HORROR(
        "Jungle Horror",
        slayerLevel = 0,
        npcIds = listOf(1042, 1043, 1044, 1045, 1046),
        superiorId = 1047,
        teleport = Tile(3730, 9353),
        min = 40,
        max = 80,
        weight = 10
    ),
    RED_DRAGON(
        "Red Dragon",
        slayerLevel = 0,
        npcIds = listOf(137, 244, 245, 246, 247, 248, 249, 250, 251),
        superiorId = 7274,
        teleport = Tile(2720, 9520),
        min = 40,
        max = 80,
        weight = 10
    ),
    ELF(
        "Elf",
        slayerLevel = 0,
        npcIds = listOf(5293, 5294, 5295, 5296),
        superiorId = 7029,
        teleport = Tile(2204, 3253),
        min = 40,
        max = 80,
        weight = 10
    ),
    BLACK_DRAGON(
        "Black Dragon",
        slayerLevel = 0,
        npcIds = listOf(252, 253, 254, 255, 256, 257, 258, 259, 1871, 1872, 7861, 7862, 7863, 8084, 8085),
        superiorId = 7275,
        teleport = Tile(2835, 9824),
        min = 40,
        max = 80,
        weight = 10
    ),
    BRONZE_DRAGON(
        "Bronze Dragon",
        slayerLevel = 0,
        npcIds = listOf(270, 271, 7253),
        superiorId = -1,
        teleport = Tile(2740, 9500),
        min = 40,
        max = 80,
        weight = 10
    ),
    DAGGANOTH(
        "Dagganoth",
        slayerLevel = 0,
        npcIds = listOf(140, 970, 971, 972, 973, 974, 975, 979, 3185, 5942, 5943, 7259, 7260),
        superiorId = 6361,
        teleport = Tile(2444, 10444),
        min = 40,
        max = 80,
        weight = 10
    ),
    HELLHOUND(
        "Hellhound",
        slayerLevel = 0,
        npcIds = listOf(104, 105, 135, 3133, 7256, 7877),
        superiorId = 5054,
        teleport = Tile(2860, 9845),
        min = 40,
        max = 80,
        weight = 10
    ),
    BLACK_DEMON(
        "Black Demon",
        slayerLevel = 0,
        npcIds = listOf(
            240, 1432, 2048, 2049, 2050, 2051, 2052, 5874, 5875, 5876, 5877, 6357, 7242, 7243, 7874, 7875, 7876
        ),
        superiorId = 1609,
        teleport = Tile(2860, 9777),
        min = 40,
        max = 80,
        weight = 10
    ),
    IRON_DRAGON(
        "Iron Dragon",
        slayerLevel = 0,
        npcIds = listOf(272, 273, 7254, 8080),
        superiorId = -1,
        teleport = Tile(2711, 9465),
        min = 40,
        max = 80,
        weight = 10
    ),
    STEEL_DRAGON(
        "Steel Dragon",
        slayerLevel = 0,
        npcIds = listOf(139, 274, 275, 7255, 8086),
        superiorId = -1,
        teleport = Tile(2700, 9435),
        min = 40,
        max = 80,
        weight = 10
    ),
    HARPIE_BUG_SWARM(
        "Harpie Bug Swarm",
        slayerLevel = 0,
        npcIds = listOf(464),
        superiorId = 6273,
        teleport = Tile(2867, 3111),
        min = 40,
        max = 80,
        weight = 10
    ),
    BASILISK(
        "Basilisk",
        slayerLevel = 0,
        npcIds = listOf(417, 418, 9283, 9284, 9285, 9286),
        superiorId = 9287,
        teleport = Tile(2742, 10010),
        min = 40,
        max = 80,
        weight = 10
    ),
    FEVER_SPIDER("Fever Spider", slayerLevel = 0, npcIds = listOf(626), superiorId = 1607, teleport = Tile(2147, 5098), min = 40, max = 80, weight = 10),
    INFERNAL_MAGE(
        "Infernal Mage",
        slayerLevel = 0,
        npcIds = listOf(443, 444, 445, 446, 447),
        superiorId = 7396,
        teleport = Tile(3436, 3572),
        min = 40,
        max = 80,
        weight = 10
    ),
    BRINE_RAT("Brine Rat", slayerLevel = 0, npcIds = listOf(4501), superiorId = 9040, teleport = Tile(2707, 10160), min = 40, max = 80, weight = 10),
    BLOODVELD(
        "Bloodveld",
        slayerLevel = 0,
        npcIds = listOf(484, 485, 486, 487, 3138),
        superiorId = 7398,
        teleport = Tile(3416, 3571),
        min = 40,
        max = 80,
        weight = 10
    ),
    MITHRIL_DRAGON(
        "Mithril Dragon",
        slayerLevel = 0,
        npcIds = listOf(2919, 8088, 8089),
        superiorId = -1,
        teleport = Tile(1767, 5341, 1),
        min = 40,
        max = 80,
        weight = 10
    ),
    ZYGOMITE("Zygomite", slayerLevel = 0, npcIds = listOf(537, 1024), superiorId = 7797, teleport = Tile(2420, 4430), min = 40, max = 80, weight = 10),
    ABERRANT_SPECTRE(
        "Aberrant Spectre",
        slayerLevel = 0,
        npcIds = listOf(2, 3, 4, 5, 6, 7),
        superiorId = 7402,
        teleport = Tile(2703, 10028),
        min = 40,
        max = 80,
        weight = 10
    ),
    WYRM("Wyrm", slayerLevel = 0, npcIds = listOf(8610), superiorId = 10399, teleport = Tile(1264, 10158), min = 40, max = 80, weight = 10),
    SPIRITUAL_CREATURE(
        "Spiritual Creature",
        slayerLevel = 0,
        npcIds = listOf(2210, 2211, 2212, 2242, 2243, 2244, 3159, 3160, 3161, 3166, 3167, 3168, 11290, 11291, 11292),
        superiorId = 2955,
        teleport = Tile(2883, 5301, 2),
        min = 40,
        max = 80,
        weight = 10
    ),
    DUST_DEVIL(
        "Dust Devil",
        slayerLevel = 0,
        npcIds = listOf(423, 7249, 11238, 423),
        superiorId = 7404,
        teleport = Tile(3191, 9363),
        min = 40,
        max = 80,
        weight = 10
    ),
    FOSSIL_WYVERN(
        "Fossil Wyvern",
        slayerLevel = 0,
        npcIds = listOf(7792, 7793, 7794, 7795),
        superiorId = 2641,
        teleport = Tile(3611, 10275),
        min = 40,
        max = 80,
        weight = 10
    ),
    KURASK("Kurask", slayerLevel = 0, npcIds = listOf(410, 411), superiorId = 7405, teleport = Tile(2701, 9997), min = 40, max = 80, weight = 10),
    SKELETAL_WYVERN(
        "Skeletal Wyvern",
        slayerLevel = 0,
        npcIds = listOf(465, 466, 467, 468),
        superiorId = 3577,
        teleport = Tile(3050, 9555),
        min = 40,
        max = 80,
        weight = 10
    ),
    GARGOYLES(
        "Gargoyles",
        slayerLevel = 0,
        npcIds = listOf(412, 1543),
        superiorId = 7407,
        teleport = Tile(3435, 3540, 2),
        min = 40,
        max = 80,
        weight = 10
    ),
    NECHRYAEL("Nechryael", slayerLevel = 0, npcIds = listOf(8, 11), superiorId = 7411, teleport = Tile(3443, 3558, 2), min = 40, max = 80, weight = 10),
    ADAMANT_DRAGON(
        "Adamant Dragon",
        slayerLevel = 0,
        npcIds = listOf(8030, 8090),
        superiorId = -1,
        teleport = Tile(3568, 4005),
        min = 40,
        max = 80,
        weight = 10
    ),
    DARK_BEAST(
        "Dark Beast",
        slayerLevel = 0,
        npcIds = listOf(4005, 7250),
        superiorId = 7409,
        teleport = Tile(2471, 6144),
        min = 40,
        max = 80,
        weight = 10
    ),
    DRAKE("Drake", slayerLevel = 0, npcIds = listOf(8612), superiorId = 10400, teleport = Tile(1264, 10158), min = 40, max = 80, weight = 10),
    RUNE_DRAGON(
        "Rune Dragon",
        slayerLevel = 0,
        npcIds = listOf(8027, 8031, 8091),
        superiorId = -1,
        teleport = Tile(3568, 4005),
        min = 40,
        max = 80,
        weight = 10
    ),
    SUQAH(
        "Suqah",
        slayerLevel = 0,
        npcIds = listOf(787, 788, 789, 790, 791, 792, 793),
        superiorId = 6588,
        teleport = Tile(2133, 3869),
        min = 40,
        max = 80,
        weight = 10
    ),
    ABYSSAL_DEMON(
        "Abyssal Demon",
        slayerLevel = 0,
        npcIds = listOf(415, 416, 7241, 11239),
        superiorId = 7410,
        teleport = Tile(3418, 3570, 2),
        min = 40,
        max = 80,
        weight = 10
    ),
    TZTOK_JAD("TzTok-Jad", slayerLevel = 0, npcIds = listOf(6506), teleport = Tile(2440, 5171), min = 40, max = 80, weight = 10),
    KING_BLACK_DRAGON("King Black Dragon", slayerLevel = 0, npcIds = listOf(239), teleport = Tile(2271, 4684), min = 40, max = 80, weight = 10),
    CORPOREAL_BEAST("Corporeal Beast", slayerLevel = 0, npcIds = listOf(319), teleport = Tile(2979, 4256, 2), min = 40, max = 80, weight = 10),
    GIANT_MOLE("Giant Mole", slayerLevel = 0, npcIds = listOf(5779), teleport = Tile(1760, 5194), min = 40, max = 80, weight = 10),
    DAGANNOTH_KING("Dagannoth King", slayerLevel = 0, npcIds = listOf(6496, 6497, 6498), teleport = Tile(2522, 10022), min = 40, max = 80, weight = 10),
    KALPHITE_QUEEN("Kalphite Queen", slayerLevel = 0, npcIds = listOf(6501), teleport = Tile(3507, 9494), min = 40, max = 80, weight = 10),
    COMMANDER_ZILYANA("Commander Zilyana", slayerLevel = 0, npcIds = listOf(2205), teleport = Tile(2882, 5310, 2), min = 40, max = 80, weight = 10),
    GENERAL_GRAARDOR("General Graardor", slayerLevel = 0, npcIds = listOf(2215), teleport = Tile(2882, 5310, 2), min = 40, max = 80, weight = 10),
    KREEARA("Kree'Ara", slayerLevel = 0, npcIds = listOf(3162), teleport = Tile(2882, 5310, 2), min = 40, max = 80, weight = 10),
    KRIL_TSUTSAROTH("K'ril Tsutsaroth", slayerLevel = 0, npcIds = listOf(6495), teleport = Tile(2882, 5310, 2), min = 40, max = 80, weight = 10),
    ZULRAH("Zulrah", slayerLevel = 0, npcIds = listOf(2042), teleport = Tile(2200, 3056), min = 40, max = 80, weight = 10),
    VORKATH("Vorkath", slayerLevel = 0, npcIds = listOf(8026), superiorId = 8178, teleport = Tile(2276, 4037), min = 40, max = 80, weight = 10),
    ABYSSAL_SIRE("Abyssal Sire", slayerLevel = 0, npcIds = listOf(5890), teleport = Tile(3039, 4787), min = 40, max = 80, weight = 10),
    CAVE_KRAKEN("Cave Kraken", slayerLevel = 0, npcIds = listOf(494), teleport = Tile(2279, 10022), min = 40, max = 80, weight = 10),
    CERBERUS("Cerberus", slayerLevel = 0, npcIds = listOf(5862), teleport = Tile(1304, 1293), min = 40, max = 80, weight = 10),
    THERMONUCLEAR_SMOKE_DEVIL(
        "Thermonuclear Smoke Devil",
        slayerLevel = 0,
        npcIds = listOf(499),
        teleport = Tile(2400, 9440),
        min = 40,
        max = 80,
        weight = 10
    ),
    SEWER_CRAB(
        "Sewer Crab",
        slayerLevel = 0,
        npcIds = listOf(8297, 8298),
        superiorId = 7576,
        teleport = Tile(3402, 4973),
        min = 40,
        max = 80,
        weight = 10
    ),
    MUTATED_LOBSTER(
        "Mutated Lobster",
        slayerLevel = 0,
        npcIds = listOf(4800),
        superiorId = 7796,
        teleport = Tile(3433, 4959),
        min = 40,
        max = 80,
        weight = 10
    ),
    SEWER_DEMON(
        "Sewer Demon",
        slayerLevel = 0,
        npcIds = listOf(8604, 8606, 8607),
        superiorId = 9614,
        teleport = Tile(3407, 4942),
        min = 40,
        max = 80,
        weight = 10
    ),
    SEWER_SNAKE("Sewer Snake", slayerLevel = 0, npcIds = listOf(7594), superiorId = 9560, teleport = Tile(3439, 4937), min = 40, max = 80, weight = 10),
    SEWER_GIANT("Sewer Giant", slayerLevel = 0, npcIds = listOf(7101), superiorId = 5129, teleport = Tile(3443, 4973), min = 40, max = 80, weight = 10),
    SEWER_CREATURE("Sewer Dog", slayerLevel = 0, npcIds = listOf(5947), superiorId = 9612, teleport = Tile(3444, 4948), min = 40, max = 80, weight = 10),
    GOBLIN_ISLAND(
        "Goblin",
        slayerLevel = 0,
        npcIds = listOf(
            655, 656, 657, 658, 659, 660, 661, 662, 663, 664, 665, 666, 667, 668, 674, 677, 678, 2245, 2246, 2247, 2248, 2249, 2484, 2485, 2486, 2487, 2488, 2489, 3028, 3029, 3030, 3031, 3032, 3033, 3034, 3035, 3036, 3037, 3038, 3039, 3040, 3041, 3042, 3043, 3044, 3045, 3046, 3047, 3048, 3051, 3052, 3053, 3054, 3073, 3074, 3075, 3076, 4902, 4903, 4904, 4905, 4906, 5152, 5153, 5154, 5192, 5193, 5195, 5196, 5197, 5198, 5199, 5200, 5201, 5202, 5203, 5204, 5205, 5206, 5207, 5208, 5376, 5377, 5508, 5509, 10566, 10567, 11322, 11323, 11324, 11325, 11326, 11327, 11328, 11329, 11330, 11331, 11332, 11333, 11334, 11335, 11336, 11337, 11338, 11339, 11340, 11341, 11342, 11343, 11344, 11345, 11346, 11347, 11348, 11349, 11350, 11351, 11352, 11353, 11354, 11355, 11356, 11357, 11358, 11359, 11360, 11361, 11362, 11363, 11364, 11365, 11366, 11367, 11368, 11369, 11370, 11371, 11372, 11373, 11374, 11375, 11376, 11377, 11378, 11379, 11380, 11381
        ),
        superiorId = 2241,
        teleport = Tile(2848, 3244),
        min = 40,
        max = 80,
        weight = 10
    ),
    WITCH_DOCTOR(
        "Witch Doctor",
        slayerLevel = 0,
        npcIds = listOf(6409, 6411, 6413),
        superiorId = 6406,
        teleport = Tile(2843, 3297),
        min = 40,
        max = 80,
        weight = 10
    ),
    PIRATE(
        "Pirate",
        slayerLevel = 0,
        npcIds = listOf(6993, 6995, 6994),
        superiorId = 1053,
        teleport = Tile(2855, 3277),
        min = 40,
        max = 80,
        weight = 10
    ),
    IMP("Imp", slayerLevel = 0, npcIds = listOf(3134, 5007), superiorId = 3355, teleport = Tile(2819, 3292), min = 40, max = 80, weight = 10),
    GHOST_WARRIOR(
        "Ghost Warrior",
        slayerLevel = 0,
        npcIds = listOf(922),
        superiorId = 625,
        teleport = Tile(2836, 9655),
        min = 40,
        max = 80,
        weight = 10
    ),
    BARBARIAN_SPIRIT(
        "Barbarian Spirit",
        slayerLevel = 0,
        npcIds = listOf(5564),
        superiorId = 1540,
        teleport = Tile(2842, 9638),
        min = 40,
        max = 80,
        weight = 10
    ),
    BARBARIAN(
        "Barbarian",
        slayerLevel = 0,
        npcIds = listOf(
            3055, 3056, 3057, 3058, 3059, 3060, 3061, 3062, 3064, 3065, 3066, 3067, 3068, 3069, 3070, 3071, 3072, 3256, 3262, 10984, 10985, 10986, 10987, 10988
        ),
        superiorId = 1661,
        teleport = Tile(2836, 3278),
        min = 40,
        max = 80,
        weight = 10
    ),
    DARK_WIZARD(
        "Dark Wizard",
        slayerLevel = 0,
        npcIds = listOf(510, 512, 2056, 2057, 2058, 2059, 5086, 5087, 5088, 5089),
        superiorId = 1783,
        teleport = Tile(2829, 9639),
        min = 40,
        max = 80,
        weight = 10
    ),
    CAVE_SPIRIT("Cave Spirit", slayerLevel = 0, npcIds = listOf(6359), superiorId = 1362, teleport = Tile(2827, 9591), min = 40, max = 80, weight = 10),
    GHAST("Ghast", slayerLevel = 0, npcIds = listOf(946), superiorId = 7936, teleport = Tile(2822, 9565), min = 40, max = 80, weight = 10),
    DRAGON_SPAWN(
        "Dragon Spawn",
        slayerLevel = 0,
        npcIds = listOf(1873),
        superiorId = 7955,
        teleport = Tile(2838, 9557),
        min = 40,
        max = 80,
        weight = 10
    ),
    CAVE_GOLEM("Cave Golem", slayerLevel = 0, npcIds = listOf(5136), superiorId = 1366, teleport = Tile(2857, 9569), min = 40, max = 80, weight = 10),
    POISONOUS_SCORPION("Poisonous Scorpion", slayerLevel = 0, npcIds = listOf(2479, 2480, 3024, 5242), superiorId = 7022, teleport = Tile(2851, 9608), min = 40, max = 80, weight = 10),
    MUD_GHOUL("Mud Ghoul", slayerLevel = 0, npcIds = listOf(289), superiorId = 6344, teleport = Tile(2834, 9607), min = 40, max = 80, weight = 10),
    ROCK_GIANT(
    "Rock Giant",
    slayerLevel = 0,
    npcIds = listOf(2098, 2099, 2100, 2101, 2102, 2103, 10374, 10375, 10376),
    superiorId = 7261,
    teleport = Tile(2873, 9584),
    min = 40,
    max = 80,
    weight = 10),
    ICE_CRAB("Ice Crab", slayerLevel = 0, npcIds = listOf(100, 102), superiorId = 2261, teleport = Tile(3667, 3876), min = 40, max = 80, weight = 10),
    SNOW_MITE("Snow Mite", slayerLevel = 0, npcIds = listOf(1782), superiorId = 1257, teleport = Tile(3710, 3843), min = 40, max = 80, weight = 10),
    ICE_BAT("Ice Bat", slayerLevel = 0, npcIds = listOf(1039), superiorId = 1722, teleport = Tile(3756, 3841), min = 40, max = 80, weight = 10),
    DARK_WARRIOR("Dark Warrior", slayerLevel = 0, npcIds = listOf(6606), superiorId = 910, teleport = Tile(3694, 3842), min = 40, max = 80, weight = 10),
    BLACK_KNIGHT(
        "Black Knight",
        slayerLevel = 0,
        npcIds = listOf(516, 517, 1545, 4331, 4959, 4960),
        superiorId = 6360,
        teleport = Tile(3747, 3869),
        min = 40,
        max = 80,
        weight = 10
    ),
    ICE_SPIRIT("Ice Spirit", slayerLevel = 0, npcIds = listOf(3458), superiorId = 4922, teleport = Tile(3705, 3883), min = 40, max = 80, weight = 10),
    FROZEN_ARCHER(
        "Frozen Archer",
        slayerLevel = 0,
        npcIds = listOf(8222),
        superiorId = 401,
        teleport = Tile(3685, 3879),
        min = 40,
        max = 80,
        weight = 10
    ),
    JELLY(
        "Jelly",
        slayerLevel = 0,
        npcIds = listOf(437, 438, 439, 440, 441, 442, 11241, 11242, 11243, 11244, 11245),
        superiorId = 7400,
        teleport = Tile(3014, 4365),
        min = 40,
        max = 80,
        weight = 10
    ),
    POISON_SPIDER(
        "Poison Spider",
        slayerLevel = 0,
        npcIds = listOf(3023, 5373),
        superiorId = 3016,
        teleport = Tile(3012, 4405),
        min = 40,
        max = 80,
        weight = 10
    ),
    SKELETON_FREMINEK(
        "Skeleton Freminek",
        slayerLevel = 0,
        npcIds = listOf(4491, 4492, 4493, 4494, 4495, 4496, 4497, 4498, 4499),
        superiorId = 9458,
        teleport = Tile(3029, 4358),
        min = 40,
        max = 80,
        weight = 10
    ),
    FROST_WIZARD(
        "Frost Wizard",
        slayerLevel = 0,
        npcIds = listOf(821),
        superiorId = 4883,
        teleport = Tile(3038, 4376),
        min = 40,
        max = 80,
        weight = 10
    ),
    ICE_TROLL(
        "Ice Troll",
        slayerLevel = 0,
        npcIds = listOf(648, 652, 651),
        superiorId = 5822,
        teleport = Tile(3039, 4398),
        min = 40,
        max = 80,
        weight = 10
    ),
    FROST_DEMON(
        "Conjured Frost",
        slayerLevel = 0,
        npcIds = listOf(9404),
        superiorId = 3588,
        teleport = Tile(3023, 4378),
        min = 40,
        max = 80,
        weight = 10
    ),
    SAND_CRAB("Sand Crab", slayerLevel = 0, npcIds = listOf(5935), superiorId = 7266, teleport = Tile(3211, 9292), min = 40, max = 80, weight = 10),
    SAND_SNAKE("Sand Snake", slayerLevel = 0, npcIds = listOf(7802), superiorId = 7903, teleport = Tile(3208, 9312), min = 40, max = 80, weight = 10),
    DUNE_GATOR("Dune Gator", slayerLevel = 0, npcIds = listOf(7802), superiorId = 7903, teleport = Tile(3208, 9312), min = 40, max = 80, weight = 10),
    FIRE_SLUG("Fire Slug", slayerLevel = 0, npcIds = listOf(7802), superiorId = 7903, teleport = Tile(3208, 9312), min = 40, max = 80, weight = 10),
    PYREFIEND(
            "Pyrefiend",
            slayerLevel = 0,
            npcIds = listOf(433, 434, 435, 436, 3139),
            superiorId = 6795,
            teleport = Tile(2614, 10276),
            min = 40,
            max = 80,
            weight = 10
    ),
    LAVA_CRAWLER("Lava Crawler", slayerLevel = 0, npcIds = listOf(7802), superiorId = 7903, teleport = Tile(3208, 9312), min = 40, max = 80, weight = 10),
    LAVA_GIANT("Lava Giant", slayerLevel = 0, npcIds = listOf(7802), superiorId = 7903, teleport = Tile(3208, 9312), min = 40, max = 80, weight = 10),
    FIRE_LIZARD(
        "Fire Lizard",
        slayerLevel = 0,
        npcIds = listOf(
            459, 460, 461, 462, 463, 2831, 4198, 6766, 6767, 6914, 6915, 6916, 6917, 6918, 6919, 7573, 7574, 7744, 7745, 7997, 8000, 8563, 8564, 8565, 10947, 10948
        ),
        superiorId = 8709,
        teleport = Tile(2450, 10260),
        min = 40,
        max = 80,
        weight = 10
    ),
    ORKMAGE("Ork", slayerLevel = 0, npcIds = listOf(1606), superiorId = 879, teleport = Tile(3216, 9352), min = 40, max = 80, weight = 10),
    JOGRE("Skogre", slayerLevel = 0, npcIds = listOf(2094), superiorId = 3356, teleport = Tile(3225, 9366), min = 40, max = 80, weight = 10),
    MUMMY(
        "Mummy",
        slayerLevel = 0,
        npcIds = listOf(
            717, 720, 721, 722, 723, 949, 950, 951, 952, 953, 7658, 7659, 7660, 7661, 7662
        ),
        superiorId = 4199,
        teleport = Tile(3756, 3750),
        min = 40,
        max = 80,
        weight = 10
    ),
    VYREWATCH(
        "Vyrewatch",
        slayerLevel = 0,
        npcIds = listOf(
            3709, 3710, 3711, 3712, 3713, 3714, 3715, 3716, 3717, 3718, 3719, 3720, 3721, 3722, 3723, 3724, 3725, 3726, 3727, 3728, 3729, 3730, 3731, 3732, 3748, 3749, 3750, 3751, 3752, 3753, 3754, 3755, 3756, 3757, 3758, 3759, 3760, 3761, 3762, 3763, 3768, 3769, 3770, 3771, 8251, 8252, 8253, 8254, 8255, 8256, 8257, 8258, 8259, 8300, 8301, 8302, 8303, 8304, 8305, 8306, 8307, 9590, 9591, 9599, 9600, 9601, 9602, 9603, 9604, 9605, 9606, 9607, 9608, 9735, 9736, 9737, 9738, 9739, 9740, 9741, 9742, 9756, 9757, 9758, 9759, 9760, 9761, 9762, 9763, 11169, 11170, 11171, 11172, 11173
        ),
        superiorId = 686,
        teleport = Tile(3799, 3824),
        min = 40,
        max = 80,
        weight = 10
    ),
    DEMONIC_GORILLA(
        "Demonic Gorilla",
        slayerLevel = 0,
        npcIds = listOf(7144, 7145, 7146, 7147, 7148, 7149, 7152),
        teleport = Tile(1329, 10185),
        min = 40,
        max = 80,
        weight = 10
    ),
    TERROR_CAT("Terror Cat", slayerLevel = 0, npcIds = listOf(8130), superiorId = 6473, teleport = Tile(1315, 10207), min = 40, max = 80, weight = 10),
    KRAKEN("Kraken", slayerLevel = 0, npcIds = listOf(494), superiorId = 4315, teleport = Tile(3745, 3779), min = 40, max = 80, weight = 10),
    RIVER_TROLL("River Troll", slayerLevel = 0, npcIds = listOf(6735), superiorId = 4314, teleport = Tile(3734, 3790), min = 40, max = 80, weight = 10),
    TUROTH(
        "Turoth",
        slayerLevel = 0,
        npcIds = listOf(426, 427, 428, 429, 430, 431, 432),
        superiorId = 10397,
        teleport = Tile(1309, 10261),
        min = 40,
        max = 80,
        weight = 10
    ),
    DEVIANT_SPECTRE(
        "Deviant Spectre",
        slayerLevel = 0,
        npcIds = listOf(7279),
        superiorId = 7403,
        teleport = Tile(1320, 10282),
        min = 40,
        max = 80,
        weight = 10
    ),
    ZAMORAK_WARRIOR(
        "Zamorak Warrior",
        slayerLevel = 0,
        npcIds = listOf(7418, 7419),
        superiorId = 7422,
        teleport = Tile(3822, 3795),
        min = 40,
        max = 80,
        weight = 10
    ),
    ANKOU(
        "Ankou",
        slayerLevel = 0,
        npcIds = listOf(2514, 2515, 2516, 2517, 2519, 6608, 7257, 7864),
        superiorId = 7296,
        teleport = Tile(3789, 3762),
        min = 40,
        max = 80,
        weight = 10
    ),
    SMOKE_DEVIL(
        "Smoke Devil",
        slayerLevel = 0,
        npcIds = listOf(498),
        superiorId = 7406,
        teleport = Tile(3793, 3780),
        min = 40,
        max = 80,
        weight = 10
    ),
    CHRONOZONE("Chronozone", slayerLevel = 0, npcIds = listOf(4987), superiorId = 7036, teleport = Tile(1237, 10206), min = 40, max = 80, weight = 10),
    GREEN_BLUE_RED_BLACK_DRAGON(
        "Dragon",
        slayerLevel = 0,
        npcIds = listOf(
            260, 261, 262, 263, 264, 5194, 5872, 5873, 7868, 7869, 7870, 8081, 8082, 241, 242, 243, 265, 266, 267, 268, 269, 4385, 5878, 5879, 5880, 5881, 5882, 8083, 137, 244, 245, 246, 247, 248, 249, 250, 251, 8079, 252, 253, 254, 255, 256, 257, 258, 259, 1871, 1872, 7861, 7862, 7863, 8084, 8085
        ),
        teleport = Tile(2662, 9808),
        min = 40,
        max = 80,
        weight = 10
    ),
    METAL_DRAGON(
        "Metal Dragon",
        slayerLevel = 0,
        npcIds = listOf(
            270, 271, 7253, 272, 273, 7254, 8080, 139, 274, 275, 7255, 8086, 2919, 8088, 8089, 8030, 8090, 8027, 8031, 8091
        ),
        teleport = Tile(2631, 9862),
        min = 40,
        max = 80,
        weight = 10
    ),
    HYDRA("Hydea", slayerLevel = 0, npcIds = listOf(8609), superiorId = 10402, teleport = Tile(2643, 9908), min = 40, max = 80, weight = 10),
    ALCHEMICAL_HYDRA("Alchemical Hydra", slayerLevel = 0, npcIds = listOf(8622), teleport = Tile(1352, 10257), min = 40, max = 80, weight = 10),
    LAVA_DRAGON("Lava Dragon", slayerLevel = 0, npcIds = listOf(6593), teleport = Tile(2638, 9814), min = 40, max = 80, weight = 10),
    SOUL_DRAGON("Soul Dragon", slayerLevel = 0, npcIds = listOf(7039), teleport = Tile(2704, 9843), min = 40, max = 80, weight = 10),
    MEN(
        "Men",
        slayerLevel = 0,
        npcIds = listOf(
            1118, 1119, 1130, 1131, 1139, 1140, 1141, 1142, 3014, 3015, 3106, 3107, 3108, 3109, 3110, 3111, 3112, 3113, 3263, 3264, 3265, 3268, 3298, 3299, 3652, 4243, 6815, 6818, 6987, 6988, 6989, 6990, 6991, 6992, 7281, 10728, 11053, 11054, 11057, 11058
        ),
        superiorId = 3263,
        teleport = Tile(2320, 3806),
        min = 40,
        max = 80,
        weight = 10
    ),
    GUARD(
        "Guard",
        slayerLevel = 0,
        npcIds = listOf(300, 4276, 4277, 4279),
        superiorId = 1028,
        teleport = Tile(2320, 3806),
        min = 40,
        max = 80,
        weight = 10
    ),
    PRIEST(
        "Priest",
        slayerLevel = 0,
        npcIds = listOf(1159, 1171),
        superiorId = 2812,
        teleport = Tile(2344, 3805),
        min = 40,
        max = 80,
        weight = 10
    ),
    SHARP_SHOOTER(
        "Sharp Shooter",
        slayerLevel = 0,
        npcIds = listOf(1576),
        superiorId = 1502,
        teleport = Tile(2322, 3832),
        min = 40,
        max = 80,
        weight = 10
    ),
    WIZARD("Wizard", slayerLevel = 0, npcIds = listOf(3257), superiorId = 3529, teleport = Tile(2360, 3831), min = 40, max = 80, weight = 10),
    CHEF("Chef", slayerLevel = 0, npcIds = listOf(4626), superiorId = 1945, teleport = Tile(2359, 3805), min = 40, max = 80, weight = 10),
    WOODCUTTER(
        "Woodcutter",
        slayerLevel = 0,
        npcIds = listOf(3296),
        superiorId = 3653,
        teleport = Tile(2343, 3820),
        min = 40,
        max = 80,
        weight = 10
    ),
    FISHERMAN(
        "Fisherman",
        slayerLevel = 0,
        npcIds = listOf(4065),
        superiorId = 5075,
        teleport = Tile(2363, 3828),
        min = 40,
        max = 80,
        weight = 10
    ),
    AFFLICTED(
        "Afflicted",
        slayerLevel = 0,
        npcIds = listOf(1293, 1294),
        superiorId = 1567,
        teleport = Tile(2351, 3819),
        min = 40,
        max = 80,
        weight = 10
    ),
    PLAGUE_FIGHTER(
        "Plague Fighter",
        slayerLevel = 0,
        npcIds = listOf(8771),
        superiorId = 1147,
        teleport = Tile(2353, 3810),
        min = 40,
        max = 80,
        weight = 10
    ),
    MASTER_FARMER(
        "Master Farmer",
        slayerLevel = 0,
        npcIds = listOf(5730, 5731, 732, 5958),
        superiorId = 3672,
        teleport = Tile(3662, 3783),
        min = 40,
        max = 80,
        weight = 10
    ),
    FORRESTER("Forrester", slayerLevel = 0, npcIds = listOf(1157), superiorId = 2995, teleport = Tile(3645, 3794), min = 40, max = 80, weight = 10),
    NATURE_MONK("Nature Monk", slayerLevel = 0, npcIds = listOf(895), superiorId = 944, teleport = Tile(3689, 3751), min = 40, max = 80, weight = 10),
    EXPLORER("Explorer", slayerLevel = 0, npcIds = listOf(827), superiorId = 1340, teleport = Tile(3669, 3807), min = 40, max = 80, weight = 10),
    BEE_KEEPER("Bee Keeper", slayerLevel = 0, npcIds = listOf(377), superiorId = 1818, teleport = Tile(3664, 3791), min = 40, max = 80, weight = 10),
    SHIP_CREW("Ship Crew", slayerLevel = 0, npcIds = listOf(3644), superiorId = 5070, teleport = Tile(3686, 3790), min = 40, max = 80, weight = 10),
    MARKET_GUARD(
        "Market Guard",
        slayerLevel = 0,
        npcIds = listOf(2120, 3949, 5732),
        superiorId = 4569,
        teleport = Tile(3677, 3764),
        min = 40,
        max = 80,
        weight = 10
    ),
    DRUIDIC_MAGE("Duidic Mage", slayerLevel = 0, npcIds = listOf(3580), superiorId = 3472, teleport = Tile(3687, 3755), min = 40, max = 80, weight = 10),
    CHIEF_WARRIOR(
        "Chief Warrior",
        slayerLevel = 0,
        npcIds = listOf(3896),
        superiorId = 8126,
        teleport = Tile(3665, 3766),
        min = 40,
        max = 80,
        weight = 10
    ),
    ARCHER_SOLIDER(
        "Archer Solider",
        slayerLevel = 0,
        npcIds = listOf(6067),
        superiorId = 8129,
        teleport = Tile(3670, 3752, 1),
        min = 40,
        max = 80,
        weight = 10
    ),
    MASTER_RANGER(
        "Master Ranger",
        slayerLevel = 0,
        npcIds = listOf(7559),
        superiorId = 8128,
        teleport = Tile(3683, 3743, 1),
        min = 40,
        max = 80,
        weight = 10
    ),
    DESERT_LOCAL(
        "Desert Local",
        slayerLevel = 0,
        npcIds = listOf(5231),
        superiorId = 8532,
        teleport = Tile(3242, 2796),
        min = 40,
        max = 80,
        weight = 10
    ),
    DESERT_GUARD(
        "Desert Guard",
        slayerLevel = 0,
        npcIds = listOf(6699),
        superiorId = 7956,
        teleport = Tile(3257, 2786),
        min = 40,
        max = 80,
        weight = 10
    ),
    DESERT_BANDIT(
        "Desert Bandit",
        slayerLevel = 0,
        npcIds = listOf(690, 695),
        superiorId = 733,
        teleport = Tile(3214, 2799),
        min = 40,
        max = 80,
        weight = 10
    ),
    DESERT_DRUID(
        "Desert Druid",
        slayerLevel = 0,
        npcIds = listOf(8166),
        superiorId = 5960,
        teleport = Tile(3217, 2764),
        min = 40,
        max = 80,
        weight = 10
    ),
    DESERT_ASSASSIN(
        "Desert Assassin",
        slayerLevel = 0,
        npcIds = listOf(7379),
        superiorId = 786,
        teleport = Tile(3265, 2768),
        min = 40,
        max = 80,
        weight = 10
    ),
    ANIMATED_ARMOR(
        "Animated Armor",
        slayerLevel = 0,
        npcIds = listOf(2450, 2451, 2452, 2453, 2454, 2455, 2456),
        superiorId = 2451,
        teleport = Tile(3229, 2784),
        min = 40,
        max = 80,
        weight = 10
    ),
    GNOME(
        "Gnome",
        slayerLevel = 0,
        npcIds = listOf(4909, 7157, 7158, 2067, 2068, 5971, 5972, 5973),
        superiorId = 4912,
        teleport = Tile(2530, 3164),
        min = 40,
        max = 80,
        weight = 10
    ),
    GORILLA_GUARD(
        "Gorilla Guard",
        slayerLevel = 0,
        npcIds = listOf(5275),
        superiorId = 1466,
        teleport = Tile(2897, 2726),
        min = 40,
        max = 80,
        weight = 10
    ),
    MONKEY_ARCHER(
        "Monkey Archer",
        slayerLevel = 0,
        npcIds = listOf(5272),
        superiorId = 5267,
        teleport = Tile(2897, 2726),
        min = 40,
        max = 80,
        weight = 10
    ),
    NINJA_MONKEY(
        "Ninja Monkey",
        slayerLevel = 0,
        npcIds = listOf(10369),
        superiorId = 6804,
        teleport = Tile(2897, 2726),
        min = 40,
        max = 80,
        weight = 10
    ),
    SKELETAL_MONKEY(
        "Skeletal Monkey",
        slayerLevel = 0,
        npcIds = listOf(5237),
        superiorId = 1468,
        teleport = Tile(2764, 9103),
        min = 40,
        max = 80,
        weight = 10
    ),
    MONKEY_PRIEST(
        "Monkey Priest",
        slayerLevel = 0,
        npcIds = listOf(5256),
        superiorId = 5254,
        teleport = Tile(2897, 2726),
        min = 40,
        max = 80,
        weight = 10
    ),
    MANIACAL_MONKEY(
        "Maniacal Monkey",
        slayerLevel = 0,
        npcIds = listOf(7118),
        superiorId = 7119,
        teleport = Tile(2583, 9056),
        min = 40,
        max = 80,
        weight = 10
    ),
    ROYAL_MONKEY(
        "Royal Monkey",
        slayerLevel = 0,
        npcIds = listOf(5284),
        superiorId = 6812,
        teleport = Tile(2897, 2726),
        min = 40,
        max = 80,
        weight = 10
    ),
    MONKEY_ELDER(
        "Monkey Elder",
        slayerLevel = 0,
        npcIds = listOf(6804),
        superiorId = 5277,
        teleport = Tile(2897, 2726),
        min = 40,
        max = 80,
        weight = 10
    ),
    ELF_WARRIOR("Elf Warrior", slayerLevel = 0, npcIds = listOf(5296), superiorId = 7029, teleport = Tile(2562, 3862), min = 40, max = 80, weight = 10),
    GRYPHON("Gryphon", slayerLevel = 0, npcIds = listOf(1490), superiorId = 5320, teleport = Tile(2516, 3859), min = 40, max = 80, weight = 10),
    ETERNAL_WIZARD(
        "Eternal Wizard",
        slayerLevel = 0,
        npcIds = listOf(3585),
        superiorId = 1604,
        teleport = Tile(2502, 3860),
        min = 40,
        max = 80,
        weight = 10
    ),
    HOLY_GUARD("Holy Guard", slayerLevel = 0, npcIds = listOf(3360), superiorId = 9648, teleport = Tile(2528, 3860), min = 40, max = 80, weight = 10),
    DEVOUT_PRIEST(
        "Devout Priest",
        slayerLevel = 0,
        npcIds = listOf(3774),
        superiorId = 7950,
        teleport = Tile(2539, 3864),
        min = 40,
        max = 80,
        weight = 10
    ),
    FORTRESS_ARCHER("Holy Archer", slayerLevel = 0, npcIds = listOf(10434), superiorId = 3217, teleport = Tile(2577, 3863), min = 40, max = 80, weight = 10),
    GRAND_WIZARD(
        "Grand Wizard",
        slayerLevel = 0,
        npcIds = listOf(1612),
        superiorId = 4645,
        teleport = Tile(2516, 3859),
        min = 40,
        max = 80,
        weight = 10
    ),
    HOLY_GNOME("Holy Gnome", slayerLevel = 0, npcIds = listOf(2560), superiorId = 9723, teleport = Tile(2539, 3864), min = 40, max = 80, weight = 10),
    GNOME_AGENT("Gnome Agent", slayerLevel = 0, npcIds = listOf(1444), superiorId = 7953, teleport = Tile(2564, 3862), min = 40, max = 80, weight = 10),
    HOLY_GIANT("Holy Giant", slayerLevel = 0, npcIds = listOf(7934), superiorId = 3668, teleport = Tile(2592, 3872), min = 40, max = 80, weight = 10);

    fun randomAmount(): Int {
        return (Math.random() * (max - min) + min).toInt()
    }
}