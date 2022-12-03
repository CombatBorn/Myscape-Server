package gg.rsmod.game.model.droptable

/**
 * Monsters drop 1 item at random per successful drop table roll
 * dropTables = HashMap<Drop Rate, List of DropTableItems>
 */
class NpcDropTable(var dropTables: HashMap<Int, List<DropTableItem>>?) {
    fun generateDrops(): ArrayList<DropTableItem> {
        val drops = ArrayList<DropTableItem>()
        // key 0 will always drop each element
        dropTables?.get(0)?.forEach { tableItem ->
            drops.add(tableItem)
        }
        // iterate through each drop table
        for (table: Int in dropTables?.keys!!) {
            if (table == 0) {
                continue
            }
            // check if the drop table succeeds
            var random = (Math.random() * table).toInt() + 1
            if (random <= 1) {
                // select a drop at random to add to the drops
                val randomDrop = (Math.random() * dropTables?.get(table)?.size!!).toInt()
                dropTables?.get(table)?.get(randomDrop)?.let {
                    drops.add(it)
                }
            }
        }
        return drops
    }
}