package gg.rsmod.game.model.slayer

enum class SlayerTaskType(val order: Int) {
    EASY(order = 1),
    MEDIUM(order = 2),
    HARD(order = 3),
    BOSS(order = 4),
    WILDERNESS(order = 5),
    CORRUPTION(order = 6),
    HEROISM(order = 7)
}