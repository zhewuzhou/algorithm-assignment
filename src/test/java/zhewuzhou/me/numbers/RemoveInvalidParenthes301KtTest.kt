package zhewuzhou.me.numbers

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class RemoveInvalidParenthes301KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
//                Pair("())", listOf("()")),
//                Pair("(a)())()", listOf("(a)()()", "(a())()")),
//                Pair("", listOf("")),
//                Pair(")(", listOf("")),
//                Pair("n", listOf("n")),
//                Pair("))))))))))))))))", listOf("")),
                Pair("()())()", listOf("()()()", "(())()"))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find all possible valid parentheses`(case: Pair<String, List<String>>) {
        val result = removeInvalidParentheses(case.first)
        assertThat(result.sorted(), `is`(case.second.sorted()))
    }
}
