package zhewuzhou.me.leetcode160

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

internal class LRUCacheTest {
    @Test
    fun `Should remove the oldest value`() {
        val cache = LRUCache(2)
        cache.put(1, 100)
        cache.put(2, 200)
        assertThat(cache.get(1), `is`(100))
        cache.put(3, 300)
        assertThat(cache.get(2), `is`(-1))
    }
}
