package zhewuzhou.me.leetcode100

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode90KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(listOf(1, 2, 2), 6),
                Pair(listOf(), 1),
                Pair(listOf(0), 2),
                Pair(listOf(4, 4, 4, 1, 4), 10)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should calculate subsets`(case: Pair<List<Int>, Int>) {
        val nums = case.first.toIntArray()
        assertThat(subsetsWithDup(nums).size, `is`(case.second))
    }
}
