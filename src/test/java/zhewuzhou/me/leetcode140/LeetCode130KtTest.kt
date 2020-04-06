package zhewuzhou.me.leetcode140

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode130KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                longFailedCase()
            )
        )

        private fun failedCase(): Array<CharArray> {
            return arrayOf(
                charArrayOf('X', 'O', 'X', 'O', 'X', 'O'),
                charArrayOf('O', 'X', 'O', 'X', 'O', 'X'),
                charArrayOf('X', 'O', 'X', 'O', 'X', 'O'),
                charArrayOf('O', 'X', 'O', 'X', 'O', 'X')
            )
        }

        private fun longFailedCase(): Array<CharArray> {
            return arrayOf(
                charArrayOf('X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'),
                charArrayOf('X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'O', 'O', 'O', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'),
                charArrayOf('X', 'X', 'X', 'X', 'X', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'),
                charArrayOf('X', 'X', 'X', 'X', 'X', 'O', 'X', 'O', 'X', 'O', 'X', 'O', 'O', 'O', 'X', 'X', 'X', 'X', 'X', 'X'),
                charArrayOf('X', 'X', 'X', 'X', 'X', 'O', 'X', 'O', 'O', 'O', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'),
                charArrayOf('X', 'X', 'X', 'X', 'X', 'O', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X')
            )
        }

        private fun complexCase(): Array<CharArray> {
            val res = Array(4) {
                CharArray(4) {
                    'X'
                }
            }
            res[1][1] = 'O'
            res[1][2] = 'O'
            res[2][2] = 'O'
            res[3][1] = 'O'
            return res
        }
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should solve it with UF`(case: Array<CharArray>) {
        solve(case)
    }
}
