package zhewuzhou.me.leetcode240

import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode224KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair("1 + 1", 2),
                Pair(" 2-1 + 2 ", 3),
                Pair(" 1-(2+3-(4+5)) ", 5),
                Pair(" 1-(2+3-(4+5))+1 ", 6),
                Pair("    ", 0),
                Pair("", 0),
                Pair("100", 100),
                Pair("-100", -100),
                Pair("(1+(4+5+2)-3)+(6+8)", 23)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should calculate the expression as given string`(case: Pair<String, Int>) {
        MatcherAssert.assertThat(calculate(case.first), CoreMatchers.`is`(case.second))
    }
}
