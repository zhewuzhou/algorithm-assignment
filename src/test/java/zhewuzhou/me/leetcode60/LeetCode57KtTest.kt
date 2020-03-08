package zhewuzhou.me.leetcode60

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

class LeetCode57KtTest {

    data class Test57CaseSearch(
        val ranges: List<IntArray>,
        val target: Int,
        val expected: Int
    )

    private companion object {
        @JvmStatic
        fun lowerCases() = Arrays.stream(
            arrayOf(
                Test57CaseSearch(
                    listOf(arrayOf(1, 3).toIntArray(), arrayOf(6, 9).toIntArray()),
                    2,
                    0
                ),
                Test57CaseSearch(
                    listOf(arrayOf(1, 3).toIntArray()),
                    2,
                    0
                ),
                Test57CaseSearch(
                    listOf(arrayOf(1, 3).toIntArray()),
                    0,
                    0
                ),
                Test57CaseSearch(
                    listOf(arrayOf(1, 3).toIntArray()),
                    3,
                    0
                ),
                Test57CaseSearch(
                    listOf(arrayOf(1, 3).toIntArray()),
                    4,
                    -1
                ),
                Test57CaseSearch(
                    listOf(arrayOf(1, 2).toIntArray(), arrayOf(3, 5).toIntArray(), arrayOf(6, 7).toIntArray(),
                        arrayOf(8, 10).toIntArray(), arrayOf(12, 16).toIntArray()),
                    4,
                    1
                ),
                Test57CaseSearch(
                    listOf(arrayOf(1, 2).toIntArray(), arrayOf(3, 5).toIntArray(), arrayOf(6, 7).toIntArray(),
                        arrayOf(8, 10).toIntArray(), arrayOf(12, 16).toIntArray()),
                    11,
                    4
                ),
                Test57CaseSearch(
                    listOf(arrayOf(1, 2).toIntArray(), arrayOf(3, 5).toIntArray(), arrayOf(6, 7).toIntArray(),
                        arrayOf(8, 10).toIntArray(), arrayOf(12, 16).toIntArray()),
                    0,
                    0
                ),
                Test57CaseSearch(
                    listOf(arrayOf(1, 2).toIntArray(), arrayOf(3, 5).toIntArray(), arrayOf(6, 7).toIntArray(),
                        arrayOf(8, 10).toIntArray(), arrayOf(12, 16).toIntArray()),
                    17,
                    -1
                )
            )
        )

        @JvmStatic
        fun upperCases() = Arrays.stream(
            arrayOf(
                Test57CaseSearch(
                    listOf(arrayOf(1, 3).toIntArray()),
                    2,
                    0
                ),
                Test57CaseSearch(
                    listOf(arrayOf(1, 3).toIntArray()),
                    4,
                    0
                ),
                Test57CaseSearch(
                    listOf(arrayOf(1, 3).toIntArray()),
                    3,
                    0
                ),
                Test57CaseSearch(
                    listOf(arrayOf(1, 3).toIntArray()),
                    0,
                    -1
                ),
                Test57CaseSearch(
                    listOf(arrayOf(1, 2).toIntArray(), arrayOf(3, 5).toIntArray(), arrayOf(6, 7).toIntArray(),
                        arrayOf(8, 10).toIntArray(), arrayOf(12, 16).toIntArray()),
                    11,
                    3
                ),
                Test57CaseSearch(
                    listOf(arrayOf(1, 2).toIntArray(), arrayOf(3, 5).toIntArray(), arrayOf(6, 7).toIntArray(),
                        arrayOf(8, 10).toIntArray(), arrayOf(12, 16).toIntArray()),
                    4,
                    1
                ),
                Test57CaseSearch(
                    listOf(arrayOf(1, 2).toIntArray(), arrayOf(3, 5).toIntArray(), arrayOf(6, 7).toIntArray(),
                        arrayOf(8, 10).toIntArray(), arrayOf(12, 16).toIntArray()),
                    0,
                    -1
                ),
                Test57CaseSearch(
                    listOf(arrayOf(1, 2).toIntArray(), arrayOf(3, 5).toIntArray(), arrayOf(6, 7).toIntArray(),
                        arrayOf(8, 10).toIntArray(), arrayOf(12, 16).toIntArray()),
                    17,
                    4
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("lowerCases")
    fun `Should search for lower bound`(case: Test57CaseSearch) {
        val ranges = case.ranges.toTypedArray()
        assertThat(searchForLowerBound(ranges, case.target), `is`(case.expected))
    }

    @ParameterizedTest
    @MethodSource("upperCases")
    fun `Should search for upper bound`(case: Test57CaseSearch) {
        val ranges = case.ranges.toTypedArray()
        assertThat(searchForUpperBound(ranges, case.target), `is`(case.expected))
    }

    @Test
    fun `Should insert newIntervals`() {
        insert(arrayOf(arrayOf(1, 3).toIntArray(), arrayOf(6, 9).toIntArray()), arrayOf(2, 5).toIntArray())
    }
}
