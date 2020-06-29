package zhewuzhou.me.linkedlist

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.me.leetcode100.ListNode
import java.util.*

internal class OddEvenLinkedListKtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(listOf(1, 2, 3, 4, 5), listOf(1, 3, 5, 2, 4)),
                Pair(listOf(1), listOf(1)),
                Pair(listOf(1, 2), listOf(1, 2)),
                Pair(listOf(), listOf()),
                Pair(listOf(2, 1, 3, 5, 6, 4, 7), listOf(2, 3, 6, 7, 1, 5, 4))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should group the odd and even linked list node`(case: Pair<List<Int>, List<Int>>) {
        var expected = convertToLinkedList(case.second)
        var result = oddEvenList(convertToLinkedList(case.first))
        while (expected != null) {
            assertThat(expected.`val`, `is`(result?.`val`))
            expected = expected.next
            result = result?.next
        }
    }

    private fun convertToLinkedList(l: List<Int>): ListNode? {
        if (l.isEmpty()) return null
        val nodes = l.map { ListNode(it) }
        nodes.forEachIndexed { i, it ->
            if (i < nodes.lastIndex) {
                it.next = nodes[i + 1]
            }
        }
        return nodes.first()
    }
}
