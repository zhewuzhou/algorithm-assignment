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

        @JvmStatic
        fun casesPath() = Arrays.stream(
            arrayOf(
                Triple("leetcode", listOf("leet", "code"), listOf("leet code")),
                Triple("a", listOf(), listOf<String>()),
                Triple("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                    listOf("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"),
                    listOf<String>()),
                Triple("catsanddog", listOf("cat", "cats", "and", "sand", "dog"),
                    listOf("cats and dog", "cat sand dog")),
                Triple("pineapplepenapple", listOf("apple", "pen", "applepen", "pine", "pineapple"),
                    listOf("pine apple pen apple", "pineapple pen apple", "pine applepen apple")),
                Triple("catsandog", listOf("cats", "dog", "sand", "and", "cat"), listOf<String>())
            )
        )
    }

//    @ParameterizedTest
//    @MethodSource("cases")
//    fun `Should break the world with dict`(case: Triple<String, List<String>, Boolean>) {
//        assertThat(wordBreak(case.first, case.second), `is`(case.third))
//    }

    @ParameterizedTest
    @MethodSource("casesPath")
    fun `Should calculate all possible combinations from dict`(case: Triple<String, List<String>, List<String>>) {
        val result = wordBreakII(case.first, case.second)
        assertThat(result.size, `is`(case.third.size))
    }
}
