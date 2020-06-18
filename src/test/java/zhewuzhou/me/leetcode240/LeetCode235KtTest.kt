package zhewuzhou.me.leetcode240

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.me.leetcode100.TreeNode
import java.util.*

internal class LeetCode235KtTest {
    private companion object {
        @JvmStatic
        fun casesE() = Arrays.stream(
            arrayOf(
                Triple(2, 8, 6),
                Triple(2, 4, 2),
                Triple(2, 4, 2)
            )
        )

        @JvmStatic
        fun casesM() = Arrays.stream(
            arrayOf(
                Triple(5, 1, 3),
                Triple(5, 4, 5)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("casesM")
    fun `Should `(case: Triple<Int, Int, Int>) {
        val bst = buildBSTM()
        val nodes = bst.second
        val result = lowestCommonAncestorEB(nodes[bst.first], nodes[case.first], nodes[case.third])
        assertThat(result?.`val`, `is`(case.third))
    }

    @ParameterizedTest
    @MethodSource("casesE")
    fun `Should find LCA`(case: Triple<Int, Int, Int>) {
        val bst = buildBSTE()
        val nodes = bst.second
        val result = lowestCommonAncestorEB(nodes[bst.first], nodes[case.first], nodes[case.second])
        assertThat(result?.`val`, `is`(case.third))
    }

    private fun buildBSTE(): Pair<Int, List<TreeNode>> {
        val nodes = (0..9).toList().map { TreeNode(it) }
        nodes.forEachIndexed { index, node ->
            when {
                node.`val` == 6 -> {
                    node.left = nodes[2]
                    node.right = nodes[8]
                }
                node.`val` == 2 -> {
                    node.left = nodes[0]
                    node.right = nodes[4]
                }
                node.`val` == 8 -> {
                    node.left = nodes[7]
                    node.right = nodes[9]
                }
                node.`val` == 4 -> {
                    node.left = nodes[3]
                    node.right = nodes[5]
                }
            }
        }
        return Pair(6, nodes)
    }

    private fun buildBSTM(): Pair<Int, List<TreeNode>> {
        val nodes = (0..9).toList().map { TreeNode(it) }
        nodes.forEachIndexed { index, node ->
            when {
                node.`val` == 3 -> {
                    node.left = nodes[1]
                    node.right = nodes[5]
                }
                node.`val` == 5 -> {
                    node.left = nodes[6]
                    node.right = nodes[2]
                }
                node.`val` == 1 -> {
                    node.left = nodes[0]
                    node.right = nodes[8]
                }
                node.`val` == 2 -> {
                    node.left = nodes[7]
                    node.right = nodes[4]
                }
            }
        }
        return Pair(3, nodes)
    }
}
