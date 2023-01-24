package gg.rsmod.game.service.cachemodifier

enum class CustomNpcs (
    val id: Int,
    val npcName: String,
    val models: List<Int>,
    val options: List<String>? = null,
    val headIconPrayer: Int = -1,
    val widthScale: Int = -1,
    val heightScale: Int = -1,
    val ambient: Int = -1,
    val contrast: Int = -1,
    val rotation: Int = -1,
    val size: Int = -1,
    val combatLevel: Int = -1,
    val walkAnim: Int = -1,
    val standAnim: Int = -1,
    val rotateLeftAnim: Int = -1,
    val rotateRightAnim: Int = -1,
    val drawDotOnMap: Boolean = true,
    val isVisible: Boolean = true,
    val isInteractable: Boolean = true,
    val isFollower: Boolean = false) {

        MOLANISK(id = 11463, npcName = "Molanisk", models = listOf(23855), options = listOf("Attack"), combatLevel = 51)

}