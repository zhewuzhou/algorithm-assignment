package zhewuzhou.me.leetcode160

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

internal class MinStackTest {
    @Test
    fun `Should do all operations in constant time`() {
        val stack = MinStack()
        stack.push(-2)
        stack.push(0)
        stack.push(-3)
        assertThat(stack.getMin(), `is`(-3))
        stack.pop()
        assertThat(stack.top(), `is`(0))
        assertThat(stack.getMin(), `is`(-2))
    }

    @Test
    fun `Should do all operations in constant time for complicated case`() {
        val stack = MinStack()
        stack.push(100)
        stack.push(1)
        stack.push(-100)
        assertThat(stack.getMin(), `is`(-100))
        stack.pop()
        assertThat(stack.top(), `is`(1))
        assertThat(stack.getMin(), `is`(1))
    }
}
