package zhewuzhou.me.numbers

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class CreateMaximumNumber321KtTest {
    private companion object {
        @JvmStatic
        fun pickNumbersCases() = Arrays.stream(
            arrayOf(
                Triple(intArrayOf(9, 1, 2, 5, 8, 3), 1, intArrayOf(9)),
                Triple(intArrayOf(9, 1, 2, 5, 8, 3), 0, intArrayOf()),
                Triple(intArrayOf(9, 1, 2, 5, 8, 3), 2, intArrayOf(9, 8)),
                Triple(intArrayOf(9, 1, 2, 5, 8, 3), 3, intArrayOf(9, 8, 3)),
                Triple(intArrayOf(9, 1, 2, 5, 8, 3), 4, intArrayOf(9, 5, 8, 3)),
                Triple(intArrayOf(9, 1, 2, 5, 8, 3), 5, intArrayOf(9, 2, 5, 8, 3)),
                Triple(intArrayOf(9, 1, 2, 5, 8, 3), 6, intArrayOf(9, 1, 2, 5, 8, 3))
            )
        )

        @JvmStatic
        fun compareIntArray() = Arrays.stream(
            arrayOf(
                Triple(intArrayOf(1, 2, 3), intArrayOf(1, 2, 3), false),
                Triple(intArrayOf(1, 3, 2), intArrayOf(1, 2, 3), true),
                Triple(intArrayOf(1, 3, 2), intArrayOf(2, 1, 3), false)
            )
        )

        @JvmStatic
        fun mergeArray() = Arrays.stream(
            arrayOf(
                Triple(intArrayOf(9), intArrayOf(8, 9), listOf(9, 8, 9)),
                Triple(intArrayOf(), intArrayOf(8, 9), listOf(8, 9)),
                Triple(intArrayOf(5, 7, 3, 1, 9), intArrayOf(8, 4, 6, 2, 10), listOf(8, 5, 7, 4, 6, 3, 2, 10, 1, 9))
            )
        )
    }

    @Test
    fun `Should create maximum number with 3, 4, 6, 5 and 9, 1, 2, 5, 8, 3`() {
        val lhs = intArrayOf(3, 4, 6, 5)
        val rhs = intArrayOf(9, 1, 2, 5, 8, 3)
        val result = mapOf(
            1 to listOf(9),
            2 to listOf(9, 8),
            3 to listOf(9, 8, 6),
            4 to listOf(9, 8, 6, 5),
            5 to listOf(9, 8, 6, 5, 3),
            6 to listOf(9, 8, 4, 6, 5, 3),
            7 to listOf(9, 8, 3, 4, 6, 5, 3),
            8 to listOf(9, 6, 5, 1, 2, 5, 8, 3),
            9 to listOf(9, 4, 6, 5, 1, 2, 5, 8, 3),
            10 to listOf(9, 3, 4, 6, 5, 1, 2, 5, 8, 3)
        )
        for (i in 1..10) {
            assertThat(maxNumber(lhs, rhs, i).toList(), `is`(result[i]))
        }
    }

    @Test
    fun `Should working on 5,1,0 and 5,2,1`() {
        val result = maxNumber(intArrayOf(5, 1, 0), intArrayOf(5, 2, 1), 3)
        assertThat(result.toList(), `is`(listOf(5, 5, 2)))
    }

    @ParameterizedTest
    @MethodSource("pickNumbersCases")
    fun `Should pick k maximum elements from array`(case: Triple<IntArray, Int, IntArray>) {
        assertThat(pickMaximum(case.first, case.second).toList(), `is`(case.third.toList()))
    }

    @ParameterizedTest
    @MethodSource("compareIntArray")
    fun `Should compare int array with the same length`(case: Triple<IntArray, IntArray, Boolean>) {
        assertThat(compareArray(case.first, case.second, 0, 0), `is`(case.third))
    }

    @ParameterizedTest
    @MethodSource("mergeArray")
    fun `Should merge array`(case: Triple<IntArray, IntArray, List<Int>>) {
        assertThat(mergeArray(case.first, case.second).toList(), `is`(case.third))
    }
}
