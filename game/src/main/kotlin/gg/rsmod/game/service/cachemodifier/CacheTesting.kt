package gg.rsmod.game.service.cachemodifier

import com.displee.cache.CacheLibrary
import com.displee.cache.ProgressListener
import com.displee.cache.index.Index
import mu.KLogging
import net.runelite.cache.IndexType
import java.io.File

class CacheTesting(
    private val cacheLibrary: CacheLibrary,
    private val getDirectory: (subDir: String) -> File
) {

    fun test(index: Index){

    }

    companion object : KLogging() {
        @JvmStatic
        fun main(args: Array<String>) {
            val lib = CacheLibrary("./data/cache/")
            val index = lib.index(IndexType.MAPS.number)
            CacheTesting(
                cacheLibrary = lib,
                getDirectory = { subdir -> File("./data/cache/$subdir") }
            ).test(index)
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