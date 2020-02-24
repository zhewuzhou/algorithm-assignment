package zhewuzhou.me.leetcode20

import org.hamcrest.core.Is.`is`
import org.junit.Test

import org.junit.Assert.*

class LeetCode3KtTest {

    @Test
    fun `should get the longest sequence correctly`() {
        assertThat(lengthOfLongestSubstring("abcabcbb"), `is`(3))
    }

    @Test
    fun `should get the longest sequence for repeated string`() {
        assertThat(lengthOfLongestSubstring("bbbbbbbb"), `is`(1))
    }

    @Test
    fun `should get the longest sequence for complicated case`() {
        assertThat(lengthOfLongestSubstring("pwwkew"), `is`(3))
    }
}
