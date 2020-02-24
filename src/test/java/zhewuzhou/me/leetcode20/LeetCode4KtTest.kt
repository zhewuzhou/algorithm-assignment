package zhewuzhou.me.leetcode20

import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThat
import org.junit.Test

class LeetCode4KtTest {

    @Test
    fun `should calculate medium for 2 lists`() {
        assertThat(kth(listOf(1, 2).toIntArray(), 0, listOf(3, 4).toIntArray(), 0, 3), `is`(3))
    }

    @Test
    fun `should fine the kth element from 2 list`() {
        val lhs = listOf(1, 2, 10, 12).toIntArray()
        val rhs = listOf(3, 4, 8, 9).toIntArray()
        val the5Th = kth(lhs, 0, rhs, 0, 5)
        val the6Th = kth(lhs, 0, rhs, 0, 6)
        assertThat(the5Th, `is`(8))
        assertThat(the6Th, `is`(9))
    }

    @Test
    fun `should find the kth element for normal case`() {
        val lhs = listOf(1, 3, 8, 9, 15).toIntArray()
        val rhs = listOf(7, 11, 18, 19, 21, 25).toIntArray()
        val result = (1..11).map { kth(lhs, 0, rhs, 0, it) }
        assertThat(result, `is`(listOf(1, 3, 7, 8, 9, 11, 15, 18, 19, 21, 25)))
        assertThat(findMedianSortedArrays(lhs, rhs), `is`(11.toDouble()))
    }

    @Test
    fun `should find the kth element for edge case`() {
        val lhs = listOf(23, 26, 31, 35).toIntArray()
        val rhs = listOf(3, 5, 7, 9, 11, 16).toIntArray()
        val result = (1..10).map { kth(lhs, 0, rhs, 0, it) }
        assertThat(result, `is`(listOf(3, 5, 7, 9, 11, 16, 23, 26, 31, 35)))
        assertThat(findMedianSortedArrays(lhs, rhs), `is`(13.5))
    }
}
