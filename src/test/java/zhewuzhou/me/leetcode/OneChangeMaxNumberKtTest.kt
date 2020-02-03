package zhewuzhou.me.leetcode

import org.hamcrest.Matchers.`is`
import org.junit.Test

import org.junit.Assert.*

class OneChangeMaxNumberKtTest {

    @Test
    fun should_return_the_same_value() {
        assertThat(oneChangeForMax(123), `is`(321))
    }

    @Test
    fun should_swap_string(){
        val result = "123".swap(0, 2)
        assertThat(result, `is`("321"))
    }
}