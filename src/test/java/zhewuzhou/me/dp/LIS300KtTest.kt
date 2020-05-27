package zhewuzhou.me.dp

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LIS300KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(listOf(10, 9, 2, 5, 3, 7, 101, 18), 4),
                Pair(listOf(4, 10, 4, 3, 8, 9), 3),
                Pair(listOf(1, 3, 6, 7, 9, 4, 10, 5, 6), 6),
                Pair(listOf(), 0),
                Pair(listOf(1), 1)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should return max increased subsequence`(case: Pair<List<Int>, Int>) {
        assertThat(lengthOfLIS(case.first.toIntArray()), `is`(case.second))
    }
}
