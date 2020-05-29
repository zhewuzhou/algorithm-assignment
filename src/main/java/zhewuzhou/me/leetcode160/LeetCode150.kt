package zhewuzhou.me.leetcode160

import java.util.*


fun evalRPN(tokens: Array<String>): Int {
    val operators = mapOf(
        "+" to fun(a: Int, b: Int) = a + b,
        "*" to fun(a: Int, b: Int) = a * b,
        "-" to fun(a: Int, b: Int) = b - a,
        "/" to fun(a: Int, b: Int) = b / a
    )
    val stack = Stack<Int>()
    for (t in tokens) {
        if (operators.contains(t)) {
            val a = stack.pop()
            val b = stack.pop()
            stack.push(operators[t]!!(a, b))
        } else {
            stack.push(t.toInt())
        }
    }
    return if (stack.isNotEmpty()) stack.pop() else 0
}
