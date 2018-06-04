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
        val jsonStr = FileManager(filesDir, "config.dat").readFile()
        val configList = Gson().fromJson(jsonStr, Array<ButtonConfig>::class.java)
        for (i in 0 until configList.size) {
            addConfig(configList[i])
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

    fun initConfig1(i: Int) {
        data[i].btn11 = ButtonFactory.ButtonType.MOD
        data[i].btn12 = ButtonFactory.ButtonType.POWER
        data[i].btn13 = ButtonFactory.ButtonType.ROOT_SQUARE
        data[i].btn14 = ButtonFactory.ButtonType.DEL
        data[i].btn21 = ButtonFactory.ButtonType.SEVEN
        data[i].btn22 = ButtonFactory.ButtonType.EIGHT
        data[i].btn23 = ButtonFactory.ButtonType.NINE
        data[i].btn24 = ButtonFactory.ButtonType.DIVIDE
        data[i].btn31 = ButtonFactory.ButtonType.FOUR
        data[i].btn32 = ButtonFactory.ButtonType.FIVE
        data[i].btn33 = ButtonFactory.ButtonType.SIX
        data[i].btn34 = ButtonFactory.ButtonType.MULTIPLY
        data[i].btn41 = ButtonFactory.ButtonType.ONE
        data[i].btn42 = ButtonFactory.ButtonType.TWO
        data[i].btn43 = ButtonFactory.ButtonType.THREE
        data[i].btn44 = ButtonFactory.ButtonType.MINUS
        data[i].btn51 = ButtonFactory.ButtonType.ZERO
        data[i].btn52 = ButtonFactory.ButtonType.DECIMAL
        data[i].btn53 = ButtonFactory.ButtonType.EQUAL
        data[i].btn54 = ButtonFactory.ButtonType.PLUS
        saveConfigToFile()
    }

    fun initConfig2(i: Int) {
        data[i].btn11 = ButtonFactory.ButtonType.SIN
        data[i].btn12 = ButtonFactory.ButtonType.COS
        data[i].btn13 = ButtonFactory.ButtonType.TAN
        data[i].btn14 = ButtonFactory.ButtonType.ROOT_CUBE
        data[i].btn21 = ButtonFactory.ButtonType.LOG
        data[i].btn22 = ButtonFactory.ButtonType.PI
        data[i].btn23 = ButtonFactory.ButtonType.BRACKET_LEFT
        data[i].btn24 = ButtonFactory.ButtonType.BRACKET_RIGHT
        data[i].btn31 = ButtonFactory.ButtonType.EMPTY
        data[i].btn32 = ButtonFactory.ButtonType.EMPTY
        data[i].btn33 = ButtonFactory.ButtonType.EMPTY
        data[i].btn34 = ButtonFactory.ButtonType.EMPTY
        data[i].btn41 = ButtonFactory.ButtonType.EMPTY
        data[i].btn42 = ButtonFactory.ButtonType.EMPTY
        data[i].btn43 = ButtonFactory.ButtonType.EMPTY
        data[i].btn44 = ButtonFactory.ButtonType.EMPTY
        data[i].btn51 = ButtonFactory.ButtonType.EMPTY
        data[i].btn52 = ButtonFactory.ButtonType.EMPTY
        data[i].btn53 = ButtonFactory.ButtonType.EMPTY
        data[i].btn54 = ButtonFactory.ButtonType.EMPTY
        saveConfigToFile()
    }

    fun initConfigEmpty(i: Int) {
        data[i].btn11 = ButtonFactory.ButtonType.EMPTY
        data[i].btn12 = ButtonFactory.ButtonType.EMPTY
        data[i].btn13 = ButtonFactory.ButtonType.EMPTY
        data[i].btn14 = ButtonFactory.ButtonType.EMPTY
        data[i].btn21 = ButtonFactory.ButtonType.EMPTY
        data[i].btn22 = ButtonFactory.ButtonType.EMPTY
        data[i].btn23 = ButtonFactory.ButtonType.EMPTY
        data[i].btn24 = ButtonFactory.ButtonType.EMPTY
        data[i].btn31 = ButtonFactory.ButtonType.EMPTY
        data[i].btn32 = ButtonFactory.ButtonType.EMPTY
        data[i].btn33 = ButtonFactory.ButtonType.EMPTY
        data[i].btn34 = ButtonFactory.ButtonType.EMPTY
        data[i].btn41 = ButtonFactory.ButtonType.EMPTY
        data[i].btn42 = ButtonFactory.ButtonType.EMPTY
        data[i].btn43 = ButtonFactory.ButtonType.EMPTY
        data[i].btn44 = ButtonFactory.ButtonType.EMPTY
        data[i].btn51 = ButtonFactory.ButtonType.EMPTY
        data[i].btn52 = ButtonFactory.ButtonType.EMPTY
        data[i].btn53 = ButtonFactory.ButtonType.EMPTY
        data[i].btn54 = ButtonFactory.ButtonType.EMPTY
        saveConfigToFile()
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