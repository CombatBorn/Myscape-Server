package gg.rsmod.game.model.slayer

import gg.rsmod.game.model.entity.Player
import java.util.*
import kotlin.collections.ArrayList

/**
 * @param id The NPC id associated with this [SlayerMaster]
 * @param rank The rank of the NPC is used for Heroic and Corrupt Slayer.
 * @param assignments A map of all [SlayerTaskType]s the [SlayerMaster] provides with every
 * possible [Assignments] the [SlayerTaskType] can yield.
 */
class SlayerMaster(val id: Int, val rank: Int = 0, val assignments: EnumMap<SlayerTaskType, ArrayList<Assignments>>) {

    val slayerMaster = this

    /**
     * Give the [Player] a random [SlayerTask].
     */
    fun getTask(player: Player, taskType: SlayerTaskType): SlayerTask {

        // determine which tasks a player is capable of doing
        var totalWeight = 0
        val validTasks: ArrayList<Assignments> = ArrayList()
        for (assignment in assignments[taskType]!!) {
            if (player.getSkills().getBaseLevel(18) >= assignment.slayerLevel && !player.blockList.contains(assignment)) {
                validTasks.add(assignment)
                totalWeight += if (player.favoriteList.contains(assignment)) assignment.weight + 500 else assignment.weight
            }
        }

        // select a random task based on the weight system
        // a smaller weight means the assignment is rarer to get
        val randomWeight = Math.random() * totalWeight + 1
        var indexWeight = 0
        var assignments: Assignments? = null
        for (indexAssignment in validTasks){
            indexWeight += if (player.favoriteList.contains(indexAssignment)) indexAssignment.weight + 500 else indexAssignment.weight
            if (indexWeight >= randomWeight) {
                assignments = indexAssignment
                break
            }
        }
        return SlayerTask(slayerMaster, assignments!!, taskType)
    }
}