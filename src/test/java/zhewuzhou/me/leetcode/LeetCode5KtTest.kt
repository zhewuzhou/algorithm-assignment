package zhewuzhou.me.leetcode

import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThat
import org.junit.Test

class LeetCode5KtTest {

    @Test
    fun `should find palindromic  substring for "banana"`() {
        assertThat(longestPalindrome("banana"), `is`("anana"))
    }

    @Test
    fun `anana should be palindromic`() {
        assertThat("anana".isPalindrome(), `is`(true))
    }

    @Test
    fun `geeksskeeg should be palindromic`() {
        assertThat("geeksskeeg".isPalindrome(), `is`(true))
    }

    @Test
    fun `empty should not be palindromic`() {
        assertThat("".isPalindrome(), `is`(false))
    }

    @Test
    fun `single char should not be palindromic`() {
        assertThat("a".isPalindrome(), `is`(false))
    }

    @Test
    fun `should calculate all substrings for banana 0`() {
        assertThat("banana".allSubStrings(0), `is`(listOf("ba", "ban", "bana", "banan", "banana")))
    }

    @Test
    fun `should calculate all substrings for empty 0`() {
        assertThat("".allSubStrings(0), `is`(listOf()))
    }

    @Test
    fun `should calculate all substrings for single char 0`() {
        assertThat("a".allSubStrings(0), `is`(listOf()))
    }
}