package zhewuzhou.me.dc

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

/*
1. Is valid could be cached
2. Should be able to stop when:
   a. knowing that can not be valid again such as path is ())
   b. knowing even if the left char all good still can not compare to current last length
 */
internal class RemoveInvalidParenthes301KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair("()())()", listOf("()()()", "(())()")),
                Pair("())", listOf("()")),
                Pair("(a)())()", listOf("(a)()()", "(a())()")),
                Pair(")(", listOf(""))
            )
        )

        @JvmStatic
        fun validates() = Arrays.stream(
            arrayOf(
                Pair("()())()".toCharArray().toList(), false),
                Pair("()()()".toCharArray().toList(), true),
                Pair("a(b)(a)()".toCharArray().toList(), true),
                Pair("(((())".toCharArray().toList(), false),
                Pair(listOf(), true)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find all possible valid parentheses`(case: Pair<String, List<String>>) {
        val result = removeInvalidParentheses(case.first)
        assertThat(result.sorted(), `is`(case.second.sorted()))
    }

    @ParameterizedTest
    @MethodSource("validates")
    fun `Should validate the given chars`(case: Pair<List<Char>, Boolean>) {
        assertThat(isValidParentheses(case.first), `is`(case.second))
    }
}
