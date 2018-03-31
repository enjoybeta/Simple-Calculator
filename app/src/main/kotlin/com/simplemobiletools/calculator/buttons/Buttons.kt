package com.simplemobiletools.calculator.buttons

import com.simplemobiletools.calculator.buttons.ButtonFactory.ButtonType.*
import com.simplemobiletools.calculator.helpers.Calculator

open interface Buttons {
    fun handleClick()
    fun handleLongClick()
}

object ButtonFactory {
    enum class ButtonType { ZERO,
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

        PLUS,
        MINUS,
        MULTIPLY,
        DIVIDE,

        MOD,
        POWER,
        ROOT_SQUARE,
        DEL
    }

    /**
     * Called by clients to get a Button based on the ButtonType
     */
    fun getButtonInstance(type: ButtonType): Buttons {
        return when (type) {
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

            PLUS -> BtnPlus()
            MINUS -> BtnMinus()
            MULTIPLY -> BtnMultiply()
            DIVIDE -> BtnDivide()

            MOD -> BtnMod()
            POWER -> BtnPower()
            ROOT_SQUARE -> BtnRootSquare()
            DEL -> BtnDel()
        }
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
            Calculator.formula += "1"
        }

        override fun handleLongClick() {}
    }

    private class BtnTwo : Buttons {
        override fun handleClick() {
            Calculator.formula += "2"
        }

        override fun handleLongClick() {}
    }

    private class BtnThree : Buttons {
        override fun handleClick() {
            Calculator.formula += "3"
        }

        override fun handleLongClick() {}
    }

    private class BtnFour : Buttons {
        override fun handleClick() {
            Calculator.formula += "4"
        }

        override fun handleLongClick() {}
    }

    private class BtnFive : Buttons {
        override fun handleClick() {
            Calculator.formula += "5"
        }

        override fun handleLongClick() {}
    }

    private class BtnSix : Buttons {
        override fun handleClick() {
            Calculator.formula += "6"
        }

        override fun handleLongClick() {}
    }

    private class BtnSeven : Buttons {
        override fun handleClick() {
            Calculator.formula += "7"
        }

        override fun handleLongClick() {}
    }

    private class BtnEight : Buttons {
        override fun handleClick() {
            Calculator.formula += "8"
        }

        override fun handleLongClick() {}
    }

    private class BtnNine : Buttons {
        override fun handleClick() {
            Calculator.formula += "9"
        }

        override fun handleLongClick() {}
    }

    private class BtnDecimal : Buttons {
        override fun handleClick() {
            Calculator.formula += "."
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

    private class BtnPlus : Buttons {
        override fun handleClick() {
            Calculator.formula += "+"
        }

        override fun handleLongClick() {}
    }

    private class BtnMinus : Buttons {
        override fun handleClick() {
            Calculator.formula += "-"
        }

        override fun handleLongClick() {}
    }

    private class BtnMultiply : Buttons {
        override fun handleClick() {
            Calculator.formula += "*"
        }

        override fun handleLongClick() {}
    }

    private class BtnDivide : Buttons {
        override fun handleClick() {
            Calculator.formula += "/"
        }

        override fun handleLongClick() {}
    }

    private class BtnMod : Buttons {
        override fun handleClick() {
            Calculator.formula += "mod"
        }

        override fun handleLongClick() {}
    }

    private class BtnPower : Buttons {
        override fun handleClick() {
            Calculator.formula += "^"
        }

        override fun handleLongClick() {}
    }

    private class BtnRootSquare : Buttons {
        override fun handleClick() {
            Calculator.formula += "√"
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

}