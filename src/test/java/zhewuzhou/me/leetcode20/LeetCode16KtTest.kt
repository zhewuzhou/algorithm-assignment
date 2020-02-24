package zhewuzhou.me.leetcode20

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class LeetCode16KtTest {

    @Test
    fun `Should calculate the closest value of target for three sum`() {
        val arr = listOf(-1, 2, 1, -4).toIntArray()
        assertThat(threeSumClosest(arr, 1), `is`(2))
    }

    @Test
    fun `Should calculate the closest value of target for three sum edge case`() {
        val arr = listOf(1, 1, 1, 1).toIntArray()
        assertThat(threeSumClosest(arr, 0), `is`(3))
    }

    @Test
    fun `Should calculate the closest value of target for three sum edge case another`() {
        val arr = listOf(-3, -2, -5, 3, -4).toIntArray()
        assertThat(threeSumClosest(arr, -1), `is`(-2))
    }
}
