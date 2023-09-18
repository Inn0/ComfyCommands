package nl.daanbrocatus.comfycommands.commands.coords

import nl.daanbrocatus.comfycommands.commands.CommandHelper
import nl.daanbrocatus.comfycommands.constants.CommandNames
import nl.daanbrocatus.comfycommands.utils.CoordUtil
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class ClearCoords: CommandExecutor {
    private val coordUtil = CoordUtil()
    private val commandHelper = CommandHelper()
    private val commandName = CommandNames().CLEARCOORDS

    override fun onCommand(sender: CommandSender, command: Command, p2: String, args: Array<out String>?): Boolean {
        if(!commandHelper.doesPlayerHavePermission(sender, commandName)) {
            return false
        }

        coordUtil.clearCoordinates(sender.name)
        sender.sendMessage("${ChatColor.GREEN}$ Coordinates cleared!")
        return true
    }
}