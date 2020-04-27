package zhewuzhou.me.leetcode180

fun compareVersion(version1: String, version2: String): Int {
    val v1 = convertVersion(version1)
    val v2 = convertVersion(version2)
    when ((v1.size).compareTo(v2.size)) {
        1 -> repeat(v1.size - v2.size) { v2.add(0) }
        -1 -> repeat(v2.size - v1.size) { v1.add(0) }
    }
    val result = v1.zip(v2)
        .map { it.first.compareTo(it.second) }
    return if (result.all { it == 0 }) 0 else result.first { it != 0 }
}

private fun convertVersion(v: String): MutableList<Int> =
    v.split(".").map { it.toInt() }.toMutableList()
