package com.simplemobiletools.calculator.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import com.simplemobiletools.calculator.BuildConfig
import com.simplemobiletools.calculator.R
import com.simplemobiletools.calculator.extensions.config
import com.simplemobiletools.calculator.extensions.updateViewColors
import com.simplemobiletools.calculator.helpers.*
import com.simplemobiletools.commons.extensions.*
import com.simplemobiletools.commons.helpers.LICENSE_AUTOFITTEXTVIEW
import com.simplemobiletools.commons.helpers.LICENSE_ESPRESSO
import com.simplemobiletools.commons.helpers.LICENSE_KOTLIN
import com.simplemobiletools.commons.helpers.LICENSE_ROBOLECTRIC
import kotlinx.android.synthetic.main.activity_main.*
import me.grantland.widget.AutofitHelper


class MainActivity : SimpleActivity() {
    private var storedTextColor = 0
    private var vibrateOnButtonPress = true
    private var storedUseEnglish = false

    private var calc: Calculator = Calculator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appLaunched()

        setListeners()
        //Calculator.findExpressionResult("x")

        AutofitHelper.create(result)
        AutofitHelper.create(formula)
        storeStateVariables()
        updateViewColors(calculator_holder, config.textColor)
    }

    private fun setListeners() {
        //.
        btn_decimal.setOnClickListener {
            calc.handleOperation(DECIMAL)
            updateView()
        }
        //+
        btn_plus.setOnClickListener {
            calc.handleOperation(PLUS)
            doClickAnimation(it)
            updateView()
        }
        //-
        btn_minus.setOnClickListener {
            calc.handleOperation(MINUS)
            doClickAnimation(it)
            updateView()
        }
        //*
        btn_multiply.setOnClickListener {
            calc.handleOperation(MULTIPLY)
            doClickAnimation(it)
            updateView()
        }
        ///
        btn_divide.setOnClickListener {
            calc.handleOperation(DIVIDE)
            doClickAnimation(it)
            updateView()
        }
        //mod
        btn_modulo.setOnClickListener {
            calc.handleOperation(MODULO)
            doClickAnimation(it)
            updateView()
        }
        //^
        btn_power.setOnClickListener {
            calc.handleOperation(POWER)
            doClickAnimation(it)
            updateView()
        }
        //^
        btn_root.setOnClickListener {
            calc.handleOperation(ROOT)
            doClickAnimation(it)
            updateView()
        }
        //c
        btn_clear.setOnClickListener {
            calc.handleDelete()
            doClickAnimation(it)
            updateView()
        }
        //ccc
        btn_clear.setOnLongClickListener {
            calc.handleReset()
            updateView()
            true
        }
        //0-9
        getButtonIds().forEach {
            it.setOnClickListener {
                calc.numberClicked(it.id)
                doClickAnimation(it)
                updateView()
            }
        }
        //=
        btn_equals.setOnClickListener {
            calc.handleEquals()
            doClickAnimation(it)
            updateView()
        }
        formula.setOnLongClickListener { copyToClipboard(false) }
        result.setOnLongClickListener { copyToClipboard(true) }
    }

    private fun updateView() {
        formula.text = calc.getFormulaText()
        result.text = calc.trimDecimal(calc.getResultText())
    }

    override fun onResume() {
        super.onResume()
        if (storedUseEnglish != config.useEnglish) {
            restartActivity()
            return
        }

        if (storedTextColor != config.textColor) {
            updateViewColors(calculator_holder, config.textColor)
        }

        if (config.preventPhoneFromSleeping) {
            window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        }

        vibrateOnButtonPress = config.vibrateOnButtonPress
    }

    override fun onPause() {
        super.onPause()
        storeStateVariables()
        if (config.preventPhoneFromSleeping) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings -> launchSettings()
            R.id.about -> startAboutActivity(
                    R.string.app_name,
                    LICENSE_KOTLIN or LICENSE_AUTOFITTEXTVIEW or LICENSE_ROBOLECTRIC or LICENSE_ESPRESSO,
                    BuildConfig.VERSION_NAME
            )
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }

    private fun storeStateVariables() {
        config.apply {
            storedTextColor = textColor
            storedUseEnglish = useEnglish
        }
    }

    private fun doClickAnimation(view: View) {
        if (vibrateOnButtonPress) {
            view.performHapticFeedback()
        }
    }

    private fun launchSettings() {
        startActivity(Intent(applicationContext, SettingsActivity::class.java))
    }

    private fun getButtonIds() = arrayOf(btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9)

    private fun copyToClipboard(copyResult: Boolean): Boolean {
        var value = formula.value
        if (copyResult) {
            value = result.value
        }

        return if (value.isEmpty()) {
            false
        } else {
            copyToClipboard(value)
            true
        }
    }

}
