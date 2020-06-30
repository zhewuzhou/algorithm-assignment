package zhewuzhou.me.leetcode280

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode190KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple("abba", "dog cat cat dog", true),
                Triple("abba", "dog cat cat fish", false),
                Triple("aaaa", "dog cat cat dog", false),
                Triple("abba", "dog dog dog dog", false),
                Triple("", "", true),
                Triple("a", "xxxxxxxxxxxxx", true)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should know if the pattern is the same`(case: Triple<String, String, Boolean>) {
        assertThat(wordPattern(case.first, case.second), `is`(case.third))
    }
}
