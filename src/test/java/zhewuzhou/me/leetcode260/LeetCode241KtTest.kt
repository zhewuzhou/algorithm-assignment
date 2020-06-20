package zhewuzhou.me.leetcode260

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode241KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair("2-1-1", listOf(0, 2)),
                Pair("2*3-4*5", listOf(-34, -14, -10, -10, 10)),
                Pair("3-4*5+7*3", listOf(-101, -141, -38, -141, -78, -26, -36, 4, 16, -135, -72, -36, -30, 6)),
                Pair("1", listOf(1)),
                Pair("", listOf())
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should calculate different value when parentheses`(case: Pair<String, List<Int>>) {
        val result = diffWaysToCompute(case.first)
        assertThat(result.size, `is`(case.second.size))
        for (n in case.second) {
            assertThat(result.contains(n), `is`(true))
            assertThat(result.count { it == n }, `is`(case.second.count { it == n }))
        }
    }
}
