package zhewuzhou.me.leetcode60

import org.junit.Test

class LeetCode54KtTest {

    @Test
    fun `Should get spiral order for 3*3 matrix`() {
        val arr = arrayOf(
            arrayOf(1, 2, 3).toIntArray(),
            arrayOf(4, 5, 6).toIntArray(),
            arrayOf(7, 8, 9).toIntArray()
        )
        spiralOrder(arr)
    }
}
