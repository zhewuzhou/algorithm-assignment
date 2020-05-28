package zhewuzhou.me.linkedlist

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class RandomPointerList138KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                listOf(Pair(7, -1), Pair(13, 0), Pair(11, 4), Pair(10, 2), Pair(1, 0)),
                listOf(Pair(1, 1), Pair(2, 1)),
                listOf(Pair(1, 0)),
                listOf(Pair(3, -1), Pair(3, 0), Pair(3, -1)),
                listOf()
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should deep clone linked list with random pointer`(case: List<Pair<Int, Int>>) {
        var head = copyRandomList(convertToRandomLinkedList(case))
        for (p in case) {
            assertThat(head?.`val`, `is`(p.first))
            if (p.second != -1)
                assertThat(head?.random?.`val`, `is`(case[p.second].first))
            head = head?.next
        }
    }

    private fun convertToRandomLinkedList(l: List<Pair<Int, Int>>): Node? {
        val nodes = l.map { Node(it.first) }
        nodes.forEachIndexed { i, it ->
            if (i < nodes.lastIndex) {
                it.next = nodes[i + 1]
            }
        }
        nodes.forEachIndexed { i, it ->
            if (l[i].second != -1) {
                it.random = nodes[l[i].second]
            }
        }
        return if (nodes.isEmpty()) null else nodes.first()
    }
}
