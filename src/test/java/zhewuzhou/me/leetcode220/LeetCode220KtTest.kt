package zhewuzhou.me.leetcode220

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode220KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(Pair(intArrayOf(1, 2, 3, 1), 3), Pair(0, true)),
                Pair(Pair(intArrayOf(1, 0, 1, 1), 1), Pair(2, true)),
                Pair(Pair(intArrayOf(1, 5, 9, 1, 5, 9), 2), Pair(3, false)),
                Pair(Pair(intArrayOf(-2147483648, -2147483647), 3), Pair(3, true))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should contains duplications within window`(case: Pair<Pair<IntArray, Int>, Pair<Int, Boolean>>) {
        val result = containsNearbyAlmostDuplicate(case.first.first, case.first.second, case.second.first)
        assertThat(result, `is`(case.second.second))
    }
}
