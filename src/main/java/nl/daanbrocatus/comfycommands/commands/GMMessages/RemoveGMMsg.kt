package nl.daanbrocatus.comfycommands.commands.GMMessages

import nl.daanbrocatus.comfycommands.commands.CommandHelper
import nl.daanbrocatus.comfycommands.constants.CommandNames
import nl.daanbrocatus.comfycommands.utils.GoodMorningMessageUtil
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class RemoveGMMsg: CommandExecutor {
    private val commandHelper = CommandHelper()
    private val commandName = CommandNames().REMOVEGMMSG
    private val goodMorningMessageUtil = GoodMorningMessageUtil()

    override fun onCommand(sender: CommandSender, command: Command, p2: String, args: Array<out String>?): Boolean {
        if(!commandHelper.doesPlayerHavePermission(sender, commandName)) {
            return false
        }

        return if (args != null) {
            goodMorningMessageUtil.removeMessage(args.joinToString(separator = " "))
            sender.sendMessage("${ChatColor.GREEN}$ Removed the following message: ${args.joinToString(separator = " ")}")
            true
        } else {
            sender.sendMessage("${ChatColor.RED}$ Please provide a name to save your coordinates!")
            false
        }
    }
}