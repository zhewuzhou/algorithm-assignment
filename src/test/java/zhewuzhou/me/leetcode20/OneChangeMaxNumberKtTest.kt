package zhewuzhou.me.leetcode20

import org.hamcrest.Matchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test

/*
TODO:
1. Swap for non first done
2. num single digit done
3. num two digit done done
4. exception and check done
Programming is only depends on the level focus on small point
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
    fun should_not_swap() {
        assertThat(oneChangeForMax(321), `is`(321))
    }

    @Test
    fun should_not_swap_when_single_digit() {
        assertThat(oneChangeForMax(3), `is`(3))
    }

    @Test
    fun should_not_swap_when_complex_situation() {
        assertThat(oneChangeForMax(987123455), `is`(987523451))
    }

    @Test
    fun should_swap_string() {
        val result = "123".swap(0, 2)
        assertThat(result, `is`("321"))
    }
}
