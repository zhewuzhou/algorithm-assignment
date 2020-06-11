package zhewuzhou.me.leetcode220

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode214KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair("ababc", listOf(0, 0, 1, 2, 0)),
                Pair("aabaaa", listOf(0, 1, 0, 1, 2, 2)),
                Pair("abcdabcy", listOf(0, 0, 0, 0, 1, 2, 3, 0)),
                Pair("abcdabca", listOf(0, 0, 0, 0, 1, 2, 3, 1))
            )
        )

        @JvmStatic
        fun searchCases() = Arrays.stream(
            arrayOf(
                Triple("ababc", "abc", 2),
                Triple("ababc", "ac", 5),
                Triple("abxabcabcaby", "abcaby", 6),
                Triple("abxabcabcaby", "abcabd", 12)
            )
        )

        @JvmStatic
        fun shortestPalindromeCases() = Arrays.stream(
            arrayOf(
                Pair("aacecaaa", "aaacecaaa"),
                Pair("abcd", "dcbabcd"),
                Pair("aaaaa", "aaaaa"),
                Pair("bbbb", "bbbb")
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should calculate the table for KMP`(case: Pair<String, List<Int>>) {
        assertThat(StringMatch(case.first).table.toList(), `is`(case.second))
    }

    @ParameterizedTest
    @MethodSource("searchCases")
    fun `Should search for the text`(case: Triple<String, String, Int>) {
        assertThat(StringMatch(case.second).search(case.first).first, `is`(case.third))
        assertThat(StringMatch(case.second).searchWithTable(case.first), `is`(case.third))
    }

    @ParameterizedTest
    @MethodSource("shortestPalindromeCases")
    fun `Should search for the text`(case: Pair<String, String>) {
        assertThat(shortestPalindrome(case.first), `is`(case.second))
    }
}
