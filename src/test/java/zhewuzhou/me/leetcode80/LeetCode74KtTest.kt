package zhewuzhou.me.leetcode80

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test


class LeetCode74KtTest {

    @Test
    fun `Should find the target 3 in ((1,3))`() {
        val matrix = Array<IntArray>(1) {
            arrayOf(1, 3).toIntArray()
        }
        assertThat(searchMatrix(matrix, 3), `is`(true))
    }

    @Test
    fun `Should find the target 3 in ((1)(3))`() {
        val matrix = arrayOf(
            arrayOf(1).toIntArray(),
            arrayOf(3).toIntArray()
        )
        assertThat(searchMatrix(matrix, 3), `is`(true))
    }
}
