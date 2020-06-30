package zhewuzhou.me.dp

class NumArray(nums: IntArray) {
    private val matrix = IntArray(nums.size) {
        nums[0]
    }

    init {
        if (nums.isNotEmpty()) {
            for (i in 1..nums.lastIndex) {
                matrix[i] = nums[i] + matrix[i - 1]
            }
        }
    }

    fun sumRange(i: Int, j: Int): Int {
        require(i <= j && i < matrix.size && j < matrix.size)
        return if (i == 0)
            matrix[j]
        else
            matrix[j] - matrix[i - 1]
    }
}
