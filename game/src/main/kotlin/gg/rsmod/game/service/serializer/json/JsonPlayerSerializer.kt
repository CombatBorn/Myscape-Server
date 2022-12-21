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
            client.slayerTask = client.loadSlayerData(data.slayerData.assignment.masterId, data.slayerData.assignment.assignmentId, data.slayerData.assignment.taskType,  data.slayerData.remaining)
            client.favoriteList = listOf(
                Triple(data.slayerData.favorites[0].masterId, data.slayerData.favorites[0].assignmentId, data.slayerData.favorites[0].taskType),
                Triple(data.slayerData.favorites[1].masterId, data.slayerData.favorites[1].assignmentId, data.slayerData.favorites[1].taskType),
                Triple(data.slayerData.favorites[2].masterId, data.slayerData.favorites[2].assignmentId, data.slayerData.favorites[2].taskType),
                Triple(data.slayerData.favorites[3].masterId, data.slayerData.favorites[3].assignmentId, data.slayerData.favorites[3].taskType),
                Triple(data.slayerData.favorites[4].masterId, data.slayerData.favorites[4].assignmentId, data.slayerData.favorites[4].taskType)
            )
            client.blockList = listOf(
                Triple(data.slayerData.blocked[0].masterId, data.slayerData.blocked[0].assignmentId, data.slayerData.blocked[0].taskType),
                Triple(data.slayerData.blocked[1].masterId, data.slayerData.blocked[1].assignmentId, data.slayerData.blocked[1].taskType),
                Triple(data.slayerData.blocked[2].masterId, data.slayerData.blocked[2].assignmentId, data.slayerData.blocked[2].taskType),
                Triple(data.slayerData.blocked[3].masterId, data.slayerData.blocked[3].assignmentId, data.slayerData.blocked[3].taskType),
                Triple(data.slayerData.blocked[4].masterId, data.slayerData.blocked[4].assignmentId, data.slayerData.blocked[4].taskType)
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
            PersistentAssignment(favoriteList[0].first, favoriteList[0].second, favoriteList[0].third),
            PersistentAssignment(favoriteList[1].first, favoriteList[1].second, favoriteList[1].third),
            PersistentAssignment(favoriteList[2].first, favoriteList[2].second, favoriteList[2].third),
            PersistentAssignment(favoriteList[3].first, favoriteList[3].second, favoriteList[3].third),
            PersistentAssignment(favoriteList[4].first, favoriteList[4].second, favoriteList[4].third)
        )
        val persistentBlockList = listOf(
            PersistentAssignment(blockList[0].first, blockList[0].second, blockList[0].third),
            PersistentAssignment(blockList[1].first, blockList[1].second, blockList[1].third),
            PersistentAssignment(blockList[2].first, blockList[2].second, blockList[2].third),
            PersistentAssignment(blockList[3].first, blockList[3].second, blockList[3].third),
            PersistentAssignment(blockList[4].first, blockList[4].second, blockList[4].third)
        )
        if (slayerTask != null) {
            val persistentAssignment = PersistentAssignment(slayerTask!!.slayerMaster.id, slayerTask!!.assignment.id, slayerTask!!.assignment.type.order)
            return PersistentSlayerData(persistentAssignment, slayerTask!!.remaining, slayerStreak, persistentFavoriteList, persistentBlockList)
        } else{
            return PersistentSlayerData(PersistentAssignment(-1,-1, -1), -1, slayerStreak, persistentFavoriteList, persistentBlockList)
        }
    }

    data class PersistentWallet(@JsonProperty("bountyHunterPoints") val bountyHunterPoints: Int,
                                @JsonProperty("slayerPoints") val slayerPoints: Int,
                                @JsonProperty("achievementPoints") val achievementPoints: Int,
                                @JsonProperty("prestigePoints") val prestigePoints: Int)
    data class PersistentSlayerData(@JsonProperty("assignment") val assignment: PersistentAssignment,
                                    @JsonProperty("remaining") val remaining: Int,
                                    @JsonProperty("streak") val streak: Int,
                                    @JsonProperty("favorites") val favorites: List<PersistentAssignment>,
                                    @JsonProperty("blocked") val blocked: List<PersistentAssignment>)
    data class PersistentAssignment(@JsonProperty("masterId") val masterId: Int,
                                    @JsonProperty("assignmentId") val assignmentId: Int,
                                    @JsonProperty("taskType") val taskType: Int)
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
