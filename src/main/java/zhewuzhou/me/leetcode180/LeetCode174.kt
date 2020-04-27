package zhewuzhou.me.leetcode180

import kotlin.math.min

fun calculateMinimumHP(dungeon: Array<IntArray>): Int {
    if (dungeon.isEmpty() || dungeon[0].isEmpty()) return 0
    val r = dungeon.size
    val c = dungeon[0].size
    val result = Array(r + 1) {
        IntArray(c + 1) {
            Int.MAX_VALUE
        }
    }
    result[r][c - 1] = 1
    for (i in r - 1 downTo 0) {
        for (j in c - 1 downTo 0) {
            val minNeighbour = Math.min(result[i + 1][j], result[i][j + 1])
            val need = minNeighbour - dungeon[i][j]
            result[i][j] = if (need <= 0) 1 else need
        }
    }
    return result[0][0]
}
