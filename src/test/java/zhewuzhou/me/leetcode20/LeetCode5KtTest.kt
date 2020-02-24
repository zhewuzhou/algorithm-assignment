package zhewuzhou.me.leetcode20

import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThat
import org.junit.Test

class LeetCode5KtTest {

    @Test
    fun `should find palindromic  substring for "banana"`() {
        assertThat(longestPalindromeBruteForce("banana"), `is`("anana"))
    }

    @Test
    fun `anana should be palindromic`() {
        assertThat("anana".isPalindrome(), `is`(true))
    }

    @Test
    fun `cbb should be palindromic`() {
        assertThat("cbb".isPalindrome(), `is`(false))
    }

    @Test
    fun `"cbbd" should be palindromic`() {
        assertThat(longestPalindromeBruteForce("cbbd"), `is`("bb"))
    }

    @Test
    fun `geeksskeeg should be palindromic`() {
        assertThat("geeksskeeg".isPalindrome(), `is`(true))
    }

    @Test
    fun `empty should not be palindromic`() {
        assertThat("".isPalindrome(), `is`(true))
    }

    @Test
    fun `single char should not be palindromic`() {
        assertThat("a".isPalindrome(), `is`(true))
    }

    @Test
    fun `should calculate all substrings for banana 0`() {
        assertThat("banana".longestByIndex(0), `is`("b"))
    }

    @Test
    fun `should calculate all substrings for empty 0`() {
        assertThat("".longestByIndex(0), `is`(""))
    }

    @Test
    fun `should calculate all substrings for single char 0`() {
        assertThat("a".longestByIndex(0), `is`("a"))
    }

    @Test
    fun `should calculate for very long string`() {
        val longString = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"
        assertThat(longestPalindromeBruteForce(longString), `is`("ranynar"))
    }
}
