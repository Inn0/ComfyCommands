package nl.daanbrocatus.comfycommands.commands.afk

import nl.daanbrocatus.comfycommands.commands.CommandHelper
import nl.daanbrocatus.comfycommands.constants.CommandNames
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class AFKList: CommandExecutor {
    private val afkHelper = AFKHelper
    private val commandHelper = CommandHelper()
    private val commandName = CommandNames().AFKLIST

    override fun onCommand(sender: CommandSender, command: Command, p2: String, args: Array<out String>?): Boolean {
        if(sender !is Player) {
            return false
        }

        if(!commandHelper.doesPlayerHavePermission(sender, commandName)) {
            return false
        }

        afkHelper.afkPlayers.forEach {
            sender.sendMessage("${ChatColor.GREEN}$ $it")
        }
        return true
    }
}