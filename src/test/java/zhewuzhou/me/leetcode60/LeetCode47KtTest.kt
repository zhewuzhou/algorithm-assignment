package zhewuzhou.me.leetcode60

import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

class LeetCode47KtTest {
    data class Test47Case(
        val nums: List<Int>,
        val expected: Int
    )

    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Test47Case(listOf(1, 1, 2), 3)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should return all permutations`(case: Test47Case) {
        MatcherAssert.assertThat(permuteUnique(case.nums.toIntArray()).size, CoreMatchers.`is`(case.expected))
    }
}
