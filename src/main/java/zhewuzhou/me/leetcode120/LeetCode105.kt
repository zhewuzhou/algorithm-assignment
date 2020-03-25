package zhewuzhou.me.leetcode120

import zhewuzhou.me.leetcode100.TreeNode

fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    if (preorder.isEmpty() || inorder.isEmpty() || preorder.sorted() != inorder.sorted()) return null
    if (preorder.size == 1) return TreeNode(preorder[0])
    val root = TreeNode(preorder[0])
    val (inLeft, inRight) = splitArray(inorder, root.`val`)
    root.left = buildTree(preorder.filter { inLeft.contains(it) }.toIntArray(), inLeft)
    root.right = buildTree(preorder.filter { inRight.contains(it) }.toIntArray(), inRight)
    return root
}

private fun splitArray(target: IntArray, root: Int): Pair<IntArray, IntArray> {
    val mid = target.indexOf(root)
    val inLeft = target.copyOfRange(0, mid)
    val inRight = target.copyOfRange(mid + 1, target.size)
    return Pair(inLeft, inRight)
}

fun sortedArrayToBST(nums: IntArray): TreeNode? {
    if (nums.isEmpty()) return null
    if (nums.size == 1) return TreeNode(nums[0])
    val root = TreeNode(nums[(0 + nums.size) / 2])
    val (left, right) = splitArray(nums, root.`val`)
    root.left = sortedArrayToBST(left)
    root.right = sortedArrayToBST(right)
    return root
}


