package zhewuzhou.me.dp

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class MaximalSquare221KtTest {
    private companion object {


        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(listOf(
                    listOf('1', '0', '1', '0', '0').toCharArray(),
                    listOf('1', '0', '1', '1', '1').toCharArray(),
                    listOf('1', '1', '1', '1', '1').toCharArray(),
                    listOf('1', '0', '0', '1', '0').toCharArray()
                ).toTypedArray(), 4)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should calculate the maximum square made by 1s`(case: Pair<Array<CharArray>, Int>) {
        assertThat(maximalSquare(case.first), `is`(case.second))
    }
}
