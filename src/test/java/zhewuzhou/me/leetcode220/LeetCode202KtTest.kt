package zhewuzhou.me.leetcode220

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode202KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(19, true),
                Pair(2, false)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should determine if the num is happy`(case: Pair<Int, Boolean>) {
        assertThat(isHappy(case.first), `is`(case.second))
    }
}
