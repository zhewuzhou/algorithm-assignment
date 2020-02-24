package zhewuzhou.me.leetcode40

val mapping = mutableMapOf<Int, List<String>>(
    0 to listOf(),
    1 to listOf("()")
)

fun generateParenthesis(n: Int): List<String> {
    return if (mapping.containsKey(n)) {
        mapping[n]!!
    } else {
        val nParenthesis = generateParenthesis(n - 1).flatMap { addParenthesis(it) }.distinct()
        mapping[n] = nParenthesis
        nParenthesis
    }
}

inline fun addParenthesis(s: String): List<String> =
    (-1 until s.length).map {
        if (it == -1) "()$s"
        else s.substring(0..it) + "()" + s.substring(it + 1 until s.length)
    }.distinct()

