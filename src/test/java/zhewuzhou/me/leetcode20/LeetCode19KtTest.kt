package zhewuzhou.me.leetcode20

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class LeetCode19KtTest {

    @Test
    fun `Should remove the n element from tail`() {
        val head = createTestList()
        var newHead = removeNthFromEnd(head, 2)
        var li = 1
        while (li < 5) {
            when (li == 4) {
                true -> assertThat(newHead?.`val`, `is`(li + 1))
                false -> assertThat(newHead?.`val`, `is`(li))
            }
            li++
            newHead = newHead?.next
        }
    }

    @Test
    fun `Should remove the n element from tail edge case remove head`() {
        val head = createTestList()
        val newHead = removeNthFromEnd(head, 5)
        assertThat(newHead?.`val`, `is`(2))
    }

    @Test
    fun `Should remove the n element from tail edge case null`() {
        val newHead = removeNthFromEnd(null, 0)
        assertThat(newHead?.`val` == null, `is`(true))
    }

    @Test
    fun `Should remove the n element from tail edge case single element`() {
        val head = ListNode(1)
        val newHead = removeNthFromEnd(head, 1)
        assertThat(newHead?.`val` == null, `is`(true))
    }

    private fun createTestList(): ListNode {
        var li5 = ListNode(5)
        var li4 = ListNode(4)
        var li3 = ListNode(3)
        var li2 = ListNode(2)
        var li1 = ListNode(1)
        li1.next = li2
        li2.next = li3
        li3.next = li4
        li4.next = li5
        return li1
    }
}
