package nl.daanbrocatus.comfycommands.models

import org.bukkit.ChatColor

data class CoordItem(
        val name: String,
        val x: Int,
        val y: Int,
        val z: Int
) {
    override fun toString(): String {
        return "${ChatColor.BOLD}$name: ${ChatColor.RESET}x: $x, y: $y, z: $y"
    }
}
