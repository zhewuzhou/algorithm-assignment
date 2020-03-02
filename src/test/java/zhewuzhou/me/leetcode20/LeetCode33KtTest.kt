package zhewuzhou.me.leetcode20

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class LeetCode33KtTest {

    @Test
    fun `Should find target 5 in 5,1,3`() {
        val list = listOf(5, 1, 3)
        val nums = list.toIntArray()
        list
            .associateBy { nums.indexOf(it) }
            .toMap()
            .forEach { (k, v) -> assertThat(search(nums, v), `is`(k)) }
        assertThat(search(nums, 2), `is`(-1))
    }

    @Test
    fun `Should find 5 in 1,2,3,4,5`() {
        val list = listOf(1, 2, 3, 4, 5)
        val nums = list.toIntArray()
        assertThat(search(nums, 5), `is`(4))
    }

    @Test
    fun `Should find target in 4,5,6,7,0,1,2`() {
        val list = listOf(4, 5, 6, 7, 0, 1, 2)
        val nums = list.toIntArray()
        list
            .associateBy { nums.indexOf(it) }
            .toMap()
            .forEach { (k, v) -> assertThat(search(nums, v), `is`(k)) }
        assertThat(search(nums, 3), `is`(-1))
    }

    @Test
    fun `Should find correct target in 0,1,2,3,4,5,6,7,8,9`() {
        val list = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        val nums = list.toIntArray()
        list.forEach {
            assertThat(binarySearch(nums, it), `is`(it))
        }
    }

    @Test
    fun `Should find pivot for the rotated array 4, 5, 6, 7, 0, 1, 2`() {
        val nums = listOf(4, 5, 6, 7, 0, 1, 2).toIntArray()
        assertThat(findPivot(nums), `is`(4))
    }

    @Test
    fun `Should find pivot for the rotated array 1,2,0`() {
        val nums = listOf(1, 2, 0).toIntArray()
        assertThat(findPivot(nums), `is`(2))
    }

    @Test
    fun `Should find pivot for the rotated array 5,1,3`() {
        val nums = listOf(5, 1, 3).toIntArray()
        assertThat(findPivot(nums), `is`(1))
    }

    @Test
    fun `Should find 0 for the rotated array 1,0`() {
        val nums = listOf(0, 1).toIntArray()
        assertThat(binarySearch(nums, 0), `is`(0))
        assertThat(binarySearch(nums, 1), `is`(1))
        assertThat(binarySearch(nums, 2), `is`(-1))
    }

    @Test
    fun `Should find 0 for the rotated array 0`() {
        val nums = listOf(0).toIntArray()
        assertThat(binarySearch(nums, 0), `is`(0))
        assertThat(binarySearch(nums, 1), `is`(-1))
    }

    @Test
    fun `Should find pivot for the rotated array 0,1,2,3,4,5,6,7`() {
        val nums = listOf(0, 1, 2, 3, 4, 5, 6, 7).toIntArray()
        assertThat(findPivot(nums), `is`(0))
    }

    @Test
    fun `Should find pivot for the rotated array 1,2,3,4,5,6,7,8,9,0`() {
        val nums = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0).toIntArray()
        assertThat(findPivot(nums), `is`(9))
    }

    @Test
    fun `Should find pivot for the rotated array 2,3,4,5,6,7,8,9,0,1`() {
        val nums = listOf(2, 3, 4, 5, 6, 7, 8, 9, 0, 1).toIntArray()
        assertThat(findPivot(nums), `is`(8))
    }
}
