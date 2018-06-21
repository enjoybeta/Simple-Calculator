package com.simplemobiletools.calculator

import com.simplemobiletools.calculator.activities.MainActivity
import com.simplemobiletools.calculator.helpers.*
import junit.framework.Assert.assertEquals
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class, sdk = intArrayOf(27))
class MainActivityTest {
    private lateinit var activity: MainActivity

    private fun getDisplayedFormula() = activity.formula
    private fun getDisplayedResult() = activity.result

    @Before
    fun setup() {
        activity = Robolectric.setupActivity(MainActivity::class.java)
    }

    @Test
    fun addSimpleDigit() {
        //TODO how to deal with private function
        //activity.
        //assertEquals("2", getDisplayedNumber())
    }

}
