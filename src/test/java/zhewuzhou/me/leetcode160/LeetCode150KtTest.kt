package zhewuzhou.me.leetcode160

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode150KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(arrayOf("2", "1", "+", "3", "*"), 9),
                Pair(arrayOf(), 0),
                Pair(arrayOf("1"), 1),
                Pair(arrayOf("4", "13", "5", "/", "+"), 6),
                Pair(arrayOf("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"), 22)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should evulate the given string and perform calculate it correctly`(case: Pair<Array<String>, Int>) {
        assertThat(evalRPN(case.first), `is`(case.second))
    }
}
