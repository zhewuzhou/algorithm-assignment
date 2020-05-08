package zhewuzhou.me.dp

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class PerfectSquare279KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(12, 3),
                Pair(13, 2),
                Pair(0, 0),
                Pair(1, 1)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should calculate latest number of perfect square`(case: Pair<Int, Int>) {
        assertThat(numSquares(case.first), `is`(case.second))
    }
}
