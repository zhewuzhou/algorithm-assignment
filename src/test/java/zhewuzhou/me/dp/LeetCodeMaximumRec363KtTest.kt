package zhewuzhou.me.dp

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCodeMaximumRec363KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(arrayOf(
                    intArrayOf(1, 0, 1),
                    intArrayOf(0, -2, 3)
                ), 2, 2)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should `(case: Triple<Array<IntArray>, Int, Int>) {
        assertThat(maxSumSubmatrix(case.first, case.second), `is`(case.third))
    }
}
