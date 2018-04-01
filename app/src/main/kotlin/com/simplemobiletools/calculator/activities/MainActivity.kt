package com.simplemobiletools.calculator.activities

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.os.Bundle
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import com.simplemobiletools.calculator.*
import com.simplemobiletools.calculator.fragments.ButtonConfig
import com.simplemobiletools.calculator.fragments.FragmentButtons
import com.simplemobiletools.calculator.helpers.*
import kotlinx.android.synthetic.main.activity_main.*
import me.grantland.widget.AutofitHelper

var vibrateOnButtonPress = true
val buttonconfig1 = ButtonConfig()
val buttonconfig2 = ButtonConfig()

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Calculator.setOnItemClickListener { updateView() }

        val adapter = ViewPagerAdapter(supportFragmentManager)
        val frag1 = FragmentButtons()
        val frag2 = FragmentButtons()
        frag1.init(buttonconfig1)
        frag2.init(buttonconfig2)
        adapter.addFragment(frag1, "1st")
        adapter.addFragment(frag2, "2nd")
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


    private fun updateView() {
        formula.text = Calculator.getFormulaText()
        result.text = Calculator.getResultText()
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

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
