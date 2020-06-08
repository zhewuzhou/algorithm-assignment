package zhewuzhou.me.leetcode220

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode204KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(10, 4),
                Pair(2, 0),
                Pair(7, 3),
                Pair(100, 25),
                Pair(500, 95)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should count prime num within n`(case: Pair<Int, Int>) {
        assertThat(countPrimes(case.first), `is`(case.second))
    }
}
