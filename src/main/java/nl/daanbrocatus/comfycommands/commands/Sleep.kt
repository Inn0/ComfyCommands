package nl.daanbrocatus.comfycommands.commands

import nl.daanbrocatus.comfycommands.constants.CommandNames
import nl.daanbrocatus.comfycommands.utils.GoodMorningMessageUtil
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.World
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class Sleep : CommandExecutor {
    private val goodMorningMessageUtil = GoodMorningMessageUtil()
    private val commandName = CommandNames().SLEEP
    private val commandHelper = CommandHelper()

    override fun onCommand(sender: CommandSender, command: Command, p2: String, args: Array<out String>?): Boolean {
        if(!commandHelper.doesPlayerHavePermission(sender, commandName)) {
            return false
        }

        val world = Bukkit.getWorlds()[0]
        if (world != null && world.environment == World.Environment.NORMAL) {
            world.time = 0
            world.setStorm(false)
            world.isThundering = false
            Bukkit.broadcastMessage("${ChatColor.GREEN}$ ${goodMorningMessageUtil.getRandomMessage()}")
            return true
        }
        return false
    }

}