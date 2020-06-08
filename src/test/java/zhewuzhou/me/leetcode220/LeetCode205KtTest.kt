package zhewuzhou.me.leetcode220

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode205KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple("egg", "add", true),
                Triple("", "", true),
                Triple("foo", "bar", false),
                Triple("paper", "title", true),
                Triple("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabb", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaacc", true),
                Triple("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabb", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaacd", false)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should be able to tell if 2 strings are isomorphic`(case: Triple<String, String, Boolean>) {
        assertThat(isIsomorphic(case.first, case.second), `is`(case.third))
    }
}
