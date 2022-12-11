spawn_npc(Npcs.VANNAKA, 2848, 3341, 0, 0)

on_npc_option(Npcs.VANNAKA, "Talk-to") {

    if (world.definitions.get(NpcDef::class.java, Npcs.VANNAKA).models != null) {
        for (model in world.definitions.get(NpcDef::class.java, Npcs.VANNAKA).models!!) {
            player.message("Model ID: $model")
        }
    }

    player.queue {
        chatNpc("What can I help you with?", Npcs.VANNAKA)
        when (options("Get assignment", "View shop", "View perks", "Favorite/block tasks")) {
            1 -> {
                chatPlayer("I'd like a slayer assignment", animation = 588)
                openSlayerInterface(player,1)
            }

            2 -> {
                chatPlayer("What do you have for sale?", animation = 567)
                openSlayerInterface(player,3)
            }

            3 -> {
                chatPlayer("What perks do you provide?", animation = 567)
                openSlayerInterface(player,2)
            }

            4 -> {
                chatPlayer("Can I favorite/Block tasks?", animation = 567)
                openSlayerInterface(player,4)
            }
        }

    }
}
on_npc_option(Npcs.VANNAKA, "Assignment") {
    player.queue {
        chatNpc("You may choose between Easy, Medium, Hard, or Boss tasks.", Npcs.VANNAKA)
        player.openInterface(interfaceId = 5000, InterfaceDestination.MAIN_SCREEN)
        openSlayerInterface(player,1)
    }
}
on_npc_option(Npcs.VANNAKA, "Trade") {
    player.queue {
        chatNpc("Sure, take a look at my goods.", Npcs.VANNAKA)
        openSlayerInterface(player,3)
    }
}

fun openSlayerInterface(player: Player, tab: Int){
    player.openInterface(interfaceId = 5000, InterfaceDestination.MAIN_SCREEN)
    // TODO: runClientScript to select which tab is opened
    if (tab == 2){
        player.setInterfaceEvents(interfaceId = 5000, component = 193, range = 0..74, InterfaceEvent.BUTTON1, InterfaceEvent.BUTTON10)
    }
}
on_button(5000, 193) {
    player.message("You clicked component 193 option: ${player.getInteractingOption()} slot: ${player.getInteractingSlot()}")
}