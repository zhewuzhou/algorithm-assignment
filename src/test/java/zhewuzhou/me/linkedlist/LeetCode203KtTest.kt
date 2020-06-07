package zhewuzhou.me.linkedlist

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.me.leetcode100.ListNode
import java.util.*

internal class LeetCode203KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(listOf(1, 2, 6, 3, 4, 5, 6), 6, listOf(1, 2, 3, 4, 5)),
                Triple(listOf(6, 6, 6, 6, 6, 6, 6), 6, listOf()),
                Triple(listOf(), 100, listOf())
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should remove all elements`(case: Triple<List<Int>, Int, List<Int>>) {
        var head = removeElements(convertToLinkedList(case.first), case.second)
        if (case.third.isEmpty()) {
            assertThat(head == null, `is`(true))
        }
        for (v in case.third) {
            assertThat(head!!.`val`, `is`(v))
            head = head.next
        }
    }

    private fun convertToLinkedList(l: List<Int>): ListNode? {
        if (l.isEmpty()) return null
        val nodes = l.map { ListNode(it) }
        for (i in 0 until nodes.lastIndex) {
            nodes[i].next = nodes[i + 1]
        }
        return nodes.first()
    }
}
