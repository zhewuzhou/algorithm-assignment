package zhewuzhou.me.leetcode120

import zhewuzhou.me.leetcode100.TreeNode

fun pathSum(root: TreeNode?, sum: Int): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    doPathSum(res, root, mutableListOf(), sum)
    return res
}

private fun doPathSum(res: MutableList<List<Int>>, root: TreeNode?, comb: MutableList<TreeNode>, sum: Int) {
    if (root == null) return
    if (root.left == null && root.right == null && root.`val` == sum) {
        val path = mutableListOf(*comb.toTypedArray())
        path.add(root)
        res.add(path.map { it.`val` })
    }
    for (t in listOf(root.left, root.right)) {
        if (t != null) {
            comb.add(t)
            doPathSum(res, t, comb, sum - t.`val`)
            comb.removeAt(comb.lastIndex)
        }
    }
}

fun flatten(root: TreeNode?) {
    flatten(root, null)
}

private fun flatten(root: TreeNode?, pre: TreeNode?): TreeNode? {
    var pre = pre
    if (root == null) return pre
    pre = flatten(root.right, pre)
    pre = flatten(root.left, pre)
    root.right = pre
    root.left = null
    pre = root
    return pre
}
