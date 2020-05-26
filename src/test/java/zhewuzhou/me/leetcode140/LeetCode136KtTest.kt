package zhewuzhou.me.leetcode140

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode136KtTest {
    private companion object {
        @JvmStatic
        fun twoCases() = Arrays.stream(
            arrayOf(
                Pair(intArrayOf(2, 2, 1), 1),
                Pair(intArrayOf(0), 0),
                Pair(intArrayOf(0, 0, 1), 1),
                Pair(intArrayOf(4, 1, 2, 1, 2), 4)
            )
        )

        @JvmStatic
        fun threeCase() = Arrays.stream(
            arrayOf(
                Pair(intArrayOf(2, 2, 1, 2), 1),
                Pair(intArrayOf(0, 1, 0, 1, 0, 1, 99), 99)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("twoCases")
    fun `Should find the single number`(case: Pair<IntArray, Int>) {
        assertThat(singleNumberTwo(case.first), `is`(case.second))
    }

    @ParameterizedTest
    @MethodSource("threeCase")
    fun `Should find the single number in three number list`(case: Pair<IntArray, Int>) {
        assertThat(singleNumber(case.first), `is`(case.second))
    }
}
