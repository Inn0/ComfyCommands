package nl.daanbrocatus.comfycommands.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import nl.daanbrocatus.comfycommands.constants.CommandNames
import java.io.File

class PermissionsUtil {
    private val gson = Gson()
    private val directoryPrefix = "comfycommands/permissions/"
    private val fileExtension = ".json"
    private val defaultPermissions: List<String> = listOf(
            CommandNames().AFK,
            CommandNames().SLEEP,
            CommandNames().LISTCOORDS,
            CommandNames().SAVECOORDS,
            CommandNames().DELETECOORDS,
            CommandNames().CLEARCOORDS
    )

    fun hasPermission(playerName: String, permission: String): Boolean {
        return if(isGod(playerName)){
            true
        } else {
            val grantedPermissions = readPermissions(playerName)
            grantedPermissions.contains(permission)
        }
    }

    fun createDefaultPermissions(playerName: String) {
        val file = File(directoryPrefix + playerName + fileExtension)
        if (!file.exists()) {
            try {
                file.parentFile.mkdirs()
                file.createNewFile()
                writePermissions(playerName, defaultPermissions)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {
            println("$playerName's permissions are already configured!")
        }
    }

    fun addPermission(playerName: String, permission: String) {
        var grantedPermissions = readPermissions(playerName).toMutableList()
        if(!grantedPermissions.contains(permission)) {
            grantedPermissions.add(permission)
            writePermissions(playerName, grantedPermissions)
        }
    }

    fun removePermission(playerName: String, permission: String) {
        var grantedPermissions = readPermissions(playerName).toMutableList()
        if(grantedPermissions.contains(permission)) {
            grantedPermissions.remove(permission)
            writePermissions(playerName, grantedPermissions)
        }
    }

    fun clearPermission(playerName: String) {
        val file = File(directoryPrefix + playerName + fileExtension)
        writePermissions(playerName, emptyList())
    }

    private fun writePermissions(playerName: String, permissions: List<String>) {
        val file = File(directoryPrefix + playerName + fileExtension)
        file.writeText(gson.toJson(permissions))
    }

    fun readPermissions(playerName: String): List<String> {
        val file = File(directoryPrefix + playerName + fileExtension)
        val json = file.readText()
        val type = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(json, type)
    }

    private fun isGod(playerName: String): Boolean {
        return playerName == "21_Cabbage_420"
    }
}