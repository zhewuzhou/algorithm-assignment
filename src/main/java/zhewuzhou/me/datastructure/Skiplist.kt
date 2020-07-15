package zhewuzhou.me.datastructure

import java.util.*

/*
TODO:
1. When nullable get nasty, refactoring should began
2. Visualize the whole stuff
 */

class Skiplist() {
    internal class Node(var value: Int, var height: Int) {
        var count = 1
        var next = arrayOfNulls<Node>(33)
    }

    private val dummyHead = Node(Int.MIN_VALUE, 32)
    private var topLevel = 0
    private val stack = Array(33) {
        Node(Int.MIN_VALUE, 33)
    }
    private val rand: Random = Random()


    fun search(target: Int): Boolean {
        val node = findPre(target)
        return compare(node.next[0], target) { t, v -> t == v }
    }

    fun add(target: Int) {
        val pre = findPre(target)
        if (compare(pre.next[0], target) { t, v -> t == v }) {
            val cur = pre.next[0]!!
            cur.count += 1
            return
        }
        val node = Node(target, pickHeight())
        while (topLevel < node.height) {
            topLevel += 1
            stack[topLevel] = dummyHead
        }
        for (i in 0..node.height) {
            node.next[i] = stack[i].next[i]
            stack[i].next[i] = node
        }
    }

    fun erase(target: Int): Boolean {
        val node = findPre(target)
        return if (compare(node.next[0], target) { t, v -> t == v }) {
            val nodeRemoved = node.next[0]!!
            nodeRemoved.count -= 1
            if (nodeRemoved.count == 0) {
                for (i in topLevel downTo 0) {
                    val cur = stack[i]
                    if (compare(cur.next[i], target) { t, v -> t == v }) {
                        val curNext = cur.next[i]!!
                        cur.next[i] = curNext.next[i]
                    }
                    if (cur == dummyHead && cur.next[i] == null) {
                        topLevel -= 1
                    }
                }
            }
            true
        } else {
            false
        }
    }

    private fun findPre(target: Int): Node {
        var cur = dummyHead
        for (i in topLevel downTo 0) {
            while (compare(cur.next[i], target) { t, v -> t > v }) {
                cur = cur.next[i]!!
            }
            stack[i] = cur
        }
        return cur
    }

    private fun pickHeight(): Int {
        return Integer.numberOfTrailingZeros(rand.nextInt())
    }

    private fun compare(n: Node?, target: Int, cond: (t: Int, v: Int) -> Boolean): Boolean {
        if (n == null) return false
        return cond(target, n.value)
    }
}
