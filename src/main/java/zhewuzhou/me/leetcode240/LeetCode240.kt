package zhewuzhou.me.leetcode240

import java.util.*

fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    if (matrix.isEmpty() || matrix[0].isEmpty()) {
        return false
    }
    var col: Int = matrix[0].size - 1
    var row = 0
    while (col >= 0 && row <= matrix.size - 1) {
        if (target == matrix[row][col]) {
            return true
        } else if (target < matrix[row][col]) {
            val inRow = Arrays.binarySearch(matrix[row], target)
            if (inRow >= 0) return true else row
        } else if (target > matrix[row][col]) {
            row++
        }
    }
    return false
}
