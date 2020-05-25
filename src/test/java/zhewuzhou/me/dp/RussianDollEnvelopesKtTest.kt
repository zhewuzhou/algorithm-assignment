package zhewuzhou.me.dp

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class RussianDollEnvelopesKtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(arrayOf(
                    intArrayOf(5, 4),
                    intArrayOf(6, 4),
                    intArrayOf(6, 7),
                    intArrayOf(2, 3)), 3)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should return the maximum doll`(case: Pair<Array<IntArray>, Int>) {
        assertThat(maxEnvelopes(case.first), `is`(case.second))
    }
}
