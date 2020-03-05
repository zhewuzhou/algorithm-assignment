package zhewuzhou.me.leetcode60

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

class LeetCode46KtTest {
    data class Test46Case(
        val nums: List<Int>,
        val expected: Int
    )

    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Test46Case(listOf(100, 101, 102), 6)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should return all permutations`(case: Test46Case) {
        assertThat(permute(case.nums.toIntArray()).size, `is`(case.expected))
    }
}
