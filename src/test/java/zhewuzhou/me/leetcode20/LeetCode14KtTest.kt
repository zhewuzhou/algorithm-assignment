package zhewuzhou.me.leetcode20

import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test

class LeetCode14KtTest {

    @Test
    fun `Should calculate the possible prefix for all simple strings`() {
        val stringArrays = listOf("flower", "flow", "flight").toTypedArray()
        assertThat(longestCommonPrefix(stringArrays), `is`("fl"))
    }

    @Test
    fun `Should calculate the possible prefix for all edge cases`() {
        val stringArrays = listOf("dog", "racecar", "car").toTypedArray()
        assertThat(longestCommonPrefix(stringArrays), `is`(""))
    }
}
