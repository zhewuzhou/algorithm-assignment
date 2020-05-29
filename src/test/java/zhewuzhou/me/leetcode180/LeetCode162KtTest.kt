package zhewuzhou.me.leetcode180

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode162KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(intArrayOf(1, 2, 3, 1), 2),
                Pair(intArrayOf(1, 2, 1, 3, 5, 6, 4), 1),
                Pair(intArrayOf(1, 2), 1),
                Pair(intArrayOf(2, 1), 0),
                Pair(intArrayOf(1), 0),
                Pair(intArrayOf(), -1)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find the peak element from int array`(case: Pair<IntArray, Int>) {
        assertThat(findPeakElement(case.first), `is`(case.second))
    }
}
