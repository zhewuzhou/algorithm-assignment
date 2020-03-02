package zhewuzhou.me.leetcode40

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

class LeetCode34KtTest {
    data class TestSearchCase(
        val nums: List<Int>,
        val target: Int,
        val expected: List<Int>
    )

    data class TestInsertCase(
        val nums: List<Int>,
        val target: Int,
        val pos: Int
    )

    private companion object {
        @JvmStatic
        fun argumentsSearch() =
            Arrays.stream(
                arrayOf(
                    TestSearchCase(listOf(5, 7, 7, 8, 8, 10), 8, listOf(3, 4)),
                    TestSearchCase(listOf(5, 7, 7, 8, 8, 10), 7, listOf(1, 2)),
                    TestSearchCase(listOf(5, 7, 7, 8, 8, 10), 6, listOf(-1, -1)),
                    TestSearchCase(listOf(1), 1, listOf(0, 0)),
                    TestSearchCase(listOf(1), 2, listOf(-1, -1))
                )
            )

        @JvmStatic
        fun argumentsInserts() =
            Arrays.stream(
                arrayOf(
                    TestInsertCase(listOf(1, 3, 5, 6), 5, 2),
                    TestInsertCase(listOf(1, 3, 5, 6), 2, 1),
                    TestInsertCase(listOf(1, 3, 5, 6), 7, 4),
                    TestInsertCase(listOf(1, 3, 5, 6), 0, 0),
                    TestInsertCase(listOf(1), 1, 0),
                    TestInsertCase(listOf(1, 3), 1, 0)
                )
            )
    }

    @ParameterizedTest
    @MethodSource("argumentsSearch")
    fun `Should calculate range`(case: TestSearchCase) {
        val nums = case.nums.toIntArray()
        val expected = case.expected.toTypedArray()
        assertThat(searchStart(nums, case.target), `is`(case.expected[0]))
        assertThat(searchEnd(nums, case.target), `is`(case.expected[1]))
    }

    @ParameterizedTest
    @MethodSource("argumentsInserts")
    fun `Should find insertion pos`(case: TestInsertCase) {
        val nums = case.nums.toIntArray()
        val expected = case.pos
        assertThat(searchInsert(nums, case.target), `is`(expected))
    }
}
