package zhewuzhou.me.leetcode180

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode168KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(1, "A"),
                Pair(2, "B"),
                Pair(3, "C"),
                Pair(26, "Z"),
                Pair(27, "AA"),
                Pair(28, "AB"),
                Pair(701, "ZY"),
                Pair(Int.MAX_VALUE, "FXSHRXW"),
                Pair(52, "AZ"),
                Pair(78, "BZ"),
                Pair(104, "CZ"),
                Pair(17576, "YYZ")
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should return the correct column header based on int`(case: Pair<Int, String>) {
        assertThat(convertToTitle(case.first), `is`(case.second))
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should convert tile to number`(case: Pair<Int, String>) {
        assertThat(titleToNumber(case.second), `is`(case.first))
    }
}
