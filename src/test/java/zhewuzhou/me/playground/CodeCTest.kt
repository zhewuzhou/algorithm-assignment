package zhewuzhou.me.playground

import org.apache.commons.codec.digest.MurmurHash2
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test


internal class CodeCTest {
    @Test
    fun `Murmur test should be very fast`() {
        assertThat(MurmurHash2.hash32("abcd"), `is`(-1323649548))
    }
}
