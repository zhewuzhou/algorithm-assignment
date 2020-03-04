package zhewuzhou.me.leetcode60

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

class LeetCode42KtTest {
    data class Test42Case(
        val nums: List<Int>,
        val water: Int
    )

    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Test42Case(listOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1), 6)
//                Test42Case(listOf(1, 0, 0, 0, 1), 3),
//                Test42Case(listOf(1, 0, 0, 0, 1, 0, 0), 3),
//                Test42Case(listOf(0, 0, 0, 1, 0, 0), 0),
//                Test42Case(listOf(0, 0, 0, 1, 0, 0, 1), 2),
//                Test42Case(listOf(1, 0, 0, 1, 0, 1, 0, 0, 1, 0), 5)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should calculate trapped water`(case: Test42Case) {
        val heights = case.nums.toIntArray()
        assertThat(trap(heights), `is`(case.water))
    }
}
