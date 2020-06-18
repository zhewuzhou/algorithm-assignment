package zhewuzhou.me.leetcode240

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode228KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(intArrayOf(0, 1, 2, 4, 5, 7), listOf("0->2", "4->5", "7")),
                Pair(intArrayOf(0, 2, 3, 4, 6, 8, 9), listOf("0", "2->4", "6", "8->9")),
                Pair(intArrayOf(), listOf()),
                Pair(intArrayOf(1), listOf("1")),
                Pair(intArrayOf(1, 3, 5, 7, 9, 11, 13, 15), listOf("1", "3", "5", "7", "9", "11", "13", "15")),
                Pair(((Int.MAX_VALUE - 100)..Int.MAX_VALUE).toList().toIntArray(), listOf("2147483547->2147483647"))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should scan and get the ranges`(case: Pair<IntArray, List<String>>) {
        assertThat(summaryRanges(case.first), `is`(case.second))
    }
}
