import gg.rsmod.game.model.slayer.SlayerDef
import gg.rsmod.game.model.slayer.SlayerTaskType
import gg.rsmod.plugins.content.inter.slotinteractions.shops.Shops

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
    // hide all components except the tab opened
    player.runClientScript(30010, tab)
    player.setInterfaceEvents(shop = Shops.VANNAKA_COIN_SHOP.shop)
    player.setInterfaceEvents(shop = Shops.VANNAKA_REWARDS_SHOP.shop)

    // TODO: load from stored persistent data
    // update favorite/block lists
    player.runClientScript(30013,
        "Favorite #1", "Favorite #2", "Favorite #3", "Favorite #4", "Favorite #5",
        "Block #1", "Block #2", "Block #3", "Block #4", "Block #5")
}
