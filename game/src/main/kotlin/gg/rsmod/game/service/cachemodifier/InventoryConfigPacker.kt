import com.displee.cache.CacheLibrary
import com.displee.cache.ProgressListener
import gg.rsmod.game.fs.def.InventoryDef
import gg.rsmod.game.service.cachemodifier.MapCachePacker
import net.runelite.cache.IndexType

class InventoryConfigPacker {
    fun pack(cache: CacheLibrary){
        MapCachePacker.logger.info { "Patching in custom inventory configs." }
        addCustomItemContainer("Slayer Reward Shop", 20000, 50, cache)
    }

    private fun addCustomItemContainer(name: String, id: Int, capacity: Int, cache: CacheLibrary) {
        val def = InventoryDef(id)
        def.capacity = capacity

        // turn Inventory Definition Object into ByteArray
        val data = def.encode()

        // store into cache
        cache.put(index = IndexType.CONFIGS.number, archive = 5, file = def.id, data = data)
        MapCachePacker.logger.info { "Custom Item Container '$name' (#${def.id}) added." }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val cache = CacheLibrary("./data/cache/")
            // put into cache
            InventoryConfigPacker().pack(cache)
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