package zhewuzhou.me.leetcode20

/*
Given String consider mod then:
0, 1, 2, 3, 4, 5, 6, 7, 8, 9
0, 1, 2, 1, 0, 1, 2, 1, 0, 1
 */

fun convert(s: String, numRows: Int): String {
    val zigzagIndex = numRows.zigzagIndex()
    return s.indices
            .groupBy { zigzagIndex[it % zigzagIndex.size] }
            .mapValues { kv -> kv.value.map { s[it] } }
            .mapValues { kv -> kv.value.joinToString(separator = "") }
            .values
            .joinToString(separator = "")
}

fun Int.zigzagIndex(): List<Int> {
    check(this > 1)
    return (0 until this).toList() + (this - 2 downTo 1).toList()
}
