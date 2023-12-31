package nl.daanbrocatus.comfycommands.listeners

import nl.daanbrocatus.comfycommands.ComfyCommands
import nl.daanbrocatus.comfycommands.commands.afk.AFKHelper
import nl.daanbrocatus.comfycommands.utils.PermissionsUtil
import org.bukkit.ChatColor
import org.bukkit.World
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent
import org.bukkit.scheduler.BukkitRunnable
import org.bukkit.scheduler.BukkitTask
import java.util.*
import kotlin.math.roundToInt

class PlayerJoinListener: Listener {
    private val permissionsUtil = PermissionsUtil()
    private val afkHelper = AFKHelper
    private val playerTasks = mutableMapOf<UUID, BukkitTask>()

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.player

        // Give the player default permissions if they don't already have permissions
        permissionsUtil.createDefaultPermissions(player.name)

        // Update the player's display name
        updateDisplayName(player)

        // Schedule a task to update the display name every 5 seconds
        val task = object : BukkitRunnable() {
            override fun run() {
                updateDisplayName(player)
            }
        }.runTaskTimer(ComfyCommands.instance, 0, 100L) // 100L = 5 seconds (20 ticks per second)

        playerTasks[player.uniqueId] = task
    }

    @EventHandler
    fun onPlayerQuit(event: PlayerQuitEvent) {
        playerTasks[event.player.uniqueId]?.cancel()
        playerTasks.remove(event.player.uniqueId)
    }

    private fun updateDisplayName(player: Player) {
        if(afkHelper.isAfk(player.name)) {
            return
        }
        var coordColor = ChatColor.DARK_GREEN
        when (player.world.environment) {
            World.Environment.NETHER -> coordColor = ChatColor.DARK_RED
            World.Environment.THE_END -> coordColor = ChatColor.DARK_PURPLE
            else -> coordColor = ChatColor.DARK_GREEN
        }

        val coordsString = "$coordColor(${player.location.x.roundToInt()}, ${player.location.y.roundToInt()}, ${player.location.z.roundToInt()})"
        val cleanPlayerDisplayName = removeParentheses(player.playerListName)
        val newPlayerDisplayName = cleanPlayerDisplayName.plus(coordsString)

        player.setPlayerListName(newPlayerDisplayName)
    }

    private fun removeParentheses(input: String): String {
        return input.replace(Regex("\\(.*?\\)"), "")
    }
}