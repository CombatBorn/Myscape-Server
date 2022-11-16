// TODO: Needs to be stored in player.kts
var strongHoldOfSecurityFloor = 0

/**
 * ANIMATION IDS
 */
val passDoorSound = 2858
val enterDoorAnim = 4282
val exitDoorAnim = 4283
val ladderClimbAnim = 828

/**
 * OBJECT IDS
 */
val doors: Array<Int> = arrayOf(19207, 19206, 17100, 17009, 23653, 23654, 23728, 23727)
val firstFloorChest = 20656
val secondFloorChest = 19000
val thirdFloorChest = 23709
val fourthFloorChest = 23731

/**
 * TILES
 */
val surface = Tile(3081, 3421)
val firstFloorEntrance = Tile(1859, 5243)
val firstFloorChestRoom = Tile(1914, 5222)
val secondFloorEntrance = Tile(2042, 5245)
val secondFloorChestRoom = Tile(2021, 5223)
val thirdFloorEntrance = Tile(2123, 5252)
val thirdFloorChestRoom = Tile(2146, 5287)
val fourthFloorEntrance = Tile(2358, 5215)
val fourthFloorChestRoom = Tile(2341, 5219)

/**
 * MESSAGES
 */
val alreadyLootedMessage = "You have already claimed your reward from this level."
val teleportThroughPortal = "You enter the portal to be whisked through to the treasure room."
val floor1ChestLootMessage1 = "The box hinges creak and appear to be forming audible words....."
val floor1ChestLootMessage2 = "...congratulations adventurer, you have been deemed worthy of this reward. You have also unlocked the Flap emote!"
val floor2ChestLootMessage1 = "he grain shifts in the sack, sighing audible words...."
val floor2ChestLootMessage2 = "...congratulations adventurer, you have been deemed worthy of this reward. You have also unlocked the Slap Head emote!"
val floor3ChestLootMessage1 = "The box hinges creak and appear to be forming audible words...."
val floor3ChestLootMessage2 = "...congratulations adventurer, you have been deemed worthy of this reward. You have also unlocked the Idea emote!"
val floor4ChestLootMessage1 = "As your hand touches the cradle, you hear a voice in your head of a million dead adventurers..."
val floor4ChestLootMessage2 = "....welcome adventurer... you have a choice...."
val floor4ChestLootMessage3 = "You can choose between these two pairs of boots."
val floor4ChestLootMessage4 = "They will both protect your feet exactly the same, however they look very different. " +
        "You can always come back and get another pair if you lose them, or even swap them for the other style!"
val floor4ChestLootMessage5Title = "Choose your style of boots"
val floor4ChestLootMessage5Option1 = "I'll take the colourful ones!"
val floor4ChestLootMessage5Option2 = "I'll take the fighting ones!"
val floor4ChestLootMessage7 = "Congratulations! You have successfully navigated the Stronghold of Security and learned " +
            "to secure your account. Remember to keep your account secure in the future!"

