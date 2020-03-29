package zhewuzhou.me.leetcode140

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode121KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(listOf(7, 1, 5, 3, 6, 4), 5),
                Pair(listOf(7, 6, 4, 3, 1), 0)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should calculate the maximum profit`(case: Pair<List<Int>, Int>) {
        val source = case.first.toIntArray()
        assertThat(maxProfit(source), `is`(case.second))
    }
}
