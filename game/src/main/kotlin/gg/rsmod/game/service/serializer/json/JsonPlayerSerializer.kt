package gg.rsmod.game.service.serializer.json

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import gg.rsmod.game.Server
import gg.rsmod.game.model.PlayerUID
import gg.rsmod.game.model.Tile
import gg.rsmod.game.model.World
import gg.rsmod.game.model.appearance.Appearance
import gg.rsmod.game.model.appearance.Gender
import gg.rsmod.game.model.attr.AttributeKey
import gg.rsmod.game.model.container.ItemContainer
import gg.rsmod.game.model.entity.Client
import gg.rsmod.game.model.entity.VirtualWallet
import gg.rsmod.game.model.interf.DisplayMode
import gg.rsmod.game.model.item.Item
import gg.rsmod.game.model.priv.Privilege
import gg.rsmod.game.model.slayer.Assignments
import gg.rsmod.game.model.slayer.SlayerTaskType
import gg.rsmod.game.model.timer.TimerKey
import gg.rsmod.game.service.serializer.PlayerLoadResult
import gg.rsmod.game.service.serializer.PlayerSerializerService
import gg.rsmod.net.codec.login.LoginRequest
import gg.rsmod.util.ServerProperties
import mu.KLogging
import org.mindrot.jbcrypt.BCrypt
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.*

/**
 * A [PlayerSerializerService] implementation that decodes and encodes player
 * data in JSON.
 *
 * @author Tom <rspsmods@gmail.com>
 */
class JsonPlayerSerializer : PlayerSerializerService() {

    private lateinit var path: Path

    override fun initSerializer(server: Server, world: World, serviceProperties: ServerProperties) {
        path = Paths.get(serviceProperties.getOrDefault("path", "./data/saves/"))
        if (!Files.exists(path)) {
            Files.createDirectory(path)
            logger.info("Path does not exist: $path, creating directory...")
        }
    }

