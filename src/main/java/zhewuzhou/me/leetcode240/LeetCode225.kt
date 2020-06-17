package zhewuzhou.me.leetcode240

import java.util.*

class MyStack() {
    private val q = LinkedList<Int>()

    fun push(x: Int) {
        q.add(x)
    }

    fun pop(): Int {
        if (q.isNotEmpty()) {
            val result = q.last
            q.removeLast()
            return result
        }
        throw EmptyStackException()
    }

    fun top(): Int {
        if (q.isNotEmpty()) {
            return q.last
        }
        throw EmptyStackException()
    }

    fun empty(): Boolean {
        return q.isEmpty()
    }
}
