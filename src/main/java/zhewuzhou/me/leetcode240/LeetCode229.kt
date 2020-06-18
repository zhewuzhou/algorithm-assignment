package zhewuzhou.me.leetcode240

//do not make branches more than 3
fun majorityElement(nums: IntArray): List<Int> {
    var counterA = 0
    var counterB = 0
    var candidateA = 0
    var candidateB = 0
    for (n in nums) {
        when {
            n == candidateA || n == candidateB -> {
                if (candidateA == n) counterA += 1 else counterB += 1
            }
            counterA == 0 || counterB == 0 -> {
                if (counterA == 0) {
                    candidateA = n
                    counterA += 1
                } else {
                    candidateB = n
                    counterB += 1
                }
            }
            else -> {
                counterA -= 1
                counterB -= 1
            }
        }
    }
    counterA = 0
    counterB = 0
    for (n in nums) {
        if (n == candidateA) counterA += 1
        if (n == candidateB) counterB += 1
    }
    val res = mutableSetOf<Int>()
    if (counterA > nums.size / 3) res.add(candidateA)
    if (counterB > nums.size / 3) res.add(candidateB)
    return res.toList()
}
