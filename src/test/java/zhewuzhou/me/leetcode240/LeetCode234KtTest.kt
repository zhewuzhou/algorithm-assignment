package zhewuzhou.me.leetcode240

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.me.leetcode100.ListNode
import java.util.*

internal class LeetCode234KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(listOf(1), true),
                Pair(listOf(1, 2), false),
                Pair(listOf(1, 2, 1), true),
                Pair(listOf(1, 2, 2, 1), true),
                Pair(listOf(1, 2, 5, 2, 1), true),
                Pair(listOf(1, 2, 5, 3, 1), false),
                Pair(listOf(1, 2, 5, 5, 3, 1), false),
                Pair(listOf(1, 2, 5, 5, 2, 1), true)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should determine if list is palindrome`(case: Pair<List<Int>, Boolean>) {
        var expected = toLinkedList(case.first)
        var head = toLinkedList(case.first)
        assertThat(isPalindrome(head), `is`(case.second))
        while (expected != null) {
            assertThat(expected.`val`, `is`(head?.`val`))
            expected = expected.next
            head = head?.next
        }
    }

    private fun toLinkedList(l: List<Int>): ListNode? {
        if (l.isEmpty()) return null
        val nodes = l.map { ListNode(it) }
        nodes.forEachIndexed { index, node ->
            if (index < nodes.lastIndex) {
                node.next = nodes[index + 1]
            }
        }
        return nodes.first()
    }
}
