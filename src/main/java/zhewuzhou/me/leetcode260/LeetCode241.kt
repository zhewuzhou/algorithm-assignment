package zhewuzhou.me.leetcode260

fun diffWaysToCompute(input: String): List<Int> {
    if (input.isEmpty()) return listOf()
    val caches = mutableMapOf<String, List<Int>>()
    val operations = mapOf(
        '+' to fun(a: Int, b: Int) = a + b,
        '-' to fun(a: Int, b: Int) = a - b,
        '*' to fun(a: Int, b: Int) = a * b
    )

    fun evaluate(s: String): Int {
        var operandL = 0
        var operandR = 0
        var op = Char.MIN_VALUE
        for (c in s) {
            when {
                c.isDigit() -> {
                    if (op == Char.MIN_VALUE) operandL = operandL * 10 + (c - '0')
                    else operandR = operandR * 10 + (c - '0')
                }
                else -> {
                    if (operations.containsKey(c)) op = c
                }
            }
        }
        return if (operations.containsKey(op)) operations[op]!!(operandL, operandR) else operandL
    }

    fun doCompute(s: String, ops: Int): List<Int> {
        if (caches.containsKey(s)) {
            return caches[s]!!
        }
        if (ops <= 1) return listOf(evaluate(s))
        var curOpCount = 0
        val res = mutableListOf<Int>()
        for (i in s.indices) {
            when {
                operations.containsKey(s[i]) -> {
                    val lr = doCompute(s.substring(0, i), curOpCount)
                    val rr = doCompute(s.substring(i + 1), ops - curOpCount - 1)
                    res.addAll(lr.flatMap { l -> rr.map { operations[s[i]]!!(l, it) } })
                    curOpCount += 1
                }
            }
        }
        caches[s] = res
        return res
    }

    val ops = input.filter { operations.containsKey(it) }.count()
    return doCompute(input, ops)
}


