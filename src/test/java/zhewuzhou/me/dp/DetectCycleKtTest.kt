package zhewuzhou.me.dp

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import zhewuzhou.me.leetcode100.ListNode
import zhewuzhou.me.linkedlist.detectCycle
import zhewuzhou.me.linkedlist.hasCycle

internal class DetectCycleKtTest {

    @Test
    fun `Has cycle on pos 1`() {
        val head = convertToList(listOf(3, 2, 0, -4), 1)
        assertThat(hasCycle(head), `is`(true))
        assertThat(detectCycle(head), `is`(head.next))
    }

    @Test
    fun `Should have no cycle when list is null or just 1 node`() {
        assertThat(hasCycle(null), `is`(false))
        assertThat(detectCycle(null) == null, `is`(true))
        assertThat(hasCycle(ListNode(1)), `is`(false))
        assertThat(detectCycle(ListNode(1)) == null, `is`(true))
    }

    @Test
    fun `Simple cases`() {
        val head = convertToList(listOf(1, 2), 0)
        assertThat(hasCycle(head), `is`(true))
        assertThat(detectCycle(head), `is`(head))
    }

    private fun convertToList(listOf: List<Int>, pos: Int): ListNode {
        val nodes = listOf.map {
            ListNode(it)
        }
        nodes.forEachIndexed { i, node ->
            if (i < nodes.lastIndex) {
                node.next = nodes[i + pos]
            }
        }
        nodes.last().next = nodes[pos]
        return nodes.first()
    }
}
