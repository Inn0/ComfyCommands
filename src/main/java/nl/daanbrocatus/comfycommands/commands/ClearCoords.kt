package nl.daanbrocatus.comfycommands.commands

import nl.daanbrocatus.comfycommands.utils.CoordUtil
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class ClearCoords: CommandExecutor {
    private val coordUtil = CoordUtil()

    override fun onCommand(sender: CommandSender, command: Command, p2: String, args: Array<out String>?): Boolean {
        if(sender !is Player) {
            sender.sendMessage("${ChatColor.RED}$ Sender needs to be a player!")
            return false
        }

        coordUtil.clearCoordinates(sender.name)
        sender.sendMessage("${ChatColor.GREEN}$ Coordinates cleared!")
        return true
    }
}