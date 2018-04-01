package com.simplemobiletools.calculator.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.simplemobiletools.calculator.R
import com.simplemobiletools.calculator.buttons.ButtonFactory
import com.simplemobiletools.calculator.fragments.ButtonConfig
import kotlinx.android.synthetic.main.activity_config.*


class ConfigActivity : AppCompatActivity() {
    private var chosenConfig = buttonconfig1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config)
        loadConfig(chosenConfig)
        setupSpinner()
        button_reset.setOnClickListener { resetConfig() }
    }

    private fun setupSpinner() {
        val spinnerStr = arrayOf("First page", "Second page")
        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerStr)
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


}
