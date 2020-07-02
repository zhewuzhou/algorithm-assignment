package zhewuzhou.me.dp

import java.util.*


fun maxSumSubmatrix(matrix: Array<IntArray>, k: Int): Int {
    if (matrix.isEmpty() || matrix[0].isEmpty()) return 0
    val height = matrix.size
    val width = matrix[0].size
    var result = Int.MIN_VALUE

    //outer loop should use smaller axis
    //now we assume we have more rows than cols, therefore outer loop will be based on cols
    for (left in matrix[0].indices) {
        //array that accumulate sums for each row from left to right
        val sums = IntArray(height)
        for (right in left until width) {
            //update sums[] to include values in curr right col
            for (i in 0 until height) {
                sums[i] += matrix[i][right]
            }

            //we use TreeSet to help us find the rectangle with maxSum <= k with O(logN) time
            val sumsSet = TreeSet<Int>()
            //add 0 to cover the single row case
            sumsSet.add(0)
            var currSum = 0
            for (sum in sums) {
                currSum += sum
                //we use sum subtraction (curSum - sum) to get the subarray with sum <= k
                //therefore we need to look for the smallest sum >= currSum - k
                val num = sumsSet.ceiling(currSum - k)
                if (num != null) result = Math.max(result, currSum - num)
                sumsSet.add(currSum)
            }
        }
    }
    return result
}
