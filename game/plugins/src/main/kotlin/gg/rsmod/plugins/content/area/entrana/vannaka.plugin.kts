import gg.rsmod.game.model.slayer.SlayerDef
import gg.rsmod.game.model.slayer.SlayerTaskType
import gg.rsmod.plugins.content.inter.slotinteractions.shops.Currency
import gg.rsmod.plugins.content.inter.slotinteractions.shops.Shops

spawn_npc(Npcs.VANNAKA, 2848, 3341, 0, 0)

val slayerMaster = SlayerDef.slayerMasters[Npcs.VANNAKA]!!

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
    val type = it.first
    on_button(5000, it.second) {
        var assigned = player.slayerTask != null
        if (assigned) {
            player.message("You're currently assigned x${player.slayerTask!!.remaining} ${player.slayerTask!!.assignment.task.taskName}.")
        }
        player.closeInterface(5000)
        player.queue {
            while(true) {
                if (!assigned){
                    player.slayerTask = slayerMaster.getTask(player, type)
                }
                val currentTask = player.slayerTask!!
                if (!assigned) player.message("You were assigned x${currentTask.remaining} ${currentTask.assignment.task.taskName}.")
                when (options("End streak and get ${type.name} Task (10 Slayer Points)", "Teleport to Slayer Task",
                    title= "Your assignment is x${currentTask.remaining} ${currentTask.assignment.task.taskName}..")) {
                    1 -> {
                        if (player.virtualWallet.removeSlayerPoints(10)){
                            assigned = false
                        } else{
                            player.message("You do not have enough Slayer Points for this.")
                            break
                        }
                    }
                    2 -> {
                        // TODO: Add delay to teleport
                        player.moveTo(currentTask.assignment.task.teleport)
                        break
                    }
                }
            }
        }
    }
}

fun Player.openSlayerInterface(tab: Int) {
    openInterface(interfaceId = 5000, InterfaceDestination.MAIN_SCREEN)
    // hide all components except the tab opened
    runClientScript(30010, tab)

    // implement items options for slayer shop interfaces
    setInterfaceEvents(shop = Shops.VANNAKA_COIN_SHOP.shop)
    setInterfaceEvents(shop = Shops.VANNAKA_REWARDS_SHOP.shop)

    // display Slayer Point currency
    updateInterfaceVirtualCurrencies(Currency.SLAYER_POINTS.virtualId)

    // TODO: load favorite/block list from stored persistent data
    // update favorite/block lists
    runClientScript(30013,
        "Favorite #1", "Favorite #2", "Favorite #3", "Favorite #4", "Favorite #5",
        "Block #1", "Block #2", "Block #3", "Block #4", "Block #5")

    // TODO: load drops from stored persistent data
    // load all item ids for current slayer task
    runClientScript(30000, 26383, 26383, 26383, 26383, 26383, 26383, 26383, 26383, 26383, 26383,
        26383, 26383, 26383, 26383, 26383, 26383, 26383, 1, 1, 1)
}
