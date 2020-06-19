package zhewuzhou.me.leetcode240

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode238KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(intArrayOf(1, 2, 3, 4), listOf(24, 12, 8, 6)),
                Pair(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8), listOf(40320, 20160, 13440, 10080, 8064, 6720, 5760, 5040))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should calculate product array`(case: Pair<IntArray, List<Int>>) {
        assertThat(productExceptSelfR(case.first).toList(), `is`(case.second))
    }
}
