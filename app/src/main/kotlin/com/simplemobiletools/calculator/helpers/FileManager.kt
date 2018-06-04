package com.simplemobiletools.calculator.helpers

import android.util.Log
import java.io.File

class FileManager(_dir: File, _fileName: String) {
    private val dir: File = _dir
    private val fileName: String = _fileName

    fun proofFile() {
        if (!checkFile()) {
            val file = File(dir, fileName)
            file.writeText("{}")
            Log.e("log_FileManage", "reset log for [$fileName]")
        }
    }

    fun readFile(): String {
        val file = File(dir, fileName)
        return file.readText()
    }

    fun writeFile(input: String) {
        val file = File(dir, fileName)
        file.writeText(input)//charset = Charset.UTF-8
    }

    private fun checkFile(): Boolean {
        return File(dir, fileName).exists()
    }
}