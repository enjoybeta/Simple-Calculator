package com.simplemobiletools.calculator.activities

import android.app.Activity
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.os.Bundle
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import com.simplemobiletools.calculator.*
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

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButtonConfigManager.setFileDir(this.filesDir)

        setupCopy2Clipboard()
        Calculator.setOnItemClickListener { updateView() }

        //setup fragments
        val adapter = ViewPagerAdapter(supportFragmentManager)
        ButtonConfigManager.initConfigFromFile(this.filesDir)
        for (i in 0 until ButtonConfigManager.getConfigSize()) {
            val frag = FragmentButtons()
            val args = Bundle()
            args.putInt("index", i)
            frag.arguments = args
            frag.updateButtonConfigIndex(i)
            adapter.addFragment(frag,"$i")
        }
        viewPager.adapter = adapter

        AutofitHelper.create(result)
        AutofitHelper.create(formula)
    }

    internal inner class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {
        private val mFragmentList: ArrayList<Fragment> = ArrayList<Fragment>()
        private val mFragmentTitleList: ArrayList<String> = ArrayList<String>()

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
            R.id.config -> startActivityForResult(Intent(applicationContext, ConfigActivity::class.java), CONFIG_CHANGE_REQUEST_CODE)
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CONFIG_CHANGE_REQUEST_CODE) {// Make sure the request was successful
            if (resultCode == Activity.RESULT_OK) {
                for (i in 0 until supportFragmentManager.fragments.size) {
                    val frag = supportFragmentManager.fragments[i] as FragmentButtons
                    frag.updateButtonConfigIndex(i)
                    frag.initButtonText()
                }
            }
        }
    }

}
