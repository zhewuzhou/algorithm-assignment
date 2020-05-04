package zhewuzhou.me.dp

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class HouseRobber198KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(listOf(1, 2, 3, 1), 4),
                Pair(listOf(1, 2), 2),
                Pair(listOf(2, 7, 9, 3, 1), 12)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should rob as much as it can`(case: Pair<List<Int>, Int>) {
        assertThat(rob(case.first.toIntArray()), `is`(case.second))
    }
}
