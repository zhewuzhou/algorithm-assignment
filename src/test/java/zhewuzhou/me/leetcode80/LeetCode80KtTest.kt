package zhewuzhou.me.leetcode80

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

class LeetCode80KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(listOf(1, 1, 1, 2, 2, 3), 5),
                Pair(listOf(0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 3, 3), 7)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should remove duplications`(case: Pair<List<Int>, Int>) {
        assertThat(removeDuplicates(case.first.toIntArray()), `is`(case.second))
    }
}
