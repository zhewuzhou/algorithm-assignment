package zhewuzhou.me.leetcode220

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode212KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(
                    arrayOf(
                        charArrayOf('o', 'a', 'a', 'n'),
                        charArrayOf('e', 't', 'a', 'e'),
                        charArrayOf('i', 'h', 'k', 'r'),
                        charArrayOf('i', 'f', 'l', 'v')
                    ), listOf("oath", "pea", "eat", "rain"), listOf("oath", "eat")
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find words in metrics`(case: Triple<Array<CharArray>, List<String>, List<String>>) {
        assertThat(findWords(case.first, case.second.toTypedArray()), `is`(case.third))
    }
}
