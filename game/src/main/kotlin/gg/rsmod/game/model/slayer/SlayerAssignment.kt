package gg.rsmod.game.model.slayer

import gg.rsmod.game.model.entity.Player

/**
 * A slayer assignment is given by a [SlayerMaster] for a [Player] to complete.
 * Slayer Assignments typically have multiple NPCs that can be defeated to complete the
 * [SlayerTask]. Completing a [SlayerAssignment] yields the virtual currency, Slayer Points.
 * The amount of Slayer Points depends on the [SlayerTaskType] and the rank of the
 * [SlayerMaster].
 *
 * @param task The [Tasks] that's being assigned to kill.
 * @param id The ID associated with the [SlayerAssignment].
 * @param type The [SlayerTaskType] this assignment is.
 * @param min The minimum number of [Tasks]s that can get assigned to be killed for a [SlayerTask].
 * @param max The maximum number of [Tasks]s that can get assigned to be killed for a [SlayerTask].
 * @param weight How often this assignment will be selected as a random [SlayerTask]. More weight = greater odds.
 */
class SlayerAssignment (
    val task: Tasks = Tasks.NONE,
    val id: Int = -1,
    val type: SlayerTaskType = SlayerTaskType.EASY,
    val min: Int = 40,
    val max: Int = 80,
    val weight: Int = 10) {
    fun randomAmount(): Int {
        return (Math.random() * (max - min) + min).toInt()
    }
}