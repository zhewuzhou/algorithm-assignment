package zhewuzhou.me.leetcode240

import java.util.*

//1-(2+3) -> operator has to be in stack
//(()) -> can not flatten the parateces
fun calculate(s: String): Int {
    val stack = Stack<Int>()
    var result = 0
    var sign = 1
    var operand = 0
    for (c in s) {
        when {
            c.isDigit() -> operand = operand * 10 + (c - '0')
            c == '-' -> {
                result += operand * sign
                sign = -1
                operand = 0
            }
            c == '+' -> {
                result += operand * sign
                sign = 1
                operand = 0
            }
            c == '(' -> {
                stack.push(result)
                stack.push(sign)
                result = 0
                sign = 1
            }
            c == ')' -> {
                result += operand * sign
                result *= stack.pop()
                result += stack.pop()
                operand = 0
            }
        }
    }
    return result + sign * operand
}
