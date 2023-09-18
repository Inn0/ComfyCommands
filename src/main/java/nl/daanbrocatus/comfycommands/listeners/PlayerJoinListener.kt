package nl.daanbrocatus.comfycommands.listeners

import nl.daanbrocatus.comfycommands.ComfyCommands
import nl.daanbrocatus.comfycommands.utils.PermissionsUtil
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.World
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.scheduler.BukkitRunnable
import kotlin.math.roundToInt

class PlayerJoinListener: Listener {
    private val permissionsUtil = PermissionsUtil()

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.player

        // Give the player default permissions if they don't already have permissions
        permissionsUtil.createDefaultPermissions(player.name)

        // Update the player's display name
        updateDisplayName(player)

        // Schedule a task to update the display name every 5 seconds
        object : BukkitRunnable() {
            override fun run() {
                updateDisplayName(player)
            }
        }.runTaskTimer(ComfyCommands.instance, 0, 100L) // 100L = 5 seconds (20 ticks per second)
    }

    private fun updateDisplayName(player: Player) {
        var coordColor = ChatColor.DARK_GREEN
        when (player.world.environment) {
            World.Environment.NETHER -> coordColor = ChatColor.DARK_RED
            World.Environment.THE_END -> coordColor = ChatColor.DARK_PURPLE
            else -> coordColor = ChatColor.DARK_GREEN
        }

        val coordsString = " $coordColor(${player.location.x.roundToInt()}, ${player.location.y.roundToInt()}, ${player.location.z.roundToInt()})"
        val cleanPlayerDisplayName = removeParentheses(player.displayName)
        println("Cleaned display name: $cleanPlayerDisplayName")
        val newPlayerDisplayName = cleanPlayerDisplayName.plus(coordsString)
        println("Displayname with coords: $newPlayerDisplayName")

        player.setPlayerListName(newPlayerDisplayName)
    }

    private fun removeParentheses(input: String): String {
        return input.replace(Regex("\\(.*?\\)"), "")
    }
}