package nl.daanbrocatus.comfycommands.commands

import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class Heal : CommandExecutor {
    private val commandHelper = CommandHelper()

    override fun onCommand(sender: CommandSender, command: Command, p2: String, p3: Array<out String>?): Boolean {
        if(sender !is Player) {
            sender.sendMessage("${ChatColor.RED}$ You are not a player!")
            return false
        }

        if(!commandHelper.isPlayerAdmin(sender.name)) {
            sender.sendMessage("${ChatColor.RED}$ Daan does not allow you to use that command!")
            return false
        }

        sender.health = 20.0
        sender.sendMessage("${ChatColor.GREEN}$ Healed player health to 20.0.")
        return true
    }
}