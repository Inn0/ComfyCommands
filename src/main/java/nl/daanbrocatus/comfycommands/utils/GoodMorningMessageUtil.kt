package nl.daanbrocatus.comfycommands.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.util.*

class GoodMorningMessageUtil {
    private val filePrefix = "comfycommands/"
    private val fileLocation: String = "strings/goodmorningmessages"
    private val fileExtension = ".json"
    private val file = File(filePrefix + fileLocation + fileExtension)
    private val gson = Gson()
    private val fileUtil = FileUtil()

    fun getRandomMessage(): String {
        val strings = readMessages()

        if (strings.isEmpty()) {
            return "There are no messages present in comfycommands/strings/goodmorningmessages.json"
        }

        val random = Random()
        val randomIndex = random.nextInt(strings.size)
        return strings[randomIndex]
    }

    fun addMessage(string: String) {
        fileUtil.createFileIfDoesNotExist(fileLocation, "[]")
        var msgList = readMessages().toMutableList()
        msgList.add(string)
        file.writeText(gson.toJson(msgList))
    }

    fun removeMessage(string: String) {
        var msgList = readMessages().toMutableList()
        if(msgList.contains(string)) {
            msgList.remove(string)
            file.writeText(gson.toJson(msgList))
        }
    }

    private fun readMessages(): List<String> {
        fileUtil.createFileIfDoesNotExist(fileLocation, "[]")
        val json = file.readText()
        val type = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(json, type)
    }
}