package gg.rsmod.game.model.slayer

enum class SlayerTaskType(val order: Int) {
    EASY(order = 1),
    MEDIUM(order = 2),
    HARD(order = 3),
    BOSS(order = 4),
    CORRUPTION(order = 5),
    HEROISM(order = 6),
    WILDERNESS(order = 7)
}