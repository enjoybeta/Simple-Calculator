package com.simplemobiletools.calculator.buttons

import com.simplemobiletools.calculator.helpers.Calculator
import com.simplemobiletools.calculator.buttons.ButtonFactory.ButtonType.*

object ButtonFactory {
    enum class ButtonType {
        EMPTY,

        ZERO,
        ONE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,

        DECIMAL,
        EQUAL,
        DEL,

        PLUS,
        MINUS,
        MULTIPLY,
        DIVIDE,

        MOD,
        POWER,
        ROOT_SQUARE,
        ROOT_CUBE,
        SIN,
        COS,
        TAN,
        LOG,
        PI,
        BRACKET_LEFT,
        BRACKET_RIGHT;
    }

    fun getSymbol(m: ButtonFactory.ButtonType): String {
        return when (m) {
            EMPTY -> ""
            ZERO -> "0"
            ONE -> "1"
            TWO -> "2"
            THREE -> "3"
            FOUR -> "4"
            FIVE -> "5"
            SIX -> "6"
            SEVEN -> "7"
            EIGHT -> "8"
            NINE -> "9"

            DECIMAL -> "."
            EQUAL -> "="
            DEL -> "Del"

            PLUS -> "+"
            MINUS -> "-"
            MULTIPLY -> "*"
            DIVIDE -> "/"

            MOD -> "mod"
            POWER -> "^"
            ROOT_SQUARE -> "√"
            ROOT_CUBE -> "∛"
            SIN -> "sin"
            COS -> "cos"
            TAN -> "tan"
            LOG -> "log"
            PI -> "π"
            BRACKET_LEFT -> "("
            BRACKET_RIGHT -> ")"
            else -> "error"
        }
    }

    /**
     * Called by clients to get a Button based on the ButtonType
     */
    fun getButtonInstance(type: ButtonType): Buttons {
        return when (type) {
            EMPTY -> BtnEmpty()
            ZERO -> BtnZero()
            ONE -> BtnOne()
            TWO -> BtnTwo()
            THREE -> BtnThree()
            FOUR -> BtnFour()
            FIVE -> BtnFive()
            SIX -> BtnSix()
            SEVEN -> BtnSeven()
            EIGHT -> BtnEight()
            NINE -> BtnNine()

            DECIMAL -> BtnDecimal()
            EQUAL -> BtnEqual()
            DEL -> BtnDel()

            PLUS -> BtnPlus()
            MINUS -> BtnMinus()
            MULTIPLY -> BtnMultiply()
            DIVIDE -> BtnDivide()

            MOD -> BtnMod()
            POWER -> BtnPower()
            ROOT_SQUARE -> BtnRootSquare()
            ROOT_CUBE -> BtnRootCube()

            SIN -> BtnSin()
            COS -> BtnCos()
            TAN -> BtnTan()
            LOG -> BtnLog()
            PI -> BtnPi()
            BRACKET_LEFT -> BtnBracketLeft()
            BRACKET_RIGHT -> BtnBracketRight()
        }
    }

    private class BtnEmpty : Buttons {
        override fun handleClick() {}
        override fun handleLongClick() {}
    }

    private class BtnZero : Buttons {
        override fun handleClick() {
            if (Calculator.formula != "0") {
                Calculator.formula += "0"
            }
        }

        override fun handleLongClick() {}
    }

    private class BtnOne : Buttons {
        override fun handleClick() {
            Calculator.formula += getSymbol(ONE)
        }

        override fun handleLongClick() {}
    }

    private class BtnTwo : Buttons {
        override fun handleClick() {
            Calculator.formula += getSymbol(TWO)
        }

        override fun handleLongClick() {}
    }

    private class BtnThree : Buttons {
        override fun handleClick() {
            Calculator.formula += getSymbol(THREE)
        }

        override fun handleLongClick() {}
    }

    private class BtnFour : Buttons {
        override fun handleClick() {
            Calculator.formula += getSymbol(FOUR)
        }

        override fun handleLongClick() {}
    }

    private class BtnFive : Buttons {
        override fun handleClick() {
            Calculator.formula += getSymbol(FIVE)
        }

