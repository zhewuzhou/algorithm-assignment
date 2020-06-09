package zhewuzhou.me.leetcode220

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode207KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(2, arrayOf(intArrayOf(1, 0)), true),
                Triple(1, arrayOf(), true),
                Triple(6, arrayOf(
                    intArrayOf(1, 0),
                    intArrayOf(1, 2),
                    intArrayOf(2, 0),
                    intArrayOf(1, 3),
                    intArrayOf(3, 5),
                    intArrayOf(5, 4),
                    intArrayOf(4, 3)
                ), false),
                Triple(2, arrayOf(intArrayOf(1, 0), intArrayOf(0, 1)), false)
            )
        )

        @JvmStatic
        fun orderCases() = Arrays.stream(
            arrayOf(
                Triple(2, arrayOf(intArrayOf(1, 0)), listOf(0, 1)),
                Triple(2, arrayOf(intArrayOf(1, 0), intArrayOf(0, 1)), listOf()),
                Triple(1, arrayOf(), listOf(0)),
                Triple(4, arrayOf(
                    intArrayOf(1, 0),
                    intArrayOf(2, 0),
                    intArrayOf(3, 1),
                    intArrayOf(3, 2)), listOf(0, 1, 2, 3)),
                Triple(6, arrayOf(
                    intArrayOf(1, 0),
                    intArrayOf(1, 2),
                    intArrayOf(2, 0),
                    intArrayOf(1, 3),
                    intArrayOf(3, 5),
                    intArrayOf(5, 4),
                    intArrayOf(4, 3)
                ), listOf()),
                Triple(6, arrayOf(
                    intArrayOf(1, 0),
                    intArrayOf(1, 2),
                    intArrayOf(2, 0),
                    intArrayOf(1, 3),
                    intArrayOf(3, 5),
                    intArrayOf(5, 4),
                    intArrayOf(3, 4)
                ), listOf(0, 4, 2, 5, 3, 1))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should know if it's possible to finish all courses`(case: Triple<Int, Array<IntArray>, Boolean>) {
        assertThat(canFinish(case.first, case.second), `is`(case.third))
    }

    @ParameterizedTest
    @MethodSource("orderCases")
    fun `Should return the proper order of courses`(case: Triple<Int, Array<IntArray>, List<Int>>) {
        assertThat(findOrder(case.first, case.second).toList(), `is`(case.third))
    }
}
