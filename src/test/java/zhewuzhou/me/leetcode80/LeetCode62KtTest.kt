package zhewuzhou.me.leetcode80

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

internal class LeetCode62KtTest {

    @Test
    fun `Should calculate unique paths`() {
        assertThat(uniquePaths(7, 3), `is`(28))
    }
}
