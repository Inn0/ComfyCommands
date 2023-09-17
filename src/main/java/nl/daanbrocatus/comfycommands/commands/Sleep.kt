package nl.daanbrocatus.comfycommands.commands

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.World
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class Sleep : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, p2: String, args: Array<out String>?): Boolean {
        if(sender !is Player) {
            sender.sendMessage("${ChatColor.RED}$ You are not a player!")
            return false
        }

        val world = Bukkit.getWorlds()[0]
        if (world != null && world.environment == World.Environment.NORMAL) {
            world.time = 0
            world.setStorm(false)
            world.isThundering = false
            Bukkit.broadcastMessage("${ChatColor.GREEN}$ Good morning gamers!")
            return true
        }
        return false
    }

}