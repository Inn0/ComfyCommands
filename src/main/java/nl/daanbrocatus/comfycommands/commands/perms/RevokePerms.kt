package nl.daanbrocatus.comfycommands.commands.perms

import nl.daanbrocatus.comfycommands.commands.CommandHelper
import nl.daanbrocatus.comfycommands.constants.CommandNames
import nl.daanbrocatus.comfycommands.utils.PermissionsUtil
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class RevokePerms: CommandExecutor {
    private val commandName = CommandNames().REVOKEPERMS
    private val commandHelper = CommandHelper()
    private val permissionsUtil = PermissionsUtil()

    override fun onCommand(sender: CommandSender, command: Command, p2: String, args: Array<out String>?): Boolean {
        if(!commandHelper.doesPlayerHavePermission(sender, commandName)) {
            return false
        }

        if (args != null && args.size == 2) {
            permissionsUtil.removePermission(args[0], args[1])
            sender.sendMessage("${ChatColor.GREEN}$ Revoked ${args[0]}'s permission to use /${args[1]}!")
        } else {
            sender.sendMessage("${ChatColor.RED}$ Please provide two arguments!")
            return false
        }

        return true
    }

}