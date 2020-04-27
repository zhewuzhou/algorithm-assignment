package zhewuzhou.me.leetcode180

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode174KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(listOf(listOf(-2, -3, 3), listOf(-5, -10, 1), listOf(10, 30, -5)), 7),
                Pair(listOf(listOf(100)), 1),
                Pair(listOf(listOf(1, -3, 3), listOf(0, -2, 0), listOf(-3, -3, -3)), 3))
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should calculate minimal health points`(case: Pair<List<List<Int>>, Int>) {
        val dungeon = case.first.map { it.toIntArray() }.toTypedArray()
        assertThat(calculateMinimumHP(dungeon), `is`(case.second))
    }
}