    override fun loadClientData(client: Client, request: LoginRequest): PlayerLoadResult {
        val save = path.resolve(client.loginUsername)
        if (!Files.exists(save)) {
            configureNewPlayer(client, request)
            client.uid = PlayerUID(client.loginUsername)
            saveClientData(client)
            return PlayerLoadResult.NEW_ACCOUNT
        }
        try {
            val world = client.world
            val reader = Files.newBufferedReader(save)
            val json = Gson()
            val data = json.fromJson(reader, JsonPlayerSaveData::class.java)
            reader.close()

            if (!request.reconnecting) {
                /*
                 * If the [request] is not a [LoginRequest.reconnecting] request, we have to
                 * verify the password is correct.
                 */
                if (!BCrypt.checkpw(request.password, data.passwordHash)) {
                    return PlayerLoadResult.INVALID_CREDENTIALS
                }
            } else {
                /*
                 * If the [request] is a [LoginRequest.reconnecting] request, we
                 * verify that the login xteas match from our previous session.
                 */
                if (!Arrays.equals(data.previousXteas, request.xteaKeys)) {
                    return PlayerLoadResult.INVALID_RECONNECTION
                }
            }

            client.loginUsername = data.username
            client.uid = PlayerUID(data.username)
            client.username = data.displayName
            client.passwordHash = data.passwordHash
            client.tile = Tile(data.x, data.z, data.height)
            client.privilege = world.privileges.get(data.privilege) ?: Privilege.DEFAULT
            client.runEnergy = data.runEnergy
            client.interfaces.displayMode = DisplayMode.values.firstOrNull { it.id == data.displayMode } ?: DisplayMode.FIXED
            client.virtualWallet = VirtualWallet(data.wallet.bountyHunterPoints, data.wallet.slayerPoints, data.wallet.achievementPoints, data.wallet.prestigePoints)
            client.slayerTask = client.loadSlayerData(
                masterId = data.slayerData.masterId,
                assignment = Assignments.valueOf(data.slayerData.assignment.assignmentName),
                type = SlayerTaskType.valueOf(data.slayerData.type),
                remaining = data.slayerData.remaining,
                extended = data.slayerData.extended
            )
            client.favoriteList = listOf(
                Assignments.valueOf(data.slayerData.favorites[0].assignmentName),
                Assignments.valueOf(data.slayerData.favorites[1].assignmentName),
                Assignments.valueOf(data.slayerData.favorites[2].assignmentName),
                Assignments.valueOf(data.slayerData.favorites[3].assignmentName),
                Assignments.valueOf(data.slayerData.favorites[4].assignmentName)
            )
            client.blockList = listOf(
                Assignments.valueOf(data.slayerData.blocked[0].assignmentName),
                Assignments.valueOf(data.slayerData.blocked[1].assignmentName),
                Assignments.valueOf(data.slayerData.blocked[2].assignmentName),
                Assignments.valueOf(data.slayerData.blocked[3].assignmentName),
                Assignments.valueOf(data.slayerData.blocked[4].assignmentName)
            )
            client.slayerStreak = data.slayerData.streak
            client.appearance = Appearance(data.appearance.looks, data.appearance.colors, Gender.values.firstOrNull { it.id == data.appearance.gender } ?: Gender.MALE)

            data.skills.forEach { skill ->
                client.getSkills().setPrestige(skill.skill, skill.prestige)
                client.getSkills().setXp(skill.skill, skill.xp)
                client.getSkills().setTemporaryLevel(skill.skill, skill.lvl)
            }
            data.itemContainers.forEach {
                val key = world.plugins.containerKeys.firstOrNull { other -> other.name == it.name }
                if (key == null) {
                    logger.error { "Container was found in serialized data, but is not registered to our World. [key=${it.name}]" }
                    return@forEach
                }
                val container = if (client.containers.containsKey(key)) client.containers[key] else {
                    client.containers[key] = ItemContainer(client.world.definitions, key)
                    client.containers[key]
                }!!
                it.items.forEach { slot, item ->
                    container[slot] = item
                }
            }
            data.attributes.forEach { (key, value) ->
                val attribute = AttributeKey<Any>(key)
                client.attr[attribute] = if (value is Double) value.toInt() else value
            }
            data.timers.forEach { timer ->
                var time = timer.timeLeft
                if (timer.tickOffline) {
                    val elapsed = System.currentTimeMillis() - timer.currentMs
                    val ticks = (elapsed / client.world.gameContext.cycleTime).toInt()
                    time -= ticks
                }
                val key = TimerKey(timer.identifier, timer.tickOffline)
                client.timers[key] = Math.max(0, time)
            }
            data.varps.forEach { varp ->
                client.varps.setState(varp.id, varp.state)
            }

            client.social = data.social

            return PlayerLoadResult.LOAD_ACCOUNT
        } catch (e: Exception) {
            logger.error(e) { "Error when loading player: ${request.username}" }
            return PlayerLoadResult.MALFORMED
        }
    }

    override fun saveClientData(client: Client): Boolean {
        val data = JsonPlayerSaveData(passwordHash = client.passwordHash, username = client.loginUsername, previousXteas = client.currentXteaKeys,
            displayName = client.username, x = client.tile.x, z = client.tile.z, height = client.tile.height,
            privilege = client.privilege.id, runEnergy = client.runEnergy, displayMode = client.interfaces.displayMode.id,
            wallet = client.getPersistentWallet(), slayerData = client.getPersistentSlayerData(), appearance = client.getPersistentAppearance(),
            skills = client.getPersistentSkills(), itemContainers = client.getPersistentContainers(), attributes = client.attr.toPersistentMap(),
            timers = client.timers.toPersistentTimers(), varps = client.varps.getAll().filter { it.state != 0 }, social = client.social)
        val writer = Files.newBufferedWriter(path.resolve(client.loginUsername))
        val json = GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create()
        json.toJson(data, writer)
        writer.close()
        return true
    }

    private fun Client.getPersistentContainers(): List<PersistentContainer> {
        val persistent = mutableListOf<PersistentContainer>()

        containers.forEach { (key, container) ->
            if (!container.isEmpty) {
                persistent.add(PersistentContainer(key.name, container.toMap()))
            }
        }

        return persistent
    }