/**
 * ENTER STRONGHOLD OF SECURITY
 */
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
// enter portal (entrance)
on_obj_option(20786, 1) {
    if (player.getVarbit(Varbits.FLAP_EMOTE_VARBIT) != 1) {
        player.message("This portal hasn't been unlocked yet.")
        return@on_obj_option
    }
    player.message(teleportThroughPortal)
    player.moveTo(firstFloorChestRoom)
}
// climb down ladder (chest room)
on_obj_option(20785, 1) {
    with(player) {
        strongHoldOfSecurityFloor = 1
        openInterface(interfaceId = 579, dest = InterfaceDestination.MAIN_SCREEN)
    }
}
// open chest (chest room)
on_obj_option(firstFloorChest, 1) {
    player.queue { firstFloorChestDialog() }
}
// open chest dialog
suspend fun QueueTask.firstFloorChestDialog() {
    if (player.getVarbit(Varbits.FLAP_EMOTE_VARBIT) == 1) {
        messageBox(alreadyLootedMessage)
        return
    }
    messageBox(floor1ChestLootMessage1)
    player.message("You have unlocked the 'Flap' emote!")
    player.setVarbit(Varbits.FLAP_EMOTE_VARBIT, 1)
    messageBox(floor1ChestLootMessage2)
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
// enter portal (entrance)
on_obj_option(19005, 1) {
    if (player.getVarbit(Varbits.SLAP_HEAD_EMOTE_VARBIT) != 1) {
        player.message("This portal hasn't been unlocked yet.")
        return@on_obj_option
    }
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
        strongHoldOfSecurityFloor = 2
        openInterface(interfaceId = 579, dest = InterfaceDestination.MAIN_SCREEN)
    }
}
// open chest (chest room)
on_obj_option(secondFloorChest, 1) {
    player.queue { secondFloorChestDialog() }
}
// open chest dialog
suspend fun QueueTask.secondFloorChestDialog() {
    if (player.getVarbit(Varbits.SLAP_HEAD_EMOTE_VARBIT) == 1) {
        messageBox(alreadyLootedMessage)
        return
    }
    messageBox(floor2ChestLootMessage1)
    player.message("You have unlocked the 'Slap Head' emote!")
    player.setVarbit(Varbits.SLAP_HEAD_EMOTE_VARBIT, 1)
    messageBox(floor2ChestLootMessage2)
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
// enter portal (entrance)
on_obj_option(23707, 1) {
    if (player.getVarbit(Varbits.IDEA_EMOTE_VARBIT) != 1) {
        player.message("This portal hasn't been unlocked yet.")
        return@on_obj_option
    }
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
        strongHoldOfSecurityFloor = 3
        openInterface(interfaceId = 579, dest = InterfaceDestination.MAIN_SCREEN)
    }
}
// open chest (chest room)
on_obj_option(thirdFloorChest, 1) {
    player.queue { thirdFloorChestDialog() }
}
// open chest dialog
suspend fun QueueTask.thirdFloorChestDialog() {
    if (player.getVarbit(Varbits.IDEA_EMOTE_VARBIT) == 1) {
        messageBox(alreadyLootedMessage)
        return
    }
    messageBox(floor3ChestLootMessage1)
    player.message("You have unlocked the 'Idea' emote!")
    player.setVarbit(Varbits.IDEA_EMOTE_VARBIT, 1)
    messageBox(floor3ChestLootMessage2)
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
// enter portal (entrance)
on_obj_option(23922, 1) {
    if (player.getVarbit(Varbits.STAMP_EMOTE_VARBIT) != 1) {
        player.message("This portal hasn't been unlocked yet.")
        return@on_obj_option
    }
    player.message(teleportThroughPortal)
    player.moveTo(fourthFloorChestRoom)
}
// climb up rope (chest room)
on_obj_option(23732, 1) {
    player.queue(TaskPriority.STRONG) {
        ascendLadder(4)
    }
}
// open chest (chest room)
on_obj_option(fourthFloorChest, 1) {
    player.queue { fourthFloorChestDialog() }
}
// open chest dialog
suspend fun QueueTask.fourthFloorChestDialog() {
    if (player.getVarbit(Varbits.STAMP_EMOTE_VARBIT) == 1) {
        messageBox(alreadyLootedMessage)
        return
    }
    messageBox(floor4ChestLootMessage1)
    messageBox(floor4ChestLootMessage2)
    doubleItemMessageBox(
        floor4ChestLootMessage3,
        item1 = Items.FANCY_BOOTS,
        item2 = Items.FIGHTING_BOOTS,
        amount1 = 400,
        amount2 = 400
    )
    messageBox(floor4ChestLootMessage4)
    var item = Items.FANCY_BOOTS
    when (options(
        floor4ChestLootMessage5Option1,
        floor4ChestLootMessage5Option2,
        title = floor4ChestLootMessage5Title
    )) {
        1 -> { item = Items.FANCY_BOOTS }
        2 -> { item = Items.FIGHTING_BOOTS }
    }
    val message = if (item == Items.FANCY_BOOTS) {
        "I'll take the fancy ones!"
    } else {
        "I'll take the fighting ones!"
    }
    chatPlayer(message)
    val success = player.inventory.add(item).completed
    if (success == 0) {
        messageBox("You do not have enough inventory space to claim ${world.definitions.get(ItemDef::class.java, item).name}.")
        return
    }
    player.message("You have unlocked the 'Stamp' emote!")
    player.setVarbit(Varbits.STAMP_EMOTE_VARBIT, 1)
    messageBox(floor4ChestLootMessage7)
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
// No thanks - I don't want to die
on_button(579, 18) {
    player.closeInterface(579)
}

/**
 * LADDERS
 */
// ascend from ladder to upper floor
suspend fun QueueTask.ascendLadder(floor: Int) {
    player.animate(ladderClimbAnim)
    wait(3)
    when (floor){
        1, 4 -> { player.moveTo(surface) }
        2 -> { player.moveTo(firstFloorEntrance) }
        3 -> { player.moveTo(secondFloorEntrance) }
    }
}
// descend from ladder to upper floor
suspend fun QueueTask.descendLadder() {
    val newFloor = strongHoldOfSecurityFloor + 1
    player.animate(ladderClimbAnim)
    wait(3)
    when (newFloor){
        2 -> { player.moveTo(secondFloorEntrance) }
        3 -> { player.moveTo(thirdFloorEntrance) }
        4 -> { player.moveTo(fourthFloorEntrance) }
    }
}

/**
 * DOORS
 */
// TODO: Fix bug where players can interact with diagonal GameObjects. Causes incorrect destination
doors.forEach { door ->
    on_obj_option(door, 1) {
        val destination = doorPassTile(player.tile,player.getInteractingGameObj())
        if (destination == player.tile) return@on_obj_option
        player.queue {player.animate(enterDoorAnim)
            player.lock()
            wait(2)
            player.playSound(passDoorSound)
            player.moveTo(destination)
            wait(2)
            player.animate(exitDoorAnim)
            wait(2)
            player.unlock()
        }
    }
}
/**
 * Door [GameObject.rot] rotations:
 *  North: 3, East: 0, South: 1, West: 2
 */
fun doorPassTile(playerTile: Tile, door: GameObject): Tile{
    when (door.rot) {
        3 -> {
            return if (playerTile == door.tile){
                Tile(door.tile.x, door.tile.z - 1)
            }else{
                Tile(door.tile.x, door.tile.z + 1)
            }
        }
        0 -> {
            return if (playerTile == door.tile){
                Tile(door.tile.x - 1, door.tile.z)
            }else{
                Tile(door.tile.x + 1, door.tile.z)
            }
        }
        1 -> {
            return if (playerTile == door.tile){
                Tile(door.tile.x, door.tile.z + 1)
            }else{
                Tile(door.tile.x, door.tile.z - 1)
            }
        }
        2 -> {
            return if (playerTile == door.tile){
                Tile(door.tile.x + 1, door.tile.z)
            }else{
                Tile(door.tile.x - 1, door.tile.z)
            }
        }
        else -> return Tile(playerTile)
    }
}