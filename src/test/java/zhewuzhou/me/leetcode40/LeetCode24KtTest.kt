package zhewuzhou.me.leetcode40

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class LeetCode24KtTest {

    @Test
    fun `Should swap every pair of 1-2-3-4-5-6-7`() {
        val head = convertToLinkedList(listOf(1, 2, 3, 4, 5, 6, 7))
        var result = swapPairs(head)
        listOf(2, 1, 4, 3, 6, 5, 7).forEach {
            assertThat(result?.`val`, `is`(it))
            result = result?.next
        }
    }

    @Test
    fun `Should swap every pair of 1-2-3-4-5-6-7-8`() {
        val head = convertToLinkedList(listOf(1, 2, 3, 4, 5, 6, 7, 8))
        var result = swapPairs(head)
        listOf(2, 1, 4, 3, 6, 5, 8, 7).forEach {
            assertThat(result?.`val`, `is`(it))
            result = result?.next
        }
    }

    @Test
    fun `Should swap single node as edge case`() {
        val head = convertToLinkedList(listOf(1))
        var result = swapPairs(head)
        listOf(1).forEach {
            assertThat(result?.`val`, `is`(it))
            result = result?.next
        }
    }

    @Test
    fun `Should works for null`() {
        val result = swapPairs(null)
        assertThat(result == null, `is`(true))
    }

    private fun convertToLinkedList(l: List<Int>): ListNode? {
        val nodes = l.map { ListNode(it) }
        for (i in 0 until nodes.size - 1) {
            nodes[i].next = nodes[i + 1]
        }
        return nodes[0]
    }
}
