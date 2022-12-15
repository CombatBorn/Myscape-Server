package gg.rsmod.game.model.slayer

import gg.rsmod.game.fs.def.NpcDef
import gg.rsmod.game.model.Tile
import gg.rsmod.game.model.World
import java.io.File
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class SlayerDef {

    companion object {

        /**
         * Stores data for each slayer master
         * @param Int Represents the Slayer Master's ID
         *
         * @param [HashMap] Stores a list of [SlayerAssignment]s for each [SlayerTaskType]
         * the Slayer Master has.
         */
        // TODO: replace this mess with a SlayerMaster class
        val slayerMasters: HashMap<Int, HashMap<SlayerTaskType, SlayerAssignment>> = HashMap()

        /**
         * An alphabetically sorted [ArrayList] of all NPC Ids for each [SlayerTaskType]
         * This data is used for the Slayer Favorite/Block list interface (#5000).
         */
        var slayerDataMap: EnumMap<SlayerTaskType, ArrayList<Int>> = EnumMap(SlayerTaskType::class.java)

        fun load(world: World) {

            var tasks: ArrayList<SlayerMonster>
            /**
             * VANNAKA
             */
            val vannakaTasks: HashMap<SlayerTaskType, SlayerAssignment> = HashMap()

            /**
             * EASY TASKS
             */
            tasks = ArrayList()
            // chickens
            tasks.add(SlayerMonster(taskId = 0, npcIds = listOf(1173, 1174, 2804, 2805, 2806, 3316, 3661, 3662, 9488, 10494, 10495, 10496, 10497, 10498, 10499,
                10556), superiorId = 6367, tp = Tile(3234, 3295)))
            // goblins
            tasks.add(SlayerMonster(taskId = 1, npcIds = listOf(655, 656, 657, 658, 659, 660, 661, 662, 663, 664, 665, 666, 667, 668, 674, 677, 678, 2245, 2246, 2247,
                2248, 2249, 2484, 2485, 2486, 2487, 2488, 2489, 3028, 3029, 3030, 3031, 3032, 3033, 3034, 3035, 3036,
                3037, 3038, 3039, 3040, 3041, 3042, 3043, 3044, 3045, 3046, 3047, 3048, 3051, 3052, 3053, 3054, 3073,
                3074, 3075, 3076, 4902, 4903, 4904, 4905, 4906, 5152, 5153, 5154, 5192, 5193, 5195, 5196, 5197, 5198,
                5199, 5200, 5201, 5202, 5203, 5204, 5205, 5206, 5207, 5208, 5376, 5377, 5508, 5509, 10566, 10567, 11322,
                11323, 11324, 11325, 11326, 11327, 11328, 11329, 11330, 11331, 11332, 11333, 11334, 11335, 11336, 11337,
                11338, 11339, 11340, 11341, 11342, 11343, 11344, 11345, 11346, 11347, 11348, 11349, 11350, 11351, 11352,
                11353, 11354, 11355, 11356, 11357, 11358, 11359, 11360, 11361, 11362, 11363, 11364, 11365, 11366, 11367,
                11368, 11369, 11370, 11371, 11372, 11373, 11374, 11375, 11376, 11377, 11378, 11379, 11380,
                11381), superiorId = 2241, tp = Tile(3246, 3241)))
            // monkeys
            tasks.add(SlayerMonster(taskId = 2, npcIds = listOf(1038,2848), superiorId = 5271, tp = Tile(2916, 3156)))
            // rats
            tasks.add(SlayerMonster(taskId = 3, npcIds = listOf(1020, 1021, 1022, 2492, 2513, 2854, 2855, 4593, 4594, 4610, 4611,
                4612, 4613, 4614, 4615, 4616, 4617, 4618, 10682), superiorId = 2510, tp = Tile(3237, 9867)))
            // spiders
            tasks.add(SlayerMonster(taskId = 4, npcId = 2478, superiorId = 134, tp = Tile(3180, 3221)))
            // bats
            tasks.add(SlayerMonster(taskId = 5, npcId = 2827, superiorId = 2834, tp = Tile(3110, 3318)))
            // cows
            tasks.add(SlayerMonster(taskId = 6, npcIds = listOf(6401,5842,2801,2791,2792,2793,2794,2795), superiorId = 5816, tp = Tile(3257,3279)))
            //dwarves
            tasks.add(SlayerMonster(taskId = 7, npcIds = listOf(290,8496), superiorId = 291, tp = Tile(3015, 3450)))
            //minotaurs
            tasks.add(SlayerMonster(taskId = 8, npcIds = listOf(2481, 2482, 2483), superiorId = 7021, tp = Tile(1879,5217)))
            //scorpions
            tasks.add(SlayerMonster(taskId = 9, npcIds = listOf(2479, 2480, 3024, 5242), superiorId = 7022, tp = Tile(3057,9777)))
            //zombies
            tasks.add(SlayerMonster(taskId = 10, npcIds = listOf(26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51,
                52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 880, 1784, 2501, 2502, 2503, 2504,
                2505, 2506, 2507, 2508, 2509, 3980, 3981, 5507, 5568, 5571, 5574, 5583, 5647, 6449, 6450, 6451, 6452,
                6453, 6454, 6455, 6456, 6457, 6458, 6459, 6460, 6461, 6462, 6463, 6464, 6465, 6466, 6596, 6597, 6598,
                6741, 7485, 7486, 7487, 7488, 8067, 8068,
                8069), superiorId = 3359, tp = Tile(3126,9863)))
            //bears
            tasks.add(SlayerMonster(taskId = 11, npcIds = listOf(2838, 2839, 3423, 3424, 3425, 3908, 3909), superiorId = 7023, tp = Tile(3289,3351)))
            //ghosts
            tasks.add(SlayerMonster(taskId = 12, npcIds = listOf(85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 472, 473, 474, 505, 506, 507, 920, 1786,
                2527, 2528, 2529, 2530, 2531, 2532, 2533, 2534, 3008, 3009, 3516, 3617, 3625, 3975, 3976, 3977, 3978,
                3979, 5370, 7263, 7264, 9194, 10538, 10697, 10698, 10699,
                11301), superiorId = 2999, tp = Tile(2910, 9830)))
            //dogs
            tasks.add(SlayerMonster(taskId = 13, npcIds = listOf(7209, 112, 113, 114, 131), superiorId = 3999, tp = Tile(2635, 3300)))
            //kalphites
            tasks.add(SlayerMonster(taskId = 14, npcIds = listOf(138, 955, 956, 957, 958, 959, 960, 961, 962, 966), superiorId = 7032, tp = Tile(3485, 9509, 2)))
            //skeletons
            tasks.add(SlayerMonster(taskId = 15, npcIds = listOf(70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 130, 680, 681, 924, 1685, 1686, 1687, 1688, 1785,
                2520, 2521, 2522, 2523, 2524, 2525, 2526, 3358, 3565, 3584, 3972, 3973, 3974, 4491, 4492, 4493, 4494,
                4495, 4496, 4497, 4498, 4499, 5054, 5237, 6326, 6387, 6440, 6441, 6442, 6443, 6444, 6445, 6446, 6447,
                6448, 6467, 6468, 6613, 6614, 7265, 8070, 8071, 8072, 8139, 8140, 10717, 10718, 10719, 10720,
                10721), superiorId = 3358 , tp = Tile(3097, 9909)))
            //icefiends
            tasks.add(SlayerMonster(taskId = 16, npcIds = listOf(3140, 4813, 7586), superiorId = 778 , tp = Tile(3007, 3478)))
            //wolves
            tasks.add(SlayerMonster(taskId = 17, npcIds = listOf(106, 109, 110, 115, 116, 117, 231, 232, 2490, 2491, 3912, 4649, 4650, 4651, 9181, 10522, 10533), superiorId = 7620, tp = Tile(2834, 3508)))
            //crawling hands
            tasks.add(SlayerMonster(taskId = 18, npcIds = listOf(120, 448, 449, 450, 451, 452, 453, 454, 455, 456, 457), superiorId = 1077, tp = Tile(3420, 3535)))
            //cave crawlers
            tasks.add(SlayerMonster(taskId = 19, npcIds = listOf(406, 407, 408, 409), superiorId = 7389 , tp = Tile(3190, 9570)))
            //banshees
            tasks.add(SlayerMonster(taskId = 20, npcId = 414, superiorId = 7391 , tp = Tile(3440, 3543)))
            //cave slimes
            tasks.add(SlayerMonster(taskId = 21, npcId = 480, superiorId = 488, tp = Tile(3250,9575)))
            //lizards
            tasks.add(SlayerMonster(taskId = 22, npcIds = listOf(459, 460, 461, 462, 463), superiorId = 458 , tp = Tile(3320,2900)))

            // add to memory
            vannakaTasks[SlayerTaskType.EASY] = SlayerAssignment(tasks = tasks)

            /**
             * MEDIUM TASKS
             */
            tasks = ArrayList()
            // molanisks
            tasks.add(SlayerMonster(taskId = 23, npcId = 1, superiorId = 3449, tp = Tile(2713, 5225)))
            // cockatrice
            tasks.add(SlayerMonster(taskId = 24, npcIds = listOf(419, 420), superiorId = 7393, tp = Tile(2619, 10265)))
            // earth warriors
            tasks.add(SlayerMonster(taskId = 25, npcId = 2840, superiorId = 3328, tp = Tile(3121, 9991)))
            // flesh crawlers
            tasks.add(SlayerMonster(taskId = 26, npcIds = listOf(2498, 2499, 2500), superiorId = 483, tp = Tile(1991, 5237)))
            // ghouls
            tasks.add(SlayerMonster(taskId = 27, npcId = 289, superiorId = 6344, tp = Tile(3438, 3461)))
            // hill giants
            tasks.add(SlayerMonster(taskId = 28, npcIds = listOf(2098, 2099, 2100, 2101, 2102, 2103, 7261, 10374, 10375, 10376, 11195), superiorId = 7027, tp = Tile(3115, 9843)))
            // ice warriors
            tasks.add(SlayerMonster(taskId = 29, npcIds = listOf(2841, 2842, 2851), superiorId = 2085, tp = Tile(3050, 9585)))
            // killerwatts
            tasks.add(SlayerMonster(taskId = 30, npcId = 469, superiorId = 470, tp = Tile(2661, 5209, 2)))
            // waterfiends
            tasks.add(SlayerMonster(taskId = 31, npcIds = listOf(2916, 2917), superiorId = 1370, tp = Tile(1740, 5353)))
            // mogres
            tasks.add(SlayerMonster(taskId = 32, npcId = 2592, superiorId = 4817, tp = Tile(3000, 3121)))
            // ogres
            tasks.add(SlayerMonster(taskId = 33, npcIds = listOf(136, 864, 865, 1225, 2095, 2096, 2233, 4368, 4369, 4370, 4371, 4372), superiorId = 7028, tp = Tile(2505, 3115)))
            // moss giants
            tasks.add(SlayerMonster(taskId = 34, npcIds = listOf(2090, 2091, 2092, 2093, 3851, 3852, 7262), superiorId = 8736, tp = Tile(2700, 3200)))
            // crocodiles
            tasks.add(SlayerMonster(taskId = 35, npcIds = listOf(4184, 11581, 11582), superiorId = 11513, tp = Tile(3217, 3179)))
            // ice giants
            tasks.add(SlayerMonster(taskId = 36, npcIds = listOf(2085, 2086, 2087, 2088, 2089, 7878, 7879, 7880), superiorId = 882, tp = Tile(3050, 9585)))
            // green dragons
            tasks.add(SlayerMonster(taskId = 37, npcIds = listOf(260, 261, 262, 263, 264, 5194, 5872, 5873, 7868, 7869, 7870, 8073, 8076, 8081, 8082), superiorId = 2918, tp = Tile(2012, 9003, 1)))
            // werewolves
            tasks.add(SlayerMonster(taskId = 38, npcIds = listOf(2593, 2594, 2595, 2596, 2597, 2598, 2599, 2600, 2601, 2602, 2603, 2604, 2605, 2606, 2607, 2608, 2609, 2610, 2611, 2612, 3135, 3136, 5928, 9580, 9581, 9582, 9743, 9744, 9745), superiorId =1377, tp = Tile(3500, 3500)))
            // seasnakes
            tasks.add(SlayerMonster(taskId = 39, npcIds = listOf(1097, 1098), superiorId =1103, tp = Tile(2619, 10265)))
            // pyrefiends
            tasks.add(SlayerMonster(taskId = 40, npcIds = listOf(433, 434, 435, 436, 3139), superiorId = 6795, tp = Tile(2700, 10025)))
            // rockslugs
            tasks.add(SlayerMonster(taskId = 41, npcIds = listOf(421, 422), superiorId = 7392, tp = Tile(2800, 10016)))
            // shades
            tasks.add(SlayerMonster(taskId = 42, npcId = 5633, superiorId = 6740, tp = Tile(1605, 10040)))
            // vampyres
            tasks.add(SlayerMonster(taskId = 43, npcIds = listOf(3137, 3234, 3237, 3239, 3690, 3691, 3692, 3693, 3694, 3695, 3696, 3697, 3698, 3699, 3700, 3707, 3708,
                4427, 4428, 4429, 4430, 4431, 4432, 4433, 4434, 4436, 4437, 4438, 4439, 4442, 4443, 4481, 4482, 4486,
                4487, 5634, 5635, 5636, 5637, 5638, 5639, 5640, 5641, 5642, 8326, 8327, 8678, 9586, 9587, 9615, 9616,
                9617, 9683, 9684, 9727, 9728, 9729, 9730, 9731, 9732, 9733, 9734), superiorId = 6393, tp = Tile(3600, 3188)))
            // white wolves
            tasks.add(SlayerMonster(taskId = 44, npcIds = listOf(107, 108), superiorId = 9181, tp = Tile(2833, 3511)))
            // aviansies
            tasks.add(SlayerMonster(taskId = 45, npcIds = listOf(3169, 3170, 3171, 3172, 3173, 3174, 3175, 3176, 3177, 3178,
                3179, 3180, 3182, 3183), superiorId = 7037, tp = Tile(2883, 5311, 2)))
            // lizardmen
            tasks.add(SlayerMonster(taskId = 46, npcIds = listOf(6766, 6767, 6914, 6915, 6916, 6917, 6918, 6919, 7573, 7574,
                7744, 7745, 7997, 8000, 8563, 8564, 8565, 10947, 10948), tp = Tile(1330, 10085)))
            // tzhaar
            tasks.add(SlayerMonster(taskId = 47, npcIds = listOf(2154, 2155, 2156, 2157, 2158, 2159, 2160, 2161, 2162, 2163,
                2164, 2165, 2166, 2167, 2168, 2169, 2170, 2171, 2172, 2173, 2174, 2175, 2176, 2177, 2178, 2179, 7679, 7682,
                7683, 7684, 7685, 7686, 7687), superiorId = 7035, tp = Tile(2451, 5146)))
            // lesser demons
            tasks.add(SlayerMonster(taskId = 48, npcIds = listOf(2005, 2006, 2007, 2008, 2018, 3982, 7247, 7248, 7656, 7657,
                7664, 7865, 7866, 7867), superiorId = 2028, tp = Tile(2935, 9793)))
            // shadow warriors
            tasks.add(SlayerMonster(taskId = 49, npcId = 2853, superiorId = 2843, tp = Tile(2728, 9774)))
            // trolls
            tasks.add(SlayerMonster(taskId = 50, npcIds = listOf(133, 648, 649, 650, 651, 652, 653, 654, 698, 699, 700, 701, 702, 703, 704, 705, 931, 932, 933, 934, 935,
                936, 937, 938, 939, 940, 941, 942, 1874, 1875, 1876, 1877, 4120, 4121, 4122, 4123, 4124, 4125, 4126,
                4127, 4128, 4129, 4135, 4136, 4137, 4138, 4139, 4143, 4308, 4309, 4310, 4311, 4313, 4315, 5822,
                5823, 5824, 5825, 5826, 5828, 5829, 5830, 5831, 6294, 6356, 6732, 6733, 6734, 6735, 6736, 6737, 7030,
                8470, 8471, 8472, 8473), superiorId = 4130, tp = Tile(2850, 3675)))
            // blue dragons
            tasks.add(SlayerMonster(taskId = 51, npcIds = listOf(241, 242, 243, 265, 266, 267, 268, 269, 4385, 5878, 5879, 5880, 5881, 5882, 8074, 8077, 8083), superiorId = 7273, tp = Tile(2922, 9803)))
            // fire giants
            tasks.add(SlayerMonster(taskId = 52, npcIds = listOf(2075, 2076, 2077, 2078, 2079, 2080, 2081, 2082, 2083, 2084, 7251, 7252), superiorId = 3448, tp = Tile(2575, 9875)))
            // jungle horrors
            tasks.add(SlayerMonster(taskId = 53, npcIds = listOf(1042, 1043, 1044, 1045, 1046), superiorId = 1047, tp = Tile(3730, 9353)))

            // add to memory
            vannakaTasks[SlayerTaskType.MEDIUM] = SlayerAssignment(tasks = tasks)

            /**
             * HARD TASKS
             */
            tasks = ArrayList()
            // red dragons
            tasks.add(SlayerMonster(taskId = 54, npcIds = listOf(137, 244, 245, 246, 247, 248, 249, 250, 251, 8075, 8078,
                8079), superiorId = 7274, tp = Tile(2720, 9520)))
            // elves
            tasks.add(SlayerMonster(taskId = 55, npcIds = listOf(5293, 5294, 5295, 5296), superiorId = 7029, tp = Tile(2204, 3253)))
            // black dragons
            tasks.add(SlayerMonster(taskId = 56, npcIds = listOf(252, 253, 254, 255, 256, 257, 258, 259, 1871, 1872, 7861,
                7862, 7863, 7955, 8084, 8085), superiorId = 7275, tp = Tile(2720, 9520)))
            // bronze dragons
            tasks.add(SlayerMonster(taskId = 57, npcIds = listOf(270, 271, 7253), superiorId = -1, tp = Tile(2740, 9500)))
            // dagannoths
            tasks.add(SlayerMonster(taskId = 58, npcIds = listOf(140, 970, 971, 972, 973, 974, 975, 976, 977, 978, 979, 3185,
                5942, 5943, 7259, 7260), superiorId = 6361, tp = Tile(2444, 10444)))
            // hellhounds
            tasks.add(SlayerMonster(taskId = 59, npcIds = listOf(104, 105, 135, 3133, 7256, 7877), superiorId = 5054, tp = Tile(2860, 9845)))
            // black demons
            tasks.add(SlayerMonster(taskId = 60, npcIds = listOf(240, 1432, 2048, 2049, 2050, 2051, 2052, 5874, 5875, 5876,
                5877, 6357, 7242, 7243, 7874, 7875, 7876), superiorId = 1609, tp = Tile(2860, 9777)))
            // iron dragons
            tasks.add(SlayerMonster(taskId = 61, npcIds = listOf(272, 273, 7254, 8080), superiorId = -1, tp = Tile(2711, 9465)))
            // steel dragons
            tasks.add(SlayerMonster(taskId = 62, npcIds = listOf(139, 274, 275, 7255, 8086), superiorId = -1, tp = Tile(2700, 9435)))
            // harpie bug swarms
            tasks.add(SlayerMonster(taskId = 63, npcId = 464, superiorId = 6273, tp = Tile(2867, 3111)))
            // basilisks
            tasks.add(SlayerMonster(taskId = 64, npcIds = listOf(122, 417, 418, 9283, 9284, 9285, 9286), superiorId = 9287, tp = Tile(2742, 10010)))
            // fever spiders
            tasks.add(SlayerMonster(taskId = 65, npcId = 626, superiorId = 1607, tp = Tile(2147, 5098)))
            // infernal mages
            tasks.add(SlayerMonster(taskId = 66, npcIds = listOf(443, 444, 445, 446, 447), superiorId = 7396, tp = Tile(3440, 3568)))
            // brine rats
            tasks.add(SlayerMonster(taskId = 67, npcId = 4501, superiorId = 9040, tp = Tile(2707, 10160)))
            // bloodveld
            tasks.add(SlayerMonster(taskId = 68, npcIds = listOf(484, 485, 486, 487, 3138), superiorId = 7398, tp = Tile(3416, 3571)))
            // mithril dragons
            tasks.add(SlayerMonster(taskId = 69, npcIds = listOf(2919, 8088, 8089), superiorId = -1, tp = Tile(2703, 10028)))
            // zygomites
            tasks.add(SlayerMonster(taskId = 70, npcIds = listOf(537, 1024), superiorId = 7797, tp = Tile(2720, 10008)))
            // aberrant spectres
            tasks.add(SlayerMonster(taskId = 71, npcIds = listOf(2, 3, 4, 5, 6, 7), superiorId = 7402, tp = Tile(1767, 5341, 1)))
            // wyrms
            tasks.add(SlayerMonster(taskId = 72, npcIds = listOf(8610), superiorId = 10399, tp = Tile(2420, 4430)))
            // spiritual creatures
            tasks.add(SlayerMonster(taskId = 73, npcIds = listOf(2210, 2211, 2212, 2242, 2243, 2244, 3159, 3160, 3161, 3166, 3167, 3168, 11290, 11291, 11292), superiorId = 2955, tp = Tile(3417, 3544)))
            // dust devils
            tasks.add(SlayerMonster(taskId = 74, npcIds = listOf(423, 7249, 11238, 423), superiorId = 7404, tp = Tile(1264, 10158)))
            // fossil wyverns
            tasks.add(SlayerMonster(taskId = 75, npcIds = listOf(7792, 7793, 7794, 7795), superiorId = 2641, tp = Tile(3611, 10275)))
            // kurasks
            tasks.add(SlayerMonster(taskId = 76, npcIds = listOf(123, 410, 411), superiorId = 7405, tp = Tile(2701, 9997)))
            // skeletal wyverns
            tasks.add(SlayerMonster(taskId = 77, npcIds = listOf(465, 466, 467, 468), superiorId = 3577, tp = Tile(3050, 9555)))
            // gargoyles
            tasks.add(SlayerMonster(taskId = 78, npcIds = listOf(412, 413, 1543), superiorId = 7407, tp = Tile(3435, 3540, 2)))
            // nechryaels
            tasks.add(SlayerMonster(taskId = 79, npcIds = listOf(8, 11), superiorId = 7411, tp = Tile(3443, 3558, 2)))
            // adamant dragons
            tasks.add(SlayerMonster(taskId = 80, npcIds = listOf(8030, 8090), superiorId = -1, tp = Tile(3568, 4005)))
            // dark beasts
            tasks.add(SlayerMonster(taskId = 81, npcIds = listOf(4005, 7250), superiorId = 7409, tp = Tile(2471, 6144)))
            // drakes
            tasks.add(SlayerMonster(taskId = 82, npcIds = listOf(8612, 8613), superiorId = 10400, tp = Tile(1264, 10158)))
            // rune dragons
            tasks.add(SlayerMonster(taskId = 83, npcIds = listOf(8027, 8031, 8091), superiorId = -1, tp = Tile(3568, 4005)))
            // suqahs
            tasks.add(SlayerMonster(taskId = 84, npcIds = listOf(787, 788, 789, 790, 791, 792, 793), superiorId = 6588, tp = Tile(2133, 3869)))
            // aby demons
            tasks.add(SlayerMonster(taskId = 85, npcIds = listOf(124, 415, 416, 7241, 11239), superiorId = 7410, tp = Tile(3418, 3570, 2)))

            // add to memory
            vannakaTasks[SlayerTaskType.HARD] = SlayerAssignment(tasks = tasks)

            /**
             * BOSS TASKS
             */
            tasks = ArrayList()
            // jad
            tasks.add(SlayerMonster(taskId = 86, npcId = 6506, tp = Tile(2440, 5171)))
            // kbd
            tasks.add(SlayerMonster(taskId = 87, npcId = 239, tp = Tile(2271, 4684)))
            // corp
            tasks.add(SlayerMonster(taskId = 88, npcId = 319, tp = Tile(2968, 4384)))
            // mole
            tasks.add(SlayerMonster(taskId = 89, npcId = 5779, tp = Tile(1760, 5194)))
            // dag kings
            tasks.add(SlayerMonster(taskId = 90, npcIds = listOf(6496, 6497, 6498), tp = Tile(2419, 4455)))
            // Kalphite queen
            tasks.add(SlayerMonster(taskId = 91, npcId = 6501, tp = Tile(3509, 9496)))
            // commander zilyana
            tasks.add(SlayerMonster(taskId = 92, npcId = 2205, tp = Tile(2882, 5310, 2)))
            // general graardor
            tasks.add(SlayerMonster(taskId = 93, npcId = 2215, tp = Tile(2882, 5310, 2)))
            // kree'arra
            tasks.add(SlayerMonster(taskId = 94, npcId = 3162, tp = Tile(2882, 5310, 2)))
            // k'ril tsutsaroth
            tasks.add(SlayerMonster(taskId = 95, npcId = 6495, tp = Tile(2882, 5310, 2)))
            // zulrah
            tasks.add(SlayerMonster(taskId = 96, npcId = 2042, tp = Tile(2200, 3056)))
            // vorkath
            tasks.add(SlayerMonster(taskId = 97, npcId = 8026, superiorId = 8178, tp = Tile(2276, 4037)))
            // aby sire
            tasks.add(SlayerMonster(taskId = 98, npcId = 5890, tp = Tile(3039, 4787)))
            // cave kraken
            tasks.add(SlayerMonster(taskId = 99, npcId = 494, tp = Tile(2283, 10015)))
            // cerberus
            tasks.add(SlayerMonster(taskId = 100, npcId = 5862, tp = Tile(1304, 1293)))
            // thermonuclear smoke devil lair
            tasks.add(SlayerMonster(taskId = 101, npcId = 499, tp = Tile(2400, 9440)))

            // add to memory
            vannakaTasks[SlayerTaskType.BOSS] = SlayerAssignment(tasks = tasks)
            slayerMasters[403] = vannakaTasks

            /**
             * KRYSTILIA
             */
//            lateinit var krystiliaTasks: HashMap<SlayerTaskTypes, SlayerAssignment>

            /**
             * WILDY TASKS
             */
//        monsters = arrayListOf(
//            SlayerMonster(taskId = 0, npcIds = 1, tp = Tile(0,0)),
//            SlayerMonster(taskId = 0, npcIds = 6, minAssigned = 20, weight = 10, tp = Tile(0,0))
//        )
//        krystiliaTasks[SlayerTaskTypes.WILDERNESS] = SlayerAssignment(monsters = monsters)

            // add to memory
//        slayerMasters[7663] = krystiliaTasks

            /**
             * Rat Man
             */
            val ratmanTasks: HashMap<SlayerTaskType, SlayerAssignment> = HashMap()

            /**
             * HEROISM TASKS
             */
            tasks = ArrayList()
            // rats
            tasks.add(SlayerMonster(taskId = 102, npcIds = listOf(1020, 1021, 1022, 2492, 2513, 2854, 2855, 4593, 4594, 4610, 4611, 4612, 4613, 4614, 4615, 4616, 4617, 4618,
                10682), superiorId = 2510, tp = Tile(3422, 4977)))
            // spiders
            tasks.add(SlayerMonster(taskId = 103, npcId = 2478, superiorId = 134, tp = Tile(3414, 4966)))
            // sewer crabs
            tasks.add(SlayerMonster(taskId = 104, npcIds = listOf(8297, 8298), superiorId = 7576, tp = Tile(3402, 4973)))
            // mutated lobsters
            tasks.add(SlayerMonster(taskId = 105, npcId = 4800, superiorId = 7796, tp = Tile(3433, 4959)))
            // sewer demons
            tasks.add(SlayerMonster(taskId = 106, npcIds = listOf(8604, 8606, 8607), superiorId = 9614, tp = Tile(3407, 4942)))
            // sewer snakes
            tasks.add(SlayerMonster(taskId = 107, npcId = 7594, superiorId = 9560, tp = Tile(3439, 4937)))
            // sewer giant
            tasks.add(SlayerMonster(taskId = 108, npcId = 7101, superiorId = 5129, tp = Tile(3443, 4973)))
            // sewer dogs
            tasks.add(SlayerMonster(taskId = 109, npcId = 6336, superiorId = 9612, tp = Tile(3444, 4949)))


            // add to memory
            ratmanTasks[SlayerTaskType.HEROISM] = SlayerAssignment(tasks = tasks)
            slayerMasters[3578] = ratmanTasks
            /**
             * Islander
             */
            val islanderTasks: HashMap<SlayerTaskType, SlayerAssignment> = HashMap()

            /**
             * HEROISM TASKS
             */
            tasks = ArrayList()
            // goblins/goblin miners/goblin mage/range goblin king, melee goblin king, mage goblin king
            // goblins
            tasks.add(SlayerMonster(taskId = 110, npcIds = listOf(655, 656, 657, 658, 659, 660, 661, 662, 663, 664, 665, 666, 667, 668, 674, 677, 678, 2245, 2246, 2247,
                2248, 2249, 2484, 2485, 2486, 2487, 2488, 2489, 3028, 3029, 3030, 3031, 3032, 3033, 3034, 3035, 3036,
                3037, 3038, 3039, 3040, 3041, 3042, 3043, 3044, 3045, 3046, 3047, 3048, 3051, 3052, 3053, 3054, 3073,
                3074, 3075, 3076, 4902, 4903, 4904, 4905, 4906, 5152, 5153, 5154, 5192, 5193, 5195, 5196, 5197, 5198,
                5199, 5200, 5201, 5202, 5203, 5204, 5205, 5206, 5207, 5208, 5376, 5377, 5508, 5509, 10566, 10567, 11322,
                11323, 11324, 11325, 11326, 11327, 11328, 11329, 11330, 11331, 11332, 11333, 11334, 11335, 11336, 11337,
                11338, 11339, 11340, 11341, 11342, 11343, 11344, 11345, 11346, 11347, 11348, 11349, 11350, 11351, 11352,
                11353, 11354, 11355, 11356, 11357, 11358, 11359, 11360, 11361, 11362, 11363, 11364, 11365, 11366, 11367,
                11368, 11369, 11370, 11371, 11372, 11373, 11374, 11375, 11376, 11377, 11378, 11379, 11380,
                11381), superiorId = 2241, tp = Tile(2848, 3244)))
            // witchdoctors
            tasks.add(SlayerMonster(taskId = 111, npcIds = listOf(6409, 6410, 6411, 6412, 6413), superiorId = 6406, tp = Tile(2843, 3297)))
            // pirates/drunk pirates
            tasks.add(SlayerMonster(taskId = 112, npcIds = listOf(6993, 6995, 7412, 6994), superiorId = 1053, tp = Tile(2855, 3277)))
            // imps
            tasks.add(SlayerMonster(taskId = 113, npcIds = listOf(3134, 5007, 5728), superiorId = 3355, tp = Tile(2819, 3292)))
            // ghost warriors
            tasks.add(SlayerMonster(taskId = 114, npcId = 922, superiorId = 625, tp = Tile(2450, 10260)))
            //bears
            tasks.add(SlayerMonster(taskId = 115, npcIds = listOf(2838, 2839, 3423, 3424, 3425, 3908, 3909), superiorId = 7023, tp = Tile(2836, 3279)))
            //minotaurs
            tasks.add(SlayerMonster(taskId = 116, npcIds = listOf(2481, 2482, 2483), superiorId = 7021, tp = Tile(2829, 9639)))
            // barbarian spirits
            tasks.add(SlayerMonster(taskId = 117, npcId = 5564, superiorId = 1540, tp = Tile(2842, 9638)))
            // barbarians
            tasks.add(SlayerMonster(taskId = 118, npcIds = listOf(3055, 3056, 3057, 3058, 3059, 3060, 3061, 3062, 3064, 3065, 3066, 3067, 3068, 3069, 3070, 3071, 3072,
                3256, 3262, 10676, 10677, 10678, 10679, 10984, 10985, 10986, 10987, 10988), superiorId = 1661, tp = Tile(2836, 3278)))
            // dark wizards
            tasks.add(SlayerMonster(taskId = 119, npcIds = listOf(510, 512, 2056, 2057, 2058, 2059, 5086, 5087, 5088, 5089, 6779, 7064, 7065), superiorId = 1783, tp = Tile(2829, 9639)))
            // crawling hands
            tasks.add(SlayerMonster(taskId = 120, npcIds = listOf(120, 448, 449, 450, 451, 452, 453, 454, 455, 456, 457), superiorId = 1077, tp = Tile(2825, 9606)))
            // banshees
            tasks.add(SlayerMonster(taskId = 121, npcId = 414, superiorId = 7391 , tp = Tile(2858, 9605)))
            // scorpians
            tasks.add(SlayerMonster(taskId = 122, npcIds = listOf(2479, 2480, 3024, 5242), superiorId = 7022, tp = Tile(2836, 9606)))
            // wolves
            tasks.add(SlayerMonster(taskId = 123, npcIds = listOf(106, 109, 110, 115, 116, 117, 231, 232, 2490, 2491, 3912, 4649, 4650, 4651, 9181, 10522, 10533), superiorId = 7620, tp = Tile(2834, 3508)))
            // cave spirits
            tasks.add(SlayerMonster(taskId = 124, npcId = 6359, superiorId = 1362, tp = Tile(2827, 9591)))
            // ghosts
            tasks.add(SlayerMonster(taskId = 125, npcIds = listOf(85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 472, 473, 474, 505, 506, 507, 920, 1786,
                2527, 2528, 2529, 2530, 2531, 2532, 2533, 2534, 3008, 3009, 3516, 3617, 3625, 3975, 3976, 3977, 3978,
                3979, 5370, 7263, 7264, 9194, 10538, 10697, 10698, 10699,
                11301), superiorId = 2999, tp = Tile(2826, 9541)))
            // ghouls
            tasks.add(SlayerMonster(taskId = 126, npcId = 289, superiorId = 6344, tp = Tile(2859, 9573)))
            // ghasts
            tasks.add(SlayerMonster(taskId = 127, npcId = 946, superiorId = 7936, tp = Tile(2822, 9565)))
            // dragon spawns
            tasks.add(SlayerMonster(taskId = 128, npcId = 1873, superiorId = 7955, tp = Tile(2838, 9557)))
            //  moss giants
            tasks.add(SlayerMonster(taskId = 129, npcIds = listOf(2090, 2091, 2092, 2093, 3851, 3852, 7262), superiorId = 8736, tp = Tile(2871, 9589)))
            // zygomites
            tasks.add(SlayerMonster(taskId = 130, npcIds = listOf(537, 1024), superiorId = 7797, tp = Tile(2870, 9557)))

            // add to memory
            islanderTasks[SlayerTaskType.HEROISM] = SlayerAssignment(tasks = tasks)
            slayerMasters[7483] = islanderTasks

            /**
             * Dwarven Chief
             */
            val dwarvenTasks: HashMap<SlayerTaskType, SlayerAssignment> = HashMap()

            /**
             * HEROISM TASKS
             */
            tasks = ArrayList()
            // rock crabs
            tasks.add(SlayerMonster(taskId = 131, npcIds = listOf(100, 102), superiorId = 2261, tp = Tile(3667, 3876)))
            // snow mites
            tasks.add(SlayerMonster(taskId = 132, npcId = 1782, superiorId = 1257, tp = Tile(3710, 3843)))
            // ice bats
            tasks.add(SlayerMonster(taskId = 133, npcId = 1039, superiorId = 1722, tp = Tile(3756, 3841)))
            // dark warriors
            tasks.add(SlayerMonster(taskId = 134, npcId = 6606, superiorId = 910, tp = Tile(3694, 3842)))
            // black knight
            tasks.add(SlayerMonster(taskId = 135, npcIds = listOf(516, 517, 1545, 4067, 4331, 4934, 4959, 4960), superiorId = 6360, tp = Tile(3747, 3869)))
            // ice spirits
            tasks.add(SlayerMonster(taskId = 136, npcId = 3458, superiorId = 4922, tp = Tile(3705, 3883)))
            // wolves
            tasks.add(SlayerMonster(taskId = 137, npcIds = listOf(107, 108), superiorId = 9181, tp = Tile(3680, 3865)))
            // ice palidans
//        monsters.add(SlayerMonster(taskId = 0, npcIds = it, superiorId = 808, tp = Tile(3707, 3858)))
            // frozen archers
            tasks.add(SlayerMonster(taskId = 138, npcId = 6222, superiorId = 401, tp = Tile(3685, 3879)))
            // ice fiends
            tasks.add(SlayerMonster(taskId = 139, npcIds = listOf(3140, 4813, 7586), superiorId = 778 , tp = Tile(3706, 3895)))
            // jellies
            tasks.add(SlayerMonster(taskId = 140, npcIds = listOf(437, 438, 439, 440, 441, 442, 7518, 11241, 11242, 11243, 11244, 11245), superiorId = 7400, tp = Tile(3014, 4365)))
            // poison spiders
            tasks.add(SlayerMonster(taskId = 141, npcIds = listOf(3023, 5373), superiorId = 3016, tp = Tile(3012, 4405)))
            // brine rats
            tasks.add(SlayerMonster(taskId = 142, npcId = 4501, superiorId = 9040, tp = Tile(3026, 4396)))
            // skeleton fremineks
            tasks.add(SlayerMonster(taskId = 143, npcIds = listOf(4491, 4492, 4493, 4494, 4495, 4496, 4497, 4498, 4499), superiorId = 9458, tp = Tile(3029, 4358)))
            // trolls
            tasks.add(SlayerMonster(taskId = 144, npcIds = listOf(133, 648, 649, 650, 651, 652, 653, 654, 698, 699, 700, 701, 702, 703, 704, 705, 931, 932, 933, 934, 935,
                936, 937, 938, 939, 940, 941, 942, 1874, 1875, 1876, 1877, 4120, 4121, 4122, 4123, 4124, 4125, 4126,
                4127, 4128, 4129, 4135, 4136, 4137, 4138, 4139, 4143, 4308, 4309, 4310, 4311, 4313, 4315, 5822,
                5823, 5824, 5825, 5826, 5828, 5829, 5830, 5831, 6294, 6356, 6732, 6733, 6734, 6735, 6736, 6737, 7030,
                8470, 8471, 8472, 8473), superiorId = 4130, tp = Tile(3039, 4397)))
            // ice warriors
            tasks.add(SlayerMonster(taskId = 145, npcIds = listOf(2841, 2842, 2851), superiorId = 2085, tp = Tile(3039, 4382)))

            // add to memory
            dwarvenTasks[SlayerTaskType.HEROISM] = SlayerAssignment(tasks = tasks)
            slayerMasters[2989] = dwarvenTasks
            /**
             * Kharidian King
             */
            val kharidTasks: HashMap<SlayerTaskType, SlayerAssignment> = HashMap()

            /**
             * HEROISM TASKS
             */
            tasks = ArrayList()
            // harpie bugs
            tasks.add(SlayerMonster(taskId = 146, npcId = 464, superiorId = 6273, tp = Tile(3233, 9330)))
            // sand crabs
            tasks.add(SlayerMonster(taskId = 147, npcId = 5935, superiorId = 7266, tp = Tile(3211, 9292)))
            // cave golems
            tasks.add(SlayerMonster(taskId = 148, npcId = 5136, superiorId = 1366, tp = Tile(3208, 9312)))
            // cave crawlers
            tasks.add(SlayerMonster(taskId = 149, npcIds = listOf(406, 407, 408, 409), superiorId = 7389 , tp = Tile(3222, 9292)))
            // rockslugs
            tasks.add(SlayerMonster(taskId = 150, npcIds = listOf(421, 422), superiorId = 7392, tp = Tile(3243, 9295)))
            // flesh crawlers
            tasks.add(SlayerMonster(taskId = 151, npcIds = listOf(2498, 2499, 2500), superiorId = 483, tp = Tile(3251, 9334)))
            // basilisks
            tasks.add(SlayerMonster(taskId = 152, npcIds = listOf(122, 417, 418, 9283, 9284, 9285, 9286), superiorId = 9287, tp = Tile(3254, 9296)))
            // sand snakes
            tasks.add(SlayerMonster(taskId = 153, npcId = 7802, superiorId = 7903, tp = Tile(3262, 9285)))
            // lizards/lizard wizards/lizard warriors, lizard shamans
            tasks.add(SlayerMonster(taskId = 154, npcIds = listOf(459, 460, 461, 462, 463, 2831, 4198, 6766, 6767, 6914, 6915, 6916, 6917, 6918, 6919, 7573, 7574, 7744, 7745, 7997, 8000, 8563, 8564, 8565,
                10947, 10948), superiorId = 8709 , tp = Tile(2450, 10260)))
            // pyrefiends
            tasks.add(SlayerMonster(taskId = 155, npcIds = listOf(433, 434, 435, 436, 3139), superiorId = 6795, tp = Tile(3249, 9314)))
            // orks/ork warrior/ork mage
            tasks.add(SlayerMonster(taskId = 156, npcIds = listOf(3832), superiorId = 1606, tp = Tile(3216, 9352)))
            // jogres
            tasks.add(SlayerMonster(taskId = 157, npcIds = listOf(2094), superiorId = 3356, tp = Tile(3225, 9366)))
            // fire giants
            tasks.add(SlayerMonster(taskId = 158, npcIds = listOf(2075, 2076, 2077, 2078, 2079, 2080, 2081, 2082, 2083, 2084, 7251, 7252), superiorId = 3448, tp = Tile(3246, 9350)))
            // kurasks
            tasks.add(SlayerMonster(taskId = 159, npcIds = listOf(123, 410, 411), superiorId = 7405, tp = Tile(3224, 9389)))
            // kalphites
            tasks.add(SlayerMonster(taskId = 160, npcIds = listOf(138, 955, 956, 957, 958, 959, 960, 961, 962, 966), superiorId = 797, tp = Tile(3259, 9400)))
            // tzarrs
            tasks.add(SlayerMonster(taskId = 161, npcIds = listOf(2154, 2155, 2156, 2157, 2158, 2159, 2160, 2161, 2162, 2163, 2164,
                2165, 2166, 2167, 2168, 2169, 2170, 2171, 2172, 2173, 2174, 2175, 2176, 2177, 2178, 2179, 7679, 7682, 7683,
                7684, 7685, 7686, 7687), superiorId = 7035, tp = Tile(3244, 9363)))

            // add to memory
            kharidTasks[SlayerTaskType.HEROISM] = SlayerAssignment(tasks = tasks)
            slayerMasters[3844] = kharidTasks

            /**
             * Angelic Nieve
             */
            val nieveTasks: HashMap<SlayerTaskType, SlayerAssignment> = HashMap()

            /**
             * HEROISM TASKS
             */
            tasks = ArrayList()
            // wyrms
            tasks.add(SlayerMonster(taskId = 162, npcIds = listOf(8610), superiorId = 10399, tp = Tile(2682, 9842)))
            // mummy
            tasks.add(SlayerMonster(taskId = 163, npcIds = listOf(717, 718, 719, 720, 721, 722, 723, 724, 725, 726, 727, 728, 949, 950,
                951, 952, 953, 5506, 7658, 7659, 7660, 7661, 7662), superiorId = 4199, tp = Tile(3756, 3750)))
            // vyrewatches
            tasks.add(SlayerMonster(taskId = 164, npcIds = listOf(3709, 3710, 3711, 3712, 3713, 3714, 3715, 3716, 3717, 3718, 3719,
                3720, 3721, 3722, 3723, 3724, 3725, 3726, 3727, 3728, 3729, 3730, 3731, 3732, 3748, 3749, 3750, 3751, 3752,
                3753, 3754, 3755, 3756, 3757, 3758, 3759, 3760, 3761, 3762, 3763, 3768, 3769, 3770, 3771, 8251, 8252, 8253,
                8254, 8255, 8256, 8257, 8258, 8259, 8300, 8301, 8302, 8303, 8304, 8305, 8306, 8307, 9590, 9591, 9599, 9600,
                9601, 9602, 9603, 9604, 9605, 9606, 9607, 9608, 9735, 9736, 9737, 9738, 9739, 9740, 9741, 9742, 9756, 9757,
                9758, 9759, 9760, 9761, 9762, 9763, 11169, 11170, 11171, 11172, 11173),
                superiorId = 686, tp = Tile(3799, 3824)))
            // demonic gorillas
            tasks.add(SlayerMonster(taskId = 165, npcIds = listOf(7144, 7145, 7146, 7147, 7148, 7149, 7152), tp = Tile(1329, 10185)))
            // nechryaels
            tasks.add(SlayerMonster(taskId = 166, npcIds = listOf(8, 11), superiorId = 7411, tp = Tile(1325, 10267)))
            // terror cats
            tasks.add(SlayerMonster(taskId = 167, npcId = 8130, superiorId = 6473, tp = Tile(1315, 10207)))
            // drakes
            tasks.add(SlayerMonster(taskId = 168, npcIds = listOf(8612, 8613), superiorId = 10400, tp = Tile(2675, 9806)))
            // cerberus
            tasks.add(SlayerMonster(taskId = 169, npcId = 5862, tp = Tile(3756, 3737)))
            // aby demons
            tasks.add(SlayerMonster(taskId = 170, npcIds = listOf(124, 415, 416, 7241, 11239), superiorId = 7410, tp = Tile(1315, 10204)))
            // kraken
            tasks.add(SlayerMonster(taskId = 171, npcId = 494, superiorId = 4315, tp = Tile(3745, 3779)))
            // abysal sire
            tasks.add(SlayerMonster(taskId = 172, npcId = 5890, tp = Tile(3039, 4787)))
            // river trolls
            tasks.add(SlayerMonster(taskId = 173, npcId = 6735, superiorId = 4314, tp = Tile(3734, 3790)))
            // shades
            tasks.add(SlayerMonster(taskId = 174, npcId = 5633, superiorId = 6740, tp = Tile(3753, 3765)))
            // jungle horrors
            tasks.add(SlayerMonster(taskId = 175, npcIds = listOf(1042, 1043, 1044, 1045, 1046), superiorId = 1047, tp = Tile(3767, 3785)))
            // dag kings
            tasks.add(SlayerMonster(taskId = 176, npcIds = listOf(6496, 6497, 6498), tp = Tile(3825, 3759)))
            // bloodvelds
            tasks.add(SlayerMonster(taskId = 177, npcIds = listOf(484, 485, 486, 487, 3138), superiorId = 7398, tp = Tile(1289, 10284)))
            // hellhounds
            tasks.add(SlayerMonster(taskId = 178, npcIds = listOf(104, 105, 135, 3133, 7256, 7877), superiorId = 5054, tp = Tile(1342, 10239)))
            // turoths
            tasks.add(SlayerMonster(taskId = 179, npcIds = listOf(426, 427, 428, 429, 430, 431, 432), superiorId = 10397, tp = Tile(1309, 10261)))
            // deviant spectres
            tasks.add(SlayerMonster(taskId = 180, npcId = 7279, superiorId = 7403, tp = Tile(1320, 10282)))
            // aviansies
            tasks.add(SlayerMonster(taskId = 181, npcIds = listOf(3169, 3170, 3171, 3172, 3173, 3174, 3175, 3176, 3177, 3178, 3179, 3180, 3182, 3183), superiorId = 7037, tp = Tile(3750, 3793)))
            // zammy warriors
            tasks.add(SlayerMonster(taskId = 182, npcIds = listOf(7418, 7419), superiorId = 7422, tp = Tile(3818, 3809)))
            // lesser demons
            tasks.add(SlayerMonster(taskId = 183, npcIds = listOf(2005, 2006, 2007, 2008, 2018, 3982, 7247, 7248, 7656, 7657, 7664, 7865, 7866, 7867), superiorId = 2028, tp = Tile(1264, 10196)))
            // black demons
            tasks.add(SlayerMonster(taskId = 184, npcIds = listOf(240, 1432, 2048, 2049, 2050, 2051, 2052, 5874, 5875, 5876, 5877, 6357, 7242, 7243, 7874, 7875, 7876), superiorId = 1609, tp = Tile(1264, 10221)))
            // skeletal wyverns
            tasks.add(SlayerMonster(taskId = 185, npcIds = listOf(465, 466, 467, 468), superiorId = 3577, tp = Tile(3820, 3786)))
            // dust devils
            tasks.add(SlayerMonster(taskId = 186, npcIds = listOf(423, 7249, 11238, 423), superiorId = 7404, tp = Tile(3765, 3742)))
            // ankous
            tasks.add(SlayerMonster(taskId = 187, npcIds = listOf(2514, 2515, 2516, 2517, 2519, 6608, 7257, 7864), superiorId = 7296, tp = Tile(3789, 3762)))
            // smoke devils
            tasks.add(SlayerMonster(taskId = 188, npcIds = listOf(498, 6639, 6655, 8482, 8483), superiorId = 7406, tp = Tile(3793, 3780)))
            // dark beasts
            tasks.add(SlayerMonster(taskId = 189, npcIds = listOf(4005, 7250), superiorId = 7409, tp = Tile(3820, 3774)))
            // chronozones
            tasks.add(SlayerMonster(taskId = 190, npcId = 4987, superiorId = 7036, tp = Tile(1237, 10206)))
            // green dragon/blue dragon/red dragon/black dragon
            tasks.add(SlayerMonster(taskId = 191, npcIds = listOf(260, 261, 262, 263, 264, 5194, 5872, 5873, 7868, 7869, 7870, 8073, 8076, 8081, 8082, 241, 242, 243, 265,
                266, 267, 268, 269, 4385, 5878, 5879, 5880, 5881, 5882, 8074, 8077, 8083, 137, 244, 245, 246, 247, 248,
                249, 250, 251, 8075, 8078, 8079, 252, 253, 254, 255, 256, 257, 258, 259, 1871, 1872, 7861, 7862, 7863,
                7955, 8084, 8085), tp = Tile(2662, 9808)))
            // bronze dragon, iron dragon, steel dragon, mithril dragon, adamant dragon, rune dragon
            tasks.add(SlayerMonster(taskId = 192, npcIds = listOf(270, 271, 7253, 272, 273, 7254, 8080, 139, 274, 275, 7255, 8086, 2919, 8088, 8089, 8030, 8090, 8027,
                8031, 8091), tp = Tile(2631, 9862)))
            // hydras
            tasks.add(SlayerMonster(taskId = 193, npcId = 8609, superiorId = 10402, tp = Tile(2643, 9908)))
            // alch hydra
            tasks.add(SlayerMonster(taskId = 194, npcId = 8622, tp = Tile(1352, 10257)))
            // vorkath
            tasks.add(SlayerMonster(taskId = 195, npcId = 8026, superiorId = 8178, tp = Tile(2704, 9843)))
            // lava dragons
            tasks.add(SlayerMonster(taskId = 196, npcId = 6593, tp = Tile(2638, 9814)))
            // soul dragons
            tasks.add(SlayerMonster(taskId = 197, npcId = 7039, tp = Tile(2704, 9843)))

            // add to memory
            nieveTasks[SlayerTaskType.HEROISM] = SlayerAssignment(tasks = tasks)
            slayerMasters[3995] = nieveTasks
            /**
             * Evil Man
             */
            val evilManTasks: HashMap<SlayerTaskType, SlayerAssignment> = HashMap()

            /**
             * CORRUPTION TASKS
             */
            tasks = ArrayList()
            // men, woman, drunk man, drunk woman, teachers
            tasks.add(SlayerMonster(taskId = 198, npcIds = listOf(385, 1118, 1119, 1130, 1131, 1138, 1139, 1140, 1141, 1142, 3014, 3015, 3106, 3107, 3108, 3109, 3110,
                3111, 3112, 3113, 3263, 3264, 3265, 3268, 3298, 3299, 3652, 4243, 4268, 4269, 4270, 4271, 4272, 6776, 6815,
                6818, 6987, 6988, 6989, 6990, 6991, 6992, 7281, 7919, 7920, 7921, 7922, 8858, 8859, 8860, 8861, 8862,
                8863, 8864, 10672, 10673, 10674, 10728, 10945, 11032, 11053, 11054, 11057,
                11058), superiorId = 3263, tp = Tile(2320, 3806)))
            // guards/jail guards
            tasks.add(SlayerMonster(taskId = 199, npcIds = listOf(300, 4276, 4277, 4279), superiorId = 1028, tp = Tile(2320, 3806)))
            // priests
            tasks.add(SlayerMonster(taskId = 200, npcIds = listOf(1159, 923, 1167, 1171), superiorId = 2812, tp = Tile(2344, 3805)))
            // sharpshooters
            tasks.add(SlayerMonster(taskId = 201, npcId = 1576, superiorId = 1502, tp = Tile(2322, 3832)))
            // wizards
            tasks.add(SlayerMonster(taskId = 202, npcId = 3257, superiorId = 3529, tp = Tile(2360, 3831)))
            // chefs
            tasks.add(SlayerMonster(taskId = 203, npcIds = listOf(4626, 3858), superiorId = 1945, tp = Tile(2359, 3805)))
            // woodcutters
            tasks.add(SlayerMonster(taskId = 204, npcIds = listOf(3296, 3653), superiorId = 7239, tp = Tile(2343, 3820)))
            // fishermen
            tasks.add(SlayerMonster(taskId = 205, npcIds = listOf(3934, 4065), superiorId = 5075, tp = Tile(2363, 3828)))
            // afflicted
            tasks.add(SlayerMonster(taskId = 206, npcIds = listOf(1293, 1294, 4469, 4470), superiorId = 1567, tp = Tile(2351, 3819)))
            // plague fighters
            tasks.add(SlayerMonster(taskId = 207, npcId = 8771, superiorId = 1147, tp = Tile(2353, 3810)))

            // add to memory
            evilManTasks[SlayerTaskType.CORRUPTION] = SlayerAssignment(tasks = tasks)
            slayerMasters[3541] = evilManTasks
            /**
             * Evil Pirate
             */
            val evilPirateTasks: HashMap<SlayerTaskType, SlayerAssignment> = HashMap()

            /**
             * CORRUPTION TASKS
             */
            tasks = ArrayList()
            // dogs
            tasks.add(SlayerMonster(taskId = 208, npcIds = listOf(7209, 112, 113, 114, 131), superiorId = 3999, tp = Tile(3662, 3800)))
            // master farmers
            tasks.add(SlayerMonster(taskId = 209, npcIds = listOf(5730, 5731, 732, 5958), superiorId = 3672, tp = Tile(3662, 3783)))
            // forester
            tasks.add(SlayerMonster(taskId = 210, npcIds = listOf(1157, 372), superiorId = 2995, tp = Tile(3645, 3794)))
            // nature monk
            tasks.add(SlayerMonster(taskId = 211, npcId = 895, superiorId = 944, tp = Tile(3689, 3751)))
            // explorer
            tasks.add(SlayerMonster(taskId = 212, npcId = 827, superiorId = 1340, tp = Tile(3669, 3807)))
            // bee keepers
            tasks.add(SlayerMonster(taskId = 213, npcId = 3225, superiorId = 1818, tp = Tile(3664, 3791)))
            // sailers/ ship captains
            tasks.add(SlayerMonster(taskId = 214, npcId = 3644, superiorId = 5070, tp = Tile(3686, 3790)))
            // market guards/ range market guards
            tasks.add(SlayerMonster(taskId = 215, npcIds = listOf(2120, 3949, 5732), superiorId = 4569, tp = Tile(3677, 3764)))
            // druidic mage
            tasks.add(SlayerMonster(taskId = 216, npcId = 3580, superiorId = 3472, tp = Tile(3687, 3755)))
            // chief warrior
            tasks.add(SlayerMonster(taskId = 217, npcId = 3896, superiorId = 8126, tp = Tile(3665, 3766)))
            // archer soldiers
            tasks.add(SlayerMonster(taskId = 218, npcId = 6067, superiorId = 8129, tp = Tile(3670, 3752, 1)))
            // master rangers
            tasks.add(SlayerMonster(taskId = 219, npcId = 7559, superiorId = 8128, tp = Tile(3683, 3743, 1)))

            // add to memory
            evilPirateTasks[SlayerTaskType.CORRUPTION] = SlayerAssignment(tasks = tasks)
            slayerMasters[5840] = evilPirateTasks
            /**
             * Evil Wizard
             */
            val evilwizardTasks: HashMap<SlayerTaskType, SlayerAssignment> = HashMap()

            /**
             * CORRUPTION TASKS
             */
            tasks = ArrayList()
            // desert locals
            tasks.add(SlayerMonster(taskId = 220, npcId = 5231, superiorId = 8532, tp = Tile(3242, 2796)))
            // desert guard
            tasks.add(SlayerMonster(taskId = 221, npcId = 6699, superiorId = 7956, tp = Tile(3257, 2786)))
            // desert bandit
            tasks.add(SlayerMonster(taskId = 222, npcIds = listOf(690, 691, 692, 693, 694, 695), superiorId = 5960, tp = Tile(3214, 2799)))
            // desert druid
            tasks.add(SlayerMonster(taskId = 223, npcId = 8166, superiorId = 8724, tp = Tile(3217, 2764)))
            // desert assasins
            tasks.add(SlayerMonster(taskId = 224, npcId = 7379, superiorId = 786, tp = Tile(3265, 2768)))
            // bronze knight/iron knight
            tasks.add(SlayerMonster(taskId = 225, npcId = 2450, superiorId = 2451, tp = Tile(3229, 2784)))
            // steel knight/black knight
            tasks.add(SlayerMonster(taskId = 226, npcId = 2452, superiorId = 2453, tp = Tile(3229, 2784)))
            // mithril knight/adamant knight
            tasks.add(SlayerMonster(taskId = 227, npcId = 2454, superiorId = 2455, tp = Tile(3229, 2784)))
            // rune knight/dragon warrior
            tasks.add(SlayerMonster(taskId = 228, npcId = 2456, superiorId = 8538, tp = Tile(3229, 2784)))
            // gnome/ gnome archer/ magic gnome/terror gnome/turtle gnome
            tasks.add(SlayerMonster(taskId = 229, npcIds = listOf(4909, 7157, 7158, 2067, 2068, 5971, 5972, 5973), superiorId = 4912, tp = Tile(2530, 3164)))

            // add to memory
            evilwizardTasks[SlayerTaskType.CORRUPTION] = SlayerAssignment(tasks = tasks)
            slayerMasters[3515] = evilwizardTasks
            /**
             * Evil Gnome
             */
            val evilgnomeTasks: HashMap<SlayerTaskType, SlayerAssignment> = HashMap()

            /**
             * CORRUPTION TASKS
             */
            tasks = ArrayList()
            // gorilla guards
            tasks.add(SlayerMonster(taskId = 230, npcId = 5275, superiorId = 1466, tp = Tile(2897, 2726)))
            // monky archers
            tasks.add(SlayerMonster(taskId = 231, npcId = 5272, superiorId = 5267, tp = Tile(2897, 2726)))
            // ninja monkeys
            tasks.add(SlayerMonster(taskId = 232, npcId = 10369, superiorId = 6804, tp = Tile(2897, 2726)))
            // skeletal monkeys
            tasks.add(SlayerMonster(taskId = 233, npcId = 5237, superiorId = 1468, tp = Tile(2764, 9103)))
            // monkey preists
            tasks.add(SlayerMonster(taskId = 234, npcId = 5256, superiorId = 5254, tp = Tile(2897, 2726)))
            // maniacle monkeys
            tasks.add(SlayerMonster(taskId = 235, npcId = 7118, superiorId = 7119, tp = Tile(2583, 9056)))
            // royal monkeys
            tasks.add(SlayerMonster(taskId = 236, npcId = 5284, superiorId = 6812, tp = Tile(2897, 2726)))
            // monkey elders
            tasks.add(SlayerMonster(taskId = 237, npcId = 6804, superiorId = 5277, tp = Tile(2897, 2726)))

            // add to memory
            evilgnomeTasks[SlayerTaskType.CORRUPTION] = SlayerAssignment(tasks = tasks)
            slayerMasters[6025] = evilgnomeTasks

            /**
             * Evil Steve
             */
            val evilsteveTasks: HashMap<SlayerTaskType, SlayerAssignment> = HashMap()

            /**
             * CORRUPTION TASKS
             */
            tasks = ArrayList()
            // elven archers/ elven warriors
            tasks.add(SlayerMonster(taskId = 238, npcId = 5296, superiorId = 7029, tp = Tile(2562, 3862)))
            // gryphons
            tasks.add(SlayerMonster(taskId = 239, npcId = 1490, superiorId = 5320, tp = Tile(2516, 3859)))
            // eternal wizards
            tasks.add(SlayerMonster(taskId = 240, npcId = 3585, superiorId = 1604, tp = Tile(2502, 3860)))
            // holy guards
            tasks.add(SlayerMonster(taskId = 241, npcId = 3360, superiorId = 9648, tp = Tile(2528, 3860)))
            // devout priests
            tasks.add(SlayerMonster(taskId = 242, npcId = 4787, superiorId = 7950, tp = Tile(2539, 3864)))
            // holy archers
            tasks.add(SlayerMonster(taskId = 243, npcId = 3217, superiorId = 3408, tp = Tile(2577, 3863)))
            // grand wizards
            tasks.add(SlayerMonster(taskId = 244, npcId = 1612, superiorId = 4645, tp = Tile(2516, 3859)))
            // holy gnomes
            tasks.add(SlayerMonster(taskId = 245, npcId = 2560, superiorId = 9723, tp = Tile(2539, 3864)))
            // gnome agents
            tasks.add(SlayerMonster(taskId = 246, npcId = 1444, superiorId = 7953, tp = Tile(2564, 3862)))
            // holy giants
            tasks.add(SlayerMonster(taskId = 247, npcId = 7934, superiorId = 3668, tp = Tile(2592, 3872)))
            // spiritual creatures
            tasks.add(SlayerMonster(taskId = 248, npcIds = listOf(2210, 2211, 2212, 2242, 2243, 2244, 3159, 3160, 3161, 3166, 3167, 3168, 11290, 11291,
                11292), superiorId = 2955, tp = Tile(2502, 3860)))

            // add to memory
            evilsteveTasks[SlayerTaskType.CORRUPTION] = SlayerAssignment(tasks = tasks)
            slayerMasters[2460] = evilsteveTasks

            loadSlayerDataMap(world)
        }

        /**
         * Loads [slayerDataMap] which stores an alphabetically sorted list of NPC Ids for each
         * [SlayerTaskType] This data is used for the Slayer Favorite/Block list interface (#5000).
         */
        private fun loadSlayerDataMap(world: World) {
            val map: EnumMap<SlayerTaskType, ArrayList<Int>> = EnumMap(SlayerTaskType::class.java)
            for (masterId in slayerMasters.keys) {
                for (taskType in slayerMasters[masterId]?.keys!!) {
                    if (map[taskType] == null) {
                        map[taskType] = ArrayList()
                    }
                    val npcs = slayerMasters[masterId]?.get(taskType)
                    for (task in npcs!!.tasks) {
                        var firstNpc = ""
                        if (task.npcIds == null) {
                            println("SlayerDef ERROR: Task ID #${task.taskId} doesn't have any NPCs within the task!")
                            continue
                        }
                        for (npc in task.npcIds!!) {
                            firstNpc = world.definitions.get(NpcDef::class.java, npc).name
                            if (firstNpc != ""){
                                map[taskType]!!.add(npc)
                                break
                            }
                        }
                        if (firstNpc == "") {
                            println("SlayerDef ERROR: Task ID #${task.taskId} didn't have any NPCs with a name!")
                        }
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