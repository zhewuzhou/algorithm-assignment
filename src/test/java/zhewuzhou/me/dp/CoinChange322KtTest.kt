package zhewuzhou.me.dp

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class CoinChaenge322KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(intArrayOf(1, 2, 5), 11, 3),
                Triple(intArrayOf(2), 3, -1),
                Triple(intArrayOf(1), 0, 0),
                Triple(intArrayOf(186, 419, 83, 408), 6249, 20)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should calculate the minimum number of coins needed`(case: Triple<IntArray, Int, Int>) {
        assertThat(coinChange(case.first, case.second), `is`(case.third))
    }
}
