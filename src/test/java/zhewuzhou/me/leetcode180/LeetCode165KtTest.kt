package zhewuzhou.me.leetcode180

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode165KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple("0.1", "1.1", -1),
                Triple("1.0.1", "1", 1),
                Triple("7.5.2.4", "7.5.3", -1),
                Triple("1.01", "1.001", 0),
                Triple("1.0", "1.0.0", 0)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should compare version numbers for open sourcing releases`(case: Triple<String, String, Int>) {
        assertThat(compareVersion(case.first, case.second), `is`(case.third))
    }
}
