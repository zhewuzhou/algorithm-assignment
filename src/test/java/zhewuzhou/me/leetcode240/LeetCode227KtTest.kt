package zhewuzhou.me.leetcode240

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode227KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair("3+2*2", 7),
                Pair("3/2", 1),
                Pair("3", 3),
                Pair("", 0),
                Pair("1/3/3", 0),
                Pair("3+5 / 2 ", 5),
                Pair("3+5 / 2 + 2*2/2+3*3*8+5/5", 80)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should calculate the more operator`(case: Pair<String, Int>) {
        assertThat(calculateS(case.first), `is`(case.second))
    }
}
