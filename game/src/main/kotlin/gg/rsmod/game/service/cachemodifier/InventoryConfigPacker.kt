import com.displee.cache.CacheLibrary
import com.displee.cache.ProgressListener
import com.displee.cache.index.Index
import gg.rsmod.game.fs.def.InventoryDef
import gg.rsmod.game.service.cachemodifier.MapCachePacker
import net.runelite.cache.IndexType

class InventoryConfigPacker {
    fun pack(cache: CacheLibrary, index: Index){

        MapCachePacker.logger.info { "Patching in custom inventory configs." }

        // define Inventory Definition Object
        val def = InventoryDef(20000)
        def.capacity = 200

        // turn Inventory Definition Object into ByteArray
        val data = def.encode()

        // put into cache
        cache.put(index = IndexType.CONFIGS.number, archive = 5, file = def.id, data = data)
        MapCachePacker.logger.info { "Custom inventory config ${def.id} added." }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val cache = CacheLibrary("./data/cache/")
            val index = cache.index(IndexType.MAPS.number)
            // put into cache
            InventoryConfigPacker().pack(cache, index)
            // pack (save)
            cache.index(IndexType.CONFIGS.number).update(
                object : ProgressListener {
                    override fun notify(progress: Double, message: String?) {
                        println("Progress: $progress. Message: $message")
                    }
                }
            )
        }
    }
}