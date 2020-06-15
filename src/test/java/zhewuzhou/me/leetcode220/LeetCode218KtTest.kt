package zhewuzhou.me.leetcode220

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode218KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
//                Pair(arrayOf(
//                    intArrayOf(2, 9, 10),
//                    intArrayOf(3, 7, 15),
//                    intArrayOf(5, 12, 12),
//                    intArrayOf(15, 20, 10),
//                    intArrayOf(19, 24, 8)
//                ), listOf(
//                    listOf(2, 10),
//                    listOf(3, 15),
//                    listOf(7, 12),
//                    listOf(12, 0),
//                    listOf(15, 10),
//                    listOf(20, 8),
//                    listOf(24, 0)
//                )),
//                Pair(arrayOf(intArrayOf(2, 9, 10)), listOf(listOf(2, 10), listOf(9, 0))),
//                Pair(arrayOf(intArrayOf(0, 2147483647, 2147483647)), listOf(listOf(0, 2147483647), listOf(2147483647, 0))),
//                Pair(arrayOf(), listOf()),
                Pair(arrayOf(intArrayOf(0, 3, 3), intArrayOf(1, 5, 3), intArrayOf(2, 4, 3), intArrayOf(3, 7, 3)),
                    listOf(listOf(0, 3), listOf(7, 0)))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should get the points of the skyline`(case: Pair<Array<IntArray>, List<List<Int>>>) {
        val result = getSkyline(case.first)
        for (p in case.second) {
            assertThat(result.contains(p), `is`(true))
        }
    }
}
