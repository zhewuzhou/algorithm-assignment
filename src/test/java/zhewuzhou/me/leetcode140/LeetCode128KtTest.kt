package zhewuzhou.me.leetcode140

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode128KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                //Pair(listOf(100, 4, 200, 1, 3, 2), 4),
                Pair(listOf(100, 4, 200, 3, 1, 2, 5), 5)
                //Pair(listOf(1, 3, 5, 2, 4), 5)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find longest consecutive element length`(case: Pair<List<Int>, Int>) {
        assertThat(longestConsecutive(case.first.toIntArray()), `is`(case.second))
    }
}
