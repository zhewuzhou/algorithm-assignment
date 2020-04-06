package zhewuzhou.me.leetcode140

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.me.leetcode100.TreeNode
import java.util.*

internal class LeetCode129KtTest {
    private companion object {
        fun simpleTree(): TreeNode {
            val root = TreeNode(1)
            root.left = TreeNode(2)
            root.right = TreeNode(3)
            return root
        }

        fun complexTree(): TreeNode {
            val root = TreeNode(4)
            root.right = TreeNode(0)
            val l = TreeNode(9)
            l.right = TreeNode(1)
            l.left = TreeNode(5)
            root.left = l
            return root
        }

        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(complexTree(), 1026),
                Pair(simpleTree(), 25)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should return the sum from root`(case: Pair<TreeNode, Int>) {
        assertThat(sumNumbers(case.first), `is`(case.second))
    }
}
