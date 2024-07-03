package nl.daanbrocatus.comfycommands.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import nl.daanbrocatus.comfycommands.constants.FileConstants
import nl.daanbrocatus.comfycommands.models.CoordItem
import org.bukkit.Location
import java.io.File
import kotlin.math.roundToInt

class CoordUtil {
    private val gson = Gson()
    private val fileUtil = FileUtil()

    fun readCoordinates(playerName: String): MutableList<CoordItem>? {
        val file = File(FileConstants().directoryPrefix + "coords/$playerName" + FileConstants().fileExtension)
        val type = object : TypeToken<List<CoordItem>>() {}.type
        val json = file.readText()
        return gson.fromJson(json, type)
    }

    fun saveCoordinates(playerName: String, coords: CoordItem) {
        fileUtil.createFileIfDoesNotExist("coords/$playerName")
        var coordList = readCoordinates(playerName)
        if(coordList == null) {
            coordList = mutableListOf()
        }
        if(coordList.contains(coords)) {
            throw Exception("These coordinates are already saved!")
        } else {
            coordList.add(coords)
            val file = File(FileConstants().directoryPrefix + "coords/$playerName" + FileConstants().fileExtension)
            file.writeText(gson.toJson(coordList))
        }
    }

    fun deleteCoordinate(playerName: String, name: String) {
        var coordList: MutableList<CoordItem>? = readCoordinates(playerName) ?: throw Exception("There are no coordinates saved!")

        coordList!!.removeIf { it.name == name }

        val file = File(FileConstants().directoryPrefix + "coords/$playerName" + FileConstants().fileExtension)
        file.writeText(gson.toJson(coordList))
    }

    fun clearCoordinates(playerName: String) {
        val file = File(FileConstants().directoryPrefix + "coords/$playerName" + FileConstants().fileExtension)
        file.writeText("[]")
    }

    fun createCoordItem(coordsName: String, location: Location): CoordItem {
        val x = location.x.roundToInt()
        val y = location.y.roundToInt()
        val z = location.z.roundToInt()

        return CoordItem(coordsName, x, y, z)
    }
}