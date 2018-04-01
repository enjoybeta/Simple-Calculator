package com.simplemobiletools.calculator.helpers

import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.properties.Delegates

object Calculator {
    lateinit var mListener: (pos: Int) -> Unit

    var result = ""

    var formula by Delegates.observable("") { prop, old, new ->
        mListener.invoke(0)
    }

    fun setOnItemClickListener(listener: ((pos: Int) -> Unit)) {
        mListener = listener
    }

    private fun findExpressionResult(input: String): Double {
        var tmp = input
        tmp = tmp.replace("√", "sqrt")
        tmp = tmp.replace("∛", "cbrt")
        tmp = tmp.replace("mod", "%")
        tmp = tmp.replace("log10", "log")
        return ExpressionBuilder(tmp)
                .build().evaluate()
    }

    fun getFormulaText(): String {
        return formula
    }

    fun getResultText(): String {
        result = try {//TODO timeout
            findExpressionResult(formula).toString()
        } catch (e: Exception) {
            ""
        }
        result = trimDecimal(result)
        if (formula == result) {
            return ""
        }
        return result
    }

    fun trimDecimal(input: String): String {
        if (input == "" || input.length < 3) {
            return input
        }
        return if (input.substring(input.length - 2, input.length) == ".0") {
            input.substring(0, input.length - 2)
        } else {
            input
        }
    }
}
