package zhewuzhou.me.leetcode120

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.me.leetcode100.TreeNode
import zhewuzhou.me.leetcode100.isSameTree
import java.util.*

internal class LeetCode105KtTest {
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
                Triple(listOf(3, 9, 20, 15, 7), listOf(9, 3, 15, 20, 7), createTree())
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should create tree based on inorder and preorder arrays`(case: Triple<List<Int>, List<Int>, TreeNode>) {
        val preOrder = case.first.toIntArray()
        val inOrder = case.second.toIntArray()
        val result = buildTree(preOrder, inOrder)
        assertThat(isSameTree(result, case.third), `is`(true))
    }
}
