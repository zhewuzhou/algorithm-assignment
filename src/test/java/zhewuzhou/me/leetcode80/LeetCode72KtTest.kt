package zhewuzhou.me.leetcode80

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode72KtTest {
    data class Test72Case(
        val from: String,
        val target: String,
        val expected: Int
    )

    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Test72Case("horse", "ros", 3),
                Test72Case("intention", "execution", 5)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find the min path from A string to B string`(case: Test72Case) {
        assertThat(minDistance(case.from, case.target), `is`(case.expected))
    }
}
