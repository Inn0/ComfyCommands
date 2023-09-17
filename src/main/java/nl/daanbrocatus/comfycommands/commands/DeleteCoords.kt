package nl.daanbrocatus.comfycommands.commands

import nl.daanbrocatus.comfycommands.utils.CoordUtil
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class DeleteCoords: CommandExecutor {
    private val coordUtil = CoordUtil()

    override fun onCommand(sender: CommandSender, command: Command, p2: String, args: Array<out String>?): Boolean {
        if(sender !is Player) {
            sender.sendMessage("${ChatColor.RED}$ Sender needs to be a player!")
            return false
        }

        return if (args != null && args.size == 1) {
            try {
                coordUtil.deleteCoordinate(sender.name, args[0])
                sender.sendMessage("${ChatColor.GREEN}$ Coordinates labeled ${args[0]} deleted! (Only if they were present)")
                true
            } catch (e: Exception) {
                sender.sendMessage("${ChatColor.RED}$ There was an error deleting the coordinates! Did you misspell the name?")
                true
            }
        } else {
            sender.sendMessage("${ChatColor.RED}$ Please provide a name of the coordinates to delete!")
            false
        }
    }

}