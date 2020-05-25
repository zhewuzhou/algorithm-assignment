package zhewuzhou.me.dp

import java.util.*

fun maxEnvelopes(envelopes: Array<IntArray>): Int {
    envelopes.sortWith(EnvelopComparator())
    val metrics = IntArray(envelopes.size) { 1 }
    var result = 1
    for (i in 1..metrics.lastIndex) {
        var maxForI = 1
        for (j in 0 until i) {
            if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                maxForI = Math.max(maxForI, metrics[j] + 1)
            }
        }
        metrics[i] = maxForI
        result = Math.max(result, metrics[i])
    }
    return result
}

class EnvelopComparator : Comparator<IntArray> {
    override fun compare(lhs: IntArray, rhs: IntArray): Int {
        return when (lhs[0].compareTo(rhs[0])) {
            1 -> 1
            -1 -> -1
            else -> lhs[1].compareTo(rhs[1])
        }
    }
}
