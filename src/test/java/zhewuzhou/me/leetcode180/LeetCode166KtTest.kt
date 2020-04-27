package zhewuzhou.me.leetcode180

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode166KtTest {

    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(1, 2, "0.5"),
                Triple(2, 1, "2"),
                Triple(2, 3, "0.(6)"),
                Triple(2, 30000, "0.0000(6)"),
                Triple(2, -30000, "-0.0000(6)"),
                Triple(-2, 30000, "-0.0000(6)"),
                Triple(-2, -30000, "0.0000(6)"),
                Triple(2, 0, ""),
                Triple(0, 2, "0")
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should handle the fraction of div`(case: Triple<Int, Int, String>) {
        assertThat(fractionToDecimal(case.first, case.second), `is`(case.third))
    }
}
