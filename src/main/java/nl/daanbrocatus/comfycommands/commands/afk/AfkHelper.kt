package nl.daanbrocatus.comfycommands.commands.afk

object AfkHelper {
    private val afkPlayers: MutableList<String> = mutableListOf()

    fun isAfk(playerName: String): Boolean {
        return afkPlayers.contains(playerName)
    }

    fun toggleAfk(playerName: String) {
        if (!isAfk(playerName)) {
            afkPlayers.add(playerName)
        } else {
            afkPlayers.remove(playerName)
        }
    }
}