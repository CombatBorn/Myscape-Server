package gg.rsmod.game.model.slayer

import gg.rsmod.game.model.Tile

/**
 * @param slayerLevel Slayer level required to fight this [Tasks].
 * @param npcIds A list of IDs for each monster classified as this [Tasks].
 * @param superiorId The ID for the monster's Superior version.
 * @param teleport The location where the standard NPCs assigned are located.
 */
enum class Tasks(
    val taskName: String,
    val slayerLevel: Int,
    val npcIds: List<Int>,
    val superiorId: Int = -1,
    val teleport: Tile
) {

    CHICKEN("Chicken", slayerLevel = 0, npcIds = listOf(1173, 1174, 2804, 2805, 2806, 3316, 3661, 3662, 9488, 10494, 10495, 10496, 10497, 10498, 10499, 10556), superiorId = 6367, teleport = Tile(3234, 3295)),
    GOBLIN("Goblin", slayerLevel = 0, npcIds = listOf(655, 656, 657, 658, 659, 660, 661, 662, 663, 664, 665, 666, 667, 668, 674, 677, 678, 2245, 2246, 2247, 2248, 2249, 2484, 2485, 2486, 2487, 2488, 2489, 3028, 3029, 3030, 3031, 3032, 3033, 3034, 3035, 3036, 3037, 3038, 3039, 3040, 3041, 3042, 3043, 3044, 3045, 3046, 3047, 3048, 3051, 3052, 3053, 3054, 3073, 3074, 3075, 3076, 4902, 4903, 4904, 4905, 4906, 5152, 5153, 5154, 5192, 5193, 5195, 5196, 5197, 5198, 5199, 5200, 5201, 5202, 5203, 5204, 5205, 5206, 5207, 5208, 5376, 5377, 5508, 5509, 10566, 10567, 11322, 11323, 11324, 11325, 11326, 11327, 11328, 11329, 11330, 11331, 11332, 11333, 11334, 11335, 11336, 11337, 11338, 11339, 11340, 11341, 11342, 11343, 11344, 11345, 11346, 11347, 11348, 11349, 11350, 11351, 11352, 11353, 11354, 11355, 11356, 11357, 11358, 11359, 11360, 11361, 11362, 11363, 11364, 11365, 11366, 11367, 11368, 11369, 11370, 11371, 11372, 11373, 11374, 11375, 11376, 11377, 11378, 11379, 11380, 11381), superiorId = 2241, teleport = Tile(3246, 3241)),
    MONKEY("Monkey", slayerLevel = 0, npcIds = listOf(1038, 2848), superiorId = 5271, teleport = Tile(2916, 3156)),
    RAT("Rat", slayerLevel = 0, npcIds = listOf(1020, 1021, 1022, 2492, 2513, 2854, 2855, 4593, 4594, 4610, 4611, 4612, 4613, 4614, 4615, 4616, 4617, 4618, 10682), superiorId = 2510, teleport = Tile(3237, 9867)),
    SPIDER("Spider", slayerLevel = 0, npcIds = listOf(2478), superiorId = 134, teleport = Tile(3180, 3221)),
    BAT("Bat", slayerLevel = 0, npcIds = listOf(2827), superiorId = 2834, teleport = Tile(3110, 3318)),
    COW("Cow", slayerLevel = 0, npcIds = listOf(6401, 5842, 2801, 2791, 2792, 2793, 2794, 2795), superiorId = 5816, teleport = Tile(3257, 3279)),
    DWARF("Dwarf", slayerLevel = 0, npcIds = listOf(290, 8496), superiorId = 291, teleport = Tile(3015, 3450)),
    MINOTAUR("Minotaur", slayerLevel = 0, npcIds = listOf(2481, 2482, 2483), superiorId = 7021, teleport = Tile(1879, 5217)),
    SCORPION("Scorpion", slayerLevel = 0, npcIds = listOf(2479, 2480, 3024, 5242), superiorId = 7022, teleport = Tile(3057, 9777)),
    ZOMBIE("Zombie", slayerLevel = 0, npcIds = listOf(26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 880, 1784, 2501, 2502, 2503, 2504, 2505, 2506, 2507, 2508, 2509, 3980, 3981, 5507, 5568, 5571, 5574, 5583, 5647, 6449, 6450, 6451, 6452, 6453, 6454, 6455, 6456, 6457, 6458, 6459, 6460, 6461, 6462, 6463, 6464, 6465, 6466, 6596, 6597, 6598, 6741, 7485, 7486, 7487, 7488, 8067, 8068, 8069), superiorId = 3359, teleport = Tile(3126, 9863)),
    BEAR("Bear", slayerLevel = 0, npcIds = listOf(2838, 2839, 3423, 3424, 3425, 3908, 3909), superiorId = 7023, teleport = Tile(3289, 3351)),
    GHOST("Ghost", slayerLevel = 0, npcIds = listOf(85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 472, 473, 474, 505, 506, 507, 920, 1786, 2527, 2528, 2529, 2530, 2531, 2532, 2533, 2534, 3008, 3009, 3516, 3617, 3625, 3975, 3976, 3977, 3978, 3979, 5370, 7263, 7264, 9194, 10538, 10697, 10698, 10699, 11301), superiorId = 2999, teleport = Tile(2910, 9830)),
    DOG("Dog", slayerLevel = 0, npcIds = listOf(7209, 112, 113, 114, 131), superiorId = 3999, teleport = Tile(2635, 3300)),
    KALPHITE("Kalphite", slayerLevel = 0, npcIds = listOf(138, 955, 956, 957, 958, 959, 960, 961, 962, 966), superiorId = 7032, teleport = Tile(3485, 9509, 2)),
    SKELETON("Skeleton", slayerLevel = 0, npcIds = listOf(70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 130, 680, 681, 924, 1685, 1686, 1687, 1688, 1785, 2520, 2521, 2522, 2523, 2524, 2525, 2526, 3358, 3565, 3584, 3972, 3973, 3974, 4491, 4492, 4493, 4494, 4495, 4496, 4497, 4498, 4499, 5054, 5237, 6326, 6387, 6440, 6441, 6442, 6443, 6444, 6445, 6446, 6447, 6448, 6467, 6468, 6613, 6614, 7265, 8070, 8071, 8072, 8139, 8140, 10717, 10718, 10719, 10720, 10721), superiorId = 3358 , teleport = Tile(3097, 9909)),
    ICEFIEND("Icefiend", slayerLevel = 0, npcIds = listOf(3140, 4813, 7586), superiorId = 778 , teleport = Tile(3007, 3478)),
    WOLF("Wolf", slayerLevel = 0, npcIds = listOf(106, 109, 110, 115, 116, 117, 231, 232, 2490, 2491, 3912, 4649, 4650, 4651, 9181, 10522, 10533), superiorId = 7620, teleport = Tile(2834, 3508)),
    CRAWLING_HAND("Crawling Hand", slayerLevel = 0, npcIds = listOf(120, 448, 449, 450, 451, 452, 453, 454, 455, 456, 457), superiorId = 1077, teleport = Tile(3420, 3535)),
    CAVE_CRAWLER("Cave Crawler", slayerLevel = 0, npcIds = listOf(406, 407, 408, 409), superiorId = 7389 , teleport = Tile(3190, 9570)),
    BANSHEE("Banshee", slayerLevel = 0, npcIds = listOf(414), superiorId = 7391 , teleport = Tile(3440, 3543)),
    CAVE_SLIME("Cave Slime", slayerLevel = 0, npcIds = listOf(480), superiorId = 488, teleport = Tile(3250, 9575)),
    LIZARD("Lizard", slayerLevel = 0, npcIds = listOf(459, 460, 461, 462, 463), superiorId = 458 , teleport = Tile(3320, 2900)),
    MOLANISK("Molanisk", slayerLevel = 0, npcIds = listOf(1), superiorId = 3449, teleport = Tile(2713, 5225)),
    COCKATRICE("Cockatrice", slayerLevel = 0, npcIds = listOf(419, 420), superiorId = 7393, teleport = Tile(2619, 10265)),
    EARTH_WARRIOR("Earth Warrior", slayerLevel = 0, npcIds = listOf(2840), superiorId = 3328, teleport = Tile(3121, 9991)),
    FLESH_CRAWLER("Flesh Crawler", slayerLevel = 0, npcIds = listOf(2498, 2499, 2500), superiorId = 483, teleport = Tile(1991, 5237)),
    GHOUL("Ghoul", slayerLevel = 0, npcIds = listOf(289), superiorId = 6344, teleport = Tile(3438, 3461)),
    HILL_GIANT("Hill Giant", slayerLevel = 0, npcIds = listOf(2098, 2099, 2100, 2101, 2102, 2103, 7261, 10374, 10375, 10376, 11195), superiorId = 0, teleport = Tile(3115, 9843)),
    ICE_WARRIOR("Ice Warrior", slayerLevel = 0, npcIds = listOf(2841, 2842, 2851), superiorId = 2085, teleport = Tile(3050, 9585)),
    KILLERWATT("Killerwatt", slayerLevel = 0, npcIds = listOf(469), superiorId = 470, teleport = Tile(2661, 5209, 2)),
    WATERFIEND("Waterfiend", slayerLevel = 0, npcIds = listOf(2916, 2917), superiorId = 1370, teleport = Tile(1740, 5353)),
    MOGRE("Mogre", slayerLevel = 0, npcIds = listOf(2592), superiorId = 4817, teleport = Tile(3000, 3121)),
    OGRE("Ogre", slayerLevel = 0, npcIds = listOf(136, 864, 865, 1225, 2095, 2096, 2233, 4368, 4369, 4370, 4371, 4372), superiorId = 7028, teleport = Tile(2505, 3115)),
    MOSS_GIANT("Moss Giant", slayerLevel = 0, npcIds = listOf(2090, 2091, 2092, 2093, 3851, 3852, 7262), superiorId = 8736, teleport = Tile(2700, 3200)),
    CROCODILE("Crocodile", slayerLevel = 0, npcIds = listOf(4184, 11581, 11582), superiorId = 11513, teleport = Tile(3217, 3179)),
    ICE_GIANT("Ice Giant", slayerLevel = 0, npcIds = listOf(2085, 2086, 2087, 2088, 2089, 7878, 7879, 7880), superiorId = 882, teleport = Tile(3050, 9585)),
    GREEN_DRAGON("Green Dragon", slayerLevel = 0, npcIds = listOf(260, 261, 262, 263, 264, 5194, 5872, 5873, 7868, 7869, 7870, 8073, 8076, 8081, 8082), superiorId = 2918, teleport = Tile(2012, 9003, 1)),
    WEREWOLF("Werewolf", slayerLevel = 0, npcIds = listOf(2593, 2594, 2595, 2596, 2597, 2598, 2599, 2600, 2601, 2602, 2603, 2604, 2605, 2606, 2607, 2608, 2609, 2610, 2611, 2612, 3135, 3136, 5928, 9580, 9581, 9582, 9743, 9744, 9745), superiorId =1377, teleport = Tile(3500, 3500)),
    SEASNAKE("Seasnake", slayerLevel = 0, npcIds = listOf(1097, 1098), superiorId =1103, teleport = Tile(2619, 10265)),
    PYREFIEND("Pyrefiend", slayerLevel = 0, npcIds = listOf(433, 434, 435, 436, 3139), superiorId = 6795, teleport = Tile(2700, 10025)),
    ROCK_SLUG("Rock Slug", slayerLevel = 0, npcIds = listOf(421, 422), superiorId = 7392, teleport = Tile(2800, 10016)),
    SHADE("Shade", slayerLevel = 0, npcIds = listOf(5633), superiorId = 6740, teleport = Tile(1605, 10040)),
    VAMPYRE("Vampyre", slayerLevel = 0, npcIds = listOf(3137, 3234, 3237, 3239, 3690, 3691, 3692, 3693, 3694, 3695, 3696, 3697, 3698, 3699, 3700, 3707, 3708, 4427, 4428, 4429, 4430, 4431, 4432, 4433, 4434, 4436, 4437, 4438, 4439, 4442, 4443, 4481, 4482, 4486, 4487, 5634, 5635, 5636, 5637, 5638, 5639, 5640, 5641, 5642, 8326, 8327, 8678, 9586, 9587, 9615, 9616, 9617, 9683, 9684, 9727, 9728, 9729, 9730, 9731, 9732, 9733, 9734), superiorId = 6393, teleport = Tile(3600, 3188)),
    WHITE_WOLF("White Wolf", slayerLevel = 0, npcIds = listOf(107, 108), superiorId = 9181, teleport = Tile(2833, 3511)),
    AVIANSIES("Aviansies", slayerLevel = 0, npcIds = listOf(3169, 3170, 3171, 3172, 3173, 3174, 3175, 3176, 3177, 3178, 3179, 3180, 3182, 3183), superiorId = 7037, teleport = Tile(2883, 5311, 2)),
    LIZARDMAN("Lizardman", slayerLevel = 0, npcIds = listOf(6766, 6767, 6914, 6915, 6916, 6917, 6918, 6919, 7573, 7574, 7744, 7745, 7997, 8000, 8563, 8564, 8565, 10947, 10948), teleport = Tile(1330, 10085)),
    TZHAAR("Tzhaar", slayerLevel = 0, npcIds = listOf(2154, 2155, 2156, 2157, 2158, 2159, 2160, 2161, 2162, 2163, 2164, 2165, 2166, 2167, 2168, 2169, 2170, 2171, 2172, 2173, 2174, 2175, 2176, 2177, 2178, 2179, 7679, 7682, 7683, 7684, 7685, 7686, 7687), superiorId = 7035, teleport = Tile(2451, 5146)),
    LESSER_DEMON("Lesser Demon", slayerLevel = 0, npcIds = listOf(2005, 2006, 2007, 2008, 2018, 3982, 7247, 7248, 7656, 7657, 7664, 7865, 7866, 7867), superiorId = 2028, teleport = Tile(2935, 9793)),
    SHADOW_WARRIOR("Shadow Warrior", slayerLevel = 0, npcIds = listOf(2853), superiorId = 2843, teleport = Tile(2728, 9774)),
    TROLL("Troll", slayerLevel = 0, npcIds = listOf(133, 648, 649, 650, 651, 652, 653, 654, 698, 699, 700, 701, 702, 703, 704, 705, 931, 932, 933, 934, 935, 936, 937, 938, 939, 940, 941, 942, 1874, 1875, 1876, 1877, 4120, 4121, 4122, 4123, 4124, 4125, 4126, 4127, 4128, 4129, 4135, 4136, 4137, 4138, 4139, 4143, 4308, 4309, 4310, 4311, 4313, 4315, 5822, 5823, 5824, 5825, 5826, 5828, 5829, 5830, 5831, 6294, 6356, 6732, 6733, 6734, 6735, 6736, 6737, 7030, 8470, 8471, 8472, 8473), superiorId = 4130, teleport = Tile(2850, 3675)),
    BLUE_DRAGON("Blue Dragon", slayerLevel = 0, npcIds = listOf(241, 242, 243, 265, 266, 267, 268, 269, 4385, 5878, 5879, 5880, 5881, 5882, 8074, 8077, 8083), superiorId = 7273, teleport = Tile(2922, 9803)),
    FIRE_GIANT("Fire Giant", slayerLevel = 0, npcIds = listOf(2075, 2076, 2077, 2078, 2079, 2080, 2081, 2082, 2083, 2084, 7251, 7252), superiorId = 3448, teleport = Tile(2575, 9875)),
    JUNGLE_HORROR("Jungle Horror", slayerLevel = 0, npcIds = listOf(1042, 1043, 1044, 1045, 1046), superiorId = 1047, teleport = Tile(3730, 9353)),
    RED_DRAGON("Red Dragon", slayerLevel = 0, npcIds = listOf(137, 244, 245, 246, 247, 248, 249, 250, 251, 8075, 8078, 8079), superiorId = 7274, teleport = Tile(2720, 9520)),
    ELF("Elf", slayerLevel = 0, npcIds = listOf(5293, 5294, 5295, 5296), superiorId = 7029, teleport = Tile(2204, 3253)),
    BLACK_DRAGON("Black Dragon", slayerLevel = 0, npcIds = listOf(252, 253, 254, 255, 256, 257, 258, 259, 1871, 1872, 7861, 7862, 7863, 7955, 8084, 8085), superiorId = 7275, teleport = Tile(2720, 9520)),
    BRONZE_DRAGON("Bronze Dragon", slayerLevel = 0, npcIds = listOf(270, 271, 7253), superiorId = -1, teleport = Tile(2740, 9500)),
    DAGGANOTH("Dagganoth", slayerLevel = 0, npcIds = listOf(140, 970, 971, 972, 973, 974, 975, 976, 977, 978, 979, 3185, 5942, 5943, 7259, 7260), superiorId = 6361, teleport = Tile(2444, 10444)),
    HELLHOUND("Hellhound", slayerLevel = 0, npcIds = listOf(104, 105, 135, 3133, 7256, 7877), superiorId = 5054, teleport = Tile(2860, 9845)),
    BLACK_DEMON("Black Demon", slayerLevel = 0, npcIds = listOf(240, 1432, 2048, 2049, 2050, 2051, 2052, 5874, 5875, 5876, 5877, 6357, 7242, 7243, 7874, 7875, 7876), superiorId = 1609, teleport = Tile(2860, 9777)),
    IRON_DRAGON("Iron Dragon", slayerLevel = 0, npcIds = listOf(272, 273, 7254, 8080), superiorId = -1, teleport = Tile(2711, 9465)),
    STEEL_DRAGON("Steel Dragon", slayerLevel = 0, npcIds = listOf(139, 274, 275, 7255, 8086), superiorId = -1, teleport = Tile(2700, 9435)),
    HARPIE_BUG_SWARM("Harpie Bug Swarm", slayerLevel = 0, npcIds = listOf(464), superiorId = 6273, teleport = Tile(2867, 3111)),
    BASILISK("Basilisk", slayerLevel = 0, npcIds = listOf(122, 417, 418, 9283, 9284, 9285, 9286), superiorId = 9287, teleport = Tile(2742, 10010)),
    FEVER_SPIDER("Fever Spider", slayerLevel = 0, npcIds = listOf(626), superiorId = 1607, teleport = Tile(2147, 5098)),
    INFERNAL_MAGE("Infernal Mage", slayerLevel = 0, npcIds = listOf(443, 444, 445, 446, 447), superiorId = 7396, teleport = Tile(3440, 3568)),
    BRINE_RAT("Brine Rat", slayerLevel = 0, npcIds = listOf(4501), superiorId = 9040, teleport = Tile(2707, 10160)),
    BLOODVELD("Bloodveld", slayerLevel = 0, npcIds = listOf(484, 485, 486, 487, 3138), superiorId = 7398, teleport = Tile(3416, 3571)),
    MITHRIL_DRAGON("Mithril Dragon", slayerLevel = 0, npcIds = listOf(2919, 8088, 8089), superiorId = -1, teleport = Tile(2703, 10028)),
    ZYGOMITE("Zygomite", slayerLevel = 0, npcIds = listOf(537, 1024), superiorId = 7797, teleport = Tile(2720, 10008)),
    ABERRANT_SPECTRE("Aberrant Spectre", slayerLevel = 0, npcIds = listOf(2, 3, 4, 5, 6, 7), superiorId = 7402, teleport = Tile(1767, 5341, 1)),
    WYRM("Wyrm", slayerLevel = 0, npcIds = listOf(8610), superiorId = 10399, teleport = Tile(2420, 4430)),
    SPIRITUAL_CREATURE("Spiritual Creature", slayerLevel = 0, npcIds = listOf(2210, 2211, 2212, 2242, 2243, 2244, 3159, 3160, 3161, 3166, 3167, 3168, 11290, 11291, 11292), superiorId = 2955, teleport = Tile(3417, 3544)),
    DUST_DEVIL("Dust Devil", slayerLevel = 0, npcIds = listOf(423, 7249, 11238, 423), superiorId = 7404, teleport = Tile(1264, 10158)),
    FOSSIL_WYVERN("Fossil Wyvern", slayerLevel = 0, npcIds = listOf(7792, 7793, 7794, 7795), superiorId = 2641, teleport = Tile(3611, 10275)),
    KURASK("Kurask", slayerLevel = 0, npcIds = listOf(123, 410, 411), superiorId = 7405, teleport = Tile(2701, 9997)),
    SKELETAL_WYVERN("Skeletal Wyvern", slayerLevel = 0, npcIds = listOf(465, 466, 467, 468), superiorId = 3577, teleport = Tile(3050, 9555)),
    GARGOYLES("Gargoyles", slayerLevel = 0, npcIds = listOf(412, 413, 1543), superiorId = 7407, teleport = Tile(3435, 3540, 2)),
    NECHRYAEL("Nechryael", slayerLevel = 0, npcIds = listOf(8, 11), superiorId = 7411, teleport = Tile(3443, 3558, 2)),
    ADAMANT_DRAGON("Adamant Dragon", slayerLevel = 0, npcIds = listOf(8030, 8090), superiorId = -1, teleport = Tile(3568, 4005)),
    DARK_BEAST("Dark Beast", slayerLevel = 0, npcIds = listOf(4005, 7250), superiorId = 7409, teleport = Tile(2471, 6144)),
    DRAKE("Drake", slayerLevel = 0, npcIds = listOf(8612, 8613), superiorId = 10400, teleport = Tile(1264, 10158)),
    RUNE_DRAGON("Rune Dragon", slayerLevel = 0, npcIds = listOf(8027, 8031, 8091), superiorId = -1, teleport = Tile(3568, 4005)),
    SUQAH("Suqah", slayerLevel = 0, npcIds = listOf(787, 788, 789, 790, 791, 792, 793), superiorId = 6588, teleport = Tile(2133, 3869)),
    ABYSSAL_DEMON("Abyssal Demon", slayerLevel = 0, npcIds = listOf(124, 415, 416, 7241, 11239), superiorId = 7410, teleport = Tile(3418, 3570, 2)),
    TZTOK_JAD("TzTok-Jad", slayerLevel = 0, npcIds = listOf(6506), teleport = Tile(2440, 5171)),
    KING_BLACK_DRAGON("King Black Dragon", slayerLevel = 0, npcIds = listOf(239), teleport = Tile(2271, 4684)),
    CORPOREAL_BEAST("Corporeal Beast", slayerLevel = 0, npcIds = listOf(319), teleport = Tile(2968, 4384)),
    GIANT_MOLE("Giant Mole", slayerLevel = 0, npcIds = listOf(5779), teleport = Tile(1760, 5194)),
    DAGANNOTH_KING("Dagannoth King", slayerLevel = 0, npcIds = listOf(6496, 6497, 6498), teleport = Tile(2419, 4455)),
    KALPHITE_QUEEN("Kalphite Queen", slayerLevel = 0, npcIds = listOf(6501), teleport = Tile(3509, 9496)),
    COMMANDER_ZILYANA("Commander Zilyana", slayerLevel = 0, npcIds = listOf(2205), teleport = Tile(2882, 5310, 2)),
    GENERAL_GRAARDOR("General Graardor", slayerLevel = 0, npcIds = listOf(2215), teleport = Tile(2882, 5310, 2)),
    KREEARA("Kree'Ara", slayerLevel = 0, npcIds = listOf(3162), teleport = Tile(2882, 5310, 2)),
    KRIL_TSUTSAROTH("K'ril Tsutsaroth", slayerLevel = 0, npcIds = listOf(6495), teleport = Tile(2882, 5310, 2)),
    ZULRAH("Zulrah", slayerLevel = 0, npcIds = listOf(2042), teleport = Tile(2200, 3056)),
    VORKATH("Vorkath", slayerLevel = 0, npcIds = listOf(8026), superiorId = 8178, teleport = Tile(2276, 4037)),
    ABYSSAL_SIRE("Abyssal Sire", slayerLevel = 0, npcIds = listOf(5890), teleport = Tile(3039, 4787)),
    CAVE_KRAKEN("Cave Kraken", slayerLevel = 0, npcIds = listOf(494), teleport = Tile(2283, 10015)),
    CERBERUS("Cerberus", slayerLevel = 0, npcIds = listOf(5862), teleport = Tile(1304, 1293)),
    THERMONUCLEAR_SMOKE_DEVIL("Thermonuclear Smoke Devil", slayerLevel = 0, npcIds = listOf(499), teleport = Tile(2400, 9440)),
    SEWER_CRAB("Sewer Crab", slayerLevel = 0, npcIds = listOf(8297, 8298), superiorId = 7576, teleport = Tile(3402, 4973)),
    MUTATED_LOBSTER("Mutated Lobster", slayerLevel = 0, npcIds = listOf(4800), superiorId = 7796, teleport = Tile(3433, 4959)),
    SEWER_DEMON("Sewer Demon", slayerLevel = 0, npcIds = listOf(8604, 8606, 8607), superiorId = 9614, teleport = Tile(3407, 4942)),
    SEWER_SNAKE("Sewer Snake", slayerLevel = 0, npcIds = listOf(7594), superiorId = 9560, teleport = Tile(3439, 4937)),
    SEWER_GIANT("Sewer Giant", slayerLevel = 0, npcIds = listOf(7101), superiorId = 5129, teleport = Tile(3443, 4973)),
    SEWER_DOG("Sewer Dog", slayerLevel = 0, npcIds = listOf(6336), superiorId = 9612, teleport = Tile(3444, 4949)),
    GOBLIN_VARITY("Goblin", slayerLevel = 0, npcIds = listOf(655, 656, 657, 658, 659, 660, 661, 662, 663, 664, 665, 666, 667, 668, 674, 677, 678, 2245, 2246, 2247, 2248, 2249, 2484, 2485, 2486, 2487, 2488, 2489, 3028, 3029, 3030, 3031, 3032, 3033, 3034, 3035, 3036, 3037, 3038, 3039, 3040, 3041, 3042, 3043, 3044, 3045, 3046, 3047, 3048, 3051, 3052, 3053, 3054, 3073, 3074, 3075, 3076, 4902, 4903, 4904, 4905, 4906, 5152, 5153, 5154, 5192, 5193, 5195, 5196, 5197, 5198, 5199, 5200, 5201, 5202, 5203, 5204, 5205, 5206, 5207, 5208, 5376, 5377, 5508, 5509, 10566, 10567, 11322, 11323, 11324, 11325, 11326, 11327, 11328, 11329, 11330, 11331, 11332, 11333, 11334, 11335, 11336, 11337, 11338, 11339, 11340, 11341, 11342, 11343, 11344, 11345, 11346, 11347, 11348, 11349, 11350, 11351, 11352, 11353, 11354, 11355, 11356, 11357, 11358, 11359, 11360, 11361, 11362, 11363, 11364, 11365, 11366, 11367, 11368, 11369, 11370, 11371, 11372, 11373, 11374, 11375, 11376, 11377, 11378, 11379, 11380, 11381), superiorId = 2241, teleport = Tile(2848, 3244)),
    WITCH_DOCTOR("Witch Doctor", slayerLevel = 0, npcIds = listOf(6409, 6410, 6411, 6412, 6413), superiorId = 6406, teleport = Tile(2843, 3297)),
    PIRATE("Pirate", slayerLevel = 0, npcIds = listOf(6993, 6995, 7412, 6994), superiorId = 1053, teleport = Tile(2855, 3277)),
    IMP("Imp", slayerLevel = 0, npcIds = listOf(3134, 5007, 5728), superiorId = 3355, teleport = Tile(2819, 3292)),
    GHOST_WARRIOR("Ghost Warrior", slayerLevel = 0, npcIds = listOf(922), superiorId = 625, teleport = Tile(2450, 10260)),
    BARBARIAN_SPIRIT("Barbarian Spirit", slayerLevel = 0, npcIds = listOf(5564), superiorId = 1540, teleport = Tile(2842, 9638)),
    BARBARIAN("Barbarian", slayerLevel = 0, npcIds = listOf(3055, 3056, 3057, 3058, 3059, 3060, 3061, 3062, 3064, 3065, 3066, 3067, 3068, 3069, 3070, 3071, 3072, 3256, 3262, 10676, 10677, 10678, 10679, 10984, 10985, 10986, 10987, 10988), superiorId = 1661, teleport = Tile(2836, 3278)),
    DARK_WIZARD("Dark Wizard", slayerLevel = 0, npcIds = listOf(510, 512, 2056, 2057, 2058, 2059, 5086, 5087, 5088, 5089, 6779, 7064, 7065), superiorId = 1783, teleport = Tile(2829, 9639)),
    CAVE_SPIRIT("Cave Spirit", slayerLevel = 0, npcIds = listOf(6359), superiorId = 1362, teleport = Tile(2827, 9591)),
    GHAST("Ghast", slayerLevel = 0, npcIds = listOf(946), superiorId = 7936, teleport = Tile(2822, 9565)),
    DRAGON_SPAWN("Dragon Spawn", slayerLevel = 0, npcIds = listOf(1873), superiorId = 7955, teleport = Tile(2838, 9557)),
    ROCK_CRAB("Rock Crab", slayerLevel = 0, npcIds = listOf(100, 102), superiorId = 2261, teleport = Tile(3667, 3876)),
    SNOW_MITE("Snow Mite", slayerLevel = 0, npcIds = listOf(1782), superiorId = 1257, teleport = Tile(3710, 3843)),
    ICE_BAT("Ice Bat", slayerLevel = 0, npcIds = listOf(1039), superiorId = 1722, teleport = Tile(3756, 3841)),
    DARK_WARRIOR("Dark Warrior", slayerLevel = 0, npcIds = listOf(6606), superiorId = 910, teleport = Tile(3694, 3842)),
    BLACK_KNIGHT("Black Knight", slayerLevel = 0, npcIds = listOf(516, 517, 1545, 4067, 4331, 4934, 4959, 4960), superiorId = 6360, teleport = Tile(3747, 3869)),
    ICE_SPIRIT("Ice Spirit", slayerLevel = 0, npcIds = listOf(3458), superiorId = 4922, teleport = Tile(3705, 3883)),
    FROZEN_ARCHER("Frozen Archer", slayerLevel = 0, npcIds = listOf(6222), superiorId = 401, teleport = Tile(3685, 3879)),
    JELLY("Jelly", slayerLevel = 0, npcIds = listOf(437, 438, 439, 440, 441, 442, 7518, 11241, 11242, 11243, 11244, 11245), superiorId = 7400, teleport = Tile(3014, 4365)),
    POISON_SPIDER("Poison Spider", slayerLevel = 0, npcIds = listOf(3023, 5373), superiorId = 3016, teleport = Tile(3012, 4405)),
    SKELETON_FREMINEK("Skeleton Freminek", slayerLevel = 0, npcIds = listOf(4491, 4492, 4493, 4494, 4495, 4496, 4497, 4498, 4499), superiorId = 9458, teleport = Tile(3029, 4358)),
    HARPIE_BUG("Harpie Bug", slayerLevel = 0, npcIds = listOf(464), superiorId = 6273, teleport = Tile(3233, 9330)),
    SAND_CRAB("Sand Crab", slayerLevel = 0, npcIds = listOf(5935), superiorId = 7266, teleport = Tile(3211, 9292)),
    CAVE_GOLEM("Cave Golem", slayerLevel = 0, npcIds = listOf(5136), superiorId = 1366, teleport = Tile(3208, 9312)),
    SAND_SNAKE("Sand Snake", slayerLevel = 0, npcIds = listOf(7802), superiorId = 7903, teleport = Tile(3262, 9285)),
    LIZARDMEN("Lizardmen", slayerLevel = 0, npcIds = listOf(459, 460, 461, 462, 463, 2831, 4198, 6766, 6767, 6914, 6915, 6916, 6917, 6918, 6919, 7573, 7574, 7744, 7745, 7997, 8000, 8563, 8564, 8565, 10947, 10948), superiorId = 8709 , teleport = Tile(2450, 10260)),
    ORK("Ork", slayerLevel = 0, npcIds = listOf(3832), superiorId = 1606, teleport = Tile(3216, 9352)),
    JOGRE("Jogre", slayerLevel = 0, npcIds = listOf(2094), superiorId = 3356, teleport = Tile(3225, 9366)),
    MUMMY("Mummy", slayerLevel = 0, npcIds = listOf(717, 718, 719, 720, 721, 722, 723, 724, 725, 726, 727, 728, 949, 950, 951, 952, 953, 5506, 7658, 7659, 7660, 7661, 7662), superiorId = 4199, teleport = Tile(3756, 3750)),
    VYREWATCH("Vyrewatch", slayerLevel = 0, npcIds = listOf(3709, 3710, 3711, 3712, 3713, 3714, 3715, 3716, 3717, 3718, 3719, 3720, 3721, 3722, 3723, 3724, 3725, 3726, 3727, 3728, 3729, 3730, 3731, 3732, 3748, 3749, 3750, 3751, 3752, 3753, 3754, 3755, 3756, 3757, 3758, 3759, 3760, 3761, 3762, 3763, 3768, 3769, 3770, 3771, 8251, 8252, 8253, 8254, 8255, 8256, 8257, 8258, 8259, 8300, 8301, 8302, 8303, 8304, 8305, 8306, 8307, 9590, 9591, 9599, 9600, 9601, 9602, 9603, 9604, 9605, 9606, 9607, 9608, 9735, 9736, 9737, 9738, 9739, 9740, 9741, 9742, 9756, 9757, 9758, 9759, 9760, 9761, 9762, 9763, 11169, 11170, 11171, 11172, 11173), superiorId = 686, teleport = Tile(3799, 3824)),
    DEMONIC_GORILLA("Demonic Gorilla", slayerLevel = 0, npcIds = listOf(7144, 7145, 7146, 7147, 7148, 7149, 7152), teleport = Tile(1329, 10185)),
    TERROR_CAT("Terror Cat", slayerLevel = 0, npcIds = listOf(8130), superiorId = 6473, teleport = Tile(1315, 10207)),
    KRAKEN("Kraken", slayerLevel = 0, npcIds = listOf(494), superiorId = 4315, teleport = Tile(3745, 3779)),
    RIVER_TROLL("River Troll", slayerLevel = 0, npcIds = listOf(6735), superiorId = 4314, teleport = Tile(3734, 3790)),
    TUROTH("Turoth", slayerLevel = 0, npcIds = listOf(426, 427, 428, 429, 430, 431, 432), superiorId = 10397, teleport = Tile(1309, 10261)),
    DEVIANT_SPECTRE("Deviant Spectre", slayerLevel = 0, npcIds = listOf(7279), superiorId = 7403, teleport = Tile(1320, 10282)),
    ZAMORAK_WARRIOR("Zamorak Warrior", slayerLevel = 0, npcIds = listOf(7418, 7419), superiorId = 7422, teleport = Tile(3818, 3809)),
    ANKOU("Ankou", slayerLevel = 0, npcIds = listOf(2514, 2515, 2516, 2517, 2519, 6608, 7257, 7864), superiorId = 7296, teleport = Tile(3789, 3762)),
    SMOKE_DEVIL("Smoke Devil", slayerLevel = 0, npcIds = listOf(498, 6639, 6655, 8482, 8483), superiorId = 7406, teleport = Tile(3793, 3780)),
    CHRONOZONE("Chronozone", slayerLevel = 0, npcIds = listOf(4987), superiorId = 7036, teleport = Tile(1237, 10206)),
    GREEN_BLUE_RED_BLACK_DRAGON("Dragon", slayerLevel = 0, npcIds = listOf(260, 261, 262, 263, 264, 5194, 5872, 5873, 7868, 7869, 7870, 8073, 8076, 8081, 8082, 241, 242, 243, 265, 266, 267, 268, 269, 4385, 5878, 5879, 5880, 5881, 5882, 8074, 8077, 8083, 137, 244, 245, 246, 247, 248, 249, 250, 251, 8075, 8078, 8079, 252, 253, 254, 255, 256, 257, 258, 259, 1871, 1872, 7861, 7862, 7863, 7955, 8084, 8085), teleport = Tile(2662, 9808)),
    METAL_DRAGON("Metal Dragon", slayerLevel = 0, npcIds = listOf(270, 271, 7253, 272, 273, 7254, 8080, 139, 274, 275, 7255, 8086, 2919, 8088, 8089, 8030, 8090, 8027, 8031, 8091), teleport = Tile(2631, 9862)),
    HYDRA("Hydea", slayerLevel = 0, npcIds = listOf(8609), superiorId = 10402, teleport = Tile(2643, 9908)),
    ALCHEMICAL_HYDRA("Alchemical Hydra", slayerLevel = 0, npcIds = listOf(8622), teleport = Tile(1352, 10257)),
    LAVA_DRAGON("Lava Dragon", slayerLevel = 0, npcIds = listOf(6593), teleport = Tile(2638, 9814)),
    SOUL_DRAGON("Soul Dragon", slayerLevel = 0, npcIds = listOf(7039), teleport = Tile(2704, 9843)),
    MEN("Men", slayerLevel = 0, npcIds = listOf(385, 1118, 1119, 1130, 1131, 1138, 1139, 1140, 1141, 1142, 3014, 3015, 3106, 3107, 3108, 3109, 3110, 3111, 3112, 3113, 3263, 3264, 3265, 3268, 3298, 3299, 3652, 4243, 4268, 4269, 4270, 4271, 4272, 6776, 6815, 6818, 6987, 6988, 6989, 6990, 6991, 6992, 7281, 7919, 7920, 7921, 7922, 8858, 8859, 8860, 8861, 8862, 8863, 8864, 10672, 10673, 10674, 10728, 10945, 11032, 11053, 11054, 11057, 11058), superiorId = 3263, teleport = Tile(2320, 3806)),
    GUARD("Guard", slayerLevel = 0, npcIds = listOf(300, 4276, 4277, 4279), superiorId = 1028, teleport = Tile(2320, 3806)),
    PRIEST("Priest", slayerLevel = 0, npcIds = listOf(1159, 923, 1167, 1171), superiorId = 2812, teleport = Tile(2344, 3805)),
    SHARP_SHOOTER("Sharp Shooter", slayerLevel = 0, npcIds = listOf(1576), superiorId = 1502, teleport = Tile(2322, 3832)),
    WIZARD("Wizard", slayerLevel = 0, npcIds = listOf(3257), superiorId = 3529, teleport = Tile(2360, 3831)),
    CHEF("Chef", slayerLevel = 0, npcIds = listOf(4626, 3858), superiorId = 1945, teleport = Tile(2359, 3805)),
    WOODCUTTER("Woodcutter", slayerLevel = 0, npcIds = listOf(3296, 3653), superiorId = 7239, teleport = Tile(2343, 3820)),
    FISHERMAN("Fisherman", slayerLevel = 0, npcIds = listOf(3934, 4065), superiorId = 5075, teleport = Tile(2363, 3828)),
    AFFLICTED("Afflicted", slayerLevel = 0, npcIds = listOf(1293, 1294, 4469, 4470), superiorId = 1567, teleport = Tile(2351, 3819)),
    PLAGUE_FIGHTER("Plague Fighter", slayerLevel = 0, npcIds = listOf(8771), superiorId = 1147, teleport = Tile(2353, 3810)),
    MASTER_FARMER("Master Farmer", slayerLevel = 0, npcIds = listOf(5730, 5731, 732, 5958), superiorId = 3672, teleport = Tile(3662, 3783)),
    FORRESTER("Forrester", slayerLevel = 0, npcIds = listOf(1157, 372), superiorId = 2995, teleport = Tile(3645, 3794)),
    NATURE_MONK("Nature Monk", slayerLevel = 0, npcIds = listOf(895), superiorId = 944, teleport = Tile(3689, 3751)),
    EXPLORER("Explorer", slayerLevel = 0, npcIds = listOf(827), superiorId = 1340, teleport = Tile(3669, 3807)),
    BEE_KEEPER("Bee Keeper", slayerLevel = 0, npcIds = listOf(3225), superiorId = 1818, teleport = Tile(3664, 3791)),
    SHIP_CREW("Ship Crew", slayerLevel = 0, npcIds = listOf(3644), superiorId = 5070, teleport = Tile(3686, 3790)),
    MARKET_GUARD("Market Guard", slayerLevel = 0, npcIds = listOf(2120, 3949, 5732), superiorId = 4569, teleport = Tile(3677, 3764)),
    DRUIDIC_MAGE("Duidic Mage", slayerLevel = 0, npcIds = listOf(3580), superiorId = 3472, teleport = Tile(3687, 3755)),
    CHIEF_WARRIOR("Chief Warrior", slayerLevel = 0, npcIds = listOf(3896), superiorId = 8126, teleport = Tile(3665, 3766)),
    ARCHER_SOLIDER("Archer Solider", slayerLevel = 0, npcIds = listOf(6067), superiorId = 8129, teleport = Tile(3670, 3752, 1)),
    MASTER_RANGER("Master Ranger", slayerLevel = 0, npcIds = listOf(7559), superiorId = 8128, teleport = Tile(3683, 3743, 1)),
    DESERT_LOCAL("Desert Local", slayerLevel = 0, npcIds = listOf(5231), superiorId = 8532, teleport = Tile(3242, 2796)),
    DESERT_GUARD("Desert Guard", slayerLevel = 0, npcIds = listOf(6699), superiorId = 7956, teleport = Tile(3257, 2786)),
    DESERT_BANDIT("Desert Bandit", slayerLevel = 0, npcIds = listOf(690, 691, 692, 693, 694, 695), superiorId = 5960, teleport = Tile(3214, 2799)),
    DESERT_DRUID("Desert Druid", slayerLevel = 0, npcIds = listOf(8166), superiorId = 8724, teleport = Tile(3217, 2764)),
    DESERT_ASSASSIN("Desert Assassin", slayerLevel = 0, npcIds = listOf(7379), superiorId = 786, teleport = Tile(3265, 2768)),
    ANIMATED_ARMOR("Animated Armor", slayerLevel = 0, npcIds = listOf(2450, 2451, 2452, 2453, 2454, 2455, 2456), superiorId = 2451, teleport = Tile(3229, 2784)),
    GNOME("Gnome", slayerLevel = 0, npcIds = listOf(4909, 7157, 7158, 2067, 2068, 5971, 5972, 5973), superiorId = 4912, teleport = Tile(2530, 3164)),
    GORILLA_GUARD("Gorilla Guard", slayerLevel = 0, npcIds = listOf(5275), superiorId = 1466, teleport = Tile(2897, 2726)),
    MONKEY_ARCHER("Monkey Archer", slayerLevel = 0, npcIds = listOf(5272), superiorId = 5267, teleport = Tile(2897, 2726)),
    NINJA_MONKEY("Ninja Monkey", slayerLevel = 0, npcIds = listOf(10369), superiorId = 6804, teleport = Tile(2897, 2726)),
    SKELETAL_MONKEY("Skeletal Monkey", slayerLevel = 0, npcIds = listOf(5237), superiorId = 1468, teleport = Tile(2764, 9103)),
    MONKEY_PRIEST("Monkey Priest", slayerLevel = 0, npcIds = listOf(5256), superiorId = 5254, teleport = Tile(2897, 2726)),
    MANIACAL_MONKEY("Maniacal Monkey", slayerLevel = 0, npcIds = listOf(7118), superiorId = 7119, teleport = Tile(2583, 9056)),
    ROYAL_MONKEY("Royal Monkey", slayerLevel = 0, npcIds = listOf(5284), superiorId = 6812, teleport = Tile(2897, 2726)),
    MONKEY_ELDER("Monkey Elder", slayerLevel = 0, npcIds = listOf(6804), superiorId = 5277, teleport = Tile(2897, 2726)),
    ELF_WARRIOR("Elf Warrior", slayerLevel = 0, npcIds = listOf(5296), superiorId = 7029, teleport = Tile(2562, 3862)),
    GRYPHON("Gryphon", slayerLevel = 0, npcIds = listOf(1490), superiorId = 5320, teleport = Tile(2516, 3859)),
    ETERNAL_WIZARD("Eternal Wizard", slayerLevel = 0, npcIds = listOf(3585), superiorId = 1604, teleport = Tile(2502, 3860)),
    HOLY_GUARD("Holy Guard", slayerLevel = 0, npcIds = listOf(3360), superiorId = 9648, teleport = Tile(2528, 3860)),
    DEVOUT_PRIEST("Devout Priest", slayerLevel = 0, npcIds = listOf(4787), superiorId = 7950, teleport = Tile(2539, 3864)),
    HOLY_ARCHER("Holy Archer", slayerLevel = 0, npcIds = listOf(3217), superiorId = 3408, teleport = Tile(2577, 3863)),
    GRAND_WIZARD("Grand Wizard", slayerLevel = 0, npcIds = listOf(1612), superiorId = 4645, teleport = Tile(2516, 3859)),
    HOLY_GNOME("Holy Gnome", slayerLevel = 0, npcIds = listOf(2560), superiorId = 9723, teleport = Tile(2539, 3864)),
    GNOME_AGENT("Gnome Agent", slayerLevel = 0, npcIds = listOf(1444), superiorId = 7953, teleport = Tile(2564, 3862)),
    HOLY_GIANT("Holy Giant", slayerLevel = 0, npcIds = listOf(7934), superiorId = 3668, teleport = Tile(2592, 3872))
}