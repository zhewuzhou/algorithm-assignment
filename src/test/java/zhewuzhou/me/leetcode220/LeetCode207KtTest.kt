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
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should know if it's possible to finish all courses`(case: Triple<Int, Array<IntArray>, Boolean>) {
        assertThat(canFinish(case.first, case.second), `is`(case.third))
    }
}
