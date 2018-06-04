package com.simplemobiletools.calculator.activities

import android.R.layout.simple_spinner_dropdown_item
import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.simplemobiletools.calculator.R
import com.simplemobiletools.calculator.buttons.ButtonFactory
import kotlinx.android.synthetic.main.activity_config.*
import android.content.Intent
import com.simplemobiletools.calculator.helpers.ButtonConfigManager
import com.simplemobiletools.calculator.helpers.CHOOSE_BUTTON_REQUEST_CODE

class ConfigActivity : AppCompatActivity() {
    private var chosenConfigIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config)
        loadConfig(chosenConfigIndex)
        setupSpinner()
        setupListener()
    }

    private fun setupSpinner() {
        val spinnerStr = arrayOf("First page", "Second page")
        spinner.adapter = ArrayAdapter(this, simple_spinner_dropdown_item, spinnerStr)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                //nothing?
            }

            override fun onItemSelected(p0: AdapterView<*>?, view: View?, i: Int, l: Long) {
                chosenConfigIndex = i
                loadConfig(chosenConfigIndex)
            }
        }
    }

    private fun loadConfig(index: Int) {
        val bc = ButtonConfigManager.getConfig(index)
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
        when (chosenConfigIndex) {
            0 -> ButtonConfigManager.initConfig1(0)
            1 -> ButtonConfigManager.initConfig2(1)
            else -> ButtonConfigManager.initConfigEmpty(chosenConfigIndex)
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
        intent.putExtra("buttonId", id)
        startActivityForResult(intent, CHOOSE_BUTTON_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CHOOSE_BUTTON_REQUEST_CODE) {// Make sure the request was successful
            if (resultCode == Activity.RESULT_OK) {
                val buttonId = data.getIntExtra("buttonId", -1)
                val buttonText = data.getStringExtra("buttonType")
                assignNewBtn(buttonId, buttonText)
            }
        }
    }

    override fun onBackPressed() {
        val intent = Intent()
        setResult(RESULT_OK, intent)
        super.onBackPressed()
    }

    private fun assignNewBtn(btnNum: Int, text: String) {
        val btnType = ButtonFactory.getType(text)
        val chosenConfig = ButtonConfigManager.getConfig(chosenConfigIndex)
        when (btnNum) {
            11 -> {
                btn_11.text = text
                chosenConfig.btn11 = btnType
            }
            12 -> {
                btn_12.text = text
                chosenConfig.btn12 = btnType
            }
            13 -> {
                btn_13.text = text
                chosenConfig.btn13 = btnType
            }
            14 -> {
                btn_14.text = text
                chosenConfig.btn14 = btnType
            }
            21 -> {
                btn_21.text = text
                chosenConfig.btn21 = btnType
            }
            22 -> {
                btn_22.text = text
                chosenConfig.btn22 = btnType
            }
            23 -> {
                btn_23.text = text
                chosenConfig.btn23 = btnType
            }
            24 -> {
                btn_24.text = text
                chosenConfig.btn24 = btnType
            }
            31 -> {
                btn_31.text = text
                chosenConfig.btn31 = btnType
            }
            32 -> {
                btn_32.text = text
                chosenConfig.btn32 = btnType
            }
            33 -> {
                btn_33.text = text
                chosenConfig.btn33 = btnType
            }
            34 -> {
                btn_34.text = text
                chosenConfig.btn34 = btnType
            }
            41 -> {
                btn_41.text = text
                chosenConfig.btn41 = btnType
            }
            42 -> {
                btn_42.text = text
                chosenConfig.btn42 = btnType
            }
            43 -> {
                btn_43.text = text
                chosenConfig.btn43 = btnType
            }
            44 -> {
                btn_44.text = text
                chosenConfig.btn44 = btnType
            }
            51 -> {
                btn_51.text = text
                chosenConfig.btn51 = btnType
            }
            52 -> {
                btn_52.text = text
                chosenConfig.btn52 = btnType
            }
            53 -> {
                btn_53.text = text
                chosenConfig.btn53 = btnType
            }
            54 -> {
                btn_54.text = text
                chosenConfig.btn54 = btnType
            }
        }
        ButtonConfigManager.updateTargetConfig(chosenConfigIndex,chosenConfig)
    }

}
