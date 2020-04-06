package zhewuzhou.me.leetcode140

fun partition(s: String): List<List<String>> {
    val caches = mutableMapOf<String, Boolean>()
    fun isPalindrome(src: String): Boolean {
        if (caches.containsKey(src)) return caches[src]!!
        val result = (0 until (src.length / 2)).all { src[it] == src[src.length - it - 1] }
        caches[src] = result
        return result
    }

    fun getPalindrome(src: String, start: Int): List<String> {
        val res = mutableListOf(src.substring(start, start + 1))
        for (i in start + 2..src.length) {
            val substring = src.substring(start, i)
            if (isPalindrome(substring)) res.add(substring)
        }
        return res
    }

    fun doPartition(res: MutableList<List<String>>, src: String, comb: MutableList<String>, start: Int) {
        if (start == src.length) {
            res.add(listOf(*comb.toTypedArray()))
        } else {
            for (p in getPalindrome(src, start)) {
                comb.add(p)
                doPartition(res, src, comb, start + p.length)
                comb.removeAt(comb.lastIndex)
            }
        }
    }


    if (s.isEmpty()) return listOf()
    val res = mutableListOf<List<String>>()
    doPartition(res, s, mutableListOf(), 0)
    return res
}

fun minCut(s: String): Int {
    val minCutCaches = mutableMapOf<String, Int>()
    val palindromeCaches = mutableMapOf<String, Boolean>()
    fun isPalindrome(src: String): Boolean {
        if (palindromeCaches.containsKey(src)) return palindromeCaches[src]!!
        val result = (0 until (src.length / 2)).all { src[it] == src[src.length - it - 1] }
        palindromeCaches[src] = result
        return result
    }

    fun minCutDP(src: String): Int {
        if (minCutCaches.containsKey(src)) return minCutCaches[src]!!
        if (src.length == 1 || isPalindrome(src)) return 0
        var min = src.lastIndex
        for (i in 1..src.lastIndex) {
            val left = minCutDP(src.substring(0, i))
            val right = minCutDP(src.substring(i))
            if (min > left + right + 1) {
                min = left + right + 1
            }
        }
        minCutCaches[src] = min
        return min
    }
    return when (s.length) {
        0 -> 0
        1 -> 0
        else -> {
            if (isPalindrome(s)) 1 else minCutDP(s)
        }
    }
}
