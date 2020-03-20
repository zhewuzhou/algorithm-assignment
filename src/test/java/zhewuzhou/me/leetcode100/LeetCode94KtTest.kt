package zhewuzhou.me.leetcode100

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*
import java.util.stream.Stream

internal class LeetCode94KtTest {
    private companion object {
        fun validTree(): TreeNode {
            val root = TreeNode(2)
            root.right = TreeNode(3)
            root.left = TreeNode(1)
            return root
        }

        fun invalidTree(): TreeNode {
            val root = TreeNode(5)
            root.left = TreeNode(1)
            val right = TreeNode(4)
            right.left = TreeNode(3)
            right.right = TreeNode(6)
            root.right = right
            return root
        }

        @JvmStatic
        fun cases(): Stream<Pair<TreeNode, Boolean>>? {
            return Arrays.stream(
                arrayOf(
                    Pair(validTree(), true),
                    Pair(invalidTree(), false)
                )
            )
        }
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should validte the tree`(case: Pair<TreeNode, Boolean>) {
        assertThat(isValidBST(case.first), `is`(case.second))
    }

    @Test
    fun `Should recover tree`() {
        val root = TreeNode(2)
        root.left = TreeNode(4)
        val r = TreeNode(1)
        r.left = TreeNode(3)
        root.right = r
        recoverTree(root)
    }
}
