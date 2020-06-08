package zhewuzhou.me.leetcode220

fun countPrimesSlow(n: Int): Int {
    val l = (2 until n).toMutableSet()
    var start = 2
    while (start < n) {
        if (isPrime(start)) {
            var t = start
            while (t <= n) {
                t += start
                l.remove(t)
            }
        }
        start = l.firstOrNull { it >= (start + 1) } ?: n
    }
    return l.size
}

private fun isPrime(n: Int): Boolean {
    val sqrt = Math.sqrt(n.toDouble()).toInt()
    if (sqrt == 1) return true
    for (i in 2..sqrt) {
        if (n % i == 0) return false
    }
    return true
}

fun countPrimes(n: Int): Int {
    val notPrime = BooleanArray(n)
    var count = 0
    for (i in 2 until n) {
        if (!notPrime[i]) {
            count++
            var j = 2
            while (i * j < n) {
                notPrime[i * j] = true
                j++
            }
        }
    }
    return count
}
