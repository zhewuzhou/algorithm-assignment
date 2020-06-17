package zhewuzhou.me.leetcode240

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

internal class MyStackTest {
    @Test
    fun `Should remove and top the element`() {
        val s = MyStack()
        s.push(1)
        s.push(2)
        assertThat(s.top(), `is`(2))
    }
}
