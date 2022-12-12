spawn_npc(Npcs.VANNAKA, 2848, 3341, 0, 0)

on_npc_option(Npcs.VANNAKA, "Talk-to") {

    player.queue {
        chatNpc("What can I help you with?", Npcs.VANNAKA)
        when (options("Get assignment", "View shop", "View perks", "Favorite/block tasks")) {
            1 -> {
                chatPlayer("I'd like a slayer assignment", animation = 588)
                openSlayerInterface(player, 1)
            }
            2 -> {
                chatPlayer("What do you have for sale?", animation = 567)
                openSlayerInterface(player, 3)
            }
            3 -> {
                chatPlayer("What perks do you provide?", animation = 567)
                openSlayerInterface(player, 2)
            }
            4 -> {
                chatPlayer("Can I favorite/Block tasks?", animation = 567)
                openSlayerInterface(player, 4)
            }
        }

    }
}
on_npc_option(Npcs.VANNAKA, "Assignment") {
    player.queue {
        chatNpc("You may choose between Easy, Medium, Hard, or Boss tasks.", Npcs.VANNAKA)
        player.openInterface(interfaceId = 5000, InterfaceDestination.MAIN_SCREEN)
        openSlayerInterface(player, 1)
    }
}
on_npc_option(Npcs.VANNAKA, "Trade") {
    player.queue {
        chatNpc("Sure, take a look at my goods.", Npcs.VANNAKA)
        openSlayerInterface(player, 3)
    }
}
on_npc_option(Npcs.VANNAKA, "Rewards") {
    player.queue {
        chatNpc("Sure, take a look at my goods.", Npcs.VANNAKA)
        openSlayerInterface(player, 2)
    }
}

fun openSlayerInterface(player: Player, tab: Int) {
    player.openInterface(interfaceId = 5000, InterfaceDestination.MAIN_SCREEN)
    player.runClientScript(30010, tab)
    // Slayer Rewards Shop (Slayer points)
    var totalItems = 50;
    player.setInterfaceEvents(interfaceId = 5000, component = 98, range = 0..(totalItems * 3 - 3), InterfaceEvent.BUTTON1, InterfaceEvent.BUTTON10)
    // Slayer items Shop (Coins)
    totalItems = 11;
    player.setInterfaceEvents(interfaceId = 5000, component = 104, range = 0..(totalItems * 3 - 3), InterfaceEvent.BUTTON1, InterfaceEvent.BUTTON10)
}

val slayerItems = listOf(4155, 4156, 4162, 4164, 4166, 4168, 4170, 4551, 6708, 7159, 23037)
val slayerItemsPrice = listOf(1, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000)
on_button(5000, 104) {
    val slot = player.getInteractingSlot() / 3
    val itemId = slayerItems[slot]
    val price = slayerItemsPrice[slot]
    if (player.getInteractingOption() == 1) {
        val removed = player.inventory.remove(995, price).completed
        if (removed == price){
            val given = player.inventory.add(itemId).completed
            if (given == 1){
                player.message("You purchased ${world.definitions.get(ItemDef::class.java, itemId).name}.")
                return@on_button
            } else {
                player.message("You do not have enough inventory space for this.")
                player.inventory.add(995, removed)
            }
        } else{
            player.inventory.add(995, removed)
            player.message("You do not have enough coins for this.")
        }
    }else if (player.getInteractingOption() == 10){
        player.message("${world.definitions.get(ItemDef::class.java, itemId).examine}")
    }
}


