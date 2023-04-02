package gg.rsmod.game.model.entity

class SeagullCatcher {
    companion object {
        val catchableSeagulls: ArrayList<Npc> = ArrayList()
        fun addSeagull(npc: Npc) {
            catchableSeagulls.add(npc)
        }

    }

}