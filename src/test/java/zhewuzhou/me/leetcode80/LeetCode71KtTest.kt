package zhewuzhou.me.leetcode80

import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode71KtTest {

    data class Test71Case(
        val path: String,
        val expected: String
    )

    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Test71Case("/../", "/"),
                Test71Case("/home//foo/", "/home/foo"),
                Test71Case("/a/./b/../../c/", "/c"),
                Test71Case("/a/../../b/../c//.//", "/c"),
                Test71Case("/a//b////c/d//././/..", "/a/b/c")
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find the min path from A string to B string`(case: Test71Case) {
        MatcherAssert.assertThat(simplifyPath(case.path), CoreMatchers.`is`(case.expected))
    }
}
