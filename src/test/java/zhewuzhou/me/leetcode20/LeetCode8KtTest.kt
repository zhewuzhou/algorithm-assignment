package zhewuzhou.me.leetcode20

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

    @Test
    fun `Should convert int list to int`() {
        assertThat(toInt("91283472332".map { it.toString().toInt() }, 1), `is`(2147483647))
        assertThat(toInt("4193".map { it.toString().toInt() }, 1), `is`(4193))
    }

    @Test
    fun `My atoi should works`() {
        assertThat(myAtoi("            -42"), `is`(-42))
        assertThat(myAtoi("            +42"), `is`(42))
        assertThat(myAtoi("            -+42"), `is`(0))
        assertThat(myAtoi("            -+1"), `is`(0))
        assertThat(myAtoi("0"), `is`(0))
        assertThat(myAtoi(""), `is`(0))
        assertThat(myAtoi("42"), `is`(42))
        assertThat(myAtoi("4193 with words"), `is`(4193))
        assertThat(myAtoi("words and 987"), `is`(0))
        assertThat(myAtoi("-91283472332"), `is`(-2147483648))
        assertThat(myAtoi("2147483648"), `is`(Int.MAX_VALUE))
    }
}
