package zhewuzhou.me.leetcode20

import java.util.*

fun isValid(s: String): Boolean {
    val mappings = mapOf(
        ')' to '(',
        ']' to '[',
        '}' to '{'
    )
    if (s.isEmpty() || s.length == 1) return false
    val stack = Stack<Char>()
    var si = 0
    while (si < s.length) {
        when (stack.isNotEmpty() && mappings[s[si]] == stack.peek()) {
            true -> stack.pop()
            false -> stack.push(s[si])
        }
        si += 1
    }
    return stack.isEmpty()
}
