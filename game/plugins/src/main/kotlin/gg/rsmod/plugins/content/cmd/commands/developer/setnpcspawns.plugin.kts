import gg.rsmod.game.model.priv.Privilege
import java.io.File
import java.nio.file.Paths

val npcs: ArrayList<String> = ArrayList()

val npcId: HashMap<String, Int> = HashMap()
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
            player.message("No Npc ID set, please type <col=801700>::sns id NPCID</col> before running this command.")
            return@on_command
        }
        if (!npcWalkRadius.containsKey(player.username)) {
            player.message("No Npc Walk Raius is set, please type <col=801700>::sns walk RADIUS</col> before running this command.")
            return@on_command
        }
        val id = npcId[player.username]
        val walkRadius = npcWalkRadius[player.username]
        val x = player.tile.x
        val z = player.tile.z
        val height = player.tile.height
        val direction = player.lastFacingDirection

        // write to file
        writeLineToNpcsFile("spawn_npc(npc= $id,tile = Tile($x, $z, $height), walkRadius = $walkRadius, direction = Direction.$direction)")

        val npc = Npc(id!!, player.tile, world)
        world.spawn(npc)
        npc.lastFacingDirection = direction
        npc.walkRadius = walkRadius!!
        player.message("NPC Location stored for NPC ${world.definitions.get(NpcDef::class.java, id).name}")
    } else if (args.size == 2 && args[0].equals("id")) {
        val id = args[1].toInt()
        npcId[player.username] = id
        player.message("Np Id updated to <col=801700>${world.definitions.get(NpcDef::class.java, id).name} (#$id)</col>")
        writeLineToNpcsFile("// Npc: ${world.definitions.get(NpcDef::class.java, id).name} (#$id)")
    } else if (args.size == 2 && args[0].equals("walk")) {
        val walkRadius = args[1].toInt()
        npcWalkRadius[player.username] = walkRadius
        player.message("Walk radius updated to <col=801700>$walkRadius</col>")
    } else {
        player.message("Valid usages: <col=801700>::sns</col>, <col=801700>::sns id NPCID</col>, or <col=801700>::sns walk NPCID</col>.")
    }
}