package zhewuzhou.me.leetcode40

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

class LeetCode34KtTest {
    data class TestCase(
        val nums: List<Int>,
        val target: Int,
        val expected: List<Int>
    )

    private companion object {
        @JvmStatic
        fun arguments() =
            Arrays.stream(
                arrayOf(
                    TestCase(listOf(5, 7, 7, 8, 8, 10), 8, listOf(3, 4)),
                    TestCase(listOf(5, 7, 7, 8, 8, 10), 7, listOf(1, 2)),
                    TestCase(listOf(5, 7, 7, 8, 8, 10), 6, listOf(-1, -1)),
                    TestCase(listOf(1), 1, listOf(0, 0)),
                    TestCase(listOf(1), 2, listOf(-1, -1))
                )
            )
    }

    @ParameterizedTest
    @MethodSource("arguments")
    fun `Should calculate range`(case: TestCase) {
        val nums = case.nums.toIntArray()
        val expected = case.expected.toTypedArray()
        assertThat(searchStart(nums, case.target), `is`(case.expected[0]))
        assertThat(searchEnd(nums, case.target), `is`(case.expected[1]))
    }
}
