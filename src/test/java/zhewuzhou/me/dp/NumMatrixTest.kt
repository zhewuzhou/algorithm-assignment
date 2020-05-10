package zhewuzhou.me.dp

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class NumMatrixTest {
    private val matrix = NumMatrix(
        arrayOf(
            listOf(3, 0, 1, 4, 2).toIntArray(),
            listOf(5, 6, 3, 2, 1).toIntArray(),
            listOf(1, 2, 0, 1, 5).toIntArray(),
            listOf(4, 1, 0, 1, 7).toIntArray(),
            listOf(1, 0, 3, 0, 5).toIntArray()
        )
    )

    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(Pair(2, 1), Pair(4, 3), 8),
                Triple(Pair(1, 1), Pair(2, 2), 11),
                Triple(Pair(1, 2), Pair(2, 4), 12)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should calculate sum of defined region`(case: Triple<Pair<Int, Int>, Pair<Int, Int>, Int>) {
        val leftCorner = case.first
        val rightCorner = case.second
        val sum = matrix.sumRegion(leftCorner.first, leftCorner.second, rightCorner.first, rightCorner.second)
        assertThat(sum, `is`(case.third))
    }

    @Test
    fun `Exception should happened when empty array`() {
        val emptyNumMatrix = NumMatrix(listOf(listOf<Int>().toIntArray()).toTypedArray())
        emptyNumMatrix.sumRegion(0, 0, 0, 0)
    }
}
