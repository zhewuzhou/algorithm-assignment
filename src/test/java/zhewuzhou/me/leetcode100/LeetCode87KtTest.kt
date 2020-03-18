package zhewuzhou.me.leetcode100

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode87KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple("great", "rgeat", true),
                Triple("great", "rgtae", true),
                Triple("abcde", "caebd", false)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should determine if target string is the scramble`(case: Triple<String, String, Boolean>) {
        assertThat(isScramble(case.first, case.second), `is`(case.third))
    }
}
