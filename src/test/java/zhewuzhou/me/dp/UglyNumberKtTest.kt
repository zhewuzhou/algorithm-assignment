package zhewuzhou.me.dp

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class UglyNumberKtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(1, 1),
                Pair(2, 2),
                Pair(3, 3),
                Pair(4, 4),
                Pair(5, 5),
                Pair(6, 6),
                Pair(7, 8),
                Pair(8, 9),
                Pair(9, 10),
                Pair(10, 12)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should calculate nth ugly number`(case: Pair<Int, Int>) {
        assertThat(nthUglyNumber(case.first), `is`(case.second))
    }
}
