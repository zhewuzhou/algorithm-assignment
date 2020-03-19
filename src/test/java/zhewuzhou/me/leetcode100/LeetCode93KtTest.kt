package zhewuzhou.me.leetcode100

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsInAnyOrder
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode93KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair("25525511135", arrayOf("255.255.111.35", "255.255.11.135")),
                Pair("0000", arrayOf("0.0.0.0"))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should calculate all possibilities`(case: Pair<String, Array<String>>) {
        assertThat(restoreIpAddresses(case.first), containsInAnyOrder(*case.second))
    }
}
