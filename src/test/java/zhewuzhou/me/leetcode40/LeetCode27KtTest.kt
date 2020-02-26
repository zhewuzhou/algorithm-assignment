package zhewuzhou.me.leetcode40

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class LeetCode27KtTest {

    @Test
    fun `Should remove 3 from 3-2-2-3`() {
        val nums = listOf(3, 2, 2, 3).toIntArray()
        assertThat(removeElement(nums, 3), `is`(2))
    }
}
