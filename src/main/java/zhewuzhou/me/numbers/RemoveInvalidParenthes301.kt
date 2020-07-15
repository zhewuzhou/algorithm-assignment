package zhewuzhou.me.numbers

import java.util.*


fun removeInvalidParenthesesSlow(s: String): List<String> {
    if (s.isEmpty()) return listOf("")
    if (!s.contains('(') && !s.contains(')')) return listOf(s)
    val res = TreeMap<Int, MutableSet<String>>()
    res[0] = mutableSetOf("")
    doSearch(res, mutableListOf(), s, 0)
    return res[res.lastKey()]!!.toList()
}

private fun doSearch(res: TreeMap<Int, MutableSet<String>>, path: MutableList<Char>, s: String, start: Int) {
    val curMaxLength = res.lastKey()
    if (isValidParentheses(path) && path.size >= curMaxLength) {
        if (res.containsKey(path.size)) {
            res[path.size]!!.add(path.joinToString(""))
        } else {
            res[path.size] = mutableSetOf(path.joinToString(""))
        }
    }
    if (start == s.length ||
        s.length - start + path.size < curMaxLength ||
        path.isNotEmpty() && path.last() == ')' && isValidBefore(path)
    ) {
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

fun isValidBefore(parentheses: List<Char>): Boolean {
    val s = Stack<Char>()
    for (i in 0 until parentheses.lastIndex) {
        if (s.isNotEmpty() && s.peek() == '(' && parentheses[i] == ')') {
            s.pop()
        } else if (parentheses[i] == ')' || parentheses[i] == '(') {
            s.push(parentheses[i])
        }
    }
    return s.isEmpty()
}


fun removeInvalidParentheses(s: String): List<String> {
    val res = mutableListOf<String>()
    val check = charArrayOf('(', ')')
    backtrace(s, res, check, 0, 0)
    return res
}

fun backtrace(s: String, res: MutableList<String>, check: CharArray, invalidPos: Int, removePos: Int) {
    var count = 0
    var i = invalidPos
    while (i < s.length && count >= 0) {
        if (s[i] == check[0]) count++
        if (s[i] == check[1]) count--
        i++
    }
    if (count >= 0) {
        val reversed = StringBuffer(s).reverse().toString()
        if (check[0] == '(') backtrace(reversed, res, charArrayOf(')', '('), 0, 0) else res.add(reversed)
    } else {
        i -= 1
        for (j in removePos..i) {
            if (s[j] == check[1] && (j == removePos || s[j - 1] != check[1])) {
                backtrace(s.substring(0, j) + s.substring(j + 1, s.length), res, check, i, j)
            }
        }
    }
}
