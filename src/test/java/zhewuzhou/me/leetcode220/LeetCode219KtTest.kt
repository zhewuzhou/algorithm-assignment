package zhewuzhou.me.leetcode220

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode219KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(intArrayOf(1, 2, 3, 1), 3, true),
                Triple(intArrayOf(1, 1), 3, true),
                Triple(intArrayOf(1, 0, 1), 2, true),
                Triple(intArrayOf(1, 0, 1, 1), 1, true),
                Triple(intArrayOf(1), 1, false),
                Triple(intArrayOf(), 1, false),
                Triple(intArrayOf(1, 2, 3), -1, false),
                Triple(intArrayOf(1), 1, false),
                Triple(intArrayOf(1, 2, 3, 1, 2, 3), 2, false)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should know if there are duplicated element within window k`(case: Triple<IntArray, Int, Boolean>) {
        assertThat(containsNearbyDuplicate(case.first, case.second), `is`(case.third))
    }
}
