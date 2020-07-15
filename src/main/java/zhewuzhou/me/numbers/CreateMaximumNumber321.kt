package zhewuzhou.me.numbers

fun maxNumber(nums1: IntArray, nums2: IntArray, k: Int): IntArray {
    var lhs = nums1
    var rhs = nums2
    if (nums1.size > nums2.size) {
        lhs = nums2
        rhs = nums1
    }
    return when (k.compareTo(nums1.size + nums2.size)) {
        0 -> mergeArray(nums1, nums2)
        1 -> intArrayOf()
        else -> {
            var maxArray = IntArray(k) {
                -1
            }
            for (i in Math.max(0, k - rhs.size)..Math.min(lhs.size, k)) {
                val p = mergeArray(pickMaximum(lhs, i), pickMaximum(rhs, k - i))
                if (compareArray(p, maxArray, 0, 0)) {
                    maxArray = p
                }
            }
            maxArray
        }
    }
}

fun compareArray(lhs: IntArray, rhs: IntArray, lStart: Int, rStart: Int): Boolean {
    for (i in 0..(lhs.lastIndex - lStart)) {
        when (lhs[lStart + i].compareTo(if (rStart + i > rhs.lastIndex) -1 else rhs[rStart + i])) {
            1 -> return true
            -1 -> return false
        }
    }
    return false
}

fun mergeArray(lhs: IntArray, rhs: IntArray): IntArray {
    val result = mutableListOf<Int>()
    var li = 0
    var ri = 0
    while (result.size < (lhs.size + rhs.size)) {
        when (compareArray(lhs, rhs, li, ri)) {
            true -> result.add(lhs[li++])
            false -> result.add(rhs[ri++])
        }
    }
    return result.toIntArray()
}

fun pickMaximum(nums: IntArray, k: Int): IntArray {
    if (nums.size == k) return nums.copyOf()
    if (k == 0) return intArrayOf()
    val result = mutableListOf<Int>()
    fun pick(start: Int, count: Int) {
        var max = start
        for (i in start..Math.min(nums.lastIndex, nums.lastIndex - count + 1)) {
            if (nums[i] > nums[max]) {
                max = i
            }
        }
        result.add(nums[max])
        if (count > 1)
            pick(max + 1, count - 1)
    }
    pick(0, k)
    return result.toIntArray()
}
