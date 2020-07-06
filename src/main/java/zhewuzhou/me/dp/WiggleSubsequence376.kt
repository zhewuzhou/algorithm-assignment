package zhewuzhou.me.dp

fun wiggleMaxLength(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    var up = 1
    var down = 1
    for (i in 1 until nums.size) {
        if (nums[i] < nums[i - 1]) {
            down = up + 1
        } else if (nums[i] > nums[i - 1]) {
            up = down + 1
        }
    }
    return Math.max(up, down)
}
