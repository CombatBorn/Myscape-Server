package gg.rsmod.game.service.cachemodifier

enum class CustomNpcs (
    val copyNpc: Int = -1,
    val id: Int,
    val npcName: String,
    val models: Array<Int>? = null,
    val category: Int = -1,
    val size: Int = 1,
    val standAnim: Int = -1,
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
    )
}