package zhewuzhou.me.linkedlist

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.me.leetcode100.ListNode
import java.util.*

internal class AddTwoNumbers445KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(listOf(7, 2, 4, 3), listOf(5, 6, 4), listOf(7, 8, 0, 7)),
                Triple(listOf(7, 2, 4, 3), listOf(), listOf(7, 2, 4, 3)),
                Triple(listOf(7, 2, 4, 3), listOf(0), listOf(7, 2, 4, 3)),
                Triple(listOf(9), listOf(9), listOf(1, 8)),
                Triple(listOf(), listOf(5, 6, 4), listOf(5, 6, 4)),
                Triple(listOf(0), listOf(5, 6, 4), listOf(5, 6, 4)),
                Triple(listOf(), listOf(), listOf()),
                Triple(listOf(0), listOf(0), listOf(0)),
                Triple(listOf(9, 9, 9, 9, 9, 9), listOf(9, 9, 9), listOf(1, 0, 0, 0, 9, 9, 8))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should add 2 numbers in linked list`(case: Triple<List<Int>, List<Int>, List<Int>>) {
        var result = addTwoNumbers(convertToLinkedList(case.first), convertToLinkedList(case.second))
        var expected = convertToLinkedList(case.third)
        while (expected != null) {
            assertThat(result?.`val`, `is`(expected.`val`))
            result = result?.next
            expected = expected.next
        }
    }

    private fun convertToLinkedList(l: List<Int>): ListNode? {
        if (l.isEmpty()) return null
        val nodes = l.map { ListNode(it) }
        for (i in 0 until nodes.size - 1) {
            nodes[i].next = nodes[i + 1]
        }
        return nodes[0]
    }
}
