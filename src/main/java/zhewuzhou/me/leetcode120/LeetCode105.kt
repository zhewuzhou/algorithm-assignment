package zhewuzhou.me.leetcode120

import zhewuzhou.me.leetcode100.TreeNode

fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    if (preorder.isEmpty() || inorder.isEmpty() || preorder.sorted() != inorder.sorted()) return null
    if (preorder.size == 1) return TreeNode(preorder[0])
    val root = TreeNode(preorder[0])
    val (inLeft, inRight) = splitInorder(inorder, root.`val`)
    root.left = buildTree(preorder.filter { inLeft.contains(it) }.toIntArray(), inLeft)
    root.right = buildTree(preorder.filter { inRight.contains(it) }.toIntArray(), inRight)
    return root
}

private fun splitInorder(inorder: IntArray, root: Int): Pair<IntArray, IntArray> {
    val mid = inorder.indexOf(root)
    val inLeft = inorder.copyOfRange(0, mid)
    val inRight = inorder.copyOfRange(mid + 1, inorder.size)
    return Pair(inLeft, inRight)
}


