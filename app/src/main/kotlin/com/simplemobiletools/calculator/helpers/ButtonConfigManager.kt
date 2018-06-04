package com.simplemobiletools.calculator.helpers

import com.google.gson.Gson
import com.simplemobiletools.calculator.buttons.ButtonConfig
import com.simplemobiletools.calculator.buttons.ButtonFactory
import java.io.File

object ButtonConfigManager {
    private val data = ArrayList<ButtonConfig>()
    private lateinit var filesDir: File

    fun setFileDir(dir: File) {
        filesDir = dir
    }

    fun getConfigSize(): Int {
        return data.size
    }

    fun getConfig(index: Int): ButtonConfig {
        return data[index]
    }

    fun initConfigFromFile(filesDir: File) {
        try {
            val jsonStr = FileManager(filesDir, "config.dat").readFile()
            val configList = Gson().fromJson(jsonStr, Array<ButtonConfig>::class.java)
            for (i in 0 until configList.size) {
                addConfig(configList[i])
            }
        } catch (e: Exception) {//in case no file being found
            addConfig(initConfig1())
            addConfig(initConfig2())
        }
    }

    fun updateTargetConfig(index: Int, config: ButtonConfig) {
        data[index].btn11 = config.btn11
        data[index].btn12 = config.btn12
        data[index].btn13 = config.btn13
        data[index].btn14 = config.btn14
        data[index].btn21 = config.btn21
        data[index].btn22 = config.btn22
        data[index].btn23 = config.btn23
        data[index].btn24 = config.btn24
        data[index].btn31 = config.btn31
        data[index].btn32 = config.btn32
        data[index].btn33 = config.btn33
        data[index].btn34 = config.btn34
        data[index].btn41 = config.btn41
        data[index].btn42 = config.btn42
        data[index].btn43 = config.btn43
        data[index].btn44 = config.btn44
        data[index].btn51 = config.btn51
        data[index].btn52 = config.btn52
        data[index].btn53 = config.btn53
        data[index].btn54 = config.btn54
        saveConfigToFile()
    }

    fun initConfig1(): ButtonConfig {
        val bc = ButtonConfig()
        bc.btn11 = ButtonFactory.ButtonType.MOD
        bc.btn12 = ButtonFactory.ButtonType.POWER
        bc.btn13 = ButtonFactory.ButtonType.ROOT_SQUARE
        bc.btn14 = ButtonFactory.ButtonType.DEL
        bc.btn21 = ButtonFactory.ButtonType.SEVEN
        bc.btn22 = ButtonFactory.ButtonType.EIGHT
        bc.btn23 = ButtonFactory.ButtonType.NINE
        bc.btn24 = ButtonFactory.ButtonType.DIVIDE
        bc.btn31 = ButtonFactory.ButtonType.FOUR
        bc.btn32 = ButtonFactory.ButtonType.FIVE
        bc.btn33 = ButtonFactory.ButtonType.SIX
        bc.btn34 = ButtonFactory.ButtonType.MULTIPLY
        bc.btn41 = ButtonFactory.ButtonType.ONE
        bc.btn42 = ButtonFactory.ButtonType.TWO
        bc.btn43 = ButtonFactory.ButtonType.THREE
        bc.btn44 = ButtonFactory.ButtonType.MINUS
        bc.btn51 = ButtonFactory.ButtonType.ZERO
        bc.btn52 = ButtonFactory.ButtonType.DECIMAL
        bc.btn53 = ButtonFactory.ButtonType.EQUAL
        bc.btn54 = ButtonFactory.ButtonType.PLUS
        return bc
    }

    fun initConfig2():ButtonConfig {
        val bc = ButtonConfig()
        bc.btn11 = ButtonFactory.ButtonType.SIN
        bc.btn12 = ButtonFactory.ButtonType.COS
        bc.btn13 = ButtonFactory.ButtonType.TAN
        bc.btn14 = ButtonFactory.ButtonType.ROOT_CUBE
        bc.btn21 = ButtonFactory.ButtonType.LOGTEN
        bc.btn22 = ButtonFactory.ButtonType.PI
        bc.btn23 = ButtonFactory.ButtonType.BRACKET_LEFT
        bc.btn24 = ButtonFactory.ButtonType.BRACKET_RIGHT
        bc.btn31 = ButtonFactory.ButtonType.EMPTY
        bc.btn32 = ButtonFactory.ButtonType.EMPTY
        bc.btn33 = ButtonFactory.ButtonType.EMPTY
        bc.btn34 = ButtonFactory.ButtonType.EMPTY
        bc.btn41 = ButtonFactory.ButtonType.EMPTY
        bc.btn42 = ButtonFactory.ButtonType.EMPTY
        bc.btn43 = ButtonFactory.ButtonType.EMPTY
        bc.btn44 = ButtonFactory.ButtonType.EMPTY
        bc.btn51 = ButtonFactory.ButtonType.EMPTY
        bc.btn52 = ButtonFactory.ButtonType.EMPTY
        bc.btn53 = ButtonFactory.ButtonType.EMPTY
        bc.btn54 = ButtonFactory.ButtonType.EMPTY
        return bc
    }

    fun initConfigEmpty() : ButtonConfig {
        val bc = ButtonConfig()
        bc.btn11 = ButtonFactory.ButtonType.EMPTY
        bc.btn12 = ButtonFactory.ButtonType.EMPTY
        bc.btn13 = ButtonFactory.ButtonType.EMPTY
        bc.btn14 = ButtonFactory.ButtonType.EMPTY
        bc.btn21 = ButtonFactory.ButtonType.EMPTY
        bc.btn22 = ButtonFactory.ButtonType.EMPTY
        bc.btn23 = ButtonFactory.ButtonType.EMPTY
        bc.btn24 = ButtonFactory.ButtonType.EMPTY
        bc.btn31 = ButtonFactory.ButtonType.EMPTY
        bc.btn32 = ButtonFactory.ButtonType.EMPTY
        bc.btn33 = ButtonFactory.ButtonType.EMPTY
        bc.btn34 = ButtonFactory.ButtonType.EMPTY
        bc.btn41 = ButtonFactory.ButtonType.EMPTY
        bc.btn42 = ButtonFactory.ButtonType.EMPTY
        bc.btn43 = ButtonFactory.ButtonType.EMPTY
        bc.btn44 = ButtonFactory.ButtonType.EMPTY
        bc.btn51 = ButtonFactory.ButtonType.EMPTY
        bc.btn52 = ButtonFactory.ButtonType.EMPTY
        bc.btn53 = ButtonFactory.ButtonType.EMPTY
        bc.btn54 = ButtonFactory.ButtonType.EMPTY
        return bc
    }

    private fun addConfig(bc: ButtonConfig) {
        data.add(bc)
    }

    private fun saveConfigToFile() {
        val fm = FileManager(filesDir, "config.dat")
        val jsonStr: String = Gson().toJson(data)
        fm.proofFile()
        fm.writeFile(jsonStr)
    }
}