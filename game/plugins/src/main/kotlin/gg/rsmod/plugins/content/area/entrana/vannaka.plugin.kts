import gg.rsmod.game.model.slayer.Assignments
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
            player.message("You're already assigned to x${player.slayerTask!!.remaining} ${player.slayerTask!!.assignment.taskName}.")
        } else {
            player.slayerTask = slayerMaster.getTask(player, type)
            player.message("You were assigned x${player.slayerTask!!.remaining} ${player.slayerTask!!.assignment.taskName}.")
            player.updateSlayerInfo()
        }
    }
}

/**
 * OPEN the main Slayer Interface.
 */
fun Player.openSlayerInterface(tab: Int) {
    openInterface(interfaceId = 5000, InterfaceDestination.MAIN_SCREEN)
    // hide all components except the tab opened
    runClientScript(30010, tab)

    // implement items options for slayer shop interfaces
    setInterfaceEvents(shop = Shops.VANNAKA_COIN_SHOP.shop)
    setInterfaceEvents(shop = Shops.VANNAKA_REWARDS_SHOP.shop)

    // display Slayer Point currency
    updateInterfaceVirtualCurrencies(Currency.SLAYER_POINTS.virtualId)

    // update favorite/block lists
    this.updateFavoriteTab()
    setInterfaceEvents(5000, 133, 0..14, InterfaceEvent.BUTTON1)
    setInterfaceEvents(5000, 139, 0..14, InterfaceEvent.BUTTON1)

    // update slayer task information in interface
    this.updateSlayerInfo()
}

/**
 * UPDATE FAVORITE/BLOCK Tasks within the Favorite Slayer Interface Tab.
 */
fun Player.updateFavoriteTab() {
    val list: ArrayList<String> = ArrayList()
    for (assignment in (favoriteList + blockList)) {
        if (assignment == Assignments.NONE) list.add("") else list.add(assignment.taskName)
    }
    runClientScript(30013,
        list[0], list[1], list[2], list[3], list[4], list[5], list[6], list[7], list[8], list[9]
    )
}

/**
 * UPDATE SLAYER information within the Information Slayer Interface Tab.
 */
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
        setComponentText(5000, 43, slayerTask.assignment.taskName)
        setComponentText(5000, 48, "${slayerTask.remaining}")
        setComponentText(5000, 54, slayerTask.type.name + " TASK")
        setComponentText(5000, 57, "You were assigned to kill x${slayerTask.remaining} ${slayerTask.assignment.taskName}.")
        setComponentText(5000, 61, slayerTask.assignment.taskName)
        setupDrops()
    }
}

/**
 * ADD DROPS to Drops Slayer Interface Tab.
 */
