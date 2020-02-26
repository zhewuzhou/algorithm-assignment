package zhewuzhou.me.leetcode40

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsInAnyOrder
import org.junit.Test

class LeetCode30KtTest {

    @Test
    fun `Should match the strings barfoothefoobarman with foo,bar`() {
        val result = findSubstring("barfoothefoobarman", listOf("foo", "bar").toTypedArray())
        assertThat(result, containsInAnyOrder(0, 9))
    }

    @Test
    fun `Should match foobarfoobar with foo bar`() {
        val result = findSubstring("foobarfoobar", listOf("foo", "bar").toTypedArray())
        assertThat(result, containsInAnyOrder(0, 3, 6))
    }

    @Test
    fun `Should match aaa with a a`() {
        val result = findSubstring("aaa", listOf("a", "a").toTypedArray())
        assertThat(result, containsInAnyOrder(0, 1))
    }

    @Test
    fun `Should not match the string wordgoodgoodgoodbestword with word good best word`() {
        val result = findSubstring("wordgoodgoodgoodbestword",
            listOf("word", "good", "best", "word").toTypedArray())

        assertThat(result.isEmpty(), `is`(true))
    }

    @Test
    fun `Should return all list for 5`() {
        val result = allList(5)
        assertThat(result.size, `is`(120))
    }

    @Test
    fun `Should return all combination for aa bb cc`() {
        val words = listOf("aa", "bb", "cc")
        val result = allCombination(words.toTypedArray())
        assertThat(result.size, `is`(6))
    }

    @Test
    fun `Should return all combination for aa bb aa`() {
        val words = listOf("aa", "bb", "aa")
        val result = allCombination(words.toTypedArray())
        assertThat(result.size, `is`(3))
    }

    @Test
    fun `Should match multiple times for s foofoofoo p foo`() {
        val result = allPositions("foofoofoo", "foo")
        assertThat(result, containsInAnyOrder(0, 3, 6))
    }
}
