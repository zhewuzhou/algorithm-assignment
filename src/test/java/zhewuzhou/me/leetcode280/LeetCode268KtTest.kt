package zhewuzhou.me.leetcode280

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode268KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(intArrayOf(3, 0, 1), 2),
                Pair(intArrayOf(9, 6, 4, 2, 3, 5, 7, 0, 1), 8),
                Pair(intArrayOf(1), 0),
                Pair(intArrayOf(0, 2), 1),
                Pair(intArrayOf(), -1)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should `(case: Pair<IntArray, Int>) {
        assertThat(missingNumber(case.first), `is`(case.second))
    }
}
