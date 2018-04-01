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
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Intent
import android.view.MenuItem
import android.widget.Toast

var vibrateOnButtonPress = true
val buttonconfig1 = ButtonConfig()
val buttonconfig2 = ButtonConfig()

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupCopy2Clipboard()
        Calculator.setOnItemClickListener { updateView() }

        //setup fragments
        val adapter = ViewPagerAdapter(supportFragmentManager)
        val frag1 = FragmentButtons()
        val frag2 = FragmentButtons()
        buttonconfig1.initConfig1()
        buttonconfig2.initConfig2()
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

    private fun setupCopy2Clipboard() {
        formula.setOnLongClickListener {
            val clipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("text", formula.text)
            clipboard.primaryClip = clip
            Toast.makeText(this, "Copied to clipboard", Toast.LENGTH_SHORT).show()
            true
        }
        result.setOnLongClickListener {
            val clipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("text", result.text)
            clipboard.primaryClip = clip
            Toast.makeText(this, "Copied to clipboard", Toast.LENGTH_SHORT).show()
            true
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.config -> startActivity(Intent(applicationContext, ConfigActivity::class.java))
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }

}
