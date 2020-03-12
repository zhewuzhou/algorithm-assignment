package zhewuzhou.me.leetcode80

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode76KtTest {
    data class Test76Case(
        val src: String,
        val target: String,
        val expected: String
    )

    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Test76Case("ADOBECODEBANC", "ABC", "BANC"),
                Test76Case("aa", "aa", "aa"),
                Test76Case("a", "a", "a"),
                Test76Case("ABXYZACBD", "ABC", "ACB")
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should calculate min window`(case: Test76Case) {
        assertThat(minWindow(case.src, case.target), `is`(case.expected))
    }
}
