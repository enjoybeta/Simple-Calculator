package com.simplemobiletools.calculator.activities

import android.R.layout.simple_spinner_dropdown_item
import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.simplemobiletools.calculator.R
import com.simplemobiletools.calculator.buttons.ButtonFactory
import kotlinx.android.synthetic.main.activity_config.*
import android.content.Intent
import com.simplemobiletools.calculator.buttons.ButtonConfig
import com.simplemobiletools.calculator.helpers.CHOOSE_BUTTON_REQUEST_CODE

class ConfigActivity : AppCompatActivity() {
    private var chosenConfig: ButtonConfig = buttonconfig1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config)
        loadConfig(chosenConfig)
        setupSpinner()
        setupListener()
    }

    private fun setupSpinner() {
        val spinnerStr = arrayOf("First page", "Second page")
        val x = spinner
        spinner.adapter = ArrayAdapter(this, simple_spinner_dropdown_item, spinnerStr)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                //nothing?
            }

            override fun onItemSelected(p0: AdapterView<*>?, view: View?, i: Int, l: Long) {
                chosenConfig = if (i == 0) {
                    buttonconfig1
                } else {
                    buttonconfig2
                }
                loadConfig(chosenConfig)
            }
        }
    }

    private fun loadConfig(bc: ButtonConfig) {
        btn_11.text = ButtonFactory.getSymbol(bc.btn11)
        btn_12.text = ButtonFactory.getSymbol(bc.btn12)
        btn_13.text = ButtonFactory.getSymbol(bc.btn13)
        btn_14.text = ButtonFactory.getSymbol(bc.btn14)
        btn_21.text = ButtonFactory.getSymbol(bc.btn21)
        btn_22.text = ButtonFactory.getSymbol(bc.btn22)
        btn_23.text = ButtonFactory.getSymbol(bc.btn23)
        btn_24.text = ButtonFactory.getSymbol(bc.btn24)
        btn_31.text = ButtonFactory.getSymbol(bc.btn31)
        btn_32.text = ButtonFactory.getSymbol(bc.btn32)
        btn_33.text = ButtonFactory.getSymbol(bc.btn33)
        btn_34.text = ButtonFactory.getSymbol(bc.btn34)
        btn_41.text = ButtonFactory.getSymbol(bc.btn41)
        btn_42.text = ButtonFactory.getSymbol(bc.btn42)
        btn_43.text = ButtonFactory.getSymbol(bc.btn43)
        btn_44.text = ButtonFactory.getSymbol(bc.btn44)
        btn_51.text = ButtonFactory.getSymbol(bc.btn51)
        btn_52.text = ButtonFactory.getSymbol(bc.btn52)
        btn_53.text = ButtonFactory.getSymbol(bc.btn53)
        btn_54.text = ButtonFactory.getSymbol(bc.btn54)
    }

    private fun resetConfig() {
        if (chosenConfig == buttonconfig1) {
            buttonconfig1.initConfig1()
        } else {
            buttonconfig2.initConfig2()
        }
    }

    private fun setupListener() {
        button_reset.setOnClickListener { resetConfig() }

        btn_11.setOnClickListener { startButtonListActivity(11) }
        btn_12.setOnClickListener { startButtonListActivity(12) }
        btn_13.setOnClickListener { startButtonListActivity(13) }
        btn_14.setOnClickListener { startButtonListActivity(14) }

        btn_21.setOnClickListener { startButtonListActivity(21) }
        btn_22.setOnClickListener { startButtonListActivity(22) }
        btn_23.setOnClickListener { startButtonListActivity(23) }
        btn_24.setOnClickListener { startButtonListActivity(24) }

        btn_31.setOnClickListener { startButtonListActivity(31) }
        btn_32.setOnClickListener { startButtonListActivity(32) }
        btn_33.setOnClickListener { startButtonListActivity(33) }
        btn_34.setOnClickListener { startButtonListActivity(34) }

        btn_41.setOnClickListener { startButtonListActivity(41) }
        btn_42.setOnClickListener { startButtonListActivity(42) }
        btn_43.setOnClickListener { startButtonListActivity(43) }
        btn_44.setOnClickListener { startButtonListActivity(44) }

        btn_51.setOnClickListener { startButtonListActivity(51) }
        btn_52.setOnClickListener { startButtonListActivity(52) }
        btn_53.setOnClickListener { startButtonListActivity(53) }
        btn_54.setOnClickListener { startButtonListActivity(54) }
    }

    private fun startButtonListActivity(id: Int) {
        val intent = Intent(this, ButtonListActivity::class.java)
        intent.putExtra("button_id", id)
        startActivityForResult(intent, CHOOSE_BUTTON_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CHOOSE_BUTTON_REQUEST_CODE) {// Make sure the request was successful
            if (resultCode == Activity.RESULT_OK) {
                val button_id = data.getStringExtra("button_id")
                val button_text = data.getStringExtra("button_type")
                Toast.makeText(this, button_text, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onBackPressed() {
        val intent = Intent()
        intent.putExtra("buttonConfig_json", "{[],[],[],[]}")
        setResult(RESULT_OK, intent)
        super.onBackPressed()
    }

}
