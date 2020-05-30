package zhewuzhou.me.leetcode180

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode167KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(intArrayOf(2, 7, 11, 15), 9, listOf(1, 2)),
                Triple(intArrayOf(1, 2, 3, 4, 15), 6, listOf(2, 4)),
                Triple(intArrayOf(0, 2, 3, 4, 15), 4, listOf(1, 4)),
                Triple(intArrayOf(-1, 0), -1, listOf(1, 2)),
                Triple(intArrayOf(-3, -2, -1, 0, 4, 8), -5, listOf(1, 2)),
                Triple(intArrayOf(-3, -2, -1, 0, 4, 8), -2, listOf(2, 4)),
                Triple(intArrayOf(-3, -2, -1, 0, 4, 8), 12, listOf(5, 6)),
                Triple(intArrayOf(-3, -2, -1, 0, 4, 8), -1, listOf(3, 4))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find the indexes that sum as the target`(case: Triple<IntArray, Int, List<Int>>) {
        assertThat(twoSum(case.first, case.second).toList(), `is`(case.third))
    }
}
