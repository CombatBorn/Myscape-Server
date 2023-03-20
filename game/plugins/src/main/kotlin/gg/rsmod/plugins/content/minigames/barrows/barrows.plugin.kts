package gg.rsmod.plugins.content.minigames.barrows

val DHAROK_MOUND = Tile(3575, 3298, 0)
val GUTHAN_MOUND = Tile(3577, 3282, 0)
val KARIL_MOUND = Tile(3566, 3275, 0)
val TORAG_MOUND = Tile(3553, 3282, 0)
val VERAC_MOUND = Tile(3557, 3297, 0)
val AHRIM_MOUND = Tile(3565, 3288, 0)
val DHAROK_SARCOPHAGUS = 1
val GUTHAN_SARCOPHAGUS = 1
val KARIL_SARCOPHAGUS = 1
val TORAG_SARCOPHAGUS = 1
val VERAC_SARCOPHAGUS = 1
val AHRIM_SARCOPHAGUS = 1
val DHAROK_STAIRS = 1
val GUTHAN_STAIRS = 1
val KARIL_STAIRS = 1
val TORAG_STAIRS = 1
val VERAC_STAIRS = 1
val AHRIM_STAIRS = 1

on_obj_option(DHAROK_SARCOPHAGUS, "Search") {
    player.openBarrowsSarcophagus(Npcs.DHAROK_THE_WRETCHED)
}
//on_obj_option(DHAROK_STAIRS, "Climb-up") {
//    player.moveTo(DHAROK_MOUND)
//}

fun Player.openBarrowsSarcophagus(id: Int) {
    if (brothersKilled.contains(id)) {
        message("The sarcophagus is empty.")
    } else if (brothersKilled.size < 5) {
        message("A barrows brother rises from the sarcophagus.")
    } else {
        message("Would you like to climb into the crypt?")
    }
}