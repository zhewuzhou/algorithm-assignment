package zhewuzhou.me.leetcode100

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode91KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair("12", 2),
                Pair("", 0),
                Pair("0", 0),
                Pair("000000", 0),
                Pair("01", 0),
                Pair(("226"), 3),
                Pair(("22222"), 8),
                Pair(("10"), 1),
                Pair(("28022"), 0)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should determine how many decode way`(case: Pair<String, Int>) {
        assertThat(numDecodings(case.first), `is`(case.second))
    }
}
