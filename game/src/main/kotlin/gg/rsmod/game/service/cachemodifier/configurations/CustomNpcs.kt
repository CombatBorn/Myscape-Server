package gg.rsmod.game.service.cachemodifier.configurations

/**
 * Custom NPCs must be in a sequence. IDs can't skip numbers.
 */
enum class CustomNpcs (
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
    val length: Int = -1,
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

    WHITE_DEMON1(id = 11463,
        models = arrayOf(17375, 17391, 17384, 17399, 17390),
        npcName = "White Demon1",
        size = 2,
        standAnim = 66,
        walkAnim = 63,
        category = 275,
        options = arrayOf("", "Attack"),
        isMinimapVisible = true, combatLevel = 243,
        widthScale = 86,
        heightScale = 86,
        render = false,
        interactable = true,
        pet = false,
        recolors = arrayListOf(Pair(910, 910), Pair(912, 910), Pair(1938, 910), Pair(1814, 910), Pair(1690, 910), Pair(0, 910))
    )

}