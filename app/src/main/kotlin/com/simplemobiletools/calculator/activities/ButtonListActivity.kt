package com.simplemobiletools.calculator.activities

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import com.simplemobiletools.calculator.R
import kotlinx.android.synthetic.main.activity_button_list.*
import android.content.Intent
import com.simplemobiletools.calculator.buttons.ButtonConfig
import com.simplemobiletools.calculator.buttons.ButtonFactory
import com.simplemobiletools.calculator.buttons.ButtonFactory.getSymbol
import com.simplemobiletools.calculator.buttons.ButtonFactory.getType

class ButtonListActivity : AppCompatActivity() {
    private var buttonId: Int = 0
    private val list: ArrayList<String> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button_list)
        buttonId = intent.extras.getInt("buttonId")
        setupAdapter()
    }

    private fun setupAdapter() {
        enumValues<ButtonFactory.ButtonType>().forEach { list.add(getSymbol(it)) }
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, android.R.id.text1, list)
        list_buttons.adapter = adapter
        list_buttons.setOnItemClickListener { _, _, position, _ ->
            returnIntent(position)
        }
    }

    private fun returnIntent(pos: Int) {
        val intent = Intent()
        intent.putExtra("buttonId", buttonId)
        intent.putExtra("buttonType", list[pos])
        setResult(RESULT_OK, intent)
        finish()
    }

    override fun onBackPressed() {
        val intent = Intent()
        setResult(RESULT_CANCELED, intent)
        super.onBackPressed()
    }
}
