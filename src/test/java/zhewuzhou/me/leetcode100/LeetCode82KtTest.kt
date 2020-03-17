package zhewuzhou.me.leetcode100

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode82KtTest {

    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(listOf(1, 4, 3, 2, 5, 2), 3, listOf(1, 2, 2, 4, 3, 5))
//                Triple(listOf(1, 4, 3, 2, 5, 2), 6, listOf(1, 4, 3, 2, 5, 2)),
//                Triple(listOf(1, 4, 3, 2, 5, 2), 0, listOf(1, 4, 3, 2, 5, 2))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should partition the linked list with given number`(case: Triple<List<Int>, Int, List<Int>>) {
        val head = listToListNode(case.first)
        var expected = listToListNode(case.third)
        var result = partition(head, case.second)
        while (expected != null) {
            assertThat((expected.`val` == result?.`val`), `is`(true))
            expected = expected.next
            result = result?.next
        }
    }

    private fun listToListNode(list: List<Int>): ListNode? {
        val nodes = list.map { ListNode(it) }
        nodes.forEachIndexed { index, node ->
            if (index != nodes.lastIndex) node.next = nodes[index + 1]
        }
        return nodes[0]
    }
}
