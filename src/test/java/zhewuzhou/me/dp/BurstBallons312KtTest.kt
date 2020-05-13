package zhewuzhou.me.dp

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class BurstBalloons312KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(listOf(3, 1, 5, 8), 167),
                Pair(listOf(1), 1)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should got maximum coins by burst balloons`(case: Pair<List<Int>, Int>) {
        assertThat(maxCoins(case.first.toIntArray()), `is`(case.second))
    }
}
