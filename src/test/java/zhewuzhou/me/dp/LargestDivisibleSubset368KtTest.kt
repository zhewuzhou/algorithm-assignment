package zhewuzhou.me.dp

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LargestDivisibleSubset368KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(intArrayOf(1, 2, 3), listOf(1, 3)),
                Pair(intArrayOf(1, 2, 4, 8), listOf(1, 2, 4, 8)),
                Pair(intArrayOf(), listOf()),
                Pair(intArrayOf(1), listOf(1)),
                Pair(intArrayOf(2, 3), listOf(3)),
                Pair(intArrayOf(1, 2, 4, 8, 16, 32, 11, 13, 17, 19, 23), listOf(1, 2, 4, 8, 16, 32))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should `(case: Pair<IntArray, List<Int>>) {
        assertThat(largestDivisibleSubset(case.first), `is`(case.second))
    }
}
