package nl.daanbrocatus.comfycommands.commands

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class Announce: CommandExecutor {
    private val commandHelper = CommandHelper()
    override fun onCommand(sender: CommandSender, command: Command, p2: String, args: Array<out String>?): Boolean {
        if(!commandHelper.isPlayerAdmin(sender.name)) {
            sender.sendMessage("${ChatColor.RED}$ Daan does not allow you to use that command!")
            return false
        }

        Bukkit.broadcastMessage("${ChatColor.BLUE}$ ${args?.joinToString(separator = " ")}")
        return true
    }

}