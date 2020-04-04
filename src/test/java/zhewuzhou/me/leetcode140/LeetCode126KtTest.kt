package zhewuzhou.me.leetcode140

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode126KtTest {
    data class Test126Case(
        val begin: String,
        val end: String,
        val wordList: List<String>,
        val result: List<List<String>>
    )

    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
//                Test126Case(
//                    "hit", "cog", listOf("hot", "dot", "dog", "lot", "log", "cog"),
//                    listOf(listOf("hit", "hot", "dot", "dog", "cog"), listOf("hit", "hot", "lot", "log", "cog"))
//                ),
//                Test126Case(
//                    "hit", "cog", listOf("hot", "dot", "dog", "lot", "log"), listOf()
//                ),
                Test126Case(
                    "a", "c", listOf("a", "b", "c"), listOf(listOf("a", "c"))
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find paths from begin to end`(case: Test126Case) {
        val result = findLadders(case.begin, case.end, case.wordList)
        assertThat(result.size, `is`(case.result.size))
        listOf("aaa").toSet()
    }
}
