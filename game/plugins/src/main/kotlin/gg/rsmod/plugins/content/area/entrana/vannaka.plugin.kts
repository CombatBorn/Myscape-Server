spawn_npc(Npcs.VANNAKA, 2848, 3341, 0, 2)

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
                player.openInterface(interfaceId = 5000, InterfaceDestination.MAIN_SCREEN)
            }

            2 -> {
                chatPlayer("What do you have for sale?", animation = 567)
                player.openInterface(interfaceId = 5000, InterfaceDestination.MAIN_SCREEN)
            }

            3 -> {
                chatPlayer("What perks do you provide?", animation = 567)
                player.openInterface(interfaceId = 5000, InterfaceDestination.MAIN_SCREEN)
            }

            4 -> {
                chatPlayer("What perks do you provide?", animation = 567)
                player.openInterface(interfaceId = 5000, InterfaceDestination.MAIN_SCREEN)
            }
        }

    }
}
on_npc_option(Npcs.VANNAKA, "Assignment") {
    player.queue {
        chatNpc("You may choose between Easy, Medium, Hard, or Boss tasks.", Npcs.VANNAKA)
        player.openInterface(interfaceId = 5000, InterfaceDestination.MAIN_SCREEN)
    }
}
on_npc_option(Npcs.VANNAKA, "Trade") {
    player.queue {
        chatNpc("Sure, take a look at my goods.", Npcs.VANNAKA)
        player.openInterface(interfaceId = 5000, InterfaceDestination.MAIN_SCREEN)
    }
}