package nl.daanbrocatus.comfycommands.listeners

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent
import kotlin.math.roundToInt

class PlayerDeathListener : Listener {
    @EventHandler
    fun onPlayerDeath(event: PlayerDeathEvent) {
        val x = event.player.location.x.roundToInt()
        val y = event.player.location.y.roundToInt()
        val z = event.player.location.z.roundToInt()
        Bukkit.broadcastMessage("${ChatColor.LIGHT_PURPLE}$ ${event.player.name} died at ${ChatColor.BOLD}x: $x, y: $y, z: $z${ChatColor.RESET}${ChatColor.LIGHT_PURPLE}!")
    }
}