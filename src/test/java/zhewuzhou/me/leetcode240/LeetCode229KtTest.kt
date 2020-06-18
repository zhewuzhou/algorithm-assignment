package zhewuzhou.me.leetcode240

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode229KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(intArrayOf(3, 2, 3), listOf(3)),
                Pair(intArrayOf(1, 1, 1, 3, 3, 2, 2, 2), listOf(1, 2)),
                Pair(intArrayOf(1, 1, 1, 3, 3, 3, 2, 2, 2), listOf()),
                Pair(intArrayOf(), listOf()),
                Pair(intArrayOf(1), listOf(1)),
                Pair(intArrayOf(1, 1), listOf(1)),
                Pair(intArrayOf(1, 2), listOf(1, 2)),
                Pair(intArrayOf(1, 2, 3), listOf()),
                Pair(intArrayOf(0, 0, 0), listOf(0)),
                Pair(intArrayOf(1, 2, 2, 3, 2, 1, 1, 3), listOf(1, 2))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find the majority element from list`(case: Pair<IntArray, List<Int>>) {
        assertThat(majorityElement(case.first), `is`(case.second))
    }
}
