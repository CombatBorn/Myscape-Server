package gg.rsmod.game.service.cachemodifier.packers

import com.displee.cache.CacheLibrary
import com.displee.cache.ProgressListener
import com.displee.cache.index.Index
import gg.rsmod.game.service.cachemodifier.XteaKeyServiceLite
import mu.KLogging
import net.runelite.cache.IndexType
import java.io.File

private const val MAPS_SUB_DIR = "customs/maps/"
private const val XTEAS_DIR = "C:\\Users\\home user\\Desktop\\files\\RSMod-rev205\\data"

class MapCachePacker(
        private val cacheLibrary: CacheLibrary,
        private val getDirectory: (subDir: String) -> File
) {
    private val xteaKeyServiceLite = XteaKeyServiceLite(XTEAS_DIR).also { it.init() }

    val indexId: Int = IndexType.MAPS.number

    fun pack(index: Index) {
        val customMapsDir = getDirectory(MAPS_SUB_DIR)
        val customMapsFiles = customMapsDir.listFiles()
        val proceed = customMapsDir.exists() && customMapsFiles?.isNotEmpty() == true
        if (!proceed) {
            logger.info { "No custom maps files found." }
            return
        }
        requireNotNull(customMapsFiles) // For the linter to stop complaining

        logger.info { "Patching in custom maps files. ${customMapsFiles.size} files to load." }

        for (regionId in 0 until Short.MAX_VALUE) {
            val x = regionId shr 8
            val z = regionId and 0xFF
            val mapArchiveName = "m${x}_$z"
            val landArchiveName = "l${x}_$z"
            // Update the map archive
            index.archive(mapArchiveName)?.let { mapArchive ->
                val archiveId = mapArchive.id
                val customFileForArchive = customMapsFiles.find { it.nameWithoutExtension == archiveId.toString() }
                if (customFileForArchive != null) {
                    cacheLibrary.put(
                            index = indexId,
                            archive = archiveId,
                            data = customFileForArchive.readBytes(),
                            xtea = null // xteaKeyServiceLite.get(regionId)
                    )
                    logger.info { "Custom file provided for map archive ID $archiveId (region ID: $regionId, name: $mapArchiveName). Patching it in." }
                }
            }
            index.archive(landArchiveName)?.let { landArchive ->
                val archiveId = landArchive.id
                val customFileForArchive = customMapsFiles.find { it.nameWithoutExtension == archiveId.toString() }
                if (customFileForArchive != null) {
                    cacheLibrary.put(
                            index = indexId,
                            archive = archiveId,
                            data = customFileForArchive.readBytes(),
                            xtea = xteaKeyServiceLite.get(regionId)
                    )
                    logger.info { "Custom file provided for map archive ID $archiveId (region ID: $regionId, name: $landArchiveName). Patching it in." }
                }
            }
        }
    }

    companion object : KLogging() {
        @JvmStatic
        fun main(args: Array<String>) {
            val lib = CacheLibrary("./data/cache/")
            val index = lib.index(IndexType.MAPS.number)
            MapCachePacker(
                    cacheLibrary = lib,
                    getDirectory = { subdir -> File("./data/cache/$subdir") }
            ).pack(index)
            index.update(
                    object : ProgressListener {
                        override fun notify(progress: Double, message: String?) {
                            println("Progress: $progress. Message: $message")
                        }
                    }
            )
        }
    }
}