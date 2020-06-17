package zhewuzhou.me.leetcode240

fun calculateS(s: String): Int {
    val ops = mapOf(
        '*' to fun(a: Int, b: Int) = a * b,
        '/' to fun(a: Int, b: Int) = a / b
    )
    var sign = 1
    var operand = 0
    var highOrderOp: Char? = null
    var highOrderResult = -1
    var result = 0
    for (c in s) {
        when {
            c.isDigit() -> operand = operand * 10 + (c - '0')
            c == '+' || c == '-' -> {
                result += if (highOrderOp != null) {
                    ops[highOrderOp]!!(highOrderResult, operand) * sign
                } else {
                    sign * operand
                }

                sign = if (c == '+') 1 else -1
                highOrderOp = null
                highOrderResult = -1
                operand = 0
            }
            c == '*' || c == '/' -> {
                highOrderResult = if (highOrderResult == -1) {
                    operand
                } else {
                    ops[highOrderOp]!!(highOrderResult, operand)
                }
                operand = 0
                highOrderOp = c
            }
        }
    }
    if (highOrderResult != -1) {
        operand = ops[highOrderOp]!!(highOrderResult, operand)
    }
    result += operand * sign
    return result
}
