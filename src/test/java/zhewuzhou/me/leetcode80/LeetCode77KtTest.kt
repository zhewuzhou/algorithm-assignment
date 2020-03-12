package zhewuzhou.me.leetcode80

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

class LeetCode77KtTest {

    @Test
    fun `Should return all combinations`() {
        val result = combine(10, 3)
        assertThat(result.size, `is`(120))
    }
}
