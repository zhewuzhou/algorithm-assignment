package zhewuzhou.me.leetcode200

fun findRepeatedDnaSequences(s: String): List<String> {
    if (s.isEmpty() || s.length < 10) return listOf()
    val seen = mutableSetOf<Int>()
    val repeat = mutableSetOf<Int>()
    for (i in 0..(s.length - 10)) {
        val key = calculateKey(s.substring(i, i + 10))
        if (seen.contains(key)) {
            repeat.add(key)
        } else {
            seen.add(key)
        }
    }
    return repeat.toList().map { calculateDNA(it) }
}

fun calculateKey(s: String): Int {
    val DNA = mapOf(
        'A' to 0,
        'C' to 1,
        'G' to 2,
        'T' to 3
    )
    var shift = 0
    var key = 0
    for (i in s.indices) {
        shift = i * 2
        key += DNA[s[i]]!!.shl(shift)
    }
    return key
}

fun calculateDNA(c: Int): String {
    var code = c
    val DNA = mapOf(
        0 to 'A',
        1 to 'C',
        2 to 'G',
        3 to 'T'
    )
    val dnas = mutableListOf<Char>()
    for (i in 0..9) {
        val last = code.and(0x00003)
        dnas.add(DNA[last]!!)
        code = code.shr(2)
    }
    return dnas.joinToString("")
}
