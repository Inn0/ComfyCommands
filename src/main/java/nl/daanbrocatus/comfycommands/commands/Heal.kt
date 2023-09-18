package nl.daanbrocatus.comfycommands.commands

import nl.daanbrocatus.comfycommands.constants.CommandNames
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class Heal : CommandExecutor {
    private val commandName = CommandNames().HEAL
    private val commandHelper = CommandHelper()

    override fun onCommand(sender: CommandSender, command: Command, p2: String, p3: Array<out String>?): Boolean {
        if(sender !is Player) {
            return false
        }

        if(!commandHelper.doesPlayerHavePermission(sender, commandName)) {
            return false
        }

        sender.health = 20.0
        sender.saturation = 20.0f
        sender.sendMessage("${ChatColor.GREEN}$ Healed player health to 20.0.")
        return true
    }
}