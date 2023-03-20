val lastClickedTeleportCategory: HashMap<PlayerUID, Int> = HashMap()
val lastClickedTeleport: HashMap<PlayerUID, Int> = HashMap()

on_command("teleporter", description = "Opens the teleport interface.") {
    player.openInterface(5002, InterfaceDestination.MAIN_SCREEN)
    player.runClientScript(30016, 1)
    player.setInterfaceEvents(5002, 48, 0..7, InterfaceEvent.BUTTON1)
    lastClickedTeleportCategory[player.uid] = 1
}

/**
 * Example code for brother to reference
 */
on_item_on_obj(20790, Items.SAPPHIRE) {
    player.inventory.remove(Items.SAPPHIRE, 1)
    player.message("You've thrown a sapphire into the Stronghold of Security!")
}

// Teleport to last selected teleport
on_button(5002, 62) {
    if (!lastClickedTeleport.containsKey(player.uid)) {
        player.message("You must select a teleport first.")
        return@on_button
    }

    if (lastClickedTeleportCategory[player.uid] == 1) {
        when (lastClickedTeleport[player.uid]) {
            0 -> {
                player.message("You've teleported to Stronghold of Security Teleport.")
                player.moveTo(Tile(3081,3421))
            }
            1 -> { player.message("You've teleported to Chicken Coop Teleport.") }
            2 -> { player.message("You've teleported to Crab Cove Teleport.") }
            3 -> { player.message("You've teleported to Giants Fortress Teleport.") }
            4 -> { player.message("You've teleported to Demons Lair Teleport.") }
            5 -> { player.message("You've teleported to Dragons Den Teleport.") }
            6 -> { player.message("You've teleported to Marsh of Ghosts Teleport.") }
            7 -> { player.message("You've teleported to Krawfies Teleport.") }
        }
    } else if (lastClickedTeleportCategory[player.uid] == 2) {
        when (lastClickedTeleport[player.uid]) {
            0 -> { player.message( "You've teleported to Mining Teleport.") }
            1 -> { player.message( "You've teleported to Smithing Teleport.") }
            2 -> { player.message( "You've teleported to Fishing Teleport.") }
            3 -> { player.message( "You've teleported to Cooking Teleport.") }
            4 -> { player.message( "You've teleported to Herblore Teleport.") }
            5 -> { player.message( "You've teleported to Thieving Teleport.") }
            6 -> { player.message( "You've teleported to Crafting Teleport.") }
            7 -> { player.message( "You've teleported to Firemaking Teleport.") }
            8 -> { player.message( "You've teleported to Fletching Teleport.") }
            9 -> { player.message( "You've teleported to Woodcutting Teleport.") }
            10 -> { player.message( "You've teleported to Runecrafting Teleport.") }
            11 -> { player.message( "You've teleported to Farming Teleport.") }
            12 -> { player.message( "You've teleported to Hunting Teleport.") }
            13 -> { player.message( "You've teleported to Construction Teleport.") }
        }
    }
}

// Teleport Information box appears
on_button(5002, 48) {
    val slot = player.getInteractingSlot()
    lastClickedTeleport[player.uid] = slot
    if (lastClickedTeleportCategory[player.uid] == 1) {
        when (slot) {
            0 -> { player.setComponentText(5002, 60, "This is the Stronghold of Security Teleport.") }
            1 -> { player.setComponentText(5002, 60, "This is the Chicken Coop Teleport.") }
            2 -> { player.setComponentText(5002, 60, "This is the Crab Cove Teleport.") }
            3 -> { player.setComponentText(5002, 60, "This is the Giants Fortress Teleport.") }
            4 -> { player.setComponentText(5002, 60, "This is the Demons Lair Teleport.") }
            5 -> { player.setComponentText(5002, 60, "This is the Dragons Den Teleport.") }
            6 -> { player.setComponentText(5002, 60, "This is the Marsh of Ghosts Teleport.") }
            7 -> { player.setComponentText(5002, 60, "This is the Krawfies Teleport.") }
        }
    } else if (lastClickedTeleportCategory[player.uid] == 2) {
        when (slot) {
            0 -> { player.setComponentText(5002, 60, "This is the Mining Teleport.") }
            1 -> { player.setComponentText(5002, 60, "This is the Smithing Teleport.") }
            2 -> { player.setComponentText(5002, 60, "This is the Fishing Teleport.") }
            3 -> { player.setComponentText(5002, 60, "This is the Cooking Teleport.") }
            4 -> { player.setComponentText(5002, 60, "This is the Herblore Teleport.") }
            5 -> { player.setComponentText(5002, 60, "This is the Thieving Teleport.") }
            6 -> { player.setComponentText(5002, 60, "This is the Crafting Teleport.") }
            7 -> { player.setComponentText(5002, 60, "This is the Firemaking Teleport.") }
            8 -> { player.setComponentText(5002, 60, "This is the Fletching Teleport.") }
            9 -> { player.setComponentText(5002, 60, "This is the Woodcutting Teleport.") }
            10 -> { player.setComponentText(5002, 60, "This is the Runecrafting Teleport.") }
            11 -> { player.setComponentText(5002, 60, "This is the Farming Teleport.") }
            12 -> { player.setComponentText(5002, 60, "This is the Hunting Teleport.") }
            13 -> { player.setComponentText(5002, 60, "This is the Construction Teleport.") }
        }
    }
}

// Monster teleports
on_button(5002, 18) {
    lastClickedTeleportCategory[player.uid] = 1
    player.setInterfaceEvents(5002, 48, 0..7, InterfaceEvent.BUTTON1)
}
// Skills teleports
on_button(5002, 20) {
    lastClickedTeleportCategory[player.uid] = 2
    player.setInterfaceEvents(5002, 48, 0..13, InterfaceEvent.BUTTON1)
}
// Slayer teleports
on_button(5002, 22) {
    lastClickedTeleportCategory[player.uid] = 3
}
// Boss teleports
on_button(5002, 24) {
    lastClickedTeleportCategory[player.uid] = 4
}
// PK teleports
on_button(5002, 26) {
    lastClickedTeleportCategory[player.uid] = 5
}
// City teleports
on_button(5002, 28) {
    lastClickedTeleportCategory[player.uid] = 6
}
// Minigame teleports
on_button(5002, 30) {
    lastClickedTeleportCategory[player.uid] = 7
}
// Market teleports
on_button(5002, 32) {
    lastClickedTeleportCategory[player.uid] = 8
}
// Donator teleports
on_button(5002, 34) {
    lastClickedTeleportCategory[player.uid] = 9
}