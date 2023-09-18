package nl.daanbrocatus.comfycommands.commands.perms

import nl.daanbrocatus.comfycommands.commands.CommandHelper
import nl.daanbrocatus.comfycommands.constants.CommandNames
import nl.daanbrocatus.comfycommands.utils.PermissionsUtil
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class ClearPerms: CommandExecutor {
    private val commandHelper = CommandHelper()
    private val commandName = CommandNames().CLEARPERMS
    private val permissionsUtil = PermissionsUtil()

    override fun onCommand(sender: CommandSender, command: Command, p2: String, args: Array<out String>?): Boolean {
        if(!commandHelper.doesPlayerHavePermission(sender, commandName)) {
            return false
        }

        if (args != null && args.size == 1) {
            permissionsUtil.clearPermission(args[0])
            sender.sendMessage("${ChatColor.GREEN}$ ${args[0]}'s permissions cleared!")
        } else {
            sender.sendMessage("${ChatColor.RED}$ Please provide an argument!")
            return false
        }

        return true
    }
}