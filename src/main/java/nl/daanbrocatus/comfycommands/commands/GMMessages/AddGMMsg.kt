package nl.daanbrocatus.comfycommands.commands.GMMessages

import nl.daanbrocatus.comfycommands.commands.CommandHelper
import nl.daanbrocatus.comfycommands.constants.CommandNames
import nl.daanbrocatus.comfycommands.utils.GoodMorningMessageUtil
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class AddGMMsg: CommandExecutor {
    private val commandHelper = CommandHelper()
    private val commandName = CommandNames().ADDGMMSG
    private val goodMorningMessageUtil = GoodMorningMessageUtil()

    override fun onCommand(sender: CommandSender, command: Command, p2: String, args: Array<out String>?): Boolean {
        if(!commandHelper.doesPlayerHavePermission(sender, commandName)) {
            return false
        }

        return if (args != null) {
            goodMorningMessageUtil.addMessage(args.joinToString(separator = " "))
            sender.sendMessage("${ChatColor.GREEN}$ Added the following message: ${args.joinToString(separator = " ")}")
            true
        } else {
            sender.sendMessage("${ChatColor.RED}$ Please provide a string!")
            false
        }
    }
}