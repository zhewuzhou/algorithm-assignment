package zhewuzhou.me.dp

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class NumArrayTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(intArrayOf(-2, 0, 3, -5, 2, -1), Pair(0, 2), 1),
                Triple(intArrayOf(-2, 0, 3, -5, 2, -1), Pair(2, 5), -1),
                Triple(intArrayOf(-2, 0, 3, -5, 2, -1), Pair(0, 5), -3),
                Triple(intArrayOf(1), Pair(0, 0), 1)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should return the sum of the array range`(case: Triple<IntArray, Pair<Int, Int>, Int>) {
        val na = NumArray(case.first)
        assertThat(na.sumRange(case.second.first, case.second.second), `is`(case.third))
    }
}
