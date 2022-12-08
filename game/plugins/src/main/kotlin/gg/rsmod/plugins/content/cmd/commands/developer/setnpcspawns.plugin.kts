import gg.rsmod.game.model.priv.Privilege
import java.io.File
import java.nio.file.Paths

val npcs: ArrayList<String> = ArrayList()

val npcId: HashMap<String, List<Int>> = HashMap()
val npcWalkRadius: HashMap<String, Int> = HashMap()

on_world_init {
    val path =
        Paths.get("./game/plugins/src/main/kotlin/gg/rsmod/plugins/content/npcs/npcs.plugin.kts").toAbsolutePath()
            .toString()
    File(path).readLines().forEach { line ->
        npcs.add(line)
    }
}

fun writeLineToNpcsFile(npcInfo: String) {
    npcs.add(npcInfo)
    updateNpcsFile()
}

fun updateNpcsFile(){
    val path = Paths.get("./game/plugins/src/main/kotlin/gg/rsmod/plugins/content/npcs/npcs.plugin.kts").toAbsolutePath().toString()
    var npcsString = ""
    for (npc in npcs) {
        npcsString = if (npcsString == "") {
            npc
        } else {
            "$npcsString\n$npc"
        }
    }
    File(path).bufferedWriter().use {
        it.write(npcsString)
    }
}

on_command("sns", Privilege.DEV_POWER, "Set Npc Spawn location to your current position.") {
    val args = player.getCommandArgs()
    // attempt to spawn a NPC in
    if (args.isEmpty()) {
        if (!npcId.containsKey(player.username)) {
            player.message("No Npc ID set, please type <col=801700>::sns id NPCID</col> or <col=801700>::sns taskId TASKID</col> before running this command.")
            return@on_command
        }
        var walkRadius = 5
        if (npcWalkRadius.containsKey(player.username)) {
            walkRadius = npcWalkRadius[player.username]!!
            return@on_command
        }
        val random = (Math.random() * npcId[player.username]!!.size).toInt()
        val id = npcId[player.username]!![random]
        val x = player.tile.x
        val z = player.tile.z
        val height = player.tile.height
        val direction = player.lastFacingDirection

        // write to file
        writeLineToNpcsFile("spawn_npc(npc= $id,tile = Tile($x, $z, $height), walkRadius = $walkRadius, direction = Direction.$direction)")

        val npc = Npc(id, player.tile, world)
        world.spawn(npc)
        npc.lastFacingDirection = direction
        npc.walkRadius = walkRadius!!
        player.message("NPC Location stored for NPC ${world.definitions.get(NpcDef::class.java, id).name}")
    } else if (args.size >= 2 && args[0] == "id") {
        val ids: ArrayList<Int> = ArrayList()
        var npcs = ""
        for (index in args.indices){
            if (index == 0) continue
            val id = args[index].toInt()
            ids.add(id)
            npcs += "${world.definitions.get(NpcDef::class.java,id).name} (#$id) "
        }
        npcId[player.username] = ids
        player.message("Npc Id updated to <col=801700>$npcs</col>")
        writeLineToNpcsFile("// Npc: $npcs")
    } else if (args.size == 2 && args[0] == "taskid") {
        val id = args[1].toInt()
        var found = false
        for (masterId in world.slayerMasters.keys){
            for (task in world.slayerMasters[masterId]?.keys!!){
                val npcs = world.slayerMasters[masterId]?.get(task)
                for (npc in npcs!!.tasks){
                    if (npc.taskId == id){
                        npcId[player.username] = npc.npcIds!!
                        found = true
                        break
                    }
                }
            }
        }
        for (masterID in world.slayerMasters.keys) {
            for (taskType in world.slayerMasters[masterID]?.keys!!) {
                for (task in world.slayerMasters[masterID]?.get(taskType)?.tasks!!) {
                    if (task.taskId == id){
                        npcId[player.username] = task.npcIds!!
                        found = true
                        break
                    }
                }
            }
        }
        if (found){
            val name = world.definitions.get(NpcDef::class.java, npcId[player.username]?.get(0)!!).name
            player.message("Npc Id updated to random <col=801700>$name</col> Slayer NPCs")
            writeLineToNpcsFile("// Npc: $name (Slayer)")
        }else{
            player.message("There was no TaskId found for ID #$id.")
        }
    } else if (args.size == 2 && args[0] == "walk") {
        val walkRadius = args[1].toInt()
        npcWalkRadius[player.username] = walkRadius
        player.message("Walk radius updated to <col=801700>$walkRadius</col>")
    } else {
        player.message("Valid usages: <col=801700>::sns</col>, <col=801700>::sns id NPCID</col>, or <col=801700>::sns walk NPCID</col>.")
    }
}