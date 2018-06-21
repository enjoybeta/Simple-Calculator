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
        LOGTWO,
        LOGTEN,
        LOGE,
        PI,
        BRACKET_LEFT,
        BRACKET_RIGHT,
        E;
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
            LOGTWO -> "log2"
            LOGTEN -> "log10"
            LOGE -> "loge"
            PI -> "π"
            BRACKET_LEFT -> "("
            BRACKET_RIGHT -> ")"
            E -> "e"
            else -> "error"
        }
    }

    fun getType(m: String): ButtonFactory.ButtonType {
        return when (m) {
            "" -> EMPTY
            "0" -> ZERO
            "1" -> ONE
            "2" -> TWO
            "3" -> THREE
            "4" -> FOUR
            "5" -> FIVE
            "6" -> SIX
            "7" -> SEVEN
            "8" -> EIGHT
            "9" -> NINE

            "." -> DECIMAL
            "=" -> EQUAL
            "Del" -> DEL

            "+" -> PLUS
            "-" -> MINUS
            "*" -> MULTIPLY
            "/" -> DIVIDE

            "mod" -> MOD
            "^" -> POWER
            "√" -> ROOT_SQUARE
            "∛" -> ROOT_CUBE
            "sin" -> SIN
            "cos" -> COS
            "tan" -> TAN
            "log2" -> LOGTWO
            "log10" -> LOGTEN
            "loge" -> LOGE
            "π" -> PI
            "(" -> BRACKET_LEFT
            ")" -> BRACKET_RIGHT
            "e" -> E
            else -> EMPTY
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
            LOGTWO -> BtnLogTwo()
            LOGTEN -> BtnLogTen()
            LOGE -> BtnLogE()
            PI -> BtnPi()
            BRACKET_LEFT -> BtnBracketLeft()
            BRACKET_RIGHT -> BtnBracketRight()
            E -> BtnE()
        }
    }

    private class BtnEmpty : Buttons() {
        override fun handleClick() {}
        override fun handleLongClick() {}
    }

    private class BtnZero : Buttons() {
        override fun handleClick() {
            if (Calculator.formula != "0") {
                Calculator.formula += "0"
            }
        }
    }

    private class BtnOne : Buttons() {
        override fun handleClick() {
            Calculator.formula += getSymbol(ONE)
        }
    }

    private class BtnTwo : Buttons() {
        override fun handleClick() {
            Calculator.formula += getSymbol(TWO)
        }
    }

    private class BtnThree : Buttons() {
        override fun handleClick() {
            Calculator.formula += getSymbol(THREE)
        }
    }

    private class BtnFour : Buttons() {
        override fun handleClick() {
            Calculator.formula += getSymbol(FOUR)
        }
    }

    private class BtnFive : Buttons() {
        override fun handleClick() {
            Calculator.formula += getSymbol(FIVE)
        }
    }

    private class BtnSix : Buttons() {
        override fun handleClick() {
            Calculator.formula += getSymbol(SIX)
        }
    }

    private class BtnSeven : Buttons() {
        override fun handleClick() {
            Calculator.formula += getSymbol(SEVEN)
        }
    }

    private class BtnEight : Buttons() {
        override fun handleClick() {
            Calculator.formula += getSymbol(EIGHT)
        }
    }

    private class BtnNine : Buttons() {
        override fun handleClick() {
            Calculator.formula += getSymbol(NINE)
        }
    }

    private class BtnDecimal : Buttons() {
        override fun handleClick() {
            Calculator.formula += getSymbol(DECIMAL)
        }
    }

    private class BtnEqual : Buttons() {
        override fun handleClick() {
            Calculator.formula = Calculator.getResultText()
            Calculator.result = ""
        }
    }

    private class BtnDel : Buttons() {
        override fun handleClick() {
            if (Calculator.formula.isEmpty()) {
                return
            }
            var needToDel: Int = 1
            val reversedStr = Calculator.formula.reversed()
            when {
                Calculator.formula.length >= 6 -> run {
                    when {
                        reversedStr.substring(0, 6) == "(01gol" -> needToDel = 6//delete "log10("
                    }
                }
                Calculator.formula.length >= 5 -> {
                    when {
                        reversedStr.substring(0, 5) == "(2gol" -> needToDel = 5//delete "log2("
                        reversedStr.substring(0, 5) == "(egol" -> needToDel = 5//delete "loge("
                    }
                }
                Calculator.formula.length >= 4 -> {
                    when {
                        reversedStr.substring(0, 4) == "(nis" -> needToDel = 4//delete "sin("
                        reversedStr.substring(0, 4) == "(soc" -> needToDel = 4//delete "cos("
                        reversedStr.substring(0, 4) == "(nat" -> needToDel = 4//delete "tan("
                    }
                }
                Calculator.formula.length >= 3 -> {
                    when {
                        reversedStr.substring(0, 3) == "dom" -> needToDel = 3//delete "mod"
                    }
                }
            }
            Calculator.formula = Calculator.formula.substring(0, Calculator.formula.length - needToDel)
        }

        override fun handleLongClick() {
            Calculator.formula = ""
            Calculator.result = ""
        }
    }

    private class BtnPlus : Buttons() {
        override fun handleClick() {
            Calculator.formula += getSymbol(PLUS)
        }
    }

    private class BtnMinus : Buttons() {
        override fun handleClick() {
            Calculator.formula += getSymbol(MINUS)
        }
    }

    private class BtnMultiply : Buttons() {
        override fun handleClick() {
            Calculator.formula += getSymbol(MULTIPLY)
        }
    }

    private class BtnDivide : Buttons() {
        override fun handleClick() {
            Calculator.formula += getSymbol(DIVIDE)
        }
    }

    private class BtnMod : Buttons() {
        override fun handleClick() {
            Calculator.formula += getSymbol(MOD)
        }
    }

    private class BtnPower : Buttons() {
        override fun handleClick() {
            Calculator.formula += getSymbol(POWER)
        }
    }

    private class BtnRootSquare : Buttons() {
        override fun handleClick() {
            Calculator.formula += getSymbol(ROOT_SQUARE)
        }
    }

    private class BtnRootCube : Buttons() {
        override fun handleClick() {
            Calculator.formula += getSymbol(ROOT_CUBE)
        }
    }

    private class BtnSin : Buttons() {
        override fun handleClick() {
            Calculator.formula += getSymbol(SIN) + "("
        }
    }

    private class BtnCos : Buttons() {
        override fun handleClick() {
            Calculator.formula += getSymbol(COS) + "("
        }
    }

    private class BtnTan : Buttons() {
        override fun handleClick() {
            Calculator.formula += getSymbol(TAN) + "("
        }
    }

    private class BtnLogTwo : Buttons() {
        override fun handleClick() {
            Calculator.formula += getSymbol(LOGTWO) + "("
        }
    }

    private class BtnLogTen : Buttons() {
        override fun handleClick() {
            Calculator.formula += getSymbol(LOGTEN) + "("
        }
    }

    private class BtnLogE : Buttons() {
        override fun handleClick() {
            Calculator.formula += getSymbol(LOGE) + "("
        }
    }

    private class BtnPi : Buttons() {
        override fun handleClick() {
            Calculator.formula += getSymbol(PI)
        }
    }

    private class BtnBracketLeft : Buttons() {
        override fun handleClick() {
            Calculator.formula += getSymbol(BRACKET_LEFT)
        }
    }

    private class BtnBracketRight : Buttons() {
        override fun handleClick() {
            Calculator.formula += getSymbol(BRACKET_RIGHT)
        }
    }

    private class BtnE : Buttons() {
        override fun handleClick() {
            Calculator.formula += getSymbol(E)
        }
    }
}