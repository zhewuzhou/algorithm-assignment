package zhewuzhou.me.leetcode140

import zhewuzhou.me.leetcode100.TreeNode

fun maxPathSum(root: TreeNode?): Int {
    var maxValue = Int.MIN_VALUE
    fun maxPathDown(node: TreeNode?): Int {
        if (node == null) return 0
        val left: Int = Math.max(0, maxPathDown(node.left))
        val right: Int = Math.max(0, maxPathDown(node.right))
        maxValue = Math.max(maxValue, left + right + node.`val`)
        return Math.max(left, right) + node.`val`
    }
    maxPathDown(root);
    return maxValue;
}

private fun isPalindrome(s: String): Boolean {
    if (s.isEmpty()) return true
    val ts = s.toCharArray()
        .filter { (it in 'a'..'z') || (it in 'A'..'Z') || (it in '0'..'9') }
        .map { it.toUpperCase() }
        .joinToString("")
    return ts.isEmpty() || ts == ts.reversed()
}
