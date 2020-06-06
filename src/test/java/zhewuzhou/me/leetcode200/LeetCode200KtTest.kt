package zhewuzhou.me.leetcode200

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode200KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(arrayOf(
                    "11110".toCharArray(),
                    "11010".toCharArray(),
                    "11000".toCharArray(),
                    "00000".toCharArray()), 1),
                Pair(arrayOf(
                    "11000".toCharArray(),
                    "11000".toCharArray(),
                    "00100".toCharArray(),
                    "00011".toCharArray()), 3)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should count the number of islands`(case: Pair<Array<CharArray>, Int>) {
        assertThat(numIslands(case.first), `is`(case.second))
    }
}
