package zhewuzhou.me.leetcode160

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.me.leetcode100.ListNode
import java.util.*

internal class SortList148KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(listOf(4, 2, 1, 3), listOf(1, 2, 3, 4)),
                Pair(listOf(1), listOf(1)),
                Pair(listOf(3, 2, 1), listOf(1, 2, 3)),
                Pair(listOf(-1, 5, 3, 4, 0), listOf(-1, 0, 3, 4, 5)),
                Pair((1000 downTo -1000).toList(), (-1000..1000).toList())
            )
        )

        @JvmStatic
        fun mergeCase() = Arrays.stream(
            arrayOf(
                Triple(listOf(), listOf(), listOf()),
                Triple(listOf(1), listOf(), listOf(1)),
                Triple(listOf(), listOf(1), listOf(1)),
                Triple(listOf(100), listOf(50), listOf(50, 100)),
                Triple(listOf(1, 3, 5, 7), listOf(2, 4, 10, 18), listOf(1, 2, 3, 4, 5, 7, 10, 18))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should sort the linked list`(case: Pair<List<Int>, List<Int>>) {
        var head = sortList(convertToList(case.first))
        for (v in case.second) {
            assertThat(head?.`val`, `is`(v))
            head = head?.next
        }
    }

    @ParameterizedTest
    @MethodSource("mergeCase")
    fun `Should merge 2 sorted list into 1`(case: Triple<List<Int>, List<Int>, List<Int>>) {
        val l1 = convertToList(case.first)
        val l2 = convertToList(case.second)
        var head = merge(l1, l2)
        for (v in case.third) {
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
