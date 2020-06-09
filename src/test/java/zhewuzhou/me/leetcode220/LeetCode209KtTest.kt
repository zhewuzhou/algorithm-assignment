package zhewuzhou.me.leetcode220

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode209KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(intArrayOf(2, 3, 1, 2, 4, 3), 7, 2),
                Triple(intArrayOf(2, 3, 1, 2, 4, 3), 15, 6),
                Triple(intArrayOf(2, 3, 1, 2, 4, 3), 16, 0),
                Triple(intArrayOf(2, 3, 1, 2, 4, 3), 4, 1),
                Triple(intArrayOf(), 0, 0),
                Triple(intArrayOf(5), 6, 0)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find the minimum length for target sum`(case: Triple<IntArray, Int, Int>) {
        assertThat(minSubArrayLen(case.second, case.first), `is`(case.third))
    }
}
