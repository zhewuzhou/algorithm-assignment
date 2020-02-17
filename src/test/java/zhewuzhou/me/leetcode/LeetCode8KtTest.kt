package zhewuzhou.me.leetcode

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Test

class LeetCode8KtTest {

    @Test
    fun myAtoi() {
    }

    @Test
    fun `Should extract valid integer from string`() {
        assertThat(extractInt("            -42"), `is`("-42"))
        assertThat(extractInt("4193 with words"), `is`("4193"))
        assertThat(extractInt("words and 987"), `is`(""))
        assertThat(extractInt("-91283472332"), `is`("-91283472332"))
    }

}
