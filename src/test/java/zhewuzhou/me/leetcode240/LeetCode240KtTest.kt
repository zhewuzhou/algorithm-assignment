package zhewuzhou.me.leetcode240

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode240KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(arrayOf(
                    intArrayOf(1, 4, 7, 11, 15),
                    intArrayOf(2, 5, 8, 12, 19),
                    intArrayOf(3, 6, 9, 16, 22),
                    intArrayOf(10, 13, 14, 17, 24),
                    intArrayOf(18, 21, 23, 26, 30)
                ), 5, true),
                Triple(arrayOf(
                    intArrayOf(1, 4, 7, 11, 15),
                    intArrayOf(2, 5, 8, 12, 19),
                    intArrayOf(3, 6, 9, 16, 22),
                    intArrayOf(10, 13, 14, 17, 24),
                    intArrayOf(18, 21, 23, 26, 30)
                ), 20, false)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find the element in matrix`(case: Triple<Array<IntArray>, Int, Boolean>) {
        assertThat(searchMatrix(case.first, case.second), `is`(case.third))
    }
}
