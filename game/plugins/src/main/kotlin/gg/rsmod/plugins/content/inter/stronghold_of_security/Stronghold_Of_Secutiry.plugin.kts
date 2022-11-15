var floor = 0

val passDoorSound = 2858
val enterDoorAnim = 4282
val exitDoorAnim = 4283
val ladderClimbAnim = 828

val flapEmoteVarbit = 3209
val slapEmoteVarbit = 3210
val ideaEmoteVarbit = 3211
val stampFootEmoteVarbit = 3212

val surface = Tile(3081, 3421)

val firstFloorEntrance = Tile(1859, 5243)
val firstFloorChestRoom = Tile(1914, 5222)
val firstFloorChest = 20656

val secondFloorEntrance = Tile(2042, 5245)
val secondFloorChestRoom = Tile(2021, 5223)
val secondFloorChest = 19000

val thirdFloorEntrance = Tile(2123, 5252)
val thirdFloorChestRoom = Tile(2146, 5287)
val thirdFloorChest = 23709

val fourthFloorEntrance = Tile(2358, 5215)
val fourthFloorChestRoom = Tile(2341, 5219)
val fourthFloorChest = 23731

//val thirdFloorEntrance = Tile()

//val fourthFloorEntrance = Tile()

val alreadyLootedMessage = "You have already claimed your reward from this level."
val teleportThroughPortal = "You enter the portal to be whisked through to the treasure room."

val floor1ChestLootMessage1 = "The box hinges creak and appear to be forming audible words....."
val floor1ChestLootMessage2 =
    "...congratulations adventurer, you have been deemed worthy of this reward. You have also unlocked the Flap emote!"

val floor2ChestLootMessage1 = "he grain shifts in the sack, sighing audible words...."
val floor2ChestLootMessage2 =
    "...congratulations adventurer, you have been deemed worthy of this reward. You have also unlocked the Slap Head emote!"

// Varbit (varpId: 1021, oldValue: 1)
// Varbit(id = 5983, value = 0)
val floor3ChestLootMessage1 = "The box hinges creak and appear to be forming audible words...."
// Varbit (varpId: 802, oldValue: 0
// Varbit(id = 2311, value = 1)
val floor3ChestLootMessage2 =
    "...congratulations adventurer, you have been deemed worthy of this reward. You have also unlocked the Idea emote!"

// Varbit (varpId: 1021, oldValue: 1)
// Varbit(id = 5983, value = 0)
val floor4ChestLootMessage1 =
    "As your hand touches the cradle, you hear a voice in your head of a million dead adventurers..."
val floor4ChestLootMessage2 = "....welcome adventurer... you have a choice...."
val floor4ChestLootMessage3 = "You can choose between these two pairs of boots."
val floor4ChestLootMessage4 = "They will both protect your feet exactly the same, however they look very different. " +
        "You can always come back and get another pair if you lose them, or even swap them for the other style!"
val floor4ChestLootMessage5Title = "Choose your style of boots"
val floor4ChestLootMessage5Option1 = "I'll take the colourful ones!"
val floor4ChestLootMessage5Option2 = "I'll take the fighting ones!"
// player message, title = player username
val floor4ChestLootMessage6 = "I'll take the <fancy/fighting> ones!"
// Varbit (varpId: 802, oldValue: 0)
// Varbit(id = 2312, value = 1)
// Varbit (varpId: 1021, oldValue: 1)
// Varbit(id = 5983, value = 0)
val floor4ChestLootMessage7 =
    "Congratulations! You have successfully navigated the Stronghold of Security and learned " +
            "to secure your account. You have unlocked the 'Stamp Foot' emote. Remember to keep your account secure in<br>the future!"


// enter stronghold of security - no animation needed
on_obj_option(20790, 1) {
    player.moveTo(firstFloorEntrance)
}

/**
 * FLOOR 1
 */

// climb up ladder (entrance & chest room same object id)
on_obj_option(20784, 1) {
    player.queue(TaskPriority.STRONG) {
        ascendLadder(1)
    }
}

// enter entrance portal
on_obj_option(20786, 1) {
    // TODO: check if player has already opened the loot of this floor
    // Check if player has emote unlocked
    player.message(teleportThroughPortal)
    player.moveTo(firstFloorChestRoom)
}

