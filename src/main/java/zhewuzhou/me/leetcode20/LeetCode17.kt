package zhewuzhou.me.leetcode20

class Solution {
    val mapping = mapOf(
        '0' to listOf(""),
        '1' to listOf(""),
        '2' to listOf("a", "b", "c"),
        '3' to listOf("d", "e", "f"),
        '4' to listOf("g", "h", "i"),
        '5' to listOf("j", "k", "l"),
        '6' to listOf("m", "n", "o"),
        '7' to listOf("p", "q", "r", "s"),
        '8' to listOf("t", "u", "v"),
        '9' to listOf("w", "x", "y", "z")
    )

    fun nextLetterCombination(r: List<String>, next: Char): List<String> =
        mapping[next]?.flatMap { c -> r.map { it + c } } ?: r

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) {
            return listOf()
        }
        var result = mapping[digits[0]] ?: listOf()
        var di = 1
        while (di < digits.length) {
            result = nextLetterCombination(result, digits[di])
            di += 1
        }
        return result
    }

}
