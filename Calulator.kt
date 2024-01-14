package com.project.calculator

import kotlin.system.exitProcess

fun main() {

    fun checkerror(input: Any): Float {
        try {
            input.toString().toFloat()
        } catch (e: NumberFormatException) {
            println("One is unsure if it was an accident, there was text, and one will not be held\nresponsible for thy foolishness to feed it text when it clearly asked for numbers.\nIn which you failed to deliver, Spectacularly.")
            exitProcess(1)
        }
        return input.toString().toFloat()
    }

    val calculator = Calculator()
    val name: String
    var number1: Any
    var number2: Any
    var mode: Int
    var state: Boolean
    var repeat = true

    println("Before we begin, how may i address you? Enter your preferred name :")
    var input = readln()
    name = input

    println("Greetings, $input, welcome to the calculator.")

    while (repeat) {

        state = true
        mode = 0
        println("Please choose your wanted operation, addition, subtraction, multiplication or division : ")
        while (state) {
            print("operation : ")
            input = readln()
            when (input) {
                "addition" -> {
                    mode = 1
                }

                "subtraction" -> {
                    mode = 2
                }

                "multiplication" -> {
                    mode = 3
                }

                "division" -> {
                    mode = 4
                }


                else -> {
                    println("That response in invalid, please try again.\nDo note to type your inputs as specific as stated below:\n - addition\n - subtraction\n - multiplication\n - division")
                }

            }
            if (mode != 0) {
                state = false
            }
        }

        println("Well then, $input it is, enter 2 numbers to perform the operation.")

        println("First number :")
        number1 = readln()
        number1 = checkerror(number1)

        println("Second number :")
        number2 = readln()
        number2 = checkerror(number2)

        when (mode) {
            1 -> {
                calculator.add(number1, number2)
            }

            2 -> {
                calculator.minus(number1, number2)
            }

            3 -> {
                calculator.multiply(number1, number2)
            }

            4 -> {
                calculator.divide(number1, number2)
            }
        }

        state = true
        while (state) {
            println("Well then, $name, would you still like to use the calculator? (Y/N)")
            input = readln()
            when (input) {
                "Y" -> {
                    state = false
                }

                "N" -> {
                    println("Thanks for using the Calculator, I bid thy farewell")
                    state = false
                    repeat = false
                }

                else -> {
                    println("input received is not recognisable, only \'Y\' or \'N\' is accepted.")
                }
            }
        }
    }
}

class Calculator {
    fun add(a: Float, b: Float): Float {
        val result = a + b
        println("$a + $b = $result")
        return result
    }

    fun minus(a: Float, b: Float): Float {
        val result = a - b
        println("$a - $b = $result")
        return result
    }

    fun multiply(a: Float, b: Float): Float {
        val result = a * b
        println("$a x $b = $result")
        return result
    }

    fun divide(a: Float, b: Float): Float {
        val result = a / b
        if (result.isInfinite()) {
            println("$a / $b = $result")
            println("That right there is illegal math an this calculator wants no part of it :)")
            exitProcess(1)
        }
        println("$a / $b = $result")
        return result
    }
}
