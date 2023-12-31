package nl.daanbrocatus.comfycommands.commands.coords

import nl.daanbrocatus.comfycommands.commands.CommandHelper
import nl.daanbrocatus.comfycommands.constants.CommandNames
import nl.daanbrocatus.comfycommands.utils.CoordUtil
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class SaveCoords : CommandExecutor {
    private val coordUtil = CoordUtil()
    private val commandName = CommandNames().SAVECOORDS
    private val commandHelper = CommandHelper()

    override fun onCommand(sender: CommandSender, command: Command, p2: String, args: Array<out String>?): Boolean {
        if(sender !is Player) {
            return false
        }

        if(!commandHelper.doesPlayerHavePermission(sender, commandName)) {
            return false
        }

        if (args != null && args.size == 1) {
            val coordsName = args[0]

            val coords = coordUtil.createCoordItem(coordsName, sender.location)
            coordUtil.saveCoordinates(sender.name, coords)

            sender.sendMessage("${ChatColor.GREEN}$ Coordinates saved! (x: ${coords.x} y: ${coords.y} z: ${coords.z})")
        } else {
            sender.sendMessage("${ChatColor.RED}$ Please provide a name to save your coordinates!")
            return false
        }
        return true
    }

}