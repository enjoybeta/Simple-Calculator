package com.simplemobiletools.calculator.activities

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import com.simplemobiletools.calculator.BuildConfig
import com.simplemobiletools.calculator.*
import com.simplemobiletools.calculator.extensions.updateViewColors
import com.simplemobiletools.calculator.fragments.OneFragment
import com.simplemobiletools.calculator.helpers.*
import kotlinx.android.synthetic.main.activity_main.*
import me.grantland.widget.AutofitHelper


class MainActivity : AppCompatActivity() {
    private var vibrateOnButtonPress = true

    private var calc: Calculator = Calculator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setListeners()
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(OneFragment(), "1st")
        adapter.addFragment(OneFragment(), "2nd")
        viewPager.adapter = adapter

        AutofitHelper.create(result)
        AutofitHelper.create(formula)
    }

    internal inner class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {
        private val mFragmentList = ArrayList<Fragment>()
        private val mFragmentTitleList = ArrayList<String>()

        override fun getItem(position: Int): Fragment {
            return mFragmentList[position]
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFragment(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence {
            return mFragmentTitleList[position]
        }
    }
//    private fun setListeners() {
//        //.
//        btn_decimal.setOnClickListener {
//            calc.handleOperation(DECIMAL)
//            updateView()
//        }
//        //+
//        btn_plus.setOnClickListener {
//            calc.handleOperation(PLUS)
//            doClickAnimation(it)
//            updateView()
//        }
//        //-
//        btn_minus.setOnClickListener {
//            calc.handleOperation(MINUS)
//            doClickAnimation(it)
//            updateView()
//        }
//        //*
//        btn_multiply.setOnClickListener {
//            calc.handleOperation(MULTIPLY)
//            doClickAnimation(it)
//            updateView()
//        }
//        ///
//        btn_divide.setOnClickListener {
//            calc.handleOperation(DIVIDE)
//            doClickAnimation(it)
//            updateView()
//        }
//        //mod
//        btn_modulo.setOnClickListener {
//            calc.handleOperation(MODULO)
//            doClickAnimation(it)
//            updateView()
//        }
//        //^
//        btn_power.setOnClickListener {
//            calc.handleOperation(POWER)
//            doClickAnimation(it)
//            updateView()
//        }
//        //^
//        btn_root.setOnClickListener {
//            calc.handleOperation(ROOT)
//            doClickAnimation(it)
//            updateView()
//        }
//        //c
//        btn_clear.setOnClickListener {
//            calc.handleDelete()
//            doClickAnimation(it)
//            updateView()
//        }
//        //ccc
//        btn_clear.setOnLongClickListener {
//            calc.handleReset()
//            updateView()
//            true
//        }
//        //0-9
//        getButtonIds().forEach {
//            it.setOnClickListener {
//                calc.numberClicked(it.id)
//                doClickAnimation(it)
//                updateView()
//            }
//        }
//        //=
//        btn_equals.setOnClickListener {
//            calc.handleEquals()
//            doClickAnimation(it)
//            updateView()
//        }
//        formula.setOnLongClickListener { copyToClipboard(false) }
//        result.setOnLongClickListener { copyToClipboard(true) }
//    }

    private fun updateView() {
        formula.text = calc.getFormulaText()
        result.text = calc.trimDecimal(calc.getResultText())
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    private fun doClickAnimation(view: View) {
        if (vibrateOnButtonPress) {
            view.performHapticFeedback(1)
        }
    }

    //private fun getButtonIds() = arrayOf(btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9)

//    private fun copyToClipboard(copyResult: Boolean): Boolean {
//        var value = formula.text
//        if (copyResult) {
//            value = result.text
//        }
//
//        return if (value.isEmpty()) {
//            false
//        } else {
//            copyToClipboard(value)
//            true
//        }
//    }

}
