package zhewuzhou.me.leetcode40

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class LeetCode21KtTest {

    @Test
    fun `Should merge two list 1-2-4 and 1-3-4 as 1-1-2-3-4-4`() {
        val lhs = convertToLinkedList(listOf(1, 2, 4))
        val rhs = convertToLinkedList(listOf(1, 3, 4))
        var result = mergeTwoLists(lhs, rhs)
        listOf(1, 1, 2, 3, 4, 4).forEach {
            assertThat(result?.`val`, `is`(it))
            result = result?.next
        }
    }

    @Test
    fun `Should works for edge case either l1 or l2 is null`() {
        val lhs = convertToLinkedList(listOf(1, 2, 4))
        val rhs: ListNode? = null
        var result = mergeTwoLists(lhs, rhs)
        listOf(1, 2, 4).forEach {
            assertThat(result?.`val`, `is`(it))
            result = result?.next
        }
    }

    private fun convertToLinkedList(l: List<Int>): ListNode {
        val nodes = l.map { ListNode(it) }
        for (i in 0 until nodes.size - 1) {
            nodes[i].next = nodes[i + 1]
        }
        return nodes[0]
    }
}
