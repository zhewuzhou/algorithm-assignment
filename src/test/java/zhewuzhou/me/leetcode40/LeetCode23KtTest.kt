package zhewuzhou.me.leetcode40

import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Test

class LeetCode23KtTest {

    @Test
    fun `Should merge k list for normal case`() {
        val toMerge = listOf(
            convertToLinkedList(listOf(1, 4, 5)),
            convertToLinkedList(listOf(1, 3, 4)),
            convertToLinkedList(listOf(2, 6))
        ).toTypedArray()
        var result = mergeKLists(toMerge);

        listOf(1, 1, 2, 3, 4, 4, 5, 6).forEach {
            MatcherAssert.assertThat(result?.`val`, CoreMatchers.`is`(it))
            result = result?.next
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
