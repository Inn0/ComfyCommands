package nl.daanbrocatus.comfycommands.listeners

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.World
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
        var world = ""

        when (event.player.world.environment) {
            World.Environment.THE_END -> world = "End"
            World.Environment.NETHER -> world = "Nether"
            else -> world = "Overworld"
        }

        Bukkit.broadcastMessage("${ChatColor.LIGHT_PURPLE}$ ${event.player.name} died at ${ChatColor.BOLD}x: $x, y: $y, z: $z${ChatColor.RESET}${ChatColor.LIGHT_PURPLE}! ($world). What a noob!")
    }
}