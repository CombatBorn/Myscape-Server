package gg.rsmod.game.service.cachemodifier.packers

import com.displee.cache.CacheLibrary
import com.displee.cache.ProgressListener
import net.runelite.cache.IndexType
import java.io.File
import java.lang.NumberFormatException
import java.nio.file.Files
import java.nio.file.Paths

class ModelPacker {

    companion object {

        val cacheLibrary = CacheLibrary("./data/cache/")
        val indexId: Int = IndexType.MODELS.number
        val index = cacheLibrary.index(indexId)
        val directory = "data/models/"

        @JvmStatic
        fun main (args: Array<String>) {
            val folder = File(directory)
            val files = folder.listFiles()
            if (files == null) {
                println("There are no dat files in the directory.")
                return
            }
            println("Attempting to pack ${files.size} models to the cache.")
            var packed = 0
            for (file in files) {
                if (file.extension == "dat") {
                    var modelId = -1
                    val data = Files.readAllBytes(Paths.get(file.absoluteFile.toURI()))
                    val fileName = file.nameWithoutExtension
                    try {
                        modelId = Integer.valueOf(fileName)
                    } catch (e: NumberFormatException) {
                        println("\"$fileName\" failed to pack, not a valid file name.")
                        continue
                    }
                    cacheLibrary.put(
                        index = indexId,
                        archive = modelId,
                        data = data
                    )
//                    println(data.map { it.toString() }.toTypedArray().contentToString())
                    println(" (!!) Packed Model \"$modelId\" to the cache.")
                    packed++
                }
            }
            if (packed == 0) {
                println("No valid files were found.")
                return
            }
            index.update(
                object : ProgressListener {
                    override fun notify(progress: Double, message: String?) {
                        println("Progress: $progress. Message: $message")
                    }
                }
            )
            println("Packed $packed files to the cache.")
        }
    }
}