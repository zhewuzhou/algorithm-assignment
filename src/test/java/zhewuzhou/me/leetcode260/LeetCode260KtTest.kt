package zhewuzhou.me.leetcode260

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode260KtTest {
    private companion object {
        fun edgeCase(): IntArray {
            val result = mutableListOf<Int>()
            result.addAll((1..100).toList())
            result.addAll((1..100).toList())
            result.add(101)
            result.add(-105)
            return result.toIntArray()
        }

        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(intArrayOf(1, 2, 1, 3, 2, 5), listOf(3, 5)),
                Pair(intArrayOf(3, 5), listOf(3, 5)),
                Pair(intArrayOf(3), listOf()),
                Pair(edgeCase(), listOf(101, -105))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find the 2 numbers show once`(case: Pair<IntArray, List<Int>>) {
        val result = singleNumber(case.first).toList().sorted()
        assertThat(result, `is`(case.second.sorted()))
    }
}
