package zhewuzhou.me.leetcode

import org.hamcrest.core.Is.`is`
import org.junit.Test

import org.junit.Assert.*

class LeetCode4KtTest {

    @Test
    fun `should calculate medium for 2 lists`() {
        val result = findMedianSortedArrays(listOf(1, 2).toIntArray(), listOf(3, 4).toIntArray())
        assertThat(result, `is`(2.5))
    }
}