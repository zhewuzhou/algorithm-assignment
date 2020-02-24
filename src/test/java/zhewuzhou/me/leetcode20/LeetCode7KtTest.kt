package zhewuzhou.me.leetcode20

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

class LeetCode7KtTest {

    @Test
    fun `Should reverse integer for normal cases`() {
        assertThat(reverse(123), `is`(321))
        assertThat(reverse(-123), `is`(-321))
        assertThat(reverse(120), `is`(21))
        assertThat(reverse(0), `is`(0))
    }

    @Test
    fun `Should reverse -10000 to -1`() {
        assertThat(reverse(-10000), `is`(-1))
    }

    @Test
    fun `Should reverse 1534236469 to 9646323451`() {
        assertThat(reverse(1534236469), `is`(0))
    }
}
