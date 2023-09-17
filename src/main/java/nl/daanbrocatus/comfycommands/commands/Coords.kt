package nl.daanbrocatus.comfycommands.commands

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.Location
import org.bukkit.entity.Player
import kotlin.math.roundToInt

class Coords: CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, p2: String, args: Array<out String>?): Boolean {
        if(sender !is Player) {
            sender.sendMessage("${ChatColor.RED}$ Sender needs to be a player!")
            return false
        }

        if (args != null && args.size == 1) {
            val playerName = args[0]
            val player = Bukkit.getServer().getPlayer(playerName)
            if(player == null) {
                sender.sendMessage("${ChatColor.RED}$ Player with name '$playerName' not found!")
                return false
            }
            sender.sendMessage("${ChatColor.GREEN}$ $playerName's coordinates are: ${ChatColor.BOLD}${getCoords(player.location)}")
        } else {
            sender.sendMessage("${ChatColor.RED}$ Please provide a player's username as an argument.")
            return false
        }
        return true
    }

    private fun getCoords(location: Location): String {
        val x = location.x.roundToInt().toString()
        val y = location.y.roundToInt().toString()
        val z = location.z.roundToInt().toString()
        return "x: $x y: $y z: $z"
    }
}