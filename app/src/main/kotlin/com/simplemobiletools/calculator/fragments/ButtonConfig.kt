package com.simplemobiletools.calculator.fragments

import com.simplemobiletools.calculator.buttons.ButtonFactory

class ButtonConfig {
    lateinit var btn11: ButtonFactory.ButtonType
    lateinit var btn12: ButtonFactory.ButtonType
    lateinit var btn13: ButtonFactory.ButtonType
    lateinit var btn14: ButtonFactory.ButtonType

    lateinit var btn21: ButtonFactory.ButtonType
    lateinit var btn22: ButtonFactory.ButtonType
    lateinit var btn23: ButtonFactory.ButtonType
    lateinit var btn24: ButtonFactory.ButtonType

    lateinit var btn31: ButtonFactory.ButtonType
    lateinit var btn32: ButtonFactory.ButtonType
    lateinit var btn33: ButtonFactory.ButtonType
    lateinit var btn34: ButtonFactory.ButtonType

    lateinit var btn41: ButtonFactory.ButtonType
    lateinit var btn42: ButtonFactory.ButtonType
    lateinit var btn43: ButtonFactory.ButtonType
    lateinit var btn44: ButtonFactory.ButtonType

    lateinit var btn51: ButtonFactory.ButtonType
    lateinit var btn52: ButtonFactory.ButtonType
    lateinit var btn53: ButtonFactory.ButtonType
    lateinit var btn54: ButtonFactory.ButtonType

    init{
        initConfig1()
    }

    fun initConfig1() {
        btn11 = ButtonFactory.ButtonType.MOD
        btn12 = ButtonFactory.ButtonType.POWER
        btn13 = ButtonFactory.ButtonType.ROOT_SQUARE
        btn14 = ButtonFactory.ButtonType.DEL
        btn21 = ButtonFactory.ButtonType.SEVEN
        btn22 = ButtonFactory.ButtonType.EIGHT
        btn23 = ButtonFactory.ButtonType.NINE
        btn24 = ButtonFactory.ButtonType.DIVIDE
        btn31 = ButtonFactory.ButtonType.FOUR
        btn32 = ButtonFactory.ButtonType.FIVE
        btn33 = ButtonFactory.ButtonType.SIX
        btn34 = ButtonFactory.ButtonType.MULTIPLY
        btn41 = ButtonFactory.ButtonType.ONE
        btn42 = ButtonFactory.ButtonType.TWO
        btn43 = ButtonFactory.ButtonType.THREE
        btn44 = ButtonFactory.ButtonType.MINUS
        btn51 = ButtonFactory.ButtonType.ZERO
        btn52 = ButtonFactory.ButtonType.DECIMAL
        btn53 = ButtonFactory.ButtonType.EQUAL
        btn54 = ButtonFactory.ButtonType.PLUS
    }

    fun initConfig2() {
        btn11 = ButtonFactory.ButtonType.SIN
        btn12 = ButtonFactory.ButtonType.COS
        btn13 = ButtonFactory.ButtonType.TAN
        btn14 = ButtonFactory.ButtonType.ROOT_CUBE
        btn21 = ButtonFactory.ButtonType.LOG
        btn22 = ButtonFactory.ButtonType.PI
        btn23 = ButtonFactory.ButtonType.BRACKET_LEFT
        btn24 = ButtonFactory.ButtonType.BRACKET_RIGHT
        btn31 = ButtonFactory.ButtonType.EMPTY
        btn32 = ButtonFactory.ButtonType.EMPTY
        btn33 = ButtonFactory.ButtonType.EMPTY
        btn34 = ButtonFactory.ButtonType.EMPTY
        btn41 = ButtonFactory.ButtonType.EMPTY
        btn42 = ButtonFactory.ButtonType.EMPTY
        btn43 = ButtonFactory.ButtonType.EMPTY
        btn44 = ButtonFactory.ButtonType.EMPTY
        btn51 = ButtonFactory.ButtonType.EMPTY
        btn52 = ButtonFactory.ButtonType.EMPTY
        btn53 = ButtonFactory.ButtonType.EMPTY
        btn54 = ButtonFactory.ButtonType.EMPTY
    }

}