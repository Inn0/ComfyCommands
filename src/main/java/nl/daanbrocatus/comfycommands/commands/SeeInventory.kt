package nl.daanbrocatus.comfycommands.commands

import nl.daanbrocatus.comfycommands.constants.CommandNames
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class SeeInventory: CommandExecutor {
    private val commandName = CommandNames().SEEINVENTORY
    private val commandHelper = CommandHelper()

    override fun onCommand(sender: CommandSender, command: Command, p2: String, args: Array<out String>?): Boolean {
        if(sender !is Player) {
            return false
        }

        if(!commandHelper.doesPlayerHavePermission(sender, commandName)) {
            return false
        }

        val targetName = args?.get(0)
        val target = targetName?.let { Bukkit.getPlayerExact(it) }

        if (target == null) {
            return false
        }

        sender.openInventory(target.inventory)
        return true
    }
}