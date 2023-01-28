package gg.rsmod.game.service.cachemodifier

enum class CustomNpcs (
    val copyNpc: Int = -1,
    val id: Int,
    val npcName: String,
    val models: Array<Int>? = null,
    val category: Int = -1,
    val size: Int = -1,
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
        recolors = arrayListOf(Pair(21619, 33719), Pair(32461, 34743), Pair(32448, 36791), Pair(32308, 37815), Pair(32424, 39863), Pair(14144, 33719), Pair(156, 40887), Pair(16067, 33719), Pair(32585, 35767), Pair(32537, 41911), Pair(32308, 37815), Pair(32448, 36791), Pair(32461, 34743), Pair(32424, 39863), Pair(898, 43959))
    ),
    ICE_DRAGON(
        copyNpc = 260,
        id = 11465,
        npcName = "Ice Dragon",
        recolors = arrayListOf(Pair(1938, 41911), Pair(910, 42935), Pair(912, 42935), Pair(1814, 40887), Pair(0, 43957), Pair(809, 39863), Pair(5198, 34743), Pair(5206, 33719), Pair(2469, 38839), Pair(2588, 39863), Pair(5219, 33719), Pair(5214, 33719), Pair(27417, 41911))
    )

}