package zhewuzhou.me.leetcode160

import java.util.*

class MinStack() {
    private val stack = Stack<Int>()
    private val min = Stack<Int>()

    /** initialize your data structure here. */


    fun push(x: Int) {
        stack.push(x)
        val newMin = if (min.isNotEmpty() && min.peek() < x) min.peek() else x
        min.push(newMin)
    }

    fun pop() {
        if (stack.isNotEmpty()) {
            stack.pop()
            min.pop()
        }
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return min.peek()
    }

}
