package zhewuzhou.me.leetcode20

import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test

class LeetCode12KtTest {

    @Test
    fun `Should convert small number to Roman number`() {
        assertThat(intToRoman(3), `is`("III"))
        assertThat(intToRoman(4), `is`("IV"))
        assertThat(intToRoman(9), `is`("IX"))
    }

    @Test
    fun `Should convert large number to Roman number`() {
        assertThat(intToRoman(58), `is`("LVIII"))
        assertThat(intToRoman(1994), `is`("MCMXCIV"))
    }

    @Test
    fun `Should convert large roman number to int`() {
        assertThat(romanToInt("LVIII"), `is`(58))
        assertThat(romanToInt("MCMXCIV"), `is`(1994))
    }

    @Test(expected = IllegalArgumentException::class)
    fun `Should throw exception for edge cases`() {
        romanToInt("LVIIIM")
    }
}
