package gg.rsmod.game.task.parallel

import gg.rsmod.game.model.World
import gg.rsmod.game.service.GameService
import gg.rsmod.game.task.GameTask
import gg.rsmod.util.concurrency.PhasedTask
import java.util.concurrent.ExecutorService
import java.util.concurrent.Phaser

/**
 * A [GameTask] responsible for executing [gg.rsmod.game.model.entity.Npc]
 * cycle logic, in parallel.
 *
 * @author Tom <rspsmods@gmail.com>
 */
class ParallelNpcCycleTask(private val executor: ExecutorService) : GameTask {

    private val phaser = Phaser(1)

    override fun execute(world: World, service: GameService) {
        val worldNpcs = world.npcs
        val npcCount = worldNpcs.count()

        phaser.bulkRegister(npcCount)
        worldNpcs.forEach { n ->
            executor.execute {
                PhasedTask.run(phaser) {
                    n.cycle()
                }
            }
        }
        phaser.arriveAndAwaitAdvance()
    }
}