fun Player.setupDrops() {
    val slayerTask = slayerTask!!
    val npcId = slayerTask.assignment.npcIds[0]
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

/**
 * TELEPORT to Slayer Task.
 */
on_button(5000, 49) {
    val slayerTask = player.slayerTask
    if (slayerTask == null) {
        player.message("You do not currently have a Slayer Task.")
        return@on_button
    }
    player.closeInterface(5000)
    player.moveTo(slayerTask.assignment.teleport)
}

/**
 * CANCEL Slayer Task.
 */
on_button(5000, 66) {
    val slayerTask = player.slayerTask
    if (slayerTask == null) {
        player.message("You do not currently have a Slayer Task.")
        return@on_button
    }
    player.closeInterface(5000)
    player.queue {
        when (options(
            "Cancel x${slayerTask.remaining} ${slayerTask.assignment.taskName} (10 Slayer Points)", "Cancel",
            title = "This will end your Slayer Task Streak of ${player.slayerStreak}.."
        )) {
            1 -> {
                if (!player.virtualWallet.removeSlayerPoints(10)) {
                    player.message("You do not have enough Slayer Points for this.")
                    return@queue
                }
                player.message("Cancelled ${slayerTask.assignment.taskName} Slayer Task, ending a streak of ${player.slayerStreak} tasks.")
                player.message("You have ${player.virtualWallet.slayerPoints} Slayer points remaining.")
                player.slayerStreak = 0
                player.slayerTask = null
                player.openSlayerInterface(1)
            }
        }
    }
}
/**
 * ADD TO FAVORITE LIST the current Slayer Assignment.
 */
on_button(5000, 70) {
    val slayerTask = player.slayerTask
    if (slayerTask == null) {
        player.message("You do not currently have a Slayer Task.")
        return@on_button
    }
    val name = slayerTask.assignment.taskName
    if (player.addToSlayerList(true, slayerTask.assignment)) {player.message("Added $name to Favorite Tasks."); player.updateFavoriteTab()}
    else player.message("Unable to add $name to Favorite Tasks.")
}

/**
 * ADD TO BLOCKED LIST the current Slayer Assignment.
 */
on_button(5000, 72) {
    val slayerTask = player.slayerTask
    if (slayerTask == null) {
        player.message("You do not currently have a Slayer Task.")
        return@on_button
    }
    val name = slayerTask.assignment.taskName
    if (player.addToSlayerList(false, slayerTask.assignment)) {player.message("Added $name to Blocked Tasks."); player.updateFavoriteTab()}
    else player.message("Unable to add $name to Blocked Tasks.")
}

/**
 * EXTEND Slayer Task.
 */
on_button(5000, 68) {
    val slayerTask = player.slayerTask
    if (slayerTask == null) {
        player.message("You do not currently have a Slayer Task.")
        return@on_button
    }
    if (!slayerTask.extend()) {
        player.message("This task has already been extended as much as it can be.")
        return@on_button
    }
    player.message("Your task has been extended to x${slayerTask.remaining} ${slayerTask.assignment.taskName}.")
    player.updateSlayerInfo()
}

/**
 * FAVORITE/BLOCK tasks in the Favorite Slayer Interface Tab.
 */
on_button(5000, 126) {
    val slot = player.getInteractingSlot()
    val assignment = SlayerDef.slayerDataMap[player.lastSelectedSlayerTaskType]?.get(slot / 4)!!
    val name = assignment.taskName
    var updated = false
    // clicked favorite
    if ((slot + 1) % 4 == 3) {
        if (player.addToSlayerList(true, assignment)) {player.message("Added $name to Favorite Tasks."); updated = true}
        else player.message("Unable to add $name to Favorite Tasks.")
    }
    // clicked block
    else if ((slot + 1) % 4 == 0) {
        if (player.addToSlayerList(false, assignment)) {player.message("Added $name to Blocked Tasks."); updated = true}
        else player.message("Unable to add $name to Blocked Tasks.")
    }
    if (updated) player.updateFavoriteTab()
}


/**
 * ADD assignments to the player's Favorite/Blocked Task lists.
 *
 * @param favorite If true, add to favorite list, otherwise block list
 */
fun Player.addToSlayerList(favorite: Boolean, assignment: Assignments): Boolean {
    val oldList = if (favorite) favoriteList else blockList
    val otherList = if (favorite) blockList else favoriteList
    if (!oldList.contains(Assignments.NONE) || oldList.contains(assignment) || otherList.contains(assignment)) return false
    var added = false
    val newList: ArrayList<Assignments> = ArrayList()
    for (indexAssignment in oldList) {
        if (!added && indexAssignment == Assignments.NONE) {
            newList.add(assignment)
            added = true
        } else {
            newList.add(indexAssignment)
        }
    }
    if (favorite) favoriteList = newList else blockList = newList
    return true
}

/**
 * REMOVE FAVORITE Slayer Task from the Favorites List.
 */
on_button(5000, 133) {
    val slot = player.getInteractingSlot() / 3
    player.removeFromSlayerList(true, slot)
}
/**
 * REMOVE BLOCKED Slayer Task from the Blocked List.
 */
on_button(5000, 139) {
    val slot = player.getInteractingSlot() / 3
    player.removeFromSlayerList(false, slot)
}

/**
 * REMOVE FAVORITE/BLOCK Slayer Task from the Blocked List.
 *
 * @param favorite If true, remove from favorite list, otherwise block list
 */
fun Player.removeFromSlayerList(favorite: Boolean, slot: Int) {
    val assignment = if (favorite) favoriteList[slot] else blockList[slot]
    val oldList = if (favorite) favoriteList else blockList
    val newList: ArrayList<Assignments> = ArrayList()
    for (index in 0..4) {
        if (index != slot && oldList[index] != Assignments.NONE) newList.add(oldList[index])
    }
    for (index in newList.size..4) {
        newList.add(Assignments.NONE)
    }
    if (favorite) favoriteList = newList else blockList = newList
    message("Removed ${assignment.taskName} from ${if (favorite) "Favorite" else "Blocked"} Tasks.")
    updateFavoriteTab()
}