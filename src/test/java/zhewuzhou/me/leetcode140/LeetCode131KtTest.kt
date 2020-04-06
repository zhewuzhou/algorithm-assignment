package zhewuzhou.me.leetcode140

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode131KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair("aab", listOf(listOf("a", "a", "b"), listOf("aa", "b")))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should partition the string with palindrome`(case: Pair<String, List<List<String>>>) {
        assertThat(partition(case.first).size, `is`(case.second.size))
    }

    @Test
    fun `Should calculate min cut`() {
        assertThat(minCut("aab"), `is`(1))
        assertThat(minCut("a"), `is`(0))
        assertThat(minCut("aaaaaaaaaaaaaaaaaaaaaaaaabbbbb"), `is`(1))
    }
}
