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

/**
 * crab cove
 */
on_obj_option(25154, "Enter"){
    player.moveTo(Tile(2542, 9812))
    player.message("You go into the tunnel..")
}
on_obj_option(15575, "Climb"){
    player.moveTo(Tile(2922, 2724))
    player.message("You climb out of the tunnel.")
}
/**
 * giants fortress
 */
on_obj_option(3759, "Enter"){
    player.moveTo(Tile(2424, 10211))
    player.message("You go into the tunnel..")
}
on_obj_option(10434, "Climb"){
    player.moveTo(Tile(2893, 3671))
    player.message("You climb out of the cave.")
}
on_obj_option(31999, "Enter"){
    player.moveTo(Tile(2845, 10351))
    player.message("You successfully walk down the stairs.")
}
on_obj_option(33261, "Climb"){
    player.moveTo(Tile(2410, 10210))
            player.message("You successfully climb up the stairs.")
}
on_obj_option(33262, "Enter"){
    player.moveTo(Tile(3386, 9786))
            player.message("You plug your nose and go in the hole.")
}
on_obj_option(12230, "Climb"){
    player.moveTo(Tile(2855, 10334))
            player.message("You plug your nose and go up the hole.")
}
/**
 * demon lair
 */
on_obj_option(28686, "Enter"){
    player.moveTo(Tile(2787, 9308))
    player.message("You crawl through the muddy hole.")
}
on_obj_option(2804, "Enter"){
    player.moveTo(Tile(3313, 9848))
    player.message("You crawl through the muddy hole.")
}
on_obj_option(31031, "Climb-down"){
    player.moveTo(Tile(2773, 9340))
    player.animate(112)
    player.message("You make your way down the hole.")
}
on_obj_option(2903, "Walk through"){
    player.moveTo(Tile(3269, 9847))
    player.message("You make your way up the hole.")
}
on_obj_option(4147, "Enter"){
    player.moveTo(Tile(2800, 9306))
    player.message("You enter the mud hound lair.")
}
on_obj_option(2852, "Enter"){
    player.moveTo(Tile(2790, 9319))
    player.message("You enter the lava demon lair.")
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
            1 -> { player.message("You've teleported to Chicken Coop Teleport.")
                player.moveTo(Tile(2853, 3374))
            }
            2 -> { player.message("You've teleported to Crab Cove Teleport.")
                player.moveTo(Tile(2900, 2725))
            }
            3 -> { player.message("You've teleported to Giants Fortress Teleport.")
                player.moveTo(Tile(2890, 3677))
            }
            4 -> { player.message("You've teleported to Demons Lair Teleport.")
                player.moveTo(Tile(3296, 9825))
            }
            5 -> { player.message("You've teleported to Dragons Den Teleport.")
                player.moveTo(Tile(2435, 9875))
            }
            6 -> { player.message("You've teleported to Marsh of Ghosts Teleport.")
                player.moveTo(Tile(3585, 3489))
            }
            7 -> { player.message("You've teleported to Krawfies Teleport.")
                player.moveTo(Tile(2860, 3479))
            }
        }
    } else if (lastClickedTeleportCategory[player.uid] == 2) {
        when (lastClickedTeleport[player.uid]) {
            0 -> { player.message( "You've teleported to Mining Teleport.")
                player.moveTo(Tile(3081,3421))
            }
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
            2 -> { player.setComponentText(5002, 60, "This is the Crab Cove. It contains Sand Crabs, Rock Crabs, and a tunnel with Gem Crabs.") }
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
    } else if (lastClickedTeleportCategory[player.uid] == 3) {
        when (slot) {
            0 -> { player.setComponentText(5002, 60, "This is the Mining Teleport.") }
            1 -> { player.setComponentText(5002, 60, "This is the Smithing Teleport.") }
            2 -> { player.setComponentText(5002, 60, "This is the Fishing Teleport.") }
        }
    } else if (lastClickedTeleportCategory[player.uid] == 4) {
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
            14 -> { player.setComponentText(5002, 60, "This is the Woodcutting Teleport.") }
            15 -> { player.setComponentText(5002, 60, "This is the Runecrafting Teleport.") }
            16 -> { player.setComponentText(5002, 60, "This is the Farming Teleport.") }
            17 -> { player.setComponentText(5002, 60, "This is the Hunting Teleport.") }
            18 -> { player.setComponentText(5002, 60, "This is the Construction Teleport.") }
        }
    } else if (lastClickedTeleportCategory[player.uid] == 5) {
        when (slot) {
            0 -> { player.setComponentText(5002, 60, "This is the Mining Teleport.") }
            1 -> { player.setComponentText(5002, 60, "This is the Smithing Teleport.") }
            2 -> { player.setComponentText(5002, 60, "This is the Fishing Teleport.") }
        }
    } else if (lastClickedTeleportCategory[player.uid] == 6) {
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
            14 -> { player.setComponentText(5002, 60, "This is the Construction Teleport.") }
            15 -> { player.setComponentText(5002, 60, "This is the Construction Teleport.") }
        }
    } else if (lastClickedTeleportCategory[player.uid] == 7) {
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
            14 -> { player.setComponentText(5002, 60, "This is the Construction Teleport.") }
            15 -> { player.setComponentText(5002, 60, "This is the Construction Teleport.") }
            16 -> { player.setComponentText(5002, 60, "This is the Construction Teleport.") }
        }
    } else if (lastClickedTeleportCategory[player.uid] == 8) {
        when (slot) {
            0 -> { player.setComponentText(5002, 60, "This is the Mining Teleport.") }
            1 -> { player.setComponentText(5002, 60, "This is the Smithing Teleport.") }
            2 -> { player.setComponentText(5002, 60, "This is the Fishing Teleport.") }
            3 -> { player.setComponentText(5002, 60, "This is the Cooking Teleport.") }
        }
    } else if (lastClickedTeleportCategory[player.uid] == 9) {
        when (slot) {
            0 -> { player.setComponentText(5002, 60, "This is the Mining Teleport.") }
            1 -> { player.setComponentText(5002, 60, "This is the Smithing Teleport.") }
            2 -> { player.setComponentText(5002, 60, "This is the Fishing Teleport.") }
            3 -> { player.setComponentText(5002, 60, "This is the Cooking Teleport.") }
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