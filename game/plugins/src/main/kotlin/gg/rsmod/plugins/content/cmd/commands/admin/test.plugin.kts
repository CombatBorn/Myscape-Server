import gg.rsmod.game.model.priv.Privilege
import gg.rsmod.plugins.content.cmd.Commands_plugin

on_command("tint", Privilege.ADMIN_POWER) {


    val args = player.getCommandArgs()
    Commands_plugin.Command.tryWithUsage(
        player,
        args,
        "Invalid format! Example of proper command <col=801700>::tint 0 100 100 100 100 1</col> or <col=801700>::item 4151</col>"
    ) { values ->
        player.message("Tint applied")
        player.applyTint(
            args[0].toInt(),
            args[1].toInt(),
            args[2].toInt(),
            args[3].toInt(),
            args[4].toInt(),
            args[5].toInt()
        )
    }
}

on_command("jad_size", Privilege.DEV_POWER) {
    val npc = Npc(Npcs.TZTOKJAD, Tile(2401, 5084, 0), world)
    println(npc.getSize())
}

on_command("barrows", Privilege.DEV_POWER) {
    BarrowsChest.open(player)
}

on_interface_close(155) {
    BarrowsChest.close(player)
}


object BarrowsChest{

    private val BARROWS_CONTAINER = AttributeKey<ItemContainer>()
    private val barrowsItems: List<Int> = listOf(Items.AHRIMS_HOOD, Items.AHRIMS_ROBETOP, Items.AHRIMS_ROBESKIRT, Items.AHRIMS_STAFF,
        Items.DHAROKS_HELM, Items.DHAROKS_PLATEBODY, Items.DHAROKS_PLATELEGS, Items.DHAROKS_GREATAXE,
        Items.KARILS_COIF, Items.KARILS_LEATHERTOP, Items.KARILS_LEATHERSKIRT, Items.KARILS_CROSSBOW,
        Items.GUTHANS_HELM, Items.GUTHANS_PLATEBODY, Items.GUTHANS_CHAINSKIRT, Items.GUTHANS_WARSPEAR,
        Items.TORAGS_HELM, Items.TORAGS_PLATEBODY, Items.TORAGS_PLATELEGS, Items.TORAGS_HAMMERS,
        Items.VERACS_HELM, Items.VERACS_BRASSARD, Items.VERACS_PLATESKIRT, Items.VERACS_FLAIL)
    fun open(player: Player){
        player.attr[BARROWS_CONTAINER] = ItemContainer(player.world.definitions, 12, ContainerStackType.STACK)
        player.openInterface(interfaceId = 155, dest = InterfaceDestination.MAIN_SCREEN)
        for (i in 1 .. 4){
            val item = (barrowsItems[(Math.random() * 24).toInt()])
            player.inventory.add(item)
            add(player, item)
        }
    }

    fun add(player: Player, item: Int) {
        val barrowsContainer = player.attr[BARROWS_CONTAINER] ?: return
        val add = barrowsContainer.add(item, 1, assureFullInsertion = false)
        if (add.completed == 0) {
            player.message("The barrows chest has no free space left.")
            return
        }
        update(player)
    }
    fun add(player: Player, items: List<Int>) {
        val barrowsContainer = player.attr[BARROWS_CONTAINER] ?: return
        var containerFull = false
        for (item in items){
            val add = barrowsContainer.add(item, 1, assureFullInsertion = false)
            if (add.completed == 0) {
                containerFull = true
                break
            }
        }
        if (containerFull){
            player.message("The barrows chest is too full for more loot.")
        }
        update(player)
    }

    fun update(player: Player) {
        val barrowsContainer = player.attr[BARROWS_CONTAINER] ?: return
        player.sendItemContainer(key = 141, container = barrowsContainer)
    }

    fun close(player: Player){
//        val barrowsContainer = player.attr[BARROWS_CONTAINER] ?: return
//        barrowsContainer.forEachIndexed { index, item ->
//            if (item != null) {
//                player.inventory.add(item.id, item.amount)
//            }
//        }
        player.attr.remove(BARROWS_CONTAINER)
    }
}
