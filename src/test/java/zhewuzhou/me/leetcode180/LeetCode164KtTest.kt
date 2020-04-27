package zhewuzhou.me.leetcode180

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode164KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(listOf(3, 6, 9, 1), 3),
                Pair(listOf(1, 4, 5, 2, 3), 1),
                Pair(listOf(10), 0)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find max gap in sorted manner`(case: Pair<List<Int>, Int>) {
        val nums = case.first.toIntArray()
        assertThat(maximumGap(nums), `is`(case.second))
    }
}
