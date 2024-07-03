package nl.daanbrocatus.comfycommands.commands

import nl.daanbrocatus.comfycommands.constants.CommandNames
import org.bukkit.GameMode
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class ToggleSpectatorMode: CommandExecutor {
    private val commandName = CommandNames().SPECTATOR
    private val commandHelper = CommandHelper()

    override fun onCommand(sender: CommandSender, command: Command, p2: String, args: Array<out String>?): Boolean {
        if(sender !is Player) {
            return false
        }

        if(!commandHelper.doesPlayerHavePermission(sender, commandName)) {
            return false
        }

        if (sender.player?.gameMode == GameMode.SPECTATOR) {
            sender.player?.gameMode = GameMode.SURVIVAL
        } else {
            sender.player?.gameMode = GameMode.SPECTATOR
        }

        return true
    }
}