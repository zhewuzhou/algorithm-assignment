package zhewuzhou.me.leetcode

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class LeetCode10KtTest {

    @Test
    fun `Should match for normal string`() {
        assertThat(isMatch("aa", "a"), `is`(false))
        assertThat(isMatch("aa", "a."), `is`(true))
    }

    @Test
    fun `Should match for normal dot string`() {
        assertThat(isMatch("ab", ".*"), `is`(true))
        assertThat(isMatch("ab", ".."), `is`(true))
    }

    @Test
    fun `Should match for normal star string`() {
        assertThat(isMatch("aa", "a*"), `is`(true))
        assertThat(isMatch("aab", "c*a*b"), `is`(true))
        assertThat(isMatch("mississippi", "mis*is*p*."), `is`(false))
    }
}
