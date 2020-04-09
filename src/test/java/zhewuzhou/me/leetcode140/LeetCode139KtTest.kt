package zhewuzhou.me.leetcode140

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode139KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple("leetcode", listOf("leet", "code"), true),
                Triple("a", listOf(), false),
                Triple("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                    listOf("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"),
                    false),
                Triple("applepenapple", listOf("apple", "pen"), true),
                Triple("catsandog", listOf("cats", "dog", "sand", "and", "cat"), false),
                Triple("aaaaaaa", listOf("aaaa", "aa"), false)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should break the world with dict`(case: Triple<String, List<String>, Boolean>) {
        assertThat(wordBreak(case.first, case.second), `is`(case.third))
    }
}
