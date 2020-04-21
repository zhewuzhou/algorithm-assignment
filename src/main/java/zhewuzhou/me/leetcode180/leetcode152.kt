package zhewuzhou.me.leetcode180

fun maxProduct(A: IntArray): Int {
    if (A.isEmpty()) {
        return 0
    }
    var maxherepre = A[0]
    var minherepre = A[0]
    var maxsofar = A[0]
    var maxhere: Int
    var minhere: Int
    for (i in 1 until A.size) {
        maxhere = Math.max(Math.max(maxherepre * A[i], minherepre * A[i]), A[i])
        minhere = Math.min(Math.min(maxherepre * A[i], minherepre * A[i]), A[i])
        maxsofar = Math.max(maxhere, maxsofar)
        maxherepre = maxhere
        minherepre = minhere
    }
    return maxsofar
}
