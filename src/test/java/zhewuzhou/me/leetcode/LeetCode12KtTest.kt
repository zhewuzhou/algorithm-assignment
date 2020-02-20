package zhewuzhou.me.leetcode

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
}
