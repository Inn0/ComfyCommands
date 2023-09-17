package nl.daanbrocatus.comfycommands.commands

import net.kyori.adventure.text.format.TextColor
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class AFK: CommandExecutor {
    private val commandHelper = CommandHelper()
    private var afkPlayers: MutableList<String> = mutableListOf()

    override fun onCommand(sender: CommandSender, command: Command, p2: String, args: Array<out String>?): Boolean {
        if(sender !is Player) {
            sender.sendMessage("${ChatColor.RED}$ Sender needs to be a player!")
            return false
        }

        val playerName = sender.name

        if(!afkPlayers.contains(playerName)) {
            afkPlayers.add(playerName)
            sender.isInvulnerable = true
            sender.walkSpeed = 0.0f
            sender.setDisplayName(ChatColor.YELLOW.toString() + sender.name)
            sender.setPlayerListName(ChatColor.YELLOW.toString() + sender.name)
            Bukkit.broadcastMessage("${ChatColor.GREEN}$ $playerName is now AFK!")
        } else {
            afkPlayers.remove(playerName)
            sender.isInvulnerable = false
            sender.walkSpeed = 0.2f
            sender.setDisplayName(sender.name)
            sender.setPlayerListName(sender.name)
            Bukkit.broadcastMessage("${ChatColor.GREEN}$ $playerName is no longer AFK!")
        }

        return true
    }
}