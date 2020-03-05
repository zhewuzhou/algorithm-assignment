package zhewuzhou.me.leetcode60

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*
import java.util.stream.Stream

class LeetCode44KtTest {
    data class Test44Case(
        val s: String,
        val p: String,
        val expected: Boolean
    )

    private companion object {
        @JvmStatic
        fun cases(): Stream<Test44Case>? {
            val VERY_LONG_S = "aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba"
            val STRANGE_P = "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*"
            return Arrays.stream(
                arrayOf(
                    Test44Case("aa", "a", false),
                    Test44Case("aa", "*", true),
                    Test44Case("cb", "?a", false),
                    Test44Case("adceb", "*a*b", true),
                    Test44Case(VERY_LONG_S, STRANGE_P, true),
                    Test44Case("acdcb", "a*c?b", false),
                    Test44Case("abefcdgiescdfimde", "ab*cd?i*de", true)
                )
            )
        }
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should match cases`(case: Test44Case) {
        assertThat(isMatch(case.s, case.p), `is`(case.expected))
    }
}
