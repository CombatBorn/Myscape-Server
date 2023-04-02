import gg.rsmod.game.action.NpcDeathAction.death

spawn_npc(Npcs.MINER, 2848, 3341, 0, 0)


on_npc_option(Npcs.MINER, "Talk-to") {
    player.queue {
        chatNpc("Would you like to take a trip in the minecart? This will cost 50,000 coins, and it's a bumpy ride.",
            Npcs.MINER)
        when (options("west varrock mine", "east varrock mine", "al kharid mine", "falador mine")) {
            1 -> {
                if (player.inventory.getItemCount(Items.COINS_995) >= 50000) {
                    player.message("You pay the toll.")
                    player.inventory.remove(Items.COINS_995, 50000)
                    player.moveTo(3178, 3369, 0)
                    chatPlayer("Thanks!", animation = 588)
                } else {
                    player.message("You don't have enough coins.")
                    chatPlayer("Sorry i forgot my money!", animation = 588)
                }
            }
            2 -> {
                if (player.inventory.getItemCount(Items.COINS_995) >= 50000) {
                    player.message("You pay the toll.")
                    player.inventory.remove(Items.COINS_995, 50000)
                    player.moveTo(3178, 3369, 0)
                    chatPlayer("Thanks!", animation = 588)
                } else {
                    player.message("You don't have enough coins.")
                    chatPlayer("Sorry i forgot my money!", animation = 588)
                }
            }
            3 -> {
                if (player.inventory.getItemCount(Items.COINS_995) >= 50000) {
                    player.message("You pay the toll.")
                    player.inventory.remove(Items.COINS_995, 50000)
                    player.moveTo(3178, 3369, 0)
                    chatPlayer("Thanks!", animation = 588)
                } else {
                    player.message("You don't have enough coins.")
                    chatPlayer("Sorry i forgot my money!", animation = 588)
                }
            }
            4 -> {
                if (player.inventory.getItemCount(Items.COINS_995) >= 50000) {
                    player.message("You pay the toll.")
                    player.inventory.remove(Items.COINS_995, 50000)
                    player.moveTo(3178, 3369, 0)
                    chatPlayer("Thanks!", animation = 588)
                } else {
                    player.message("You don't have enough coins.")
                    chatPlayer("Sorry i forgot my money!", animation = 588)
                }
            }
        }
    }
}

/**
 * Npc dialog that gives the player a fishing net and pufferfish
 */
on_npc_option(Npcs.KLARENSE, "Talk-to") {
    player.queue {
        chatNpc("Can you help me deal with these seagulls? They keep stealing all the fish.", Npcs.KLARENSE)
        when (options("Yes", "No")) {
            1 -> {
                chatPlayer("You're in luck. I'm a Seagull's worst nightmare!", animation = 588)
                chatNpc("Lure them with this Pufferfish. These aren't good to eat but once they are puffed up the seagulls will flock right to them!",
                    Npcs.KLARENSE)
                chatNpc("Take this Small Fishing Net too, when they come just use it on them! There's more supplies in the boxes if you need!",
                    Npcs.KLARENSE)
                chatPlayer("Puff Puff Puff it up!", animation = 588)
                player.inventory.add(Items.PUFFERFISH, 1)
                player.inventory.add(Items.SMALL_FISHING_NET, 1)
            }
            2 -> {
                chatPlayer("Sharing is caring!", animation = 588)
            }
        }
    }
}

/**
 * Deploy the pufferfish
 */
on_item_option(21655, "Puff") {

    // Attempt to remove a pufferfish from player and place on ground
    player.queue {
        wait(3)
        val removedCorrectAmount = player.inventory.remove(21655, 1).completed != 1
        if (removedCorrectAmount) {
            return@queue
        }
        player.animate(3649)
        wait(2)
        player.animate(-1)
        world.spawn(GroundItem(Items.PUFFERFISH, 1, tile = player.tile, player))
    }

    // add potential seagulls near the player to a list
    val potentialSeagulls: ArrayList<Npc> = ArrayList()
    for (seagull in SeagullCatcher.catchableSeagulls) {
        val distance = player.tile.getDistance(seagull.tile)
        if (distance <= 5 && seagull.isAlive() && seagull.owner == null) {
            potentialSeagulls.add(seagull)
        }
    }

    if (potentialSeagulls.size == 0) {
        player.forceChat("Seems no seagulls are interested in my pufferfish!")
        return@on_item_option
    }

    // select a random seagull from the list as the target
    val seagull = potentialSeagulls.random()
    val destination = Tile(player.tile)

    seagull.owner = player

    seagull.queue {
        while(seagull.tile != destination) {
            seagull.forceChat("eep1")
            seagull.walkTo(destination)
            wait(4)
        }
        var count = 0
        while(seagull.owner == player) {
            count++
            seagull.freeze(1)
            wait(1)
            if (count == 10) seagull.owner = null
        }

    }
}

/**
 * When a player attempts to catch a catchable seagull
 */
on_npc_option(11636, "Catch") {
    val seagull = player.getInteractingNpc()
//    if (seagull.lastCapture != true || seagull.owner != player || (player.inventory.getItemCount(Items.SMALL_FISHING_NET) == 0)) {
//        player.message("something wasnt true")
//        return@on_npc_option
//    }
    player.queue {
        player.animate(621)
        wait(1)
        player.animate(-1)
    }
    seagull.queue(TaskPriority.STRONG) {
        death(seagull)
    }
    seagull.owner = null
    player.inventory.add(Items.RAW_BIRD_MEAT, 1)
    player.inventory.add(Items.FEATHER, world.random(500) + 500)
    player.addXp(Skills.HUNTER, 999.0)
    player.message("FUCK YOU  SEAGULL.")
}

/**
 * Search crates to receive supplies
 */
on_obj_option(6176, "Search") {
    player.message("You find some Seagull hunting supplies!")
    player.inventory.add(Items.PUFFERFISH, 1)
    player.inventory.add(Items.SMALL_FISHING_NET, 1)
}


