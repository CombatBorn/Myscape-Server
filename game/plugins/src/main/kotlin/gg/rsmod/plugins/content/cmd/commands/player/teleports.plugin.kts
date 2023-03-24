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
 * custom npc attacks
 */
on_npc_combat(20790, Items.SAPPHIRE) {
    player.inventory.remove(Items.SAPPHIRE, 1)
    player.message("You've thrown a sapphire into the Stronghold of Security!")
}

/**
 * crab cove
 */
on_obj_option(25154, "Enter") {
    player.moveTo(Tile(2542, 9812))
    player.message("You go into the tunnel..")
}
on_obj_option(15575, "Climb") {
    player.moveTo(Tile(2922, 2724))
    player.message("You climb out of the tunnel.")
}
/**
 * giants fortress
 */
on_obj_option(3759, "Enter") {
    player.moveTo(Tile(2424, 10211))
    player.message("You go into the tunnel..")
}
on_obj_option(10434, "Climb") {
    player.moveTo(Tile(2893, 3671))
    player.message("You climb out of the cave.")
}
on_obj_option(31999, "Enter") {
    player.moveTo(Tile(2845, 10351))
    player.message("You successfully walk down the stairs.")
}
on_obj_option(33261, "Climb") {
    player.moveTo(Tile(2410, 10210))
    player.message("You successfully climb up the stairs.")
}
on_obj_option(33262, "Enter") {
    player.moveTo(Tile(3386, 9786))
    player.message("You plug your nose and go in the hole.")
}
on_obj_option(12230, "Climb") {
    player.moveTo(Tile(2855, 10334))
    player.message("You plug your nose and go up the hole.")
}
/**
 * demon lair
 */
