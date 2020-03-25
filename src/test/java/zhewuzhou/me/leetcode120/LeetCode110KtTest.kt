package zhewuzhou.me.leetcode120

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.me.leetcode100.TreeNode
import java.util.*

internal class LeetCode110KtTest {
    private companion object {
        fun createTree(): TreeNode? {
            val root = TreeNode(3)
            root.left = TreeNode(9)
            val r = TreeNode(20)
            r.left = TreeNode(15)
            r.right = TreeNode(7)
            root.right = r
            return root
        }

        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(createTree(), true)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should create tree based on inorder and preorder arrays`(case: Pair<TreeNode, Boolean>) {
        assertThat(isBalanced(case.first), `is`(case.second))
    }
}
