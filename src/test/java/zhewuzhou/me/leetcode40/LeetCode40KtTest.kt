package zhewuzhou.me.leetcode40

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

class LeetCode40KtTest {
    data class CombinationCase(
        val nums: List<Int>,
        val target: Int,
        val expected: List<List<Int>>
    )

    private companion object {
        @JvmStatic
        fun cases() =
            Arrays.stream(
                arrayOf(
                    CombinationCase(listOf(10, 1, 2, 7, 6, 1, 5),
                        8,
                        listOf(listOf(1, 7), listOf(1, 2, 5), listOf(2, 6), listOf(1, 1, 6)))
                )
            )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should get all combs`(case: CombinationCase) {
        val nums = case.nums.toIntArray()
        assertThat(combinationSum2(nums, case.target).size, `is`(4))
    }
}
