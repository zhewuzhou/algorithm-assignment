package zhewuzhou.me.leetcode40

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Test

class LeetCode35KtTest {
    private val validBoard = arrayOf(
        arrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.').toCharArray(),
        arrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.').toCharArray(),
        arrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.').toCharArray(),
        arrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3').toCharArray(),
        arrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1').toCharArray(),
        arrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6').toCharArray(),
        arrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.').toCharArray(),
        arrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5').toCharArray(),
        arrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9').toCharArray()
    )

    private val invalidBoard = arrayOf(
        arrayOf('8', '3', '.', '.', '7', '.', '.', '.', '.').toCharArray(),
        arrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.').toCharArray(),
        arrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.').toCharArray(),
        arrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3').toCharArray(),
        arrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1').toCharArray(),
        arrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6').toCharArray(),
        arrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.').toCharArray(),
        arrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5').toCharArray(),
        arrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9').toCharArray()
    )

    @Test
    fun `Should be valid row and invalid rows`() {
        assertThat(validRows(validBoard), `is`(true))
        assertThat(validRows(invalidBoard), `is`(true))
    }

    @Test
    fun `Should be valid columns and invalid columns`() {
        assertThat(validColumns(validBoard), `is`(true))
        assertThat(validColumns(invalidBoard), `is`(false))
    }

    @Test
    fun `Should be valid block and invalid blocks`() {
        assertThat(validBlock(validBoard), `is`(true))
        assertThat(validBlock(invalidBoard), `is`(false))
    }
}
