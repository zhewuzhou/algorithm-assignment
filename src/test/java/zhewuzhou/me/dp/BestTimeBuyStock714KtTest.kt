package zhewuzhou.me.dp

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class BestTimeBuyStock714KtTest {
    private companion object {
        @JvmStatic
        fun casesOfTransactionFee() = Arrays.stream(
            arrayOf(
                Triple(listOf(1, 3, 2, 8, 4, 9), 2, 8)
            )
        )

        @JvmStatic
        fun casesCoolDown() = Arrays.stream(
            arrayOf(
                Pair(listOf(1, 2, 3, 0, 2), 3),
                Pair(listOf(1, 2, 3, 100, 2), 99),
                Pair(listOf(1, 2, 4, 2, 5, 7, 2, 4, 9, 0), 11),
                Pair(listOf(6, 1, 6, 4, 3, 0, 2), 7)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("casesOfTransactionFee")
    fun `Should get max profit with transaction fee`(case: Triple<List<Int>, Int, Int>) {
        assertThat(maxProfit(case.first.toIntArray(), case.second), `is`(case.third))
    }

    @ParameterizedTest
    @MethodSource("casesCoolDown")
    fun `Should get max profit with cool down`(case: Pair<List<Int>, Int>) {
        assertThat(maxProfitCoolDown(case.first.toIntArray()), `is`(case.second))
    }
}
