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

    /**
     * The total weight for each [SlayerTaskType] of every possible [SlayerAssignment] combined.
     */
    val totalWeight: EnumMap<SlayerTaskType, Int> = calculateTotalWeight()

    val slayerMaster = this

    /**
     * Give the [Player] a random [SlayerTask].
     */
    fun randomTask(taskType: SlayerTaskType): SlayerTask? {
        val randomWeight = Math.random() * totalWeight[taskType]!! + 1
        var indexWeight = 0
        var assignment: SlayerAssignment? = null
        for (indexAssignment in slayerAssignments[taskType]!!){
            indexWeight += indexAssignment.weight
            if (indexWeight >= randomWeight) {
                assignment = indexAssignment
                break
            }
        }
        return if (assignment != null){
            SlayerTask(slayerMaster, assignment)
        } else {
            null
        }
    }

    /**
     * Calculate the total weight for each [SlayerTaskType] of every possible [SlayerAssignment] combined.
     */
    private fun calculateTotalWeight(): EnumMap<SlayerTaskType, Int> {
        val totalWeight: EnumMap<SlayerTaskType, Int> = EnumMap(SlayerTaskType::class.java)
        for (taskType in slayerAssignments.keys){
            var weight = 0
            for (assignment in slayerAssignments[taskType]!!){
                weight += assignment.weight
            }
            totalWeight[taskType] = weight
        }
        return totalWeight
    }
}