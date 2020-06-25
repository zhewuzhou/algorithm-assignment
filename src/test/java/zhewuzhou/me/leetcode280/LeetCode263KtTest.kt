package zhewuzhou.me.leetcode280

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode263KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(6, true),
                Pair(8, true),
                Pair(2, true),
                Pair(3, true),
                Pair(5, true),
                Pair(30, true),
                Pair(22, false),
                Pair(14, false),
                Pair(Int.MIN_VALUE, false),
                Pair(Int.MAX_VALUE, false)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should `(case: Pair<Int, Boolean>) {
        assertThat(isUgly(case.first), `is`(case.second))
    }
}