on_obj_option(28686, "Enter") {
    player.moveTo(Tile(2787, 9308))
    player.message("You crawl through the muddy hole.")
}
on_obj_option(2804, "Enter") {
    player.moveTo(Tile(3313, 9848))
    player.message("You crawl through the muddy hole.")
}
on_obj_option(31031, "Climb-down") {
    player.moveTo(Tile(2773, 9340))
    player.animate(112)
    player.message("You make your way down the hole.")
}
on_obj_option(2903, "Walk through") {
    player.moveTo(Tile(3269, 9847))
    player.message("You make your way up the hole.")
}
on_obj_option(4147, "Enter") {
    player.moveTo(Tile(2800, 9306))
    player.message("You enter the mud hound lair.")
}
on_obj_option(2852, "Enter") {
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
                player.moveTo(Tile(3081, 3421))
            }
            1 -> {
                player.message("You've teleported to Chicken Coop Teleport.")
                player.moveTo(Tile(2853, 3374))
            }
            2 -> {
                player.message("You've teleported to Crab Cove Teleport.")
                player.moveTo(Tile(2900, 2725))
            }
            3 -> {
                player.message("You've teleported to Giants Fortress Teleport.")
                player.moveTo(Tile(2890, 3677))
            }
            4 -> {
                player.message("You've teleported to Demons Lair Teleport.")
                player.moveTo(Tile(3296, 9825))
            }
            5 -> {
                player.message("You've teleported to Dragons Den Teleport.")
                player.moveTo(Tile(2435, 9875))
            }
            6 -> {
                player.message("You've teleported to Marsh of Ghosts Teleport.")
                player.moveTo(Tile(3585, 3489))
            }
            7 -> {
                player.message("You've teleported to Krawfies Teleport.")
                player.moveTo(Tile(2860, 3479))
            }
        }
    } else if (lastClickedTeleportCategory[player.uid] == 2) {
        when (lastClickedTeleport[player.uid]) {
            0 -> {
                player.message("You've teleported to Mining Teleport.")
                player.moveTo(Tile(2867, 3341))
            }
            1 -> {
                player.message("You've teleported to Smithing Teleport.")
                player.moveTo(Tile(2867, 3341))
            }
            2 -> {
                player.message("You've teleported to Fishing Teleport.")
                player.moveTo(Tile(2867, 3341))
            }
            3 -> {
                player.message("You've teleported to Cooking Teleport.")
                player.moveTo(Tile(2867, 3341))
            }
            4 -> {
                player.message("You've teleported to Herblore Teleport.")
                player.moveTo(Tile(2867, 3341))
            }
            5 -> {
                player.message("You've teleported to Thieving Teleport.")
                player.moveTo(Tile(2867, 3341))
            }
            6 -> {
                player.message("You've teleported to Crafting Teleport.")
                player.moveTo(Tile(2867, 3341))
            }
            7 -> {
                player.message("You've teleported to Firemaking Teleport.")
                player.moveTo(Tile(2867, 3341))
            }
            8 -> {
                player.message("You've teleported to Fletching Teleport.")
                player.moveTo(Tile(2867, 3341))
            }
            9 -> {
                player.message("You've teleported to Woodcutting Teleport.")
                player.moveTo(Tile(2867, 3341))
            }
            10 -> {
                player.message("You've teleported to Runecrafting Teleport.")
                player.moveTo(Tile(2867, 3341))
            }
            11 -> {
                player.message("You've teleported to Farming Teleport.")
                player.moveTo(Tile(2867, 3341))
            }
            12 -> {
                player.message("You've teleported to Hunting Teleport.")
                player.moveTo(Tile(2867, 3341))
            }
            13 -> {
                player.message("You've teleported to Construction Teleport.")
                player.moveTo(Tile(2867, 3341))
            }
        }
    } else if (lastClickedTeleportCategory[player.uid] == 3) {
        when (lastClickedTeleport[player.uid]) {
            0 -> {
                player.message("You've teleported to Vannaka. Talk to him to get a Slayer Task!")
                player.moveTo(Tile(2867, 3341))
            }
            1 -> {
                player.message("You've teleported to Hero's Keep.")
                player.moveTo(Tile(2867, 3341))
            }
            2 -> {
                player.message("You've teleported to Corrupted Cavern.")
                player.moveTo(Tile(2867, 3341))
            }
        }
    } else if (lastClickedTeleportCategory[player.uid] == 4) {
        when (lastClickedTeleport[player.uid]) {

            0 -> {
                player.message("You've teleported to the Giant Mole boss.")
                player.moveTo(Tile(2867, 3341))
            }
            1 -> {
                player.message("You've teleported to the Daggonoths boss.")
                player.moveTo(Tile(2867, 3341))
            }
            2 -> {
                player.message("You've teleported to the King Black Dragon boss.")
                player.moveTo(Tile(2867, 3341))
            }
            3 -> {
                player.message("You've teleported to the Kalphite Queen boss.")
                player.moveTo(Tile(2867, 3341))
            }
            4 -> {
                player.message("You've teleported to the Godwars Dungeon.")
                player.moveTo(Tile(2867, 3341))
            }
            5 -> {
                player.message("You've teleported to the boss lobby for Nex.")
                player.moveTo(Tile(2867, 3341))
            }
            6 -> {
                player.message("You've teleported to the Vorkath boss.")
                player.moveTo(Tile(2867, 3341))
            }
            7 -> {
                player.message("You've teleported to the Thermonuclear Smoke Devil boss.")
                player.moveTo(Tile(2867, 3341))
            }
            8 -> {
                player.message("You've teleported to the Cave Kraken boss.")
                player.moveTo(Tile(2867, 3341))
            }
            9 -> {
                player.message("You've teleported to the Abyssal Sire boss.")
                player.moveTo(Tile(2867, 3341))
            }
            10 -> {
                player.message("You've teleported to the Cerberus boss.")
                player.moveTo(Tile(2867, 3341))
            }
            11 -> {
                player.message("You've teleported to the Corpereal Beast boss.")
                player.moveTo(Tile(2867, 3341))
            }
            12 -> {
                player.message("You've teleported to the Chaos Elemental boss.")
                player.moveTo(Tile(2867, 3341))
            }
            13 -> {
                player.message("You've teleported to the Crazy Archeologist boss.")
                player.moveTo(Tile(2867, 3341))
            }
            14 -> {
                player.message("You've teleported to the Vetian boss.")
                player.moveTo(Tile(2867, 3341))
            }
            15 -> {
                player.message("You've teleported to the Scorpia boss.")
                player.moveTo(Tile(2867, 3341))
            }
            16 -> {
                player.message("You've teleported to the Vennanatis boss.")
                player.moveTo(Tile(2867, 3341))
            }
            17 -> {
                player.message("You've teleported to the Callisto boss.")
                player.moveTo(Tile(2867, 3341))
            }
            18 -> {
                player.message("You've teleported to the Nomad's Temple.")
                player.moveTo(Tile(3363, 9648))
            }
        }
    } else if (lastClickedTeleportCategory[player.uid] == 5) {
        when (lastClickedTeleport[player.uid]) {
            0 -> {
                player.message("You've teleported to the Wilderness Ditch.")
                player.moveTo(Tile(2867, 3341))
            }
            1 -> {
                player.message("You've teleported to the East Wilderness.")
                player.moveTo(Tile(2867, 3341))
            }
            2 -> {
                player.message("You've teleported to the Mage Bank.")
                player.moveTo(Tile(2867, 3341))
            }
        }
    } else if (lastClickedTeleportCategory[player.uid] == 6) {
        when (lastClickedTeleport[player.uid]) {

            0 -> {
                player.message("You've teleported to Lumbridge.")
                player.moveTo(Tile(2867, 3341))
            }
            1 -> {
                player.message("You've teleported to Draynor.")
                player.moveTo(Tile(2867, 3341))
            }
            2 -> {
                player.message("You've teleported to Port Sarim.")
                player.moveTo(Tile(2867, 3341))
            }
            3 -> {
                player.message("You've teleported to Falador.")
                player.moveTo(Tile(2867, 3341))
            }
            4 -> {
                player.message("You've teleported to Edgeville.")
                player.moveTo(Tile(2867, 3341))
            }
            5 -> {
                player.message("You've teleported to Varrock.")
                player.moveTo(Tile(2867, 3341))
            }
            6 -> {
                player.message("You've teleported to Al Kharid.")
                player.moveTo(Tile(2867, 3341))
            }
            7 -> {
                player.message("You've teleported to Catherby.")
                player.moveTo(Tile(2867, 3341))
            }
            8 -> {
                player.message("You've teleported to Ardougne.")
                player.moveTo(Tile(2867, 3341))
            }
            9 -> {
                player.message("You've teleported to Brimhaven.")
                player.moveTo(Tile(2867, 3341))
            }
            10 -> {
                player.message("You've teleported to Yanille.")
                player.moveTo(Tile(2867, 3341))
            }
            11 -> {
                player.message("You've teleported to Gnome Stronghold.")
                player.moveTo(Tile(2867, 3341))
            }
            12 -> {
                player.message("You've teleported to Rellekka.")
                player.moveTo(Tile(2867, 3341))
            }
            13 -> {
                player.message("You've teleported to Canifis.")
                player.moveTo(Tile(2867, 3341))
            }
            14 -> {
                player.message("You've teleported to Morytania.")
                player.moveTo(Tile(2867, 3341))
            }
            15 -> {
                player.message("You've teleported to Port Phasmatys.")
                player.moveTo(Tile(2867, 3341))
            }
        }
    } else if (lastClickedTeleportCategory[player.uid] == 7) {
        when (lastClickedTeleport[player.uid]) {
            0 -> {
                player.message("You've teleported to the Party Room.")
                player.moveTo(Tile(2867, 3341))
            }
            1 -> {
                player.message("You've teleported to the Dual Arena.")
                player.moveTo(Tile(2867, 3341))
            }
            2 -> {
                player.message("You've teleported to the Well of Luck.")
                player.moveTo(Tile(2867, 3341))
            }
            3 -> {
                player.message("You've teleported to Fist of Guthix.")
                player.moveTo(Tile(2867, 3341))
            }
            4 -> {
                player.message("You've teleported to Zombie Island.")
                player.moveTo(Tile(2867, 3341))
            }
            5 -> {
                player.message("You've teleported to Castle Wars.")
                player.moveTo(Tile(2867, 3341))
            }
            6 -> {
                player.message("You've teleported to Last Man Standing.")
                player.moveTo(Tile(2867, 3341))
            }
            7 -> {
                player.message("You've teleported to the Nightmare Zone.")
                player.moveTo(Tile(2867, 3341))
            }
            8 -> {
                player.message("You've teleported to Pest Control.")
                player.moveTo(Tile(2867, 3341))
            }
            9 -> {
                player.message("You've teleported to Fight Caves.")
                player.moveTo(Tile(2444, 5169))
            }
            10 -> {
                player.message("You've teleported to Barbarian Assualt.")
                player.moveTo(Tile(2867, 3341))
            }
            11 -> {
                player.message("You've teleported to the Agility Arena.")
                player.moveTo(Tile(2867, 3341))
            }
            12 -> {
                player.message("You've teleported to the Gnome Restaurant.")
                player.moveTo(Tile(2867, 3341))
            }
            13 -> {
                player.message("You've teleported to Guardians of the Rift.")
                player.moveTo(Tile(2867, 3341))
            }
            14 -> {
                player.message("You've teleported to the Rogues Den.")
                player.moveTo(Tile(2867, 3341))
            }
            15 -> {
                player.message("You've teleported to the Sorceress Garden.")
                player.moveTo(Tile(2867, 3341))
            }
            16 -> {
                player.message("You've teleported to Tears of Guthix.")
                player.moveTo(Tile(2867, 3341))
            }
        }
    } else if (lastClickedTeleportCategory[player.uid] == 8) {
        when (lastClickedTeleport[player.uid]) {
            0 -> {
                player.message("You've teleported to the Magic Shop.")
                player.moveTo(Tile(2867, 3341))
            }
            1 -> {
                player.message("You've teleported to the Weapon Store.")
                player.moveTo(Tile(2867, 3341))
            }
            2 -> {
                player.message("You've teleported to the Skilling Supplies shop.")
                player.moveTo(Tile(2867, 3341))
            }
            3 -> {
                player.message("You've teleported to the Grand Exchange")
                player.moveTo(Tile(2867, 3341))
            }
        }
    } else if (lastClickedTeleportCategory[player.uid] == 9) {
        when (lastClickedTeleport[player.uid]) {
            0 -> {
                player.message("You've teleported to the Donation Point Shop.")
                player.moveTo(Tile(2867, 3341))
            }
            1 -> {
                player.message("You've teleported to the Sapphire Zone.")
                player.moveTo(Tile(2867, 3341))
            }
            2 -> {
                player.message("You've teleported to the Diamond Zone.")
                player.moveTo(Tile(2867, 3341))
            }
            3 -> {
                player.message("You've teleported to the Zenyte Zone.")
                player.moveTo(Tile(2867, 3341))
            }
        }
    }
}
// Teleport Information box appears
on_button(5002, 48) {
    player.message("test")
    val slot = player.getInteractingSlot()
    lastClickedTeleport[player.uid] = slot
    if (lastClickedTeleportCategory[player.uid] == 1) {
        when (slot) {
            0 -> {
                player.setComponentText(5002, 60, "This is the Stronghold of Security Teleport.")
            }
            1 -> {
                player.setComponentText(5002, 60, "This is the Chicken Coop Teleport.")
            }
            2 -> {
                player.setComponentText(5002, 60, "This is the Crab Cove. It contains Sand Crabs, Rock Crabs, and a tunnel with Gem Crabs.")
            }
            3 -> {
                player.setComponentText(5002, 60, "This is the Giants Fortress Teleport.")
            }
            4 -> {
                player.setComponentText(5002, 60, "This is the Demons Lair Teleport.")
            }
            5 -> {
                player.setComponentText(5002, 60, "This is the Dragons Den Teleport.")
            }
            6 -> {
                player.setComponentText(5002, 60, "This is the Marsh of Ghosts Teleport.")
            }
            7 -> {
                player.setComponentText(5002, 60, "This is the Krawfies Teleport.")
            }
        }
    } else if (lastClickedTeleportCategory[player.uid] == 2) {
        when (slot) {
            0 -> {
                player.setComponentText(5002, 60, "This is the Mining Teleport.")
            }
            1 -> {
                player.setComponentText(5002, 60, "This is the Smithing Teleport.")
            }
            2 -> {
                player.setComponentText(5002, 60, "This is the Fishing Teleport.")
            }
            3 -> {
                player.setComponentText(5002, 60, "This is the Cooking Teleport.")
            }
            4 -> {
                player.setComponentText(5002, 60, "This is the Herblore Teleport.")
            }
            5 -> {
                player.setComponentText(5002, 60, "This is the Thieving Teleport.")
            }
            6 -> {
                player.setComponentText(5002, 60, "This is the Crafting Teleport.")
            }
            7 -> {
                player.setComponentText(5002, 60, "This is the Firemaking Teleport.")
            }
            8 -> {
                player.setComponentText(5002, 60, "This is the Fletching Teleport.")
            }
            9 -> {
                player.setComponentText(5002, 60, "This is the Woodcutting Teleport.")
            }
            10 -> {
                player.setComponentText(5002, 60, "This is the Runecrafting Teleport.")
            }
            11 -> {
                player.setComponentText(5002, 60, "This is the Farming Teleport.")
            }
            12 -> {
                player.setComponentText(5002, 60, "This is the Hunting Teleport.")
            }
            13 -> {
                player.setComponentText(5002, 60, "This is the Construction Teleport.")
            }
        }
    } else if (lastClickedTeleportCategory[player.uid] == 3) {
        when (slot) {
            0 -> {
                player.setComponentText(5002, 60, "Speak to Vannaka to get a slayer task.")
            }
            1 -> {
                player.setComponentText(5002, 60, "This is the Smithing Teleport.")
            }
            2 -> {
                player.setComponentText(5002, 60, "This is the Fishing Teleport.")
            }
        }
    } else if (lastClickedTeleportCategory[player.uid] == 4) {
        when (slot) {
            0 -> {
                player.setComponentText(5002, 60, "This is the Mining Teleport.")
            }
            1 -> {
                player.setComponentText(5002, 60, "This is the Smithing Teleport.")
            }
            2 -> {
                player.setComponentText(5002, 60, "This is the Fishing Teleport.")
            }
            3 -> {
                player.setComponentText(5002, 60, "This is the Cooking Teleport.")
            }
            4 -> {
                player.setComponentText(5002, 60, "This is the Herblore Teleport.")
            }
            5 -> {
                player.setComponentText(5002, 60, "This is the Thieving Teleport.")
            }
            6 -> {
                player.setComponentText(5002, 60, "This is the Crafting Teleport.")
            }
            7 -> {
                player.setComponentText(5002, 60, "This is the Firemaking Teleport.")
            }
            8 -> {
                player.setComponentText(5002, 60, "This is the Fletching Teleport.")
            }
            9 -> {
                player.setComponentText(5002, 60, "This is the Woodcutting Teleport.")
            }
            10 -> {
                player.setComponentText(5002, 60, "This is the Runecrafting Teleport.")
            }
            11 -> {
                player.setComponentText(5002, 60, "This is the Farming Teleport.")
            }
            12 -> {
                player.setComponentText(5002, 60, "This is the Hunting Teleport.")
            }
            13 -> {
                player.setComponentText(5002, 60, "This is the Construction Teleport.")
            }
            14 -> {
                player.setComponentText(5002, 60, "This is the Woodcutting Teleport.")
            }
            15 -> {
                player.setComponentText(5002, 60, "This is the Runecrafting Teleport.")
            }
            16 -> {
                player.setComponentText(5002, 60, "This is the Farming Teleport.")
            }
            17 -> {
                player.setComponentText(5002, 60, "This is the Hunting Teleport.")
            }
            18 -> {
                player.setComponentText(5002, 60, "This is the Nomad's Temple Teleport.")
            }
        }
    } else if (lastClickedTeleportCategory[player.uid] == 5) {
        when (slot) {
            0 -> {
                player.setComponentText(5002, 60, "This is the Mining Teleport.")
            }
            1 -> {
                player.setComponentText(5002, 60, "This is the Smithing Teleport.")
            }
            2 -> {
                player.setComponentText(5002, 60, "This is the Fishing Teleport.")
            }
        }
    } else if (lastClickedTeleportCategory[player.uid] == 6) {
        when (slot) {
            0 -> {
                player.setComponentText(5002, 60, "This is the Mining Teleport.")
            }
            1 -> {
                player.setComponentText(5002, 60, "This is the Smithing Teleport.")
            }
            2 -> {
                player.setComponentText(5002, 60, "This is the Fishing Teleport.")
            }
            3 -> {
                player.setComponentText(5002, 60, "This is the Cooking Teleport.")
            }
            4 -> {
                player.setComponentText(5002, 60, "This is the Herblore Teleport.")
            }
            5 -> {
                player.setComponentText(5002, 60, "This is the Thieving Teleport.")
            }
            6 -> {
                player.setComponentText(5002, 60, "This is the Crafting Teleport.")
            }
            7 -> {
                player.setComponentText(5002, 60, "This is the Firemaking Teleport.")
            }
            8 -> {
                player.setComponentText(5002, 60, "This is the Fletching Teleport.")
            }
            9 -> {
                player.setComponentText(5002, 60, "This is the Woodcutting Teleport.")
            }
            10 -> {
                player.setComponentText(5002, 60, "This is the Runecrafting Teleport.")
            }
            11 -> {
                player.setComponentText(5002, 60, "This is the Farming Teleport.")
            }
            12 -> {
                player.setComponentText(5002, 60, "This is the Hunting Teleport.")
            }
            13 -> {
                player.setComponentText(5002, 60, "This is the Construction Teleport.")
            }
            14 -> {
                player.setComponentText(5002, 60, "This is the Construction Teleport.")
            }
            15 -> {
                player.setComponentText(5002, 60, "This is the Construction Teleport.")
            }
        }
    } else if (lastClickedTeleportCategory[player.uid] == 7) {
        when (slot) {
            0 -> {
                player.setComponentText(5002, 60, "This is the Mining Teleport.")
            }
            1 -> {
                player.setComponentText(5002, 60, "This is the Smithing Teleport.")
            }
            2 -> {
                player.setComponentText(5002, 60, "This is the Fishing Teleport.")
            }
            3 -> {
                player.setComponentText(5002, 60, "This is the Cooking Teleport.")
            }
            4 -> {
                player.setComponentText(5002, 60, "This is the Herblore Teleport.")
            }
            5 -> {
                player.setComponentText(5002, 60, "This is the Thieving Teleport.")
            }
            6 -> {
                player.setComponentText(5002, 60, "This is the Crafting Teleport.")
            }
            7 -> {
                player.setComponentText(5002, 60, "This is the Firemaking Teleport.")
            }
            8 -> {
                player.setComponentText(5002, 60, "This is the Fletching Teleport.")
            }
            9 -> {
                player.setComponentText(5002, 60, "This is the Woodcutting Teleport.")
            }
            10 -> {
                player.setComponentText(5002, 60, "This is the Runecrafting Teleport.")
            }
            11 -> {
                player.setComponentText(5002, 60, "This is the Farming Teleport.")
            }
            12 -> {
                player.setComponentText(5002, 60, "This is the Hunting Teleport.")
            }
            13 -> {
                player.setComponentText(5002, 60, "This is the Construction Teleport.")
            }
            14 -> {
                player.setComponentText(5002, 60, "This is the Construction Teleport.")
            }
            15 -> {
                player.setComponentText(5002, 60, "This is the Construction Teleport.")
            }
            16 -> {
                player.setComponentText(5002, 60, "This is the Construction Teleport.")
            }
        }
    } else if (lastClickedTeleportCategory[player.uid] == 8) {
        when (slot) {
            0 -> {
                player.setComponentText(5002, 60, "This is the Mining Teleport.")
            }
            1 -> {
                player.setComponentText(5002, 60, "This is the Smithing Teleport.")
            }
            2 -> {
                player.setComponentText(5002, 60, "This is the Fishing Teleport.")
            }
            3 -> {
                player.setComponentText(5002, 60, "This is the Cooking Teleport.")
            }
        }
    } else if (lastClickedTeleportCategory[player.uid] == 9) {
        when (slot) {
            0 -> {
                player.setComponentText(5002, 60, "This is the Mining Teleport.")
            }
            1 -> {
                player.setComponentText(5002, 60, "This is the Smithing Teleport.")
            }
            2 -> {
                player.setComponentText(5002, 60, "This is the Fishing Teleport.")
            }
            3 -> {
                player.setComponentText(5002, 60, "This is the Cooking Teleport.")
            }
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
    player.setInterfaceEvents(5002, 48, 0..2, InterfaceEvent.BUTTON1)
}
// Boss teleports
on_button(5002, 24) {
    lastClickedTeleportCategory[player.uid] = 4
    player.setInterfaceEvents(5002, 48, 0..18, InterfaceEvent.BUTTON1)
}
// PK teleports
on_button(5002, 26) {
    lastClickedTeleportCategory[player.uid] = 5
    player.setInterfaceEvents(5002, 48, 0..2, InterfaceEvent.BUTTON1)
}
// City teleports
on_button(5002, 28) {
    lastClickedTeleportCategory[player.uid] = 6
    player.setInterfaceEvents(5002, 48, 0..15, InterfaceEvent.BUTTON1)
}
// Minigame teleports
on_button(5002, 30) {
    lastClickedTeleportCategory[player.uid] = 7
    player.setInterfaceEvents(5002, 48, 0..16, InterfaceEvent.BUTTON1)
}
// Market teleports
on_button(5002, 32) {
    lastClickedTeleportCategory[player.uid] = 8
    player.setInterfaceEvents(5002, 48, 0..3, InterfaceEvent.BUTTON1)
}
// Donator teleports
on_button(5002, 34) {
    lastClickedTeleportCategory[player.uid] = 9
    player.setInterfaceEvents(5002, 48, 0..3, InterfaceEvent.BUTTON1)
}
