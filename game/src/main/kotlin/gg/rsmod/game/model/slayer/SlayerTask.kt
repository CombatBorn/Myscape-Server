package gg.rsmod.game.model.slayer

import gg.rsmod.game.fs.def.NpcDef
import gg.rsmod.game.model.entity.Player

/**
 * [SlayerTask]s are given by [SlayerMaster]s for players to complete randomly
 * assigned [SlayerAssignment]s.
 * @param slayerMaster The Slayer Master who gave the task.
 * @param assignment The assigned NPC to kill.
 */
class SlayerTask(val slayerMaster: SlayerMaster, val assignment: SlayerAssignment) {

    /**
     * The amount of NPCs needed to be killed to complete the [SlayerTask].
     */
    var remaining = assignment.randomAmount()

    /**
     * This occurs when an assigned [SlayerNpc] has been defeated.
     */
    fun Player.defeatedTaskMonster() {
        remaining -= 1
        if (world.random(150) == 1) this.summonSuperior()
        if (remaining <= 0){
            this.slayerTaskCompleted()
        }
    }

    /**
     * The total [remaining] NPCs have been defeated.
     */
    fun Player.slayerTaskCompleted() {
        this.giveTaskRewards()
    }

    /**
     * Teleport a player to their [SlayerAssignment].
     */
    fun Player.teleportToAssignment() {
        this.moveTo(assignment.slayerNpc.teleport)
    }

    /**
     * Rewards given to the player for completing the [SlayerTask].
     */
    fun Player.giveTaskRewards() {
        var slayerPoints = 0
        var corruptionSigils = 0
        var heroismSigils = 0
        when(assignment.type) {
            SlayerTaskType.EASY -> { slayerPoints = 5; this.writeMessage("Nice work.") }
            SlayerTaskType.MEDIUM -> { slayerPoints = 10; this.writeMessage("Nice work.") }
            SlayerTaskType.HARD -> { slayerPoints = 15; this.writeMessage("Nice work.") }
            SlayerTaskType.BOSS -> { slayerPoints = 25; this.writeMessage("Nice work.") }
            SlayerTaskType.HEROISM -> { slayerPoints = 10; heroismSigils = slayerMaster.rank * 20; this.writeMessage("Nice work.") }
            SlayerTaskType.CORRUPTION -> { slayerPoints = 10; corruptionSigils = slayerMaster.rank * 20; this.writeMessage("Nice work.") }
            SlayerTaskType.WILDERNESS -> { slayerPoints = 35; this.writeMessage("Nice work.") }
        }
        // TODO: Add virtual currencies.
        // TODO: Modify Slayer Point yield based on Task Streak.
    }

    /**
     * The odds of a superior spawning are currently 1/150. In the future this will scale depending
     * on the killed NPC's maximum health.
     */
    fun Player.summonSuperior() {
        val superiorId = assignment.slayerNpc.superiorId
        if (superiorId == -1){
            return
        }
        val superiorName = world.definitions.get(NpcDef::class.java, superiorId).name
        // TODO: Check if player has superiors unlocked.
        // TODO: Spawn a NPC that only the player can kill.
        if (assignment.type == SlayerTaskType.BOSS) {
            world.announce("A $superiorName superior NPC has spawned for ${this.username}!")
        }
        this.writeMessage("A $superiorName superior NPC has spawned for you!")
    }

}