package gg.rsmod.plugins.content.items.spade

val BARROWS_AREA = Tile(3565, 3289)
val DHAROK_MOUND = Tile(3575, 3298, 0)
val GUTHAN_MOUND = Tile(3577, 3282, 0)
val KARIL_MOUND = Tile(3566, 3275, 0)
val TORAG_MOUND = Tile(3553, 3282, 0)
val VERAC_MOUND = Tile(3557, 3297, 0)
val AHRIM_MOUND = Tile(3565, 3288, 0)
val DHAROK_CRYPT = Tile(3556, 9718, 3)
val GUTHAN_CRYPT = Tile(3534, 9704, 3)
val KARIL_CRYPT = Tile(3546, 9684, 3)
val TORAG_CRYPT = Tile(3568, 9683, 3)
val VERAC_CRYPT = Tile(3578, 9706, 3)
val AHRIM_CRYPT = Tile(3557, 9703, 3)

on_item_option(item = Items.SPADE, "dig") {
    player.animate(830)
    // player is in barrows area
    if (player.tile.getDistance(BARROWS_AREA) <= 20) {
        if (DHAROK_MOUND.getDistance(player.tile) <= 3) {
            player.moveTo(DHAROK_CRYPT)
        } else if (GUTHAN_MOUND.getDistance(player.tile) <= 3) {
            player.moveTo(GUTHAN_CRYPT)
        } else if (KARIL_MOUND.getDistance(player.tile) <= 3) {
            player.moveTo(KARIL_CRYPT)
        } else if (TORAG_MOUND.getDistance(player.tile) <= 3) {
            player.moveTo(TORAG_CRYPT)
        } else if (VERAC_MOUND.getDistance(player.tile) <= 3) {
            player.moveTo(VERAC_CRYPT)
        } else if (AHRIM_MOUND.getDistance(player.tile) <= 3) {
            player.moveTo(AHRIM_CRYPT)
        }
    } else player.message("Nothing interesting happens.")
}