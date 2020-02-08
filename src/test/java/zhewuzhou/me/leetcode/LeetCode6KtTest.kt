package zhewuzhou.me.leetcode

import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThat
import org.junit.Test

class LeetCode6KtTest {

    @Test
    fun `Should convert the "PAYPALISHIRING" follow zigzag rules 3`() {
        val result = convert("PAYPALISHIRING", 3)
        assertThat(result, `is`("PAHNAPLSIIGYIR"))
    }

    @Test
    fun `Should convert the "PAYPALISHIRING" follow zigzag rules 4`() {
        val result = convert("PAYPALISHIRING", 4)
        assertThat(result, `is`("PINALSIGYAHRPI"))
    }

    @Test
    fun `Should convert the "ABCDEFGH" follow zigzag rules 2`() {
        val result = convert("ABCDEFGH", 2)
        assertThat(result, `is`("ACEGBDFH"))
    }

    @Test
    fun `Should get correct index for 3 zigzag`() {
        val index = 3.zigzagIndex()
        assertThat(index, `is`(listOf(0, 1, 2, 1)))
    }

    @Test
    fun `Should get correct index for 4 zigzag`() {
        val index = 4.zigzagIndex()
        assertThat(index, `is`(listOf(0, 1, 2, 3, 2, 1)))
    }

    @Test(expected = IllegalStateException::class)
    fun `Should get correct index for 2 zigzag`() {
        val index = 2.zigzagIndex()
        assertThat(index, `is`(listOf(0, 1)))
    }
}