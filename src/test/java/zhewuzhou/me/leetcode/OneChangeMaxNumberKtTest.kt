package zhewuzhou.me.leetcode

import org.hamcrest.Matchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test

/*
TODO:
1. Swap for non first
2. num single digit
3. num two digit
4. exception and check
 */

class OneChangeMaxNumberKtTest {

    @Test
    fun should_swap_first_and_third() {
        assertThat(oneChangeForMax(123), `is`(321))
    }

    @Test
    fun should_swap_first_and_third_given_double_three() {
        assertThat(oneChangeForMax(133), `is`(331))
    }

    @Test
    fun should_swap_second_and_third() {
        assertThat(oneChangeForMax(323), `is`(332))
    }

    @Test
    fun should_swap_string() {
        val result = "123".swap(0, 2)
        assertThat(result, `is`("321"))
    }
}