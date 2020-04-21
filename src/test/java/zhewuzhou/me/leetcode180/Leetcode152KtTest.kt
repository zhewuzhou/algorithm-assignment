package zhewuzhou.me.leetcode180

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class Leetcode152KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(listOf(2, 3, -2, 4), 6),
                Pair(listOf(-2, 0, -1), 0)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should calculate the maximum products`(case: Pair<List<Int>, Int>) {
        assertThat(maxProduct(case.first.toIntArray()), `is`(case.second))
    }
}
