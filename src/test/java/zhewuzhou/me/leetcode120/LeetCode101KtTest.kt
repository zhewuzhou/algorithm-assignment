package zhewuzhou.me.leetcode120

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.me.leetcode100.TreeNode
import java.util.*

internal class LeetCode101KtTest {
    private companion object {
        fun symmetricTree(): TreeNode {
            val root = TreeNode(1)
            val l = TreeNode(2)
            l.left = TreeNode(3)
            l.right = TreeNode(4)
            val r = TreeNode(2)
            r.right = TreeNode(3)
            root.left = l
            root.right = r
            return root
        }

        fun wrongTree(): TreeNode {
            val root = TreeNode(1)
            val l = TreeNode(2)
            l.right = TreeNode(3)
            val r = TreeNode(2)
            r.right = TreeNode(3)
            root.left = l
            root.right = r
            return root
        }

        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(symmetricTree(), false)
//                Pair(wrongTree(), false)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should determine if tree is symmetric`(case: Pair<TreeNode, Boolean>) {
        assertThat(isSymmetric(case.first), `is`(case.second))
    }
}
