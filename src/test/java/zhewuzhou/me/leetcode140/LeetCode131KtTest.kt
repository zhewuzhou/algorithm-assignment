package zhewuzhou.me.leetcode140

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode131KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair("aab", listOf(listOf("a", "a", "b"), listOf("aa", "b")))
            )
        )

        @JvmStatic
        fun minCutCases() = Arrays.stream(
            arrayOf(
                Pair("aab", 1),
                Pair("a", 0),
                Pair("aba", 0),
                Pair("aaaaaaaaaaaaaaaaaaaaaaaaabbbbb", 1),
                Pair("apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp", 452),
                Pair("fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi", 75)

            )
        )
    }

//    @ParameterizedTest
//    @MethodSource("cases")
//    fun `Should partition the string with palindrome`(case: Pair<String, List<List<String>>>) {
//        assertThat(partition(case.first).size, `is`(case.second.size))
//    }

    @ParameterizedTest
    @MethodSource("minCutCases")
    fun `Should calculate min cut`(case: Pair<String, Int>) {
        assertThat(minCut(case.first), `is`(case.second))
    }
}
