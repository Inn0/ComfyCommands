package nl.daanbrocatus.comfycommands.commands.afk

object AfkHelper {
    private val afkPlayers: MutableList<String> = mutableListOf()

    fun isAfk(playerName: String): Boolean {
        return afkPlayers.contains(playerName)
    }

    fun toggleAfk(playerName: String) {
        println("Before toggling afk status: $afkPlayers")
        if (!isAfk(playerName)) {
            afkPlayers.add(playerName)
        } else {
            afkPlayers.remove(playerName)
        }
        println("After toggling afk status: $afkPlayers")
    }
}