package zhewuzhou.me.dp

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class MaximumSwapKtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(2736, 7236),
                Pair(9973, 9973),
                Pair(1993, 9913)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should return the maximum possible value by swap once`(case: Pair<Int, Int>) {
        assertThat(maximumSwap(case.first), `is`(case.second))
    }

    @Test
    fun `Should split num to digits`() {
        assertThat(splitToDigits(100000), `is`(listOf(0, 0, 0, 0, 0, 1)))
        assertThat(splitToDigits(123456), `is`(listOf(6, 5, 4, 3, 2, 1)))
    }
}
