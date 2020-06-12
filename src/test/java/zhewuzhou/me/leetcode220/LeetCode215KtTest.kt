package zhewuzhou.me.leetcode220

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode215KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(intArrayOf(3, 2, 1, 5, 6, 4), 2, 5),
                Triple(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4, 4),
                Triple(intArrayOf(1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4), 4, 4)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find the kth largest element`(case: Triple<IntArray, Int, Int>) {
        assertThat(findKthLargest(case.first, case.second), `is`(case.third))
    }
}
