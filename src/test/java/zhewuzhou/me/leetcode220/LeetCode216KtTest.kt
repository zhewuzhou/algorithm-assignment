package zhewuzhou.me.leetcode220

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode216KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(3, 7, listOf(listOf(1, 2, 4))),
                Triple(2, 10, listOf(
                    listOf(1, 9),
                    listOf(2, 8),
                    listOf(3, 7),
                    listOf(4, 6)
                )),
                Triple(3, 9, listOf(listOf(1, 2, 6), listOf(1, 3, 5), listOf(2, 3, 4))),
                Triple(4, 20, listOf(
                    listOf(1, 2, 8, 9),
                    listOf(1, 3, 7, 9),
                    listOf(1, 4, 6, 9),
                    listOf(1, 4, 7, 8),
                    listOf(1, 5, 6, 8),
                    listOf(2, 3, 6, 9),
                    listOf(2, 3, 7, 8),
                    listOf(2, 4, 5, 9),
                    listOf(2, 4, 6, 8),
                    listOf(2, 5, 6, 7),
                    listOf(3, 4, 5, 8),
                    listOf(3, 4, 6, 7)
                )),
                Triple(9, 45, listOf(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9))),
                Triple(9, 44, listOf()),
                Triple(1, 9, listOf(listOf(9))),
                Triple(1, 10, listOf()),
                Triple(3, 25, listOf()),
                Triple(3, 5, listOf())
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find all combinations of sum`(case: Triple<Int, Int, List<List<Int>>>) {
        val result = combinationSum3(case.first, case.second)
        for (l in case.third) {
            assertThat(result.contains(l), `is`(true))
        }
    }
}
