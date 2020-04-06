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