        override fun handleLongClick() {}
    }

    private class BtnSix : Buttons {
        override fun handleClick() {
            Calculator.formula += getSymbol(SIX)
        }

        override fun handleLongClick() {}
    }

    private class BtnSeven : Buttons {
        override fun handleClick() {
            Calculator.formula += getSymbol(SEVEN)
        }

        override fun handleLongClick() {}
    }

    private class BtnEight : Buttons {
        override fun handleClick() {
            Calculator.formula += getSymbol(EIGHT)
        }

        override fun handleLongClick() {}
    }

    private class BtnNine : Buttons {
        override fun handleClick() {
            Calculator.formula += getSymbol(NINE)
        }

        override fun handleLongClick() {}
    }

    private class BtnDecimal : Buttons {
        override fun handleClick() {
            Calculator.formula += getSymbol(DECIMAL)
        }

        override fun handleLongClick() {}
    }

    private class BtnEqual : Buttons {
        override fun handleClick() {
            Calculator.formula = Calculator.trimDecimal(Calculator.result)
            Calculator.result = ""
        }

        override fun handleLongClick() {}
    }

    private class BtnDel : Buttons {
        override fun handleClick() {
            if (Calculator.formula.isEmpty()) {
                return
            }
            Calculator.formula = Calculator.formula.substring(0, Calculator.formula.length - 1)
        }

        override fun handleLongClick() {
            Calculator.formula = ""
            Calculator.result = ""
        }
    }

    private class BtnPlus : Buttons {
        override fun handleClick() {
            Calculator.formula += getSymbol(PLUS)
        }

        override fun handleLongClick() {}
    }

    private class BtnMinus : Buttons {
        override fun handleClick() {
            Calculator.formula += getSymbol(MINUS)
        }

        override fun handleLongClick() {}
    }

    private class BtnMultiply : Buttons {
        override fun handleClick() {
            Calculator.formula += getSymbol(MULTIPLY)
        }

        override fun handleLongClick() {}
    }

    private class BtnDivide : Buttons {
        override fun handleClick() {
            Calculator.formula += getSymbol(DIVIDE)
        }

        override fun handleLongClick() {}
    }

    private class BtnMod : Buttons {
        override fun handleClick() {
            Calculator.formula += getSymbol(MOD)
        }

        override fun handleLongClick() {}
    }

    private class BtnPower : Buttons {
        override fun handleClick() {
            Calculator.formula += getSymbol(POWER)
        }

        override fun handleLongClick() {}
    }

    private class BtnRootSquare : Buttons {
        override fun handleClick() {
            Calculator.formula += getSymbol(ROOT_SQUARE)
        }

        override fun handleLongClick() {}
    }

    private class BtnRootCube : Buttons {
        override fun handleClick() {
            Calculator.formula += getSymbol(ROOT_CUBE)
        }

        override fun handleLongClick() {}
    }

    private class BtnSin : Buttons {
        override fun handleClick() {
            Calculator.formula += getSymbol(SIN) + "("
        }

        override fun handleLongClick() {}
    }

    private class BtnCos : Buttons {
        override fun handleClick() {
            Calculator.formula += getSymbol(COS) + "("
        }

        override fun handleLongClick() {}
    }

    private class BtnTan : Buttons {
        override fun handleClick() {
            Calculator.formula += getSymbol(TAN) + "("
        }

        override fun handleLongClick() {}
    }

    private class BtnLog : Buttons {
        override fun handleClick() {
            Calculator.formula += getSymbol(LOG) + "10("
        }

        override fun handleLongClick() {}
    }

    private class BtnPi : Buttons {
        override fun handleClick() {
            Calculator.formula += getSymbol(PI)
        }

        override fun handleLongClick() {}
    }

    private class BtnBracketLeft : Buttons {
        override fun handleClick() {
            Calculator.formula += getSymbol(BRACKET_LEFT)
        }

        override fun handleLongClick() {}
    }

    private class BtnBracketRight : Buttons {
        override fun handleClick() {
            Calculator.formula += getSymbol(BRACKET_RIGHT)
        }

        override fun handleLongClick() {}
    }
}