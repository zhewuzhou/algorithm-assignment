package zhewuzhou.me.leetcode60

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

class LeetCode45KtTest {
    data class Test45Case(
        val nums: List<Int>,
        val expected: Int
    )

    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Test45Case(listOf(2, 3, 1, 1, 4), 2),
                Test45Case(listOf(2, 3, 0, 1, 4), 2),
                Test45Case(listOf(1, 2, 1, 1, 1), 3),
                Test45Case(listOf(3, 2, 1, 0, 4), 6)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should jump minimal steps to end`(case: Test45Case) {
        assertThat(jump(case.nums.toIntArray()), `is`(case.expected))
    }
}
