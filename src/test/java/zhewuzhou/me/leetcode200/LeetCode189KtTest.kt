package zhewuzhou.me.leetcode200


import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

/*
TODO:
1. Empty
2. Single Element Array
3. K is very large
 */

internal class LeetCode189KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(intArrayOf(1), Int.MAX_VALUE, intArrayOf(1)),
                Triple(intArrayOf(), Int.MAX_VALUE, intArrayOf()),
                Triple((1..30000).toList().toIntArray(), 30000, (1..30000).toList().toIntArray()),
                Triple(intArrayOf(1, 2, 3, 4, 5, 6, 7), 1, intArrayOf(7, 1, 2, 3, 4, 5, 6)),
                Triple(intArrayOf(1, 2, 3, 4, 5, 6, 7), 2, intArrayOf(6, 7, 1, 2, 3, 4, 5)),
                Triple(intArrayOf(1, 2, 3, 4, 5, 6, 7), 3, intArrayOf(5, 6, 7, 1, 2, 3, 4)),
                Triple(intArrayOf(1, 2, 3, 4, 5, 6, 7), 4, intArrayOf(4, 5, 6, 7, 1, 2, 3)),
                Triple(intArrayOf(1, 2, 3, 4, 5, 6, 7), 5, intArrayOf(3, 4, 5, 6, 7, 1, 2)),
                Triple(intArrayOf(1, 2, 3, 4, 5, 6, 7), 6, intArrayOf(2, 3, 4, 5, 6, 7, 1)),
                Triple(intArrayOf(1, 2, 3, 4, 5, 6, 7), 7, intArrayOf(1, 2, 3, 4, 5, 6, 7)),
                Triple(intArrayOf(1, 2, 3, 4, 5, 6, 7), 8, intArrayOf(7, 1, 2, 3, 4, 5, 6))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should rotate the array in constant space and linear time`(case: Triple<IntArray, Int, IntArray>) {
        val nums = case.first
        rotate(nums, case.second)
        assertThat(nums.toList(), `is`(case.third.toList()))
    }
}
