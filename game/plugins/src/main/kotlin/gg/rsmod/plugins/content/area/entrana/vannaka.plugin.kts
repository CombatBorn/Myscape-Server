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
    val component = it.second
    on_button(5000, component) {
        val assigned = player.slayerTask != null
        if (assigned) {
            player.message("You're already assigned to x${player.slayerTask!!.remaining} ${player.slayerTask!!.assignment.task.taskName}.")
        } else {
            player.slayerTask = slayerMaster.getTask(player, type)
            player.slayerTask!!.extended = false
            player.message("You were assigned x${player.slayerTask!!.remaining} ${player.slayerTask!!.assignment.task.taskName}.")
            player.updateSlayerInfo()
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

    // update slayer task information in interface
    this.updateSlayerInfo()
}

fun Player.updateSlayerInfo() {
    if (slayerTask == null) {
        setComponentText(5000, 43, "Current Task")
        setComponentText(5000, 48, "0")
        setComponentText(5000, 54, "Task Type")
        setComponentText(5000, 57, "Click the \"Task\" tab on the top left to get a Slayer Assignment.")
        setComponentText(5000, 61, "Current Task Drops")
        runClientScript(30000, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
    }
    else {
        val slayerTask = slayerTask!!
        setComponentText(5000, 43, slayerTask.assignment.task.taskName)
        setComponentText(5000, 48, "${slayerTask.remaining}")
        setComponentText(5000, 54, slayerTask.assignment.type.name + " TASK")
        setComponentText(5000, 57, "You were assigned to kill x${slayerTask.remaining} ${slayerTask.assignment.task.taskName}.")
        setComponentText(5000, 61, slayerTask.assignment.task.taskName)
        setupDrops()
    }
}

fun Player.setupDrops() {
    val slayerTask = slayerTask!!
    val npcId = slayerTask.assignment.task.npcIds[0]
    val drops: ArrayList<Int> = ArrayList()
    val dropTables = world.plugins.npcDropTableDefs[npcId]?.dropTables
    if (dropTables != null) {
        for (dropTable in dropTables.keys) {
            for (drop in dropTables[dropTable]!!) {
                drops.add(drop.id)
                drops.add(drop.maxQuantity)
                if (drops.size == 40) break
            }
        }
    }
    // remaining empty slots fill up with ID 1 (no items)
    if (drops.size < 40) for (index in drops.size + 1.. 40) drops.add(1)
    runClientScript(id = 30000, args = drops.toTypedArray())
}

// Slayer Interface button teleport to task
on_button(5000, 49) {
    val slayerTask = player.slayerTask
    if (slayerTask == null) {
        player.message("You do not currently have a Slayer Task.")
        return@on_button
    }
    player.closeInterface(5000)
    player.moveTo(slayerTask.assignment.task.teleport)
}

// Slayer Interface button cancel task
on_button(5000, 66) {
    val slayerTask = player.slayerTask
    if (slayerTask == null) {
        player.message("You do not currently have a Slayer Task.")
        return@on_button
    }
    player.closeInterface(5000)
    player.queue {
        when (options(
            "Cancel x${slayerTask.remaining} ${slayerTask.assignment.task.taskName} (10 Slayer Points)", "Cancel",
            title = "This will end your Slayer Task Streak of ${player.slayerStreak}.."
        )) {
            1 -> {
                if (!player.virtualWallet.removeSlayerPoints(10)) {
                    player.message("You do not have enough Slayer Points for this.")
                    return@queue
                }
                player.message("Cancelled ${slayerTask.assignment.task.taskName} Slayer Task, ending a streak of ${player.slayerStreak} tasks.")
                player.message("You have ${player.virtualWallet.slayerPoints} Slayer points remaining.")
                player.slayerStreak = 0
                player.slayerTask = null
                player.openSlayerInterface(1)
            }
        }
    }
}

// Slayer Interface button extend task
on_button(5000, 68) {
    val slayerTask = player.slayerTask
    if (slayerTask == null) {
        player.message("You do not currently have a Slayer Task.")
        return@on_button
    }
    if (!slayerTask.extend()) {
        player.message("This task may not be extended. Complete the current task to extend your next task.")
        return@on_button
    }
    player.updateSlayerInfo()
    player.message("Your task has been extended to x${slayerTask.remaining} ${slayerTask.assignment.task.taskName}.")
}

// Select Favorite or Block on a task in the list.
on_button(5000, 126) {
    val slot = player.getInteractingSlot()
    val assignment = SlayerDef.slayerDataMap[player.lastSelectedSlayerTaskType]?.get(slot / 4)!!
    val name = assignment.task.taskName
    // clicked favorite
    if ((slot + 1) % 4 == 3) {
        player.message("Added $name to favorite tasks.")
    }
    // clicked block
    else if ((slot + 1) % 4 == 0) {
        player.message("Added $name to blocked tasks.")
    }
//    player.runClientScript(30013, player.favoriteAndBlockNames().toTypedArray())
    player.runClientScript(30013,
        "Favorite #1", "Favorite #2", "Favorite #3", "Favorite #4", "Favorite #5",
    "Block #1", "Block #2", "Block #3", "Block #4", "Block #5")
}


/**
 * @param favorite If true, add to favorite list, otherwise block list
 */
fun Player.addToSlayerList(favorite: Boolean, slayerMasterId: Int, assignmentId: Int, taskType: Int) {
    val newList: ArrayList<Triple<Int, Int, Int>> = ArrayList()
    val oldList = if (favorite) favoriteList else blockList
    val added = false
    oldList.forEach {assignment ->
        if (!added && assignment.first != -1) {
            newList.add(Triple(slayerMasterId, assignmentId, taskType))
        } else {
            newList.add(Triple(assignment.first, assignment.second, assignment.third))
        }
    }
    if (favorite) favoriteList = newList else blockList = newList
}