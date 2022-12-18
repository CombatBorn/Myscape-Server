package gg.rsmod.game.model.slayer

import gg.rsmod.game.model.entity.Player
import java.util.*
import kotlin.collections.ArrayList

/**
 * @param id The NPC id associated with this [SlayerMaster]
 * @param rank The rank of the NPC is used for Heroic and Corrupt Slayer.
 * @param slayerAssignments A map of all [SlayerTaskType]s the [SlayerMaster] provides with every
 * possible [SlayerAssignment] the [SlayerTaskType] can yield.
 */
class SlayerMaster(val id: Int, val rank: Int = 0, val slayerAssignments: EnumMap<SlayerTaskType, ArrayList<SlayerAssignment>>) {

    val slayerMaster = this

    /**
     * Give the [Player] a random [SlayerTask].
     */
    fun getTask(player: Player, taskType: SlayerTaskType): SlayerTask {

        // determine which tasks a player is capable of doing
        var weight = 0
        val validTasks: ArrayList<SlayerAssignment> = ArrayList()
        for (assignment in slayerAssignments[taskType]!!) {
            if (player.getSkills().getBaseLevel(18) >= assignment.task.slayerLevel) {
                validTasks.add(assignment)
                weight += assignment.weight
            }
        }

        // select a random task based on the weight system
        // a smaller weight means the assignment is rarer to get
        val randomWeight = Math.random() * weight + 1
        var indexWeight = 0
        var assignment: SlayerAssignment? = null
        for (indexAssignment in validTasks){
            indexWeight += indexAssignment.weight
            if (indexWeight >= randomWeight) {
                assignment = indexAssignment
                break
            }
        }
        return SlayerTask(slayerMaster, assignment!!)
    }
}