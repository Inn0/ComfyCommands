package nl.daanbrocatus.comfycommands

import nl.daanbrocatus.comfycommands.commands.*
import nl.daanbrocatus.comfycommands.commands.GMMessages.AddGMMsg
import nl.daanbrocatus.comfycommands.commands.GMMessages.RemoveGMMsg
import nl.daanbrocatus.comfycommands.commands.coords.*
import nl.daanbrocatus.comfycommands.commands.perms.ClearPerms
import nl.daanbrocatus.comfycommands.commands.perms.GivePerms
import nl.daanbrocatus.comfycommands.commands.perms.ListPerms
import nl.daanbrocatus.comfycommands.commands.perms.RevokePerms
import nl.daanbrocatus.comfycommands.constants.CommandNames
import nl.daanbrocatus.comfycommands.listeners.PlayerDeathListener
import nl.daanbrocatus.comfycommands.listeners.PlayerJoinListener
import org.bukkit.plugin.java.JavaPlugin

class ComfyCommands : JavaPlugin() {
    companion object {
        lateinit var instance: ComfyCommands
            private set
    }
    override fun onEnable() {
        instance = this

        getCommand(CommandNames().HEAL)?.setExecutor(Heal())
        getCommand(CommandNames().AFK)?.setExecutor(AFK())
        getCommand(CommandNames().SLEEP)?.setExecutor(Sleep())
        getCommand(CommandNames().ANNOUNCE)?.setExecutor(Announce())
        getCommand(CommandNames().ENDERCHEST)?.setExecutor(Enderchest())

        // Coordinates command executors
        getCommand(CommandNames().SAVECOORDS)?.setExecutor(SaveCoords())
        getCommand(CommandNames().LISTCOORDS)?.setExecutor(ListCoords())
        getCommand(CommandNames().DELETECOORDS)?.setExecutor(DeleteCoords())
        getCommand(CommandNames().CLEARCOORDS)?.setExecutor(ClearCoords())

        // Permission command executors
        getCommand(CommandNames().LISTPERMS)?.setExecutor(ListPerms())
        getCommand(CommandNames().REVOKEPERMS)?.setExecutor(RevokePerms())
        getCommand(CommandNames().GIVEPERMS)?.setExecutor(GivePerms())
        getCommand(CommandNames().CLEARPERMS)?.setExecutor(ClearPerms())

        // Good morning message command executors
        getCommand(CommandNames().ADDGMMSG)?.setExecutor(AddGMMsg())
        getCommand(CommandNames().REMOVEGMMSG)?.setExecutor(RemoveGMMsg())

        // Event listeners
        server.pluginManager.registerEvents(PlayerDeathListener(), this)
        server.pluginManager.registerEvents(PlayerJoinListener(), this)
    }

    override fun onDisable() {
    }
}
