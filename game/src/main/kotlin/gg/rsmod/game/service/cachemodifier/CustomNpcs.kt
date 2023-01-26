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
    val chatHeadModels: Array<Int>? = null,
    val examine: String? = null) {

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
        recolors = arrayListOf(Pair(6938, 21676), Pair(7958, 21672), Pair(7068, 22827), Pair(9096, 31119), Pair(6080, 22832), Pair(0, 0))
    ),
    AIR_GIANT(
        copyNpc = 2085,
        id = 11464,
        npcName = "Air Giant",
        recolors = arrayListOf(Pair(21619, 16499), Pair(32461, 27767), Pair(32448, 27767), Pair(32308, 27767), Pair(32424, 27767), Pair(14144, 27767), Pair(156, 27767), Pair(16067, 27767), Pair(32585, 27767), Pair(32537, 27767), Pair(32308, 27767), Pair(32448, 27767), Pair(32461, 27767), Pair(32424, 27767), Pair(898, 27767))
    )

}