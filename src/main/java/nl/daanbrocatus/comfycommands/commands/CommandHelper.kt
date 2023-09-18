package nl.daanbrocatus.comfycommands.commands

import nl.daanbrocatus.comfycommands.utils.PermissionsUtil
import org.bukkit.ChatColor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class CommandHelper {
    private val permissionsUtil = PermissionsUtil()

    fun doesPlayerHavePermission(sender: CommandSender, permission: String): Boolean {
        return if(!permissionsUtil.hasPermission(sender.name, permission)) {
            sender.sendMessage("${ChatColor.RED}$ You do not have permission to use this command!")
            false
        } else {
            isSenderPlayer(sender)
        }
    }

    private fun isSenderPlayer(sender: CommandSender): Boolean {
        return if(sender !is Player) {
            sender.sendMessage("${ChatColor.RED}$ Sender needs to be a player!")
            false
        } else true
    }
}