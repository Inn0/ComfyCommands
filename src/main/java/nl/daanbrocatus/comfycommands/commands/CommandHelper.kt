package nl.daanbrocatus.comfycommands.commands

class CommandHelper {
    private val admins: List<String> = listOf("21_Cabbage_420")

    fun isPlayerAdmin(playerName: String): Boolean {
        return admins.contains(playerName)
    }
}