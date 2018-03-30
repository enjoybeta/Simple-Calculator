package com.simplemobiletools.calculator.helpers

import com.simplemobiletools.calculator.R
import net.objecthunter.exp4j.ExpressionBuilder

//import kotlinx.coroutines.experimental.withTimeout

object Calculator {
    private var formula = ""
    private var result = ""

    fun findExpressionResult(input: String): Double {
        //TODO: remove last digit? eg: "8*8."
        return ExpressionBuilder(input)
                .build().evaluate()
    }

    fun getFormulaText(): String {
        return formula
    }

    fun getResultText(): String {
        return result
    }

    fun handleOperation(operationStr: String) {
        when (operationStr) {
            DECIMAL -> formula += "."
            PLUS -> formula += "+"
            MINUS -> formula += "-"
            MULTIPLY -> formula += "*"
            DIVIDE -> formula += "/"
            MODULO -> formula += "%"
            POWER -> formula += "^"
            ROOT -> formula += "sqrt"//	√
        }
        result = try {//TODO timeout
            findExpressionResult(formula).toString()
        } catch (e: Exception) {
            ""
        }
    }

    fun handleDelete() {
        if (formula.isEmpty()) {
            return
        }
        formula = formula.substring(0, formula.length - 1)
    }

    fun handleReset() {
        formula = ""
        result = ""
    }

    fun numberClicked(id: Int) {
        when (id) {
            R.id.btn_0 -> {
                if (formula != "0") {
                    addDigit(0)
                }
            }
            R.id.btn_1 -> addDigit(1)
            R.id.btn_2 -> addDigit(2)
            R.id.btn_3 -> addDigit(3)
            R.id.btn_4 -> addDigit(4)
            R.id.btn_5 -> addDigit(5)
            R.id.btn_6 -> addDigit(6)
            R.id.btn_7 -> addDigit(7)
            R.id.btn_8 -> addDigit(8)
            R.id.btn_9 -> addDigit(9)
        }
        result = try {//TODO timeout
            findExpressionResult(formula).toString()
        } catch (e: Exception) {
            ""
        }
    }

    private fun addDigit(i: Int) {
        formula += i.toString()
    }

    fun handleEquals() {
        formula = result
    }

    fun trimDecimal(input: String): String {
        if (input == "") {
            return input
        }
        return if (input.substring(input.length - 2, input.length) == ".0") {
            input.substring(0, input.length - 2)
        } else {
            input
        }
    }
}
