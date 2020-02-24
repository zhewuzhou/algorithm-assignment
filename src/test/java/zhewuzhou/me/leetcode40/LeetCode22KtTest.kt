package zhewuzhou.me.leetcode40

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsInAnyOrder
import org.junit.Test

class LeetCode22KtTest {

    @Test
    fun `Should generate all possible parentheses given 3`() {
        assertThat(generateParenthesis(3),
            containsInAnyOrder(
                "((()))",
                "(()())",
                "(())()",
                "()(())",
                "()()()"))
    }

    @Test
    fun `Should add one more () in possible position for ((()))`() {
        assertThat(addParenthesis("((()))"),
            containsInAnyOrder(
                "()((()))",
                "(()(()))",
                "((()()))",
                "(((())))",
                "((())())",
                "((()))()"))
    }

    @Test
    fun `Should add one more () in possible position for ()()`() {
        assertThat(addParenthesis("()()"),
            containsInAnyOrder(
                "()()()",
                "(())()",
                "()(())"))
    }
}
