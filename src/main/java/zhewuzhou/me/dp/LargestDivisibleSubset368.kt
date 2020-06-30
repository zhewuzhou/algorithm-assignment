package zhewuzhou.me.dp

fun largestDivisibleSubset(nums: IntArray): List<Int> {
    if (nums.isEmpty()) return listOf()
    nums.sortDescending()
    val matrix = mutableListOf<Pair<Int, Int>>()
    for (i in nums.indices) {
        matrix.add(Pair(i, 1))
    }
    var largest = Triple(0, 1, 0)
    for (i in 1..matrix.lastIndex) {
        var pre = -1
        for (j in 0 until i) {
            if (nums[j] % nums[i] == 0) {
                pre = when {
                    pre == -1 -> j
                    matrix[pre].second < matrix[j].second -> j
                    else -> pre
                }
            }
        }
        matrix[i] = if (pre != -1) Pair(pre, matrix[pre].second + 1) else matrix[i]
        largest = if (matrix[i].second > largest.second) Triple(matrix[i].first, matrix[i].second, i) else largest
    }
    var cur = largest.third
    val result = mutableListOf<Int>()
    while (cur >= 0) {
        result.add(nums[cur])
        cur = if (cur == matrix[cur].first) -1 else matrix[cur].first
    }
    return result
}
