package zhewuzhou.me.leetcode20

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsInAnyOrder
import org.junit.Test

class LeetCode17Test {
    @Test
    fun `Should convert digits to possible combinations`() {
        val s = Solution()
        assertThat(s.letterCombinations("23"),
            containsInAnyOrder("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"))
    }

    @Test
    fun `Should convert digits to possible combinations with 01`() {
        val s = Solution()
        assertThat(s.letterCombinations("0123"),
            containsInAnyOrder("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"))
    }
}
