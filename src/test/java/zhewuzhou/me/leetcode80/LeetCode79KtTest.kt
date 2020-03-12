package zhewuzhou.me.leetcode80

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

class LeetCode79KtTest {
    data class Test79Case(
        val board: List<String>,
        val word: String,
        val expected: Boolean
    )

    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Test79Case(listOf("ABCE", "SFCS", "ADEE"), "ABCCED", true),
                Test79Case(listOf("ABCE", "SFCS", "ADEE"), "SEE", true),
                Test79Case(listOf("ABCE", "SFCS", "ADEE"), "ABCB", false)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find word in matrix`(case: Test79Case) {
        val board = case.board.map { it.toCharArray() }.toTypedArray()
        assertThat(exist(board, case.word), `is`(case.expected))
    }
}
