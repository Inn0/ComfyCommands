package nl.daanbrocatus.comfycommands

import nl.daanbrocatus.comfycommands.commands.AFK
import nl.daanbrocatus.comfycommands.commands.Coords
import nl.daanbrocatus.comfycommands.commands.Heal
import org.bukkit.plugin.java.JavaPlugin

class ComfyCommands : JavaPlugin() {
    override fun onEnable() {
        getCommand("heal")?.setExecutor(Heal())
        getCommand("coords")?.setExecutor(Coords())
        getCommand("afk")?.setExecutor(AFK())
    }

    override fun onDisable() {
    }
}
