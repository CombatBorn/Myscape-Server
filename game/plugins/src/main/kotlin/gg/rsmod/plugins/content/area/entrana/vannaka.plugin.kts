import gg.rsmod.game.model.slayer.SlayerTaskType
import gg.rsmod.plugins.content.inter.slotinteractions.shops.Shops

spawn_npc(Npcs.VANNAKA, 2848, 3341, 0, 0)

on_npc_option(Npcs.VANNAKA, "Talk-to") {
    player.queue {
        chatNpc("What can I help you with?", Npcs.VANNAKA)
        when (options("Get assignment", "View shop", "View perks", "Favorite/block tasks")) {
            1 -> {
                chatPlayer("I'd like a slayer assignment", animation = 588)
                player.openSlayerInterface( 1)
            }
            2 -> {
                chatPlayer("What do you have for sale?", animation = 567)
                player.openSlayerInterface( 3)
            }
            3 -> {
                chatPlayer("What perks do you provide?", animation = 567)
                player.openSlayerInterface( 2)
            }
            4 -> {
                chatPlayer("Can I favorite/Block tasks?", animation = 567)
                player.openSlayerInterface( 4)
            }
        }
    }
}
on_npc_option(Npcs.VANNAKA, "Assignment") {
    player.queue {
        chatNpc("You may choose between Easy, Medium, Hard, or Boss tasks.", Npcs.VANNAKA)
        player.openInterface(interfaceId = 5000, InterfaceDestination.MAIN_SCREEN)
        player.openSlayerInterface( 1)
    }
}
on_npc_option(Npcs.VANNAKA, "Trade") {
    player.queue {
        chatNpc("Sure, take a look at my goods.", Npcs.VANNAKA)
        player.openSlayerInterface( 3)
    }
}
on_npc_option(Npcs.VANNAKA, "Rewards") {
    player.queue {
        chatNpc("Sure, take a look at my goods.", Npcs.VANNAKA)
        player.openSlayerInterface(2)
    }
}

/**
 * Player initiates a slayer task
 */
listOf(SlayerTaskType.EASY to 78, SlayerTaskType.MEDIUM to 82, SlayerTaskType.HARD to 86, SlayerTaskType.BOSS to 90).forEach {
    val type = it.first.name
    on_button(5000, it.second) {
        player.closeInterface(5000)
        player.queue {
            when (options("End streak and reroll $type Task (15 Slayer Points)", "Teleport to Slayer Task", title= "You were assigned x74 Abyssal Demons..")) {
                1 -> player.message("You got another $type Task!")
                2 -> player.message("Teleported to your $type Task!")
            }
        }
        player.message("You were assigned x86 Abyssal Demons.")
    }
}

fun Player.openSlayerInterface(tab: Int) {
    openInterface(interfaceId = 5000, InterfaceDestination.MAIN_SCREEN)
    // hide all components except the tab opened
    runClientScript(30010, tab)

    // implement items options for slayer shop interfaces
    setInterfaceEvents(shop = Shops.VANNAKA_COIN_SHOP.shop)
    setInterfaceEvents(shop = Shops.VANNAKA_REWARDS_SHOP.shop)

    // TODO: load from stored persistent data
    // update favorite/block lists
    runClientScript(30013,
        "Favorite #1", "Favorite #2", "Favorite #3", "Favorite #4", "Favorite #5",
        "Block #1", "Block #2", "Block #3", "Block #4", "Block #5")

    // load all item ids for current slayer task
    runClientScript(30000, 26383, 26383, 26383, 26383, 26383, 26383, 26383, 26383, 26383, 26383,
        26383, 26383, 26383, 26383, 26383, 26383, 26383, 1, 1, 1)
}
