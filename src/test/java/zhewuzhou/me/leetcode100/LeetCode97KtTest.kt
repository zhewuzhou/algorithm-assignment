package zhewuzhou.me.leetcode100

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode97KtTest {
    data class Test97Case(
        val s1: String,
        val s2: String,
        val target: String,
        val expected: Boolean
    )

    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Test97Case("aabcc", "dbbca", "aadbbcbcac", true),
                Test97Case("aabcc", "dbbca", "aadbbbaccc", false)
            )
        )
    }


    @ParameterizedTest
    @MethodSource("cases")
    fun `Should determine if target string are formed by interleave`(case: Test97Case) {
        assertThat(isInterleave(case.s1, case.s2, case.target), `is`(case.expected))
    }
}
