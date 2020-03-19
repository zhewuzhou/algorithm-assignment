package zhewuzhou.me.leetcode100

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    for (i in m until (m + n)) {
        nums1[i] = nums2[i - m]
    }
    nums1.sort(0, m + n - 1)
}

//Micro view && Overview
fun grayCode(n: Int): List<Int> {
    val res = mutableListOf<Int>(0)
    for (x in 0 until n) {
        val s = res.size - 1
        for (i in s downTo 0) {
            res.add(res[i] or (1 shl x))
        }
    }
    return res
}

fun grayCode(res: MutableList<Int>, source: List<Int>, comb: MutableList<Int>): Boolean {
    when (comb.size == source.size) {
        true -> {
            res.addAll(comb)
            return true
        }
        false -> {
            for (n in source) {
                if (!comb.contains(n) && isDiffInOneBit(comb.last(), n)) {
                    comb.add(n)
                    if (grayCode(res, source, comb)) {
                        return true
                    } else {
                        comb.removeAt(comb.lastIndex)
                    }
                }
            }
            return false
        }
    }
}

fun isDiffInOneBit(a: Int, b: Int): Boolean {
    val diff = a.xor(b)
    return diff != 0 && (diff.and(diff - 1) == 0)
}


