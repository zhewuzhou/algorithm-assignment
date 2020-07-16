package zhewuzhou.me.datastructure

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

internal class SkiplistTest {
    @Test
    fun `Should be able to add delete search elements in skip list`() {
        val skiplist = Skiplist()
        for (i in 1..1000) {
            skiplist.add(i)
        }
        assertThat(skiplist.search(0), `is`(false))
        assertThat(skiplist.search(1), `is`(true))
        assertThat(skiplist.search(999), `is`(true))
        assertThat(skiplist.erase(999), `is`(true))
        assertThat(skiplist.search(999), `is`(false))
        assertThat(skiplist.erase(1), `is`(true))
        assertThat(skiplist.search(1), `is`(false))
    }

    @Test
    fun `Should remove empty or non exist elements`() {
        val skipList = Skiplist()
        assertThat(skipList.erase(100), `is`(false))
        skipList.add(99)
        assertThat(skipList.erase(100), `is`(false))
    }

    @Test
    fun `Should search for empty or non exist elements`() {
        val skipList = Skiplist()
        assertThat(skipList.search(100), `is`(false))
    }
}
