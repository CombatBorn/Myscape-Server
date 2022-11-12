package gg.rsmod.util

object PathingUtil {

    data class Box(val x: Int, val z: Int, val width: Int, val length: Int) {

        val x1: Int get() = x

        val x2: Int get() = (x + width - 1)

        val z1: Int get() = z

        val z2: Int get() = (z + length - 1)
    }

}