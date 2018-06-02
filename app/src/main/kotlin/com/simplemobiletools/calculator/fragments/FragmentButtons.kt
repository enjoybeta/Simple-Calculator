package com.simplemobiletools.calculator.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.simplemobiletools.calculator.R
import com.simplemobiletools.calculator.activities.vibrateOnButtonPress
import com.simplemobiletools.calculator.buttons.ButtonConfig
import com.simplemobiletools.calculator.buttons.ButtonFactory
import com.simplemobiletools.calculator.buttons.Buttons
import kotlinx.android.synthetic.main.fragment_buttons.*

class FragmentButtons : Fragment() {
    private lateinit var buttonconfig: ButtonConfig

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_buttons, container, false)
    }

    override fun onStart() {
        super.onStart()
        setClickListeners()
        setLongClickListeners()
        initButtonText()
    }

    fun initButtonConfig(bc: ButtonConfig) {
        buttonconfig = bc
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
            ButtonFactory.getButtonInstance(buttonconfig.btn11).handleClick()
            doClickAnimation(it)
        }
        btn_12.setOnClickListener {
            ButtonFactory.getButtonInstance(buttonconfig.btn12).handleClick()
        }
        btn_13.setOnClickListener {
            ButtonFactory.getButtonInstance(buttonconfig.btn13).handleClick()
            doClickAnimation(it)
        }
        btn_14.setOnClickListener {
            ButtonFactory.getButtonInstance(buttonconfig.btn14).handleClick()
            doClickAnimation(it)
        }
        //row2
        btn_21.setOnClickListener {
            ButtonFactory.getButtonInstance(buttonconfig.btn21).handleClick()
            doClickAnimation(it)
        }
        btn_22.setOnClickListener {
            ButtonFactory.getButtonInstance(buttonconfig.btn22).handleClick()
            doClickAnimation(it)
        }
        btn_23.setOnClickListener {
            ButtonFactory.getButtonInstance(buttonconfig.btn23).handleClick()
            doClickAnimation(it)
        }
        btn_24.setOnClickListener {
            ButtonFactory.getButtonInstance(buttonconfig.btn24).handleClick()
            doClickAnimation(it)
        }
        //row3
        btn_31.setOnClickListener {
            ButtonFactory.getButtonInstance(buttonconfig.btn31).handleClick()
            doClickAnimation(it)
        }
        btn_32.setOnClickListener {
            ButtonFactory.getButtonInstance(buttonconfig.btn32).handleClick()
            doClickAnimation(it)
        }
        btn_33.setOnClickListener {
            ButtonFactory.getButtonInstance(buttonconfig.btn33).handleClick()
            doClickAnimation(it)
        }
        btn_34.setOnClickListener {
            ButtonFactory.getButtonInstance(buttonconfig.btn34).handleClick()
            doClickAnimation(it)
        }
        //row 4
        btn_41.setOnClickListener {
            ButtonFactory.getButtonInstance(buttonconfig.btn41).handleClick()
            doClickAnimation(it)
        }
        btn_42.setOnClickListener {
            ButtonFactory.getButtonInstance(buttonconfig.btn42).handleClick()
            doClickAnimation(it)
        }
        btn_43.setOnClickListener {
            ButtonFactory.getButtonInstance(buttonconfig.btn43).handleClick()
            doClickAnimation(it)
        }
        btn_44.setOnClickListener {
            ButtonFactory.getButtonInstance(buttonconfig.btn44).handleClick()
            doClickAnimation(it)
        }
        //row 5
        btn_51.setOnClickListener {
            ButtonFactory.getButtonInstance(buttonconfig.btn51).handleClick()
            doClickAnimation(it)
        }
        btn_52.setOnClickListener {
            ButtonFactory.getButtonInstance(buttonconfig.btn52).handleClick()
            doClickAnimation(it)
        }
        btn_53.setOnClickListener {
            ButtonFactory.getButtonInstance(buttonconfig.btn53).handleClick()
            doClickAnimation(it)
        }
        btn_54.setOnClickListener {
            ButtonFactory.getButtonInstance(buttonconfig.btn54).handleClick()
            doClickAnimation(it)
        }
    }

    private fun setLongClickListeners() {
        //row1
        btn_11.setOnLongClickListener {
            ButtonFactory.getButtonInstance(buttonconfig.btn11).handleLongClick()
            true
        }
        btn_12.setOnLongClickListener {
            ButtonFactory.getButtonInstance(buttonconfig.btn12).handleLongClick()
            true
        }
        btn_13.setOnLongClickListener {
            ButtonFactory.getButtonInstance(buttonconfig.btn13).handleLongClick()
            true
        }
        btn_14.setOnLongClickListener {
            ButtonFactory.getButtonInstance(buttonconfig.btn14).handleLongClick()
            true
        }
        //row2
        btn_21.setOnLongClickListener {
            ButtonFactory.getButtonInstance(buttonconfig.btn21).handleLongClick()
            true
        }
        btn_22.setOnLongClickListener {
            ButtonFactory.getButtonInstance(buttonconfig.btn22).handleLongClick()
            true
        }
        btn_23.setOnLongClickListener {
            ButtonFactory.getButtonInstance(buttonconfig.btn23).handleLongClick()
            true
        }
        btn_24.setOnLongClickListener {
            ButtonFactory.getButtonInstance(buttonconfig.btn24).handleLongClick()
            true
        }
        //row3
        btn_31.setOnLongClickListener {
            ButtonFactory.getButtonInstance(buttonconfig.btn31).handleLongClick()
            true
        }
        btn_32.setOnLongClickListener {
            ButtonFactory.getButtonInstance(buttonconfig.btn32).handleLongClick()
            true
        }
        btn_33.setOnLongClickListener {
            ButtonFactory.getButtonInstance(buttonconfig.btn33).handleLongClick()
            true
        }
        btn_34.setOnLongClickListener {
            ButtonFactory.getButtonInstance(buttonconfig.btn34).handleLongClick()
            true
        }
        //row 4
        btn_41.setOnLongClickListener {
            ButtonFactory.getButtonInstance(buttonconfig.btn41).handleLongClick()
            true
        }
        btn_42.setOnLongClickListener {
            ButtonFactory.getButtonInstance(buttonconfig.btn42).handleLongClick()
            true
        }
        btn_43.setOnLongClickListener {
            ButtonFactory.getButtonInstance(buttonconfig.btn43).handleLongClick()
            true
        }
        btn_44.setOnLongClickListener {
            ButtonFactory.getButtonInstance(buttonconfig.btn44).handleLongClick()
            true
        }
        //row 5
        btn_51.setOnLongClickListener {
            ButtonFactory.getButtonInstance(buttonconfig.btn51).handleLongClick()
            true
        }
        btn_52.setOnLongClickListener {
            ButtonFactory.getButtonInstance(buttonconfig.btn52).handleLongClick()
            true
        }
        btn_53.setOnLongClickListener {
            ButtonFactory.getButtonInstance(buttonconfig.btn53).handleLongClick()
            true
        }
        btn_54.setOnLongClickListener {
            ButtonFactory.getButtonInstance(buttonconfig.btn54).handleLongClick()
            true
        }
    }

    private fun doClickAnimation(view: View) {
        if (vibrateOnButtonPress) {
            view.performHapticFeedback(1)
        }
    }
}