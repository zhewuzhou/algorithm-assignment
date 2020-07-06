package zhewuzhou.me.dp

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*


internal class WiggleSubsequence376KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(intArrayOf(1, 7, 4, 9, 2, 5), 6),
                Pair(intArrayOf(1, 17, 5, 10, 13, 15, 10, 5, 16, 8), 7),
                Pair(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9), 2)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should `(case: Pair<IntArray, Int>) {
        assertThat(wiggleMaxLength(case.first), `is`(case.second))
    }
}
