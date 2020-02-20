package zhewuzhou.me.leetcode

import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test

class LeetCode11KtTest {

    @Test
    fun `Should calculate area for valid list`() {
        assertThat(maxArea(listOf(1, 8, 6, 2, 5, 4, 8, 3, 7).toIntArray()), `is`(49))
    }

    @Test
    fun `Should calculate area for list 1 1`() {
        assertThat(maxArea(listOf(1, 1).toIntArray()), `is`(1))
    }

    @Test(expected = IllegalStateException::class)
    fun `Should calculate area for list 1`() {
        maxArea(listOf(1).toIntArray())
    }
}
