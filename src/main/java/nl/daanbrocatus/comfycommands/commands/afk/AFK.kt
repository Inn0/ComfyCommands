package nl.daanbrocatus.comfycommands.commands.afk

import nl.daanbrocatus.comfycommands.commands.CommandHelper
import nl.daanbrocatus.comfycommands.constants.CommandNames
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class AFK: CommandExecutor {
    private val afkHelper = AFKHelper
    private val commandHelper = CommandHelper()
    private val commandName = CommandNames().AFK

    override fun onCommand(sender: CommandSender, command: Command, p2: String, args: Array<out String>?): Boolean {
        if(sender !is Player) {
            return false
        }

        if(!commandHelper.doesPlayerHavePermission(sender, commandName)) {
            return false
        }

        if(afkHelper.isAfk(sender.name)) {
            afkHelper.setAfkStatus(sender, false)
        } else {
            afkHelper.setAfkStatus(sender, true)
        }

        return true
    }
}