package zhewuzhou.me.leetcode160

import zhewuzhou.me.leetcode100.TreeNode
import java.util.*


fun preorderTraversal(root: TreeNode?): List<Int>? {
    val result: MutableList<Int> = ArrayList()
    val stack = Stack<TreeNode>()
    var p: TreeNode? = root
    while (!stack.isEmpty() || p != null) {
        p = if (p != null) {
            stack.push(p)
            result.add(p.`val`) // Add before going to children
            p.left
        } else {
            val node: TreeNode = stack.pop()
            node.right
        }
    }
    return result
}

fun inorderTraversal(root: TreeNode?): List<Int>? {
    val result: MutableList<Int> = ArrayList()
    val stack = Stack<TreeNode>()
    var p = root
    while (!stack.isEmpty() || p != null) {
        p = if (p != null) {

            stack.push(p)
            p.left
        } else {
            val node = stack.pop()
            result.add(node.`val`) // Add after all left children
            node.right
        }
    }
    return result
}

fun postorderTraversal(root: TreeNode?): List<Int>? {
    val result = LinkedList<Int>()
    val stack = Stack<TreeNode>()
    var p = root
    while (!stack.isEmpty() || p != null) {
        p = if (p != null) {
            stack.push(p)
            result.addFirst(p.`val`) // Reverse the process of preorder
            p.right // Reverse the process of preorder
        } else {
            val node = stack.pop()
            node.left // Reverse the process of preorder
        }
    }
    return result
}
