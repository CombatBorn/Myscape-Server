package gg.rsmod.game.service.cachemodifier

import com.google.gson.Gson
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap
import mu.KLogging
import org.apache.commons.io.FilenameUtils
import java.io.FileNotFoundException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

/**
 * Loads and exposes XTEA keys required for map encryption.
 */
class XteaKeyServiceLite(private val xteasDir: String) {

    private val keys = Int2ObjectOpenHashMap<IntArray>()

    val validRegions: IntArray
        get() = keys.keys.toIntArray()

    fun init() {
        val path = Paths.get(xteasDir)
        if (!Files.exists(path)) {
            throw FileNotFoundException("Path does not exist. $path")
        }
        val singleFile = path.resolve("xteas.json")
        if (Files.exists(singleFile)) {
            loadSingleFile(singleFile)
        } else {
            loadDirectory(path)
        }
    }

    fun get(region: Int): IntArray {
        if (keys[region] == null) {
            logger.trace { "No XTEA keys found for region $region." }
            keys[region] = EMPTY_KEYS
        }
        return keys[region]!!
    }

    private fun loadSingleFile(path: Path) {
        val reader = Files.newBufferedReader(path)
        val xteas = Gson().fromJson(reader, Array<XteaFile>::class.java)
        reader.close()
        xteas?.forEach { xtea ->
            keys[xtea.region] = xtea.keys
        }
    }

    private fun loadDirectory(path: Path) {
        Files.list(path).forEach { list ->
            val region = FilenameUtils.removeExtension(list.fileName.toString()).toInt()
            val keys = IntArray(4)
            Files.newBufferedReader(list).useLines { lines ->
                lines.forEachIndexed { index, line ->
                    val key = line.toInt()
                    keys[index] = key
                }
            }
            this.keys[region] = keys
        }
    }

    private data class XteaFile(val region: Int, val keys: IntArray) {

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as XteaFile

            if (region != other.region) return false
            if (!keys.contentEquals(other.keys)) return false

            return true
        }
        override fun hashCode(): Int {
            var result = region
            result = 31 * result + keys.contentHashCode()
            return result
        }
    }

    companion object : KLogging() {
        val EMPTY_KEYS = intArrayOf(0, 0, 0, 0)
    }
}