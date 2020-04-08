package zhewuzhou.me.leetcode140

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode135KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(arrayOf(1, 1).toIntArray(), 2),
                Pair(arrayOf(1, 2).toIntArray(), 3),
                Pair(arrayOf(2, 1).toIntArray(), 3),
                Pair(arrayOf(1, 0, 2).toIntArray(), 5),
                Pair(arrayOf(1, 2, 2).toIntArray(), 4),
                Pair(arrayOf(3, 2, 1).toIntArray(), 6),
                Pair(arrayOf(1, 2, 3).toIntArray(), 6),
                Pair(arrayOf(1, 2, 2, 1).toIntArray(), 6),
                Pair(arrayOf(5, 4, 3, 3, 3, 2, 1).toIntArray(), 13),
                Pair(arrayOf(1, 6, 5, 4, 3, 2).toIntArray(), 16)
            )
        )

        @JvmStatic
        fun cutCases() = Arrays.stream(
            arrayOf(
                Pair(arrayOf(1, 0, 2).toIntArray(), listOf(listOf(0, 1), listOf(1, 2))),
                Pair(arrayOf(1, 2, 2).toIntArray(), listOf(listOf(0, 1), listOf(1, 2))),
                Pair(arrayOf(3, 2, 1).toIntArray(), listOf(listOf(0, 1, 2))),
                Pair(arrayOf(1, 2, 3).toIntArray(), listOf(listOf(0, 1, 2))),
                Pair(arrayOf(1, 2, 2, 1).toIntArray(), listOf(listOf(0, 1), listOf(1, 2), listOf(2, 3))),
                Pair(arrayOf(5, 4, 3, 3, 3, 2, 1).toIntArray(), listOf(listOf(0, 1, 2), listOf(2, 3, 4), listOf(4, 5, 6))),
                Pair(arrayOf(1, 6, 5, 4, 3, 2).toIntArray(), listOf(listOf(0, 1), listOf(1, 2, 3, 4, 5)))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should give minimal candy to children`(case: Pair<IntArray, Int>) {
        assertThat(candy(case.first), `is`(case.second))
    }

    @ParameterizedTest
    @MethodSource("cutCases")
    fun `Should cut the rating properly`(case: Pair<IntArray, List<List<Int>>>) {
        assertThat(cutRatings(case.first).size, `is`(case.second.size))
    }
}
