package zhewuzhou.me.leetcode140

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode122KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(listOf(7, 1, 5, 3, 6, 4), 7),
                Pair(listOf(1, 2, 3, 4, 5), 4),
                Pair(listOf(7, 6, 4, 3, 1), 0)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should calculate max profit given multiple transactions`(case: Pair<List<Int>, Int>) {
        val prices = case.first.toIntArray()
        assertThat(maxProfitM(prices), `is`(case.second))
    }
}
