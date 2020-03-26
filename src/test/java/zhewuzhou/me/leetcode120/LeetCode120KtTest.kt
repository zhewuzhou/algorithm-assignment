package zhewuzhou.me.leetcode120

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode120KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(listOf(
                    listOf(2),
                    listOf(3, 4),
                    listOf(6, 5, 7),
                    listOf(4, 1, 8, 3)
                ), 11)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should be able to follow the min steps`(case: Pair<List<List<Int>>, Int>) {
        assertThat(minimumTotal(case.first), `is`(case.second))
    }
}
