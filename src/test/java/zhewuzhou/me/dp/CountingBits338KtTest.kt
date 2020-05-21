package zhewuzhou.me.dp

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class CountingBits338KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(2, listOf(0, 1, 1)),
                Pair(5, listOf(0, 1, 1, 2, 1, 2)),
                Pair(15, listOf(0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4)),
                Pair(1, listOf(0, 1)),
                Pair(0, listOf(0))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should counting bits for given num`(case: Pair<Int, List<Int>>) {
        assertThat(countBits(case.first).toList(), `is`(case.second))
    }
}
