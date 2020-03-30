package zhewuzhou.me.leetcode140

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode121KtTest {
    private companion object {
        @JvmStatic
        fun cases1T() = Arrays.stream(
            arrayOf(
                Pair(listOf(7, 1, 5, 3, 6, 4), 5),
                Pair(listOf(7, 6, 4, 3, 1), 0)
            )
        )

        @JvmStatic
        fun cases2T() = Arrays.stream(
            arrayOf(
                Pair(listOf(3, 3, 5, 0, 0, 3, 1, 4), 6),
                Pair(listOf(1, 2, 3, 4, 5), 4),
                Pair(listOf(7, 6, 4, 3, 1), 0),
                Pair(listOf(1, 2), 1),
                Pair(listOf(2, 1, 2, 0, 1), 2)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases1T")
    fun `Should calculate the maximum profit`(case: Pair<List<Int>, Int>) {
        val source = case.first.toIntArray()
        assertThat(maxProfitOneTransaction(source, 1, source.size), `is`(case.second))
    }

    @ParameterizedTest
    @MethodSource("cases2T")
    fun `Should calculate the maximum profit given at most 2 T`(case: Pair<List<Int>, Int>) {
        val source = case.first.toIntArray()
        assertThat(maxProfit(source), `is`(case.second))
    }
}
