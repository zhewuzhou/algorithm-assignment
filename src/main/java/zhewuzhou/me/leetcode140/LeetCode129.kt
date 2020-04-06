package zhewuzhou.me.leetcode140

import zhewuzhou.me.leetcode100.TreeNode

fun sumNumbers(root: TreeNode?): Int {
    if (root == null) return 0
    val res = doSum(root)
    return res.map { list ->
        list.mapIndexed { index, value -> value * powOfTen(index) }.sum()
    }.sum()
}

fun powOfTen(pow: Int): Int {
    var res = 1
    repeat(pow) {
        res *= 10
    }
    return res
}

fun doSum(node: TreeNode): List<MutableList<Int>> {
    val res = mutableListOf<MutableList<Int>>()
    if (node.left == null && node.right == null) {
        return listOf(mutableListOf(node.`val`))
    }
    if (node.left != null) {
        res.addAll(doSum(node.left!!))
    }
    if (node.right != null) {
        res.addAll(doSum(node.right!!))
    }
    res.forEach { it.add(node.`val`) }
    return res
}
