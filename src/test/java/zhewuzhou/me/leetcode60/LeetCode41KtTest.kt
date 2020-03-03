package zhewuzhou.me.leetcode60

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

class LeetCode41KtTest {
    data class Test41Case(
        val nums: List<Int>,
        val expected: Int
    )

    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Test41Case(listOf(1, 2, 0), 3),
                Test41Case(listOf(3, 4, -1, 1), 2),
                Test41Case(listOf(7, 8, 9, 11, 12), 1)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find the smallest positive number`(case: Test41Case) {
        assertThat(firstMissingPositive(case.nums.toIntArray()), `is`(case.expected))
    }
}
