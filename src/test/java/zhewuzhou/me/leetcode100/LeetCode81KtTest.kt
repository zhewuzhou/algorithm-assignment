package zhewuzhou.me.leetcode100

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

class LeetCode81KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(listOf(2, 5, 6, 0, 0, 1, 2), 0, true),
                Triple(listOf(2, 5, 6, 0, 0, 1, 2), 7, false),
                Triple(listOf(0, 1, 2, 3, 4, 5, 6), 7, false),
                Triple(listOf(0, 1, 2, 3, 4, 5, 6), 5, true),
                Triple(listOf(0, 0, 0, 0, 0, 0, 0), 5, false),
                Triple(listOf(0, 0, 0, 0, 0, 0, 0), 0, true),
                Triple(listOf(0, 1, 0, 0, 0, 0, 0), 1, true),
                Triple(listOf(0, 0, 0, 0, 0, 1, 0), 1, true),
                Triple(listOf(0, 0, 0, 0, 0, 1, 0), 2, false)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find target in rotated array`(case: Triple<List<Int>, Int, Boolean>) {
        val nums = case.first.toIntArray()
        assertThat(search(nums, case.second), `is`(case.third))
    }
}