// climb down ladder (chest room)
on_obj_option(20785, 1) {
    with(player) {
        floor = 1
        openInterface(interfaceId = 579, dest = InterfaceDestination.MAIN_SCREEN)
    }
}

// open chest (chest room)
on_obj_option(firstFloorChest, 1) {
    player.setVarbit(flapEmoteVarbit,1)
}

/**
 * FLOOR 2
 */

// climb up ladder (entrance)
on_obj_option(19003, 1) {
    player.queue(TaskPriority.STRONG) {
        ascendLadder(2)
    }
}

// enter entrance portal
on_obj_option(19005, 1) {
    // TODO: check if player has already opened the loot of this floor
    // Check if player has emote unlocked
    player.message(teleportThroughPortal)
    player.moveTo(secondFloorChestRoom)
}

// climb up rope (chest room)
on_obj_option(19001, 1) {
    player.queue(TaskPriority.STRONG) {
        ascendLadder(2)
    }
}

// climb down ladder (chest room)
on_obj_option(19004, 1) {
    with(player) {
        floor = 2
        openInterface(interfaceId = 579, dest = InterfaceDestination.MAIN_SCREEN)
    }
}

/**
 * FLOOR 3
 */

// climb up ladder (entrance)
on_obj_option(23705, 1) {
    player.queue(TaskPriority.STRONG) {
        ascendLadder(3)
    }
}

// enter entrance portal
on_obj_option(23707, 1) {
    // TODO: check if player has already opened the loot of this floor
    // Check if player has emote unlocked
    player.message(teleportThroughPortal)
    player.moveTo(thirdFloorChestRoom)
}

// climb up rope (chest room)
on_obj_option(23703, 1) {
    player.queue(TaskPriority.STRONG) {
        ascendLadder(3)
    }
}

// climb down ladder (chest room)
on_obj_option(23706, 1) {
    with(player) {
        floor = 3
        openInterface(interfaceId = 579, dest = InterfaceDestination.MAIN_SCREEN)
    }
}

/**
 * FLOOR 4
 */

// climb up ladder (entrance)
on_obj_option(23921, 1) {
    player.queue(TaskPriority.STRONG) {
        ascendLadder(4)
    }
}

// enter entrance portal
on_obj_option(23922, 1) {
    // TODO: check if player has already opened the loot of this floor
    // Check if player has emote unlocked
    player.message(teleportThroughPortal)
    player.moveTo(fourthFloorChestRoom)
}

// climb up rope (chest room)
on_obj_option(23732, 1) {
    player.queue(TaskPriority.STRONG) {
        ascendLadder(4)
    }
}

// interact with chest
on_obj_option(fourthFloorChest, 1) {
    player.queue {
        doubleItemMessageBox(
            floor4ChestLootMessage3,
            item1 = Items.FANCY_BOOTS,
            item2 = Items.FIGHTING_BOOTS,
            amount1 = 400,
            amount2 = 400
        )
    }
}

/**
 * INTERFACE BUTTONS
 **/
// Yes - I know that it may be dangerous down there
on_button(579, 17) {
    player.closeInterface(579)
    player.queue(TaskPriority.STRONG) {
        descendLadder()
    }
}

// no thanks - I don't want to die
on_button(579, 18) {
    player.closeInterface(579)
}

// ascend from ladder to upper floor
suspend fun QueueTask.ascendLadder(floor: Int) {
    player.animate(ladderClimbAnim)
    wait(3)
    if (floor == 1) {
        player.moveTo(surface)
    } else if (floor == 2) {
        player.moveTo(firstFloorEntrance)
    } else if (floor == 3) {
        player.moveTo(secondFloorEntrance)
    } else if (floor == 4) {
        player.moveTo(surface)
    }
}

suspend fun QueueTask.descendLadder() {
    val newFloor = floor + 1
    player.animate(ladderClimbAnim)
    wait(3)
    if (newFloor == 2) {
        player.moveTo(secondFloorEntrance)
    } else if (newFloor == 3) {
        player.moveTo(thirdFloorEntrance)
    } else if (newFloor == 4) {
        player.moveTo(fourthFloorEntrance)
    }
}