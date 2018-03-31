package com.simplemobiletools.calculator.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.simplemobiletools.calculator.R
import com.simplemobiletools.calculator.activities.vibrateOnButtonPress
import com.simplemobiletools.calculator.buttons.ButtonFactory
import com.simplemobiletools.calculator.buttons.Buttons
import kotlinx.android.synthetic.main.fragment_buttons.*

class FragmentButtons : Fragment() {
    private lateinit var buttonObj11: Buttons
    private lateinit var buttonObj12: Buttons
    private lateinit var buttonObj13: Buttons
    private lateinit var buttonObj14: Buttons

    private lateinit var buttonObj21: Buttons
    private lateinit var buttonObj22: Buttons
    private lateinit var buttonObj23: Buttons
    private lateinit var buttonObj24: Buttons

    private lateinit var buttonObj31: Buttons
    private lateinit var buttonObj32: Buttons
    private lateinit var buttonObj33: Buttons
    private lateinit var buttonObj34: Buttons

    private lateinit var buttonObj41: Buttons
    private lateinit var buttonObj42: Buttons
    private lateinit var buttonObj43: Buttons
    private lateinit var buttonObj44: Buttons

    private lateinit var buttonObj51: Buttons
    private lateinit var buttonObj52: Buttons
    private lateinit var buttonObj53: Buttons
    private lateinit var buttonObj54: Buttons

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buttons, container, false)
    }

    override fun onStart() {
        super.onStart()
        initButtonObjects()
        setListeners()
    }

    private fun initButtonObjects() {
        buttonObj11 = ButtonFactory.getButtonInstance(ButtonFactory.ButtonType.MOD)
        buttonObj12 = ButtonFactory.getButtonInstance(ButtonFactory.ButtonType.POWER)
        buttonObj13 = ButtonFactory.getButtonInstance(ButtonFactory.ButtonType.ROOT_SQUARE)
        buttonObj14 = ButtonFactory.getButtonInstance(ButtonFactory.ButtonType.DEL)

        buttonObj21 = ButtonFactory.getButtonInstance(ButtonFactory.ButtonType.SEVEN)
        buttonObj22 = ButtonFactory.getButtonInstance(ButtonFactory.ButtonType.EIGHT)
        buttonObj23 = ButtonFactory.getButtonInstance(ButtonFactory.ButtonType.NINE)
        buttonObj24 = ButtonFactory.getButtonInstance(ButtonFactory.ButtonType.DIVIDE)

        buttonObj31 = ButtonFactory.getButtonInstance(ButtonFactory.ButtonType.FOUR)
        buttonObj32 = ButtonFactory.getButtonInstance(ButtonFactory.ButtonType.FIVE)
        buttonObj33 = ButtonFactory.getButtonInstance(ButtonFactory.ButtonType.SIX)
        buttonObj34 = ButtonFactory.getButtonInstance(ButtonFactory.ButtonType.MULTIPLY)

        buttonObj41 = ButtonFactory.getButtonInstance(ButtonFactory.ButtonType.ONE)
        buttonObj42 = ButtonFactory.getButtonInstance(ButtonFactory.ButtonType.TWO)
        buttonObj43 = ButtonFactory.getButtonInstance(ButtonFactory.ButtonType.THREE)
        buttonObj44 = ButtonFactory.getButtonInstance(ButtonFactory.ButtonType.MINUS)

        buttonObj51 = ButtonFactory.getButtonInstance(ButtonFactory.ButtonType.ZERO)
        buttonObj52 = ButtonFactory.getButtonInstance(ButtonFactory.ButtonType.DECIMAL)
        buttonObj53 = ButtonFactory.getButtonInstance(ButtonFactory.ButtonType.EQUAL)
        buttonObj54 = ButtonFactory.getButtonInstance(ButtonFactory.ButtonType.PLUS)
    }

    private fun setListeners() {
        //row1
        btn_11.setOnClickListener {
            buttonObj11.handleClick()
            doClickAnimation(it)
        }
        btn_12.setOnClickListener {
            buttonObj12.handleClick()
            doClickAnimation(it)
        }
        btn_13.setOnClickListener {
            buttonObj13.handleClick()
            doClickAnimation(it)
        }
        btn_14.setOnClickListener {
            buttonObj14.handleClick()
            doClickAnimation(it)
        }
        //row2
        btn_21.setOnClickListener {
            buttonObj21.handleClick()
            doClickAnimation(it)
        }
        btn_22.setOnClickListener {
            buttonObj22.handleClick()
            doClickAnimation(it)
        }
        btn_23.setOnClickListener {
            buttonObj23.handleClick()
            doClickAnimation(it)
        }
        btn_24.setOnClickListener {
            buttonObj24.handleClick()
            doClickAnimation(it)
        }
        //row3
        btn_31.setOnClickListener {
            buttonObj31.handleClick()
            doClickAnimation(it)
        }
        btn_32.setOnClickListener {
            buttonObj32.handleClick()
            doClickAnimation(it)
        }
        btn_33.setOnClickListener {
            buttonObj33.handleClick()
            doClickAnimation(it)
        }
        btn_34.setOnClickListener {
            buttonObj34.handleClick()
            doClickAnimation(it)
        }
        //row 4
        btn_41.setOnClickListener {
            buttonObj41.handleClick()
            doClickAnimation(it)
        }
        btn_42.setOnClickListener {
            buttonObj42.handleClick()
            doClickAnimation(it)
        }
        btn_43.setOnClickListener {
            buttonObj43.handleClick()
            doClickAnimation(it)
        }
        btn_44.setOnClickListener {
            buttonObj44.handleClick()
            doClickAnimation(it)
        }
        //row 5
        btn_51.setOnClickListener {
            buttonObj51.handleClick()
            doClickAnimation(it)
        }
        btn_52.setOnClickListener {
            buttonObj52.handleClick()
            doClickAnimation(it)
        }
        btn_53.setOnClickListener {
            buttonObj53.handleClick()
            doClickAnimation(it)
        }
        btn_54.setOnClickListener {
            buttonObj54.handleClick()
            doClickAnimation(it)
        }
    }

    private fun doClickAnimation(view: View) {
        if (vibrateOnButtonPress) {
            view.performHapticFeedback(1)
        }
    }
}