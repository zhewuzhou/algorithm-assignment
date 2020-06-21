package zhewuzhou.me.leetcode260

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode242KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple("anagram", "anagram", true),
                Triple("rat", "car", false),
                Triple("", "", true),
                Triple("a", "", false)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should know if 2 strings are anagram`(case: Triple<String, String, Boolean>) {
        assertThat(isAnagram(case.first, case.second), `is`(case.third))
    }
}
