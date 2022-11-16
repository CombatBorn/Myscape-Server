on_command("empty", description = "Empty all items from inventory") {
    player.queue(TaskPriority.STRONG) {
        emptyInventoryRequest()
    }
}
suspend fun QueueTask.emptyInventoryRequest() {
    when (options("yes", "no", title = "Empty all items in your inventory?")) {
        1 -> player.inventory.removeAll()
    }
}