package nl.daanbrocatus.comfycommands.commands.afk

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

object AFKHelper {
    val afkPlayers: MutableList<String> = mutableListOf()

    fun isAfk(playerName: String): Boolean {
        return afkPlayers.contains(playerName)
    }

    fun setAfkStatus(player: Player, isPlayerAfk: Boolean) {
        if (isPlayerAfk) {
            player.isInvulnerable = true
            player.walkSpeed = 0.0f
            player.isSneaking = false
            player.addPotionEffect(PotionEffect(PotionEffectType.JUMP, Int.MAX_VALUE, 128, false, false))
            player.setDisplayName(ChatColor.YELLOW.toString() + player.name)
            player.setPlayerListName(ChatColor.YELLOW.toString() + player.playerListName)
            Bukkit.broadcastMessage("${ChatColor.GREEN}$ ${player.name} is now AFK!")

            afkPlayers.add(player.name)
        } else {
            player.isInvulnerable = false
            player.walkSpeed = 0.2f
            player.removePotionEffect(PotionEffectType.JUMP)
            player.setDisplayName(player.name)
            player.setPlayerListName(player.playerListName.substring(2))
            Bukkit.broadcastMessage("${ChatColor.GREEN}$ ${player.name} is no longer AFK!")
            
            afkPlayers.remove(player.name)
        }
    }
}