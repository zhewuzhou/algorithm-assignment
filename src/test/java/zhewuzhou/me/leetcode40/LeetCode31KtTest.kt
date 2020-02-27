package zhewuzhou.me.leetcode40

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class LeetCode31KtTest {

    @Test
    fun `Should do debug`() {
        val nums = listOf(2, 3, 6, 5, 4, 1).toIntArray()
        nextPermutation(nums)
        assertThat(nums, `is`(listOf(2, 4, 1, 3, 5, 6).toIntArray()))
    }

    @Test
    fun `Should do debug 1-3-2`() {
        val nums = listOf(1, 3, 2).toIntArray()
        nextPermutation(nums)
        assertThat(nums, `is`(listOf(2, 1, 3).toIntArray()))
    }

    @Test
    fun `Should do debug 3-2-1`() {
        val nums = listOf(3, 2, 1).toIntArray()
        nextPermutation(nums)
        assertThat(nums, `is`(listOf(1, 2, 3).toIntArray()))
    }

    @Test
    fun `Should do debug 1-5-1`() {
        val nums = listOf(1, 5, 1).toIntArray()
        nextPermutation(nums)
        assertThat(nums, `is`(listOf(5, 1, 1).toIntArray()))
    }

    @Test
    fun `Should do debug 2,2,7,5,4,3,2,2,1`() {
        val nums = listOf(2, 2, 7, 5, 4, 3, 2, 2, 1).toIntArray()
        nextPermutation(nums)
        assertThat(nums, `is`(listOf(2, 3, 1, 2, 2, 2, 4, 5, 7).toIntArray()))
    }
}
