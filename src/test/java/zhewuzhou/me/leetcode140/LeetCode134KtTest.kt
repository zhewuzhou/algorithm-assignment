package zhewuzhou.me.leetcode140

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode134KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(arrayOf(1, 2, 3, 4, 5).toIntArray(), arrayOf(3, 4, 5, 1, 2).toIntArray(), 3),
                Triple(arrayOf(2, 3, 4).toIntArray(), arrayOf(3, 4, 3).toIntArray(), -1),
                Triple(arrayOf(5, 8, 2, 8).toIntArray(), arrayOf(6, 5, 6, 6).toIntArray(), 3),
                Triple(arrayOf(4).toIntArray(), arrayOf(5).toIntArray(), -1),
                Triple(arrayOf(5).toIntArray(), arrayOf(4).toIntArray(), 0)

            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should return the starting station for the circular travel`(case: Triple<IntArray, IntArray, Int>) {
        assertThat(canCompleteCircuit(case.first, case.second), `is`(case.third))
    }
}
