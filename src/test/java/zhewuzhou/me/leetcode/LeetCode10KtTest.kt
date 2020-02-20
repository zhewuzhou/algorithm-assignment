package zhewuzhou.me.leetcode

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class LeetCode10KtTest {

//    @Test
//    fun `Should match for normal string`() {
//        assertThat(isMatchRecursive("aa", "a"), `is`(false))
//        assertThat(isMatchRecursive("aa", "a."), `is`(true))
//    }
//
//    @Test
//    fun `Should match for normal dot string`() {
//        assertThat(isMatchRecursive("ab", ".*"), `is`(true))
//        assertThat(isMatchRecursive("ab", ".."), `is`(true))
//    }

    @Test
    fun `Should match for normal star string`() {
//        assertThat(isMatchRecursive("aa", "a*"), `is`(true))
        assertThat(isMatchRecursive("aab", "c*a*b"), `is`(true))
//        assertThat(isMatchRecursive("mississippi", "mis*is*p*."), `is`(false))
    }

//    @Test
//    fun `Should match empty src`() {
//        assertThat(isMatchRecursive("", "a*"), `is`(true))
//        assertThat(isMatchRecursive("", "a*b*c*"), `is`(true))
//        assertThat(isMatchRecursive("", ""), `is`(true))
//        assertThat(isMatchRecursive("", "a"), `is`(false))
//        assertThat(isMatchRecursive("", "."), `is`(false))
//    }
//
//    @Test
//    fun `should match more edge cases`() {
//        assertThat(isMatchRecursive("ab", ".*c"), `is`(false))
//    }
}
