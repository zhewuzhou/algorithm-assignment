package zhewuzhou.me.leetcode200

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode187KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT", listOf("AAAAACCCCC", "CCCCCAAAAA"))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find the repeated DNA sequences`(case: Pair<String, List<String>>) {
        assertThat(findRepeatedDnaSequences(case.first), `is`(case.second))
    }
}
