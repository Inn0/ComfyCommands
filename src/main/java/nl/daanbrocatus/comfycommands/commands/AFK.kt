package nl.daanbrocatus.comfycommands.commands

import nl.daanbrocatus.comfycommands.constants.CommandNames
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class AFK: CommandExecutor {
    private var afkPlayers: MutableList<String> = mutableListOf()
    private val commandHelper = CommandHelper()
    private val commandName = CommandNames().AFK

    override fun onCommand(sender: CommandSender, command: Command, p2: String, args: Array<out String>?): Boolean {
        if(sender !is Player) {
            return false
        }

        if(!commandHelper.doesPlayerHavePermission(sender, commandName)) {
            return false
        }

        val playerName = sender.name

        if(!afkPlayers.contains(playerName)) {
            afkPlayers.add(playerName)
            sender.isInvulnerable = true
            sender.walkSpeed = 0.0f
            sender.isSneaking = false
            sender.addPotionEffect(PotionEffect(PotionEffectType.JUMP, Int.MAX_VALUE, 128, false, false))
            sender.setDisplayName(ChatColor.YELLOW.toString() + sender.name)
            sender.setPlayerListName(ChatColor.YELLOW.toString() + sender.playerListName)
            Bukkit.broadcastMessage("${ChatColor.GREEN}$ $playerName is now AFK!")
        } else {
            afkPlayers.remove(playerName)
            sender.isInvulnerable = false
            sender.walkSpeed = 0.2f
            sender.removePotionEffect(PotionEffectType.JUMP)
            sender.setDisplayName(sender.name)
            sender.setPlayerListName(sender.playerListName.substring(2))
            Bukkit.broadcastMessage("${ChatColor.GREEN}$ $playerName is no longer AFK!")
        }

        return true
    }
}