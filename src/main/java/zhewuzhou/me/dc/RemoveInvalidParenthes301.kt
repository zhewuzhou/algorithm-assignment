package zhewuzhou.me.dc

import java.util.*

fun removeInvalidParentheses(s: String): List<String> {
    val res = mutableSetOf<String>()
    doSearch(res, mutableListOf(), s, 0)
    val maxLength = res.maxBy { it.length }?.length!!
    return res.filter { it.length == maxLength }
}

private fun doSearch(res: MutableSet<String>, path: MutableList<Char>, s: String, start: Int) {
    if (isValidParentheses(path)) res.add(path.joinToString(""))
    if (start == s.length) {
        return
    }
    for (i in start..s.lastIndex) {
        path.add(s[i])
        doSearch(res, path, s, i + 1)
        path.removeAt(path.lastIndex)
    }
}

fun isValidParentheses(parentheses: List<Char>): Boolean {
    val s = Stack<Char>()
    for (p in parentheses) {
        if (s.isNotEmpty() && s.peek() == '(' && p == ')') {
            s.pop()
        } else if (p == ')' || p == '(') {
            s.push(p)
        }
    }
    return s.isEmpty()
}
