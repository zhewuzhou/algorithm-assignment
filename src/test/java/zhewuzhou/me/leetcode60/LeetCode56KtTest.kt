package zhewuzhou.me.leetcode60

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsInAnyOrder
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

class LeetCode56KtTest {
    data class Test56Case(
        val interval: List<IntArray>,
        val expected: List<List<Int>>
    )

    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Test56Case(
                    listOf(
                        arrayOf(1, 3).toIntArray(),
                        arrayOf(2, 6).toIntArray(),
                        arrayOf(8, 10).toIntArray(),
                        arrayOf(15, 18).toIntArray()
                    ),
                    listOf(
                        listOf(1, 6),
                        listOf(8, 10),
                        listOf(15, 18)
                    )
                ),
                Test56Case(
                    listOf(
                        arrayOf(1, 4).toIntArray(),
                        arrayOf(4, 5).toIntArray()
                    ),
                    listOf(
                        listOf(1, 5)
                    )
                ),
                Test56Case(
                    listOf(
                        arrayOf(1, 4).toIntArray(),
                        arrayOf(0, 4).toIntArray()
                    ),
                    listOf(
                        listOf(0, 4)
                    )
                ),
                Test56Case(
                    listOf(
                        arrayOf(1, 4).toIntArray(),
                        arrayOf(2, 3).toIntArray()
                    ),
                    listOf(
                        listOf(1, 4)
                    )
                ),
                Test56Case(
                    listOf(
                        arrayOf(2, 3).toIntArray(),
                        arrayOf(4, 5).toIntArray(),
                        arrayOf(6, 7).toIntArray(),
                        arrayOf(8, 9).toIntArray(),
                        arrayOf(1, 10).toIntArray()
                    ),
                    listOf(
                        listOf(1, 10)
                    )
                ),
                Test56Case(
                    listOf(
                        arrayOf(0, 0).toIntArray(),
                        arrayOf(1, 2).toIntArray(),
                        arrayOf(5, 5).toIntArray(),
                        arrayOf(2, 4).toIntArray(),
                        arrayOf(3, 3).toIntArray(),
                        arrayOf(5, 6).toIntArray(),
                        arrayOf(5, 6).toIntArray(),
                        arrayOf(4, 6).toIntArray(),
                        arrayOf(0, 0).toIntArray(),
                        arrayOf(1, 2).toIntArray(),
                        arrayOf(0, 2).toIntArray(),
                        arrayOf(4, 5).toIntArray()
                    ),
                    listOf(
                        listOf(0, 6)
                    )
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should merge intervals`(case: Test56Case) {
        val input = case.interval.toTypedArray()
        assertThat(merge(input).toList().map { it.toList() },
            containsInAnyOrder(*case.expected.toTypedArray()))
    }
}
