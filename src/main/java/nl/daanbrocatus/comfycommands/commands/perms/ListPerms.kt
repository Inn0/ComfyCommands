package nl.daanbrocatus.comfycommands.commands.perms

import nl.daanbrocatus.comfycommands.commands.CommandHelper
import nl.daanbrocatus.comfycommands.constants.CommandNames
import nl.daanbrocatus.comfycommands.utils.PermissionsUtil
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class ListPerms: CommandExecutor {
    private val commandHelper = CommandHelper()
    private val commandName = CommandNames().LISTPERMS
    private val permissionsUtil = PermissionsUtil()

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
        sender.sendMessage("${ChatColor.GREEN}${ChatColor.BOLD}-+- ${player}'s permissions -+-")
        permissionsUtil.readPermissions(player)?.forEach { sender.sendMessage(it) }
        sender.sendMessage("${ChatColor.GREEN}${ChatColor.BOLD}-+--+--+--+--+--+--+--+--+--+--+-")
    }
}