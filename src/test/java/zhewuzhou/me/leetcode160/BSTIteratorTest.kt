package zhewuzhou.me.leetcode160

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.me.leetcode100.TreeNode
import java.util.*

internal class BSTIteratorTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(
                    listOf(70, 30, 115, 20, 40, 90, 200, 10, 25, 35, 45, 80, 95, 150, 210),
                    listOf(10, 20, 25, 30, 35, 40, 45, 70, 80, 90, 95, 115, 150, 200, 210)
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should iterator tree in ascending order `(case: Pair<List<Int>, List<Int>>) {
        val treeNode = convertToTree(case.first)
        val iterator = BSTIterator(treeNode)
        for (v in case.second) {
            assertThat(iterator.hasNext(), `is`(true))
            assertThat(iterator.next(), `is`(v))
        }
        assertThat(iterator.hasNext(), `is`(false))
    }

    @Test
    fun `Should iterator tree only have root`() {
        val iterator = BSTIterator(TreeNode(0))
        assertThat(iterator.hasNext(), `is`(true))
        assertThat(iterator.next(), `is`(0))
        assertThat(iterator.hasNext(), `is`(false))
    }

    fun convertToTree(l: List<Int>): TreeNode {
        val nodes = l.map { TreeNode(it) }
        var i = 0
        while (2 * (i + 1) <= nodes.lastIndex) {
            nodes[i].left = nodes[2 * i + 1]
            nodes[i].right = nodes[2 * (i + 1)]
            i += 1
        }
        return nodes[0]
    }
}
