package zhewuzhou.me.leetcode80

import org.junit.jupiter.api.Test
import java.util.*

class LeetCode80KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(listOf(1, 1, 1, 2, 2, 3), 5),
                Pair(listOf(0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 3, 3), 7)
            )
        )
    }

//    @ParameterizedTest
//    @MethodSource("cases")
//    fun `Should remove duplications`(case: Pair<List<Int>, Int>) {
//        assertThat(removeDuplicates(case.first.toIntArray()), `is`(case.second))
//    }

    @Test
    fun `Should sort colors`() {
        sortColors(arrayOf(1, 2, 0).toIntArray())
    }
}
