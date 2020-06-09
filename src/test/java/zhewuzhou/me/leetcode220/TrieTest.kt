package zhewuzhou.me.leetcode220

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

internal class TrieTest {
    @Test
    fun `Should remove & insert word into tries`() {
        val t = Trie()
        t.insert("apple")
        assertThat(t.search("apple"), `is`(true))
        assertThat(t.search("app"), `is`(false))
        assertThat(t.startsWith("app"), `is`(true))
        t.insert("app")
        t.insert("apply")
        t.insert("apache")
        assertThat(t.search("app"), `is`(true))
        assertThat(t.search("apply"), `is`(true))
        assertThat(t.startsWith("apa"), `is`(true))
        assertThat(t.search("apache"), `is`(true))
    }

    @Test
    fun `Should works in edge cases`() {
        val t = Trie()
        assertThat(t.search("abc"), `is`(false))
        assertThat(t.startsWith("abc"), `is`(false))

        t.insert("a")
        assertThat(t.search("abc"), `is`(false))
        assertThat(t.startsWith("a"), `is`(true))

    }
}
