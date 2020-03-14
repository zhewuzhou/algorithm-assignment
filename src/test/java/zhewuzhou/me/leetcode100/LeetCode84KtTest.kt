package zhewuzhou.me.leetcode100

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsInAnyOrder
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode84KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(listOf(2, 1, 5, 6, 2, 3), 10),
                Pair(listOf(1, 2, 3, 4, 5), 9),
                Pair(listOf(2, 2, 2, 2, 2, 2), 12),
                Pair(listOf(2, 2, 2, 2, 2, 2, 8, 8), 16)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should calculate the max area of histogram`(case: Pair<List<Int>, Int>) {
        val heights = case.first.toIntArray()
        assertThat(largestRectangleArea(heights), `is`(case.second))
    }

    @Test
    fun `Should calculate min indexes for 2, 1, 5, 6, 2, 3, 1, 1, 1`() {
        val nums = listOf(2, 1, 5, 6, 2, 3, 1, 1, 1).toIntArray()
        assertThat(minIndexes(nums, 0, nums.lastIndex).second,
            containsInAnyOrder(1, 6, 7, 8))
    }
}
