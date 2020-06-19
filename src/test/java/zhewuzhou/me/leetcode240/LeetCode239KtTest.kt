package zhewuzhou.me.leetcode240

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode239KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 3, listOf(3, 3, 5, 5, 6, 7)),
                Triple(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 1, listOf(1, 3, -1, -3, 5, 3, 6, 7)),
                Triple(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 8, listOf(7)),
                Triple(intArrayOf(7, 2, 4), 2, listOf(7, 4)),
                Triple(intArrayOf(2, 4, 7), 2, listOf(4, 7)),
                Triple(intArrayOf(-7, -8, 7, 5, 7, 1, 6, 0), 4, listOf(7, 7, 7, 7, 7)),
                Triple(intArrayOf(-7, -8, 7, 5, 7, 1, 6, 0), 0, listOf()),
                Triple(intArrayOf(), 4, listOf())
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should return the max window`(case: Triple<IntArray, Int, List<Int>>) {
        assertThat(maxSlidingWindow(case.first, case.second).toList(), `is`(case.third))
    }
}
