package zhewuzhou.me.leetcode180

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode153KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(listOf(3, 4, 5, 1, 2), 1),
                Pair(listOf(4, 5, 6, 7, 0, 1, 2), 0)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find the min value`(case: Pair<List<Int>, Int>) {
        assertThat(findMin(case.first.toIntArray()), `is`(case.second))
    }
}
