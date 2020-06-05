package zhewuzhou.me.leetcode200

fun findRepeatedDnaSequences(s: String): List<String> {
    val DNA = mapOf(
        'A' to 0,
        'C' to 1,
        'G' to 2,
        'T' to 3
    )

    if (s.isEmpty() || s.length < 10) return listOf()
    val seen = mutableSetOf<Int>()
    val repeat = mutableSetOf<String>()
    var preKey = -1
    for (i in 0..(s.length - 10)) {
        val sub = s.substring(i, i + 10)
        val key = when (preKey != -1) {
            true -> preKey.shr(2) + (DNA[s[i + 9]]!!.shl(18))
            false -> {
                var shift = 0
                var key = 0
                for (j in sub.indices) {
                    shift = j * 2
                    key += DNA[sub[j]]!!.shl(shift)
                }
                key
            }
        }
        if (seen.contains(key)) {
            repeat.add(sub)
        } else {
            seen.add(key)
        }
        preKey = key
    }
    return repeat.toList()
}


