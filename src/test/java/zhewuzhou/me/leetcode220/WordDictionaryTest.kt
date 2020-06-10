package zhewuzhou.me.leetcode220

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

internal class WordDictionaryTest {
    @Test
    fun `Should support search and add words`() {
        val wd = WordDictionary()
        wd.addWord("bad")
        wd.addWord("dad")
        wd.addWord("mad")
        assertThat(wd.search("pad"), `is`(false))
        assertThat(wd.search("bad"), `is`(true))
        assertThat(wd.search(".ad"), `is`(true))
        assertThat(wd.search("b.."), `is`(true))
        assertThat(wd.search("..a"), `is`(false))
        assertThat(wd.search("..d"), `is`(true))
    }

    @Test
    fun `Should works for some edge case`() {
        val wd = WordDictionary()
        assertThat(wd.search("..........."), `is`(false))
        wd.addWord("a")
        assertThat(wd.search("b"), `is`(false))
        assertThat(wd.search("a"), `is`(true))
        assertThat(wd.search("."), `is`(true))
        wd.addWord("foobarfoobarfoobarfoobar")
        assertThat(wd.search("foobarfoobarfoobarfoobar"), `is`(true))
        assertThat(wd.search("f..bar......fooba..oobar"), `is`(true))
        assertThat(wd.search("f..bar......fooba..oobab"), `is`(false))
    }
}
