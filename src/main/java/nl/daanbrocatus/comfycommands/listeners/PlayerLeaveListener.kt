package nl.daanbrocatus.comfycommands.listeners

import nl.daanbrocatus.comfycommands.commands.afk.AFKHelper
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerQuitEvent
class PlayerLeaveListener: Listener {
    private val afkHelper = AFKHelper

    @EventHandler
    fun onPlayerLeave(event: PlayerQuitEvent){
        if(afkHelper.isAfk(event.player.name)) {
            afkHelper.setAfkStatus(event.player, false)
        }
    }
}