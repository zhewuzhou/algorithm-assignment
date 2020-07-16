package zhewuzhou.me.leetcode280

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode273KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(123, "One Hundred Twenty Three"),
                Pair(1, "One"),
                Pair(0, "Zero"),
                Pair(100, "One Hundred"),
                Pair(1000, "One Thousand"),
                Pair(1000000, "One Million"),
                Pair(1000000000, "One Billion"),
                Pair(12345, "Twelve Thousand Three Hundred Forty Five"),
                Pair(1234567, "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"),
                Pair(2147483647, "Two Billion One Hundred Forty Seven Million Four Hundred Eighty Three Thousand Six Hundred Forty Seven")
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should convert num to string representation`(case: Pair<Int, String>) {
        assertThat(numberToWords(case.first), `is`(case.second))
    }
}
