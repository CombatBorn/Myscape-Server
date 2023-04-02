import gg.rsmod.game.action.NpcDeathAction.death

spawn_npc(Npcs.MINER, 2848, 3341, 0, 0)


on_npc_option(Npcs.MINER, "Talk-to") {
    player.queue {
        chatNpc("Would you like to take a trip in the minecart? This will cost 50,000 coins, and it's a bumpy ride.", Npcs.MINER)
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

on_npc_option(Npcs.KLARENSE, "Talk-to") {
    player.queue {
        chatNpc("Can you help me deal with these seagulls? They keep stealing all the fish.", Npcs.KLARENSE)
        when (options("Yes", "No")) {
            1 -> {
                chatPlayer("You're in luck. I'm a Seagull's worst nightmare!", animation = 588)
                chatNpc("Lure them with this Pufferfish. These aren't good to eat but once they are puffed up the seagulls will flock right to them!", Npcs.KLARENSE)
                chatNpc("Take this Small Fishing Net too, when they come just use it on them! There's more supplies in the boxes if you need!", Npcs.KLARENSE)
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
on_item_option(21655, "Puff") {
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
        val nearbySeagulls: ArrayList<Npc> = ArrayList()
        for (seagull in SeagullCatcher.catchableSeagulls) {
            val distance = player.tile.getDistance(seagull.tile)
            if (distance <= 5 && seagull.isAlive() == true && seagull.owner == null) {
                nearbySeagulls.add(seagull)
            }
        }
        val seagull = nearbySeagulls.random()
        seagull.forceChat("eep1")
        seagull.owner = player
        seagull.catchable = true
/**
* if the seagull was originally on the player's tile
*/
        if (seagull.tile == Tile(player.tile) && (seagull.owner == player) || (seagull.hasbeenowned != player)) {
            seagull.queue(TaskPriority.STRONG) {
                seagull.forceChat("squak2?..")
                seagull.freeze(10)
                wait(10)
                seagull.forceChat("squak2..")
                seagull.owner = null
                death(seagull)
            }
        }
        while (seagull.tile != Tile(player.tile) && (seagull.owner == player)) {
            player.message("you dont fully own a seagull yet")
/**
* if the seagull isnt on the player's tile
 * */
            if (seagull.tile != Tile(player.tile)) {
                seagull.hasbeenowned == null
                seagull.forceChat("eep2")
                seagull.walkTo(player.tile)
                wait(5)
/**
* while the seagull is on the player's tile
*/
            } else {
                player.message("you fully own a seagull")
                seagull.queue(TaskPriority.STRONG) {
                    seagull.forceChat("squak1?..")
                    seagull.freeze(10)
                    wait(10)
                    seagull.forceChat("squak1..")
                    seagull.owner = null
                    death(seagull)
                }
            }
        }
    }
}


on_npc_option(11636, "Catch") {
    val seagull = player.getInteractingNpc()
    if (seagull.catchable != true || seagull.owner != player || (player.inventory.getItemCount(Items.SMALL_FISHING_NET) == 0)) {
        player.message("something wasnt true")
        return@on_npc_option
    }
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

on_obj_option(6176, "Search") {
    player.message("You find some Seagull hunting supplies!")
    player.inventory.add(Items.PUFFERFISH, 1)
    player.inventory.add(Items.SMALL_FISHING_NET, 1)
}


