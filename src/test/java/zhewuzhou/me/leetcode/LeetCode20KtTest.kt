package zhewuzhou.me.leetcode

import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test

class LeetCode20KtTest {

    @Test
    fun `Valid Parentheses ()`() {
        assertThat(isValid("()"), `is`(true))
    }

    @Test
    fun `Valid Parentheses ()(){}`() {
        assertThat(isValid("()[]{}"), `is`(true))
    }

    @Test
    fun `Valid Parentheses {()}`() {
        assertThat(isValid("{()}"), `is`(true))
    }

    @Test
    fun `Valid Parentheses (}`() {
        assertThat(isValid("(}"), `is`(false))
    }

    @Test
    fun `Valid Parentheses ({)}`() {
        assertThat(isValid("({)}"), `is`(false))
    }

    @Test
    fun `Invalid Parentheses (`() {
        assertThat(isValid("("), `is`(false))
    }

    @Test
    fun `Invalid Parentheses empty`() {
        assertThat(isValid(""), `is`(false))
    }
}
