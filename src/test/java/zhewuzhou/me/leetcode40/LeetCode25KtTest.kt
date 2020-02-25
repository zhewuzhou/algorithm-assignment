package zhewuzhou.me.leetcode40

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class LeetCode25KtTest {

    @Test
    fun `Reverse list 1-2-3-4-5 by 2`() {
        val head = convertToLinkedList(listOf(1, 2, 3, 4, 5))
        var r2 = reverseKGroup(head, 2)
        listOf(2, 1, 4, 3, 5).forEach {
            assertThat(r2?.`val`, `is`(it))
            r2 = r2?.next
        }
        var r3 = reverseKGroup(head, 3)
        listOf(3, 2, 1, 4, 5).forEach {
            assertThat(r3?.`val`, `is`(it))
            r3 = r3?.next
        }
    }

    private fun convertToLinkedList(l: List<Int>): ListNode? {
        val nodes = l.map { ListNode(it) }
        for (i in 0 until nodes.size - 1) {
            nodes[i].next = nodes[i + 1]
        }
        return nodes[0]
    }
}
