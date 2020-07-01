package zhewuzhou.me.linkedlist

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.me.leetcode100.ListNode
import java.util.*

internal class SplitList725KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(listOf(1, 2, 3), 5, listOf(listOf(1),
                    listOf(2), listOf(3), listOf(), listOf())),
                Triple(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3,
                    listOf(
                        listOf(1, 2, 3, 4),
                        listOf(5, 6, 7),
                        listOf(8, 9, 10)
                    )),
                Triple(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11), 3,
                    listOf(
                        listOf(1, 2, 3, 4),
                        listOf(5, 6, 7, 8),
                        listOf(9, 10, 11)
                    )),
                Triple(listOf(), 5,
                    listOf(
                        listOf(),
                        listOf(),
                        listOf(),
                        listOf(),
                        listOf()
                    )),
                Triple(listOf(1), 5,
                    listOf(
                        listOf(1),
                        listOf(),
                        listOf(),
                        listOf(),
                        listOf()
                    ))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should split the list into parts`(case: Triple<List<Int>, Int, List<List<Int>>>) {
        val result = splitListToParts(convertToLinkedList(case.first), case.second)
        val expected = case.third.map { convertToLinkedList(it) }
        assertThat(result.size, `is`(expected.size))
        for (i in expected.indices) {
            var le = expected[i]
            var lr = result[i]
            while (le != null) {
                assertThat(le.`val`, `is`(lr?.`val`))
                le = le.next
                lr = lr?.next
            }
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
