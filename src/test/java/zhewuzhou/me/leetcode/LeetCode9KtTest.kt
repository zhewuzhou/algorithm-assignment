package zhewuzhou.me.leetcode

import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test

class LeetCode9KtTest {

    @Test
    fun `Should judge if palindrome`() {
        assertThat(isPalindrome(121), `is`(true))
        assertThat(isPalindrome(-121), `is`(false))
        assertThat(isPalindrome(123), `is`(false))
        assertThat(isPalindrome(+121), `is`(true))
        assertThat(isPalindrome(10000), `is`(false))
        assertThat(isPalindrome(1000000001), `is`(true))
    }

    @Test
    fun `Should convert 12345 into list`() {
        assertThat(intToDigits(12345), `is`(listOf(5, 4, 3, 2, 1)))
        assertThat(intToDigits(0), `is`(listOf(0)))
    }
}
