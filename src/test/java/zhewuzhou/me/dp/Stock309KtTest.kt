package zhewuzhou.me.dp

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class Stock309KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(listOf(1, 2, 3, 0, 2), 3),
                Pair(listOf(1, 2, 3, 100, 2), 99),
                Pair(listOf(1, 2, 4, 2, 5, 7, 2, 4, 9, 0), 11),
                Pair(listOf(6, 1, 6, 4, 3, 0, 2), 7)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should calculate the maximum profit given cool down 1 day after sell`(case: Pair<List<Int>, Int>) {
        assertThat(maxProfit(case.first.toIntArray()), `is`(case.second))
    }
}
