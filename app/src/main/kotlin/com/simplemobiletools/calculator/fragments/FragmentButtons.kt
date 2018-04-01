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
    private lateinit var buttonconfig: ButtonConfig

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

    fun init(bc: ButtonConfig) {
        buttonconfig = bc
        buttonObj11 = ButtonFactory.getButtonInstance(bc.btn11)
        buttonObj12 = ButtonFactory.getButtonInstance(bc.btn12)
        buttonObj13 = ButtonFactory.getButtonInstance(bc.btn13)
        buttonObj14 = ButtonFactory.getButtonInstance(bc.btn14)
        buttonObj21 = ButtonFactory.getButtonInstance(bc.btn21)
        buttonObj22 = ButtonFactory.getButtonInstance(bc.btn22)
        buttonObj23 = ButtonFactory.getButtonInstance(bc.btn23)
        buttonObj24 = ButtonFactory.getButtonInstance(bc.btn24)
        buttonObj31 = ButtonFactory.getButtonInstance(bc.btn31)
        buttonObj32 = ButtonFactory.getButtonInstance(bc.btn32)
        buttonObj33 = ButtonFactory.getButtonInstance(bc.btn33)
        buttonObj34 = ButtonFactory.getButtonInstance(bc.btn34)
        buttonObj41 = ButtonFactory.getButtonInstance(bc.btn41)
        buttonObj42 = ButtonFactory.getButtonInstance(bc.btn42)
        buttonObj43 = ButtonFactory.getButtonInstance(bc.btn43)
        buttonObj44 = ButtonFactory.getButtonInstance(bc.btn44)
        buttonObj51 = ButtonFactory.getButtonInstance(bc.btn51)
        buttonObj52 = ButtonFactory.getButtonInstance(bc.btn52)
        buttonObj53 = ButtonFactory.getButtonInstance(bc.btn53)
        buttonObj54 = ButtonFactory.getButtonInstance(bc.btn54)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_buttons, container, false)
    }

    override fun onStart() {
        super.onStart()
        setClickListeners()
        setLongClickListeners()
        initButtonText()
    }

    private fun initButtonText(){
        btn_11.text = ButtonFactory.getSymbol(buttonconfig.btn11)
        btn_12.text = ButtonFactory.getSymbol(buttonconfig.btn12)
        btn_13.text = ButtonFactory.getSymbol(buttonconfig.btn13)
        btn_14.text = ButtonFactory.getSymbol(buttonconfig.btn14)

        btn_21.text = ButtonFactory.getSymbol(buttonconfig.btn21)
        btn_22.text = ButtonFactory.getSymbol(buttonconfig.btn22)
        btn_23.text = ButtonFactory.getSymbol(buttonconfig.btn23)
        btn_24.text = ButtonFactory.getSymbol(buttonconfig.btn24)

        btn_31.text = ButtonFactory.getSymbol(buttonconfig.btn31)
        btn_32.text = ButtonFactory.getSymbol(buttonconfig.btn32)
        btn_33.text = ButtonFactory.getSymbol(buttonconfig.btn33)
        btn_34.text = ButtonFactory.getSymbol(buttonconfig.btn34)

        btn_41.text = ButtonFactory.getSymbol(buttonconfig.btn41)
        btn_42.text = ButtonFactory.getSymbol(buttonconfig.btn42)
        btn_43.text = ButtonFactory.getSymbol(buttonconfig.btn43)
        btn_44.text = ButtonFactory.getSymbol(buttonconfig.btn44)

        btn_51.text = ButtonFactory.getSymbol(buttonconfig.btn51)
        btn_52.text = ButtonFactory.getSymbol(buttonconfig.btn52)
        btn_53.text = ButtonFactory.getSymbol(buttonconfig.btn53)
        btn_54.text = ButtonFactory.getSymbol(buttonconfig.btn54)
    }

    private fun setClickListeners() {
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

    private fun setLongClickListeners() {
        //row1
        btn_11.setOnLongClickListener {
            buttonObj11.handleLongClick()
            true
        }
        btn_12.setOnLongClickListener {
            buttonObj12.handleLongClick()
            true
        }
        btn_13.setOnLongClickListener {
            buttonObj13.handleLongClick()
            true
        }
        btn_14.setOnLongClickListener {
            buttonObj14.handleLongClick()
            true
        }
        //row2
        btn_21.setOnLongClickListener {
            buttonObj21.handleLongClick()
            true
        }
        btn_22.setOnLongClickListener {
            buttonObj22.handleLongClick()
            true
        }
        btn_23.setOnLongClickListener {
            buttonObj23.handleLongClick()
            true
        }
        btn_24.setOnLongClickListener {
            buttonObj24.handleLongClick()
            true
        }
        //row3
        btn_31.setOnLongClickListener {
            buttonObj31.handleLongClick()
            true
        }
        btn_32.setOnLongClickListener {
            buttonObj32.handleLongClick()
            true
        }
        btn_33.setOnLongClickListener {
            buttonObj33.handleLongClick()
            true
        }
        btn_34.setOnLongClickListener {
            buttonObj34.handleLongClick()
            true
        }
        //row 4
        btn_41.setOnLongClickListener {
            buttonObj41.handleLongClick()
            true
        }
        btn_42.setOnLongClickListener {
            buttonObj42.handleLongClick()
            true
        }
        btn_43.setOnLongClickListener {
            buttonObj43.handleLongClick()
            true
        }
        btn_44.setOnLongClickListener {
            buttonObj44.handleLongClick()
            true
        }
        //row 5
        btn_51.setOnLongClickListener {
            buttonObj51.handleLongClick()
            true
        }
        btn_52.setOnLongClickListener {
            buttonObj52.handleLongClick()
            true
        }
        btn_53.setOnLongClickListener {
            buttonObj53.handleLongClick()
            true
        }
        btn_54.setOnLongClickListener {
            buttonObj54.handleLongClick()
            true
        }
    }

    private fun doClickAnimation(view: View) {
        if (vibrateOnButtonPress) {
            view.performHapticFeedback(1)
        }
    }
}