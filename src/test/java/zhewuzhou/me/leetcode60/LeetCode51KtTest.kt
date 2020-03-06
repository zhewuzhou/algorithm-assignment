package zhewuzhou.me.leetcode60

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

class LeetCode51KtTest {
    data class Test51Case(
        val n: Int,
        val expected: Int
    )

    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                //Test51Case(4, 2),
                Test51Case(8, 2)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should solve n queue`(case: Test51Case) {
        assertThat(solveNQueens(case.n).size, `is`(case.expected))
    }
}
