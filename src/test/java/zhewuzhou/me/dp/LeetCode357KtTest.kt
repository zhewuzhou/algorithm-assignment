package zhewuzhou.me.dp

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode357KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(1, 10),
                Pair(2, 91),
                Pair(3, 739)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should calculate the different unique numbers`(case: Pair<Int, Int>) {
        assertThat(countNumbersWithUniqueDigits(case.first), `is`(case.second))
    }

    @Test
    fun permutationShouldWorksForAllNumber() {
        assertThat(permutationsOn9(1), `is`(9))
        assertThat(permutationsOn9(2), `is`(72))
        assertThat(permutationsOn9(3), `is`(504))
        assertThat(permutationsOn9(9), `is`(362880))
    }
}
