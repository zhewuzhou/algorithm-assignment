package zhewuzhou.me.linkedlist

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.me.leetcode100.ListNode
import java.util.*

internal class ReorderList143KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(listOf(1), listOf(1)),
                Pair(listOf(1, 2), listOf(1, 2)),
                Pair(listOf(1, 2, 3), listOf(1, 3, 2)),
                Pair(listOf(1, 2, 3, 4), listOf(1, 4, 2, 3)),
                Pair(listOf(1, 2, 3, 4, 5), listOf(1, 5, 2, 4, 3))
            )
        )

        @JvmStatic
        fun removeDuplicatedCase() = Arrays.stream(
            arrayOf(
                Pair(listOf(), listOf()),
                Pair(listOf(1), listOf(1)),
                Pair(listOf(1, 1, 2), listOf(1, 2)),
                Pair(listOf(1, 1, 2, 3, 3), listOf(1, 2, 3)),
                Pair(listOf(1, 1, 1, 1, 2, 2, 3, 3, 3, 3, 3, 3), listOf(1, 2, 3))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should reorder list as given`(case: Pair<List<Int>, List<Int>>) {
        var head = convertToList(case.first)
        reorderList(head)
        for (v in case.second) {
            assertThat(head?.`val`, `is`(v))
            head = head?.next
        }
    }

    @ParameterizedTest
    @MethodSource("removeDuplicatedCase")
    fun `Should remove duplicated element from list`(case: Pair<List<Int>, List<Int>>) {
        var head = deleteDuplicates(convertToList(case.first))
        for (v in case.second) {
            assertThat(head?.`val`, `is`(v))
            head = head?.next
        }
    }

    private fun convertToList(l: List<Int>): ListNode? {
        val nodes = l.map { ListNode(it) }
        nodes.forEachIndexed { i, node ->
            if (i < nodes.lastIndex) {
                node.next = nodes[i + 1]
            }
        }
        return if (nodes.isEmpty()) null else nodes.first()
    }
}
