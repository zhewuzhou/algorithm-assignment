package zhewuzhou.me.dp

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class IntegerBreakKtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(1, 0),
                Pair(2, 1),
                Pair(3, 2),
                Pair(4, 4),
                Pair(5, 6),
                Pair(6, 9),
                Pair(7, 12),
                Pair(8, 18),
                Pair(9, 27),
                Pair(10, 36),
                Pair(58, 1549681956),
                Pair(59, 0)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should break the integer to nums that maximum the products`(case: Pair<Int, Int>) {
        assertThat(integerBreak(case.first), `is`(case.second))
    }
}
