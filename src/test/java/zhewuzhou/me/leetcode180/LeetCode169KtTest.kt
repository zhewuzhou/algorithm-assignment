package zhewuzhou.me.leetcode180

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode169KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(intArrayOf(3, 2, 3), 3),
                Pair(intArrayOf(2, 2, 1, 1, 1, 2, 2), 2)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find the majority element of int array`(case: Pair<IntArray, Int>) {
        assertThat(majorityElement(case.first), `is`(case.second))
    }
}
