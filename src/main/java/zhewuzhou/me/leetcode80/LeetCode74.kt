package zhewuzhou.me.leetcode80

fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    if (matrix.isEmpty() || matrix[0].isEmpty()) return false
    val rowIndex = searchRowIndex(matrix, target)
    return if (rowIndex == -1)
        false
    else
        searchInRow(matrix[rowIndex], target)
}

private fun searchRowIndex(matrix: Array<IntArray>, target: Int): Int {
    val row = matrix.lastIndex
    val col = matrix[0].lastIndex
    if (target < matrix[0][0] || target > matrix[row][col]) return -1
    if (row == 0) return 0
    var start = 0
    var end = row
    while (start <= end) {
        val mid = (start + end + 1) / 2
        if ((mid < row && target >= matrix[mid][0] && target < matrix[mid + 1][0]) ||
            mid == row && target >= matrix[mid][0]) {
            return mid
        } else if (target > matrix[mid][0]) {
            start = mid + 1
        } else {
            end = mid - 1
        }
    }
    return -1
}

private fun searchInRow(row: IntArray, target: Int): Boolean {
    var start = 0
    var end = row.lastIndex
    while (start <= end) {
        val mid = (start + end + 1) / 2
        if (row[mid] == target) {
            return true
        } else if (row[mid] < target) {
            start = mid + 1
        } else {
            end = mid - 1
        }
    }
    return false
}
