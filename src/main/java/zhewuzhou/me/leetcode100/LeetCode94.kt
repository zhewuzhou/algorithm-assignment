package zhewuzhou.me.leetcode100

import java.util.*


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun recoverTree(root: TreeNode?): Unit {
    var first: TreeNode? = null
    var second: TreeNode? = null
    val stack: Stack<TreeNode> = Stack<TreeNode>()
    var cur = root
    var pre: TreeNode? = null
    while (cur != null || !stack.empty()) {
        while (cur != null) {
            stack.add(cur)
            cur = cur.left
        }
        cur = stack.pop()
        if (pre != null && pre.`val` >= cur.`val` && first == null) {
            first = pre
        }

        if (pre != null && pre.`val` >= cur.`val` && first != null) {
            second = cur
        }
        pre = cur
        cur = cur.right
    }
    val temp: Int = first!!.`val`
    first.`val` = second!!.`val`
    second.`val` = temp
}

fun isValidBST(root: TreeNode?): Boolean {
    val list = mutableListOf<Int>()
    val stack: Stack<TreeNode> = Stack<TreeNode>()
    var cur = root
    while (cur != null || !stack.empty()) {
        while (cur != null) {
            stack.add(cur)
            cur = cur.left
        }
        cur = stack.pop()
        if (list.isNotEmpty() && cur.`val` < list.last()) {
            return false
        }
        list.add(cur.`val`)
        cur = cur.right
    }
    return true
}

fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    if (p == null && q == null) return true
    if (p == null || q == null) return false
    if (p.`val` == q.`val`) {
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    }
    return false
}

fun inorderTraversal(root: TreeNode?): List<Int> {
    val list = mutableListOf<Int>()
    val stack: Stack<TreeNode> = Stack<TreeNode>()
    var cur = root
    while (cur != null || !stack.empty()) {
        while (cur != null) {
            stack.add(cur)
            cur = cur.left
        }
        cur = stack.pop()
        list.add(cur.`val`)
        cur = cur.right
    }
    return list
}

fun generateTrees(n: Int): List<TreeNode?> {
    if (n == 0) return listOf()
    return doGenerate(1, n)
}

fun numTrees(n: Int): Int {
    val matrix = IntArray(n + 1) {
        1
    }
    for (x in 2..n) {
        matrix[x] = 0
        for (j in 1..x) {
            matrix[x] += matrix[j - 1] * matrix[x - j]
        }
    }
    return matrix[n]
}

fun nFactor(n: Int): Int {
    return when (n) {
        0 -> 1
        1 -> 1
        else -> {
            var x = 1
            var res = 1
            while (x <= n) {
                res *= x
                x += 1
            }
            res
        }
    }
}

fun doCount(start: Int, end: Int): Int {
    return when (start.compareTo(end)) {
        1 -> 1
        0 -> 1
        else -> {
            var count = 0
            for (i in start..end) {
                val lc = doCount(start, i - 1)
                val rc = doCount(i + 1, end)
                count += lc * rc
            }
            count
        }
    }
}

fun doGenerate(start: Int, end: Int): List<TreeNode?> {
    return when (start.compareTo(end)) {
        1 -> listOf(null)
        0 -> listOf(TreeNode(start))
        else -> {
            val res = mutableListOf<TreeNode?>()
            for (i in start..end) {
                val lp = doGenerate(start, i - 1)
                val rp = doGenerate(i + 1, end)
                for (l in lp) {
                    for (r in rp) {
                        val root = TreeNode(i)
                        root.right = r
                        root.left = l
                        res.add(root)
                    }
                }
            }
            res
        }
    }
}
