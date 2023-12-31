package nl.daanbrocatus.comfycommands.commands.coords

import nl.daanbrocatus.comfycommands.commands.CommandHelper
import nl.daanbrocatus.comfycommands.constants.CommandNames
import nl.daanbrocatus.comfycommands.utils.CoordUtil
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class ListCoords: CommandExecutor {
    private val commandName = CommandNames().LISTCOORDS
    private val coordUtil = CoordUtil()
    private val commandHelper = CommandHelper()

    override fun onCommand(sender: CommandSender, command: Command, p2: String, args: Array<out String>?): Boolean {
        if(!commandHelper.doesPlayerHavePermission(sender, commandName)) {
            return false
        }

        if (args != null && args.size == 1) {
            getList(sender, args[0])
        } else {
            getList(sender, sender.name)
        }

        return true
    }

    private fun getList(sender: CommandSender, player: String) {
        sender.sendMessage("${ChatColor.GREEN}${ChatColor.BOLD}-+- ${player}'s saved coordinates -+-")
        coordUtil.readCoordinates(player)?.forEach { sender.sendMessage(it.toString()) }
        sender.sendMessage("${ChatColor.GREEN}${ChatColor.BOLD}-+--+--+--+--+--+--+--+--+--+--+--+--+-")
    }
}