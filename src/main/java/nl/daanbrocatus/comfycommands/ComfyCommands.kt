package nl.daanbrocatus.comfycommands

import nl.daanbrocatus.comfycommands.commands.*
import nl.daanbrocatus.comfycommands.commands.coords.*
import nl.daanbrocatus.comfycommands.listeners.PlayerDeathListener
import org.bukkit.plugin.java.JavaPlugin

class ComfyCommands : JavaPlugin() {
    override fun onEnable() {
        getCommand("heal")?.setExecutor(Heal())
        getCommand("coords")?.setExecutor(Coords())
        getCommand("afk")?.setExecutor(AFK())
        getCommand("sleep")?.setExecutor(Sleep())
        getCommand("announce")?.setExecutor(Announce())
        getCommand("savecoords")?.setExecutor(SaveCoords())
        getCommand("listcoords")?.setExecutor(ListCoords())
        getCommand("deletecoords")?.setExecutor(DeleteCoords())
        getCommand("clearcoords")?.setExecutor(ClearCoords())

        server.pluginManager.registerEvents(PlayerDeathListener(), this)
    }

    override fun onDisable() {
    }
}
