//on_item_option(Items.ABYSSAL_TENTACLE, option = 4) {
//    player.queue {
//        when (options("Yes", "No", title = "Would you like to dissolve the tentacle whip back into an abyssal whip?")) {
//            1 -> {
//                if (player.inventory.contains(Items.ABYSSAL_TENTACLE)) {
//                    player.inventory.remove(Items.ABYSSAL_TENTACLE)
//                    player.inventory.add(Items.ABYSSAL_WHIP)
//                }
//            }
//            2 -> {
//                player.queue(TaskPriority.STRONG) {
//                    messageBox("You keep the Tentacle Whip")
//                }
//            }
//        }
//    }
//}
//
//can_drop_item(Items.ABYSSAL_TENTACLE) {
//    false
//}