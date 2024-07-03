package nl.daanbrocatus.comfycommands.utils

import com.google.gson.Gson
import java.io.File

class FileUtil {
    private val directoryPrefix = "comfycommands/"
    private val fileExtension = ".json"

    fun createFileIfDoesNotExist(fileName: String, content: String? = null) {
        val file = File(directoryPrefix + fileName + fileExtension)
        if (!file.exists()) {
            try {
                file.parentFile.mkdirs()
                file.createNewFile()
                if (content != null) {
                    file.writeText(content)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}