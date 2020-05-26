package zhewuzhou.me.leetcode140

fun singleNumberTwo(nums: IntArray) =
    nums.reduce { acc, it -> acc.xor(it) }

fun singleNumber(nums: IntArray): Int {
    var ones = 0
    var twos = 0
    nums.forEach {
        ones = (ones xor it) and twos.inv()
        twos = (twos xor it) and ones.inv()
    }
    return ones
}