    private fun Client.getPersistentSkills(): List<PersistentSkill> {
        val skills = mutableListOf<PersistentSkill>()

        for (i in 0 until getSkills().maxSkills) {
            val xp = getSkills().getCurrentXp(i)
            val lvl = getSkills().getCurrentLevel(i)
            val prestige = getSkills().getPrestige(i)

            skills.add(PersistentSkill(skill = i, xp = xp, lvl = lvl, prestige = prestige))
        }

        return skills
    }

    private fun Client.getPersistentAppearance(): PersistentAppearance = PersistentAppearance(appearance.gender.id, appearance.looks, appearance.colors)

    private fun Client.getPersistentWallet(): PersistentWallet = PersistentWallet(virtualWallet.bountyHunterPoints,
        virtualWallet.slayerPoints, virtualWallet.achievementPoints, virtualWallet.prestigePoints)

    private fun Client.getPersistentSlayerData(): PersistentSlayerData {
        val persistentFavoriteList = listOf(
            PersistentAssignment(favoriteList[0].name),
            PersistentAssignment(favoriteList[1].name),
            PersistentAssignment(favoriteList[2].name),
            PersistentAssignment(favoriteList[3].name),
            PersistentAssignment(favoriteList[4].name)
        )
        val persistentBlockList = listOf(
            PersistentAssignment(blockList[0].name),
            PersistentAssignment(blockList[1].name),
            PersistentAssignment(blockList[2].name),
            PersistentAssignment(blockList[3].name),
            PersistentAssignment(blockList[4].name)
        )
        if (slayerTask != null) {
            val persistentAssignment = PersistentAssignment(slayerTask!!.assignment.name)
            return PersistentSlayerData(
                assignment = persistentAssignment,
                masterId = slayerTask!!.slayerMaster.id,
                type = slayerTask!!.type.name,
                remaining = slayerTask!!.remaining,
                extended = slayerTask!!.extended,
                streak = slayerStreak,
                favorites = persistentFavoriteList,
                blocked = persistentBlockList
            )
        } else {
            val persistentAssignment = PersistentAssignment(Assignments.NONE.name)
            return PersistentSlayerData(
                assignment = persistentAssignment,
                masterId = -1,
                type = SlayerTaskType.EASY.name,
                remaining = -1,
                extended = -1,
                streak = slayerStreak,
                favorites = persistentFavoriteList,
                blocked = persistentBlockList
            )
        }
    }

    data class PersistentWallet(@JsonProperty("bountyHunterPoints") val bountyHunterPoints: Int,
                                @JsonProperty("slayerPoints") val slayerPoints: Int,
                                @JsonProperty("achievementPoints") val achievementPoints: Int,
                                @JsonProperty("prestigePoints") val prestigePoints: Int)
    data class PersistentSlayerData(@JsonProperty("assignment") val assignment: PersistentAssignment,
                                    @JsonProperty("masterId") val masterId: Int,
                                    @JsonProperty("type") val type: String,
                                    @JsonProperty("remaining") val remaining: Int,
                                    @JsonProperty("extended") val extended: Int,
                                    @JsonProperty("streak") val streak: Int,
                                    @JsonProperty("favorites") val favorites: List<PersistentAssignment>,
                                    @JsonProperty("blocked") val blocked: List<PersistentAssignment>)
    data class PersistentAssignment(@JsonProperty("assignmentName") val assignmentName: String)
    data class PersistentAppearance(@JsonProperty("gender") val gender: Int,
                                    @JsonProperty("looks") val looks: IntArray,
                                    @JsonProperty("colors") val colors: IntArray)
    data class PersistentContainer(@JsonProperty("name") val name: String,
                                   @JsonProperty("items") val items: Map<Int, Item>)
    data class PersistentSkill(@JsonProperty("skill") val skill: Int,
                               @JsonProperty("prestige") val prestige: Int,
                               @JsonProperty("xp") val xp: Double,
                               @JsonProperty("lvl") val lvl: Int)
    companion object : KLogging()
}
