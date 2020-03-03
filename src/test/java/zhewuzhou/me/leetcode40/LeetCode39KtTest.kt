package zhewuzhou.me.leetcode40

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

class LeetCode39KtTest {

    data class CombinationCase(
        val nums: List<Int>,
        val target: Int,
        val expected: List<List<Int>>
    )

    private companion object {
        @JvmStatic
        fun simpleCases() =
            Arrays.stream(
                arrayOf(
                    CombinationCase(listOf(2, 3, 6, 7), 7, listOf(listOf(7), listOf(2, 2, 3))),
                    CombinationCase(listOf(2, 3, 5), 8, listOf(listOf(2, 2, 2, 2), listOf(2, 3, 3), listOf(3, 5)))
                )
            )
    }

    @ParameterizedTest
    @MethodSource("simpleCases")
    fun `Should find all combinations`(case: CombinationCase) {
        val ints = case.nums.toIntArray()
        val expectedSize = case.expected.size
        assertThat(combinationSum(ints, case.target).size, `is`(expectedSize))
    }
}
