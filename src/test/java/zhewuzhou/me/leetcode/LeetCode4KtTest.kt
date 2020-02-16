package zhewuzhou.me.leetcode

import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThat
import org.junit.Test

class LeetCode4KtTest {

    @Test
    fun `should calculate medium for 2 lists`() {
        //val result = findMedianSortedArrays(listOf(1, 2).toIntArray(), listOf(3, 4).toIntArray())
        assertThat(findKthElement(listOf(1, 2), listOf(3, 4), 3), `is`(3))
        //assertThat(result, `is`(2.5))
    }

    @Test
    fun `should fine the kth element from 2 list`() {
        val the5Th = findKthElement(listOf(1, 2, 10, 12), listOf(3, 4, 8, 9), 5)
        val the6Th = findKthElement(listOf(1, 2, 10, 12), listOf(3, 4, 8, 9), 6)
        assertThat(the5Th, `is`(8))
        assertThat(the6Th, `is`(9))
    }

    @Test
    fun `should find the kth element for normal case`() {
        val lhs = listOf(1, 3, 8, 9, 15)
        val rhs = listOf(7, 11, 18, 19, 21, 25)
        val result = (1..11).map { findKthElement(lhs, rhs, it) }
        assertThat(result, `is`(listOf(1, 3, 7, 8, 9, 11, 15, 18, 19, 21, 25)))
    }
}
