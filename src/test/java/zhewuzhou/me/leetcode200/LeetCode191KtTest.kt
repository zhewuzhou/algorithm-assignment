package zhewuzhou.me.leetcode200

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode191KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(1, 1),
                Pair(0, 0),
                Pair(7, 3),
                Pair(10000, 5),
                Pair(Int.MAX_VALUE, 31),
                Pair(Int.MIN_VALUE, 1)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should count all 1 bits`(case: Pair<Int, Int>) {
        assertThat(hammingWeight(case.first), `is`(case.second))
    }
}
