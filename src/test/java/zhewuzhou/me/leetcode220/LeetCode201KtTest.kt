package zhewuzhou.me.leetcode220

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode201KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(5, 7, 4),
                Triple(4, 7, 4),
                Triple(1, Int.MAX_VALUE, 0),
                Triple(0, 1, 0)
            )

        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should return and result in all range`(case: Triple<Int, Int, Int>) {
        assertThat(rangeBitwiseAnd(case.first, case.second), `is`(case.third))
    }
}
