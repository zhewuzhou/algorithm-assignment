package zhewuzhou.me.leetcode220

import java.util.*


data class DirectedGraph(val V: Int) {
    private var E = 0
    private var adj = Array(V) { mutableListOf<Int>() }
    private val indegree: IntArray = IntArray(V)

    fun addEdge(v: Int, w: Int) {
        adj[v].add(w)
        indegree[w]++
        E++
    }

    fun adj(v: Int): Iterable<Int> {
        return adj[v]
    }

    fun outdegree(v: Int): Int {
        return adj[v].size
    }

    fun indegree(v: Int): Int {
        return indegree[v]
    }
}

fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    if (numCourses < 1) return false
    val g = DirectedGraph(numCourses)
    for (e in prerequisites) {
        g.addEdge(e[1], e[0])
    }
    if (hasCycle(g)) return false
    return true

}

private fun hasCycle(g: DirectedGraph): Boolean {
    fun moveVertex(v: Int, source: MutableSet<Int>, dest: MutableSet<Int>) {
        source.remove(v)
        dest.add(v)
    }

    fun dfs(v: Int, white: MutableSet<Int>, gray: MutableSet<Int>, black: MutableSet<Int>): Boolean {
        moveVertex(v, white, gray)
        for (n in g.adj(v)) {
            if (black.contains(n)) {
                continue;
            }
            if (gray.contains(n)) {
                return true
            }
            if (dfs(n, white, gray, black)) {
                return true
            }
        }
        moveVertex(v, gray, black)
        return false
    }

    val white = mutableSetOf(*(0 until g.V).toList().toTypedArray())
    val black = mutableSetOf<Int>()
    val gray = mutableSetOf<Int>()
    while (white.isNotEmpty()) {
        if (dfs(white.first(), white, gray, black)) {
            return true
        }
    }
    return false
}

fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
    if (numCourses < 1) return intArrayOf()
    val g = DirectedGraph(numCourses)
    for (e in prerequisites) {
        g.addEdge(e[1], e[0])
    }
    val queue = LinkedList<Int>()
    val order = LinkedList<Int>()
    val inDegree = IntArray(numCourses)
    for (v in 0 until numCourses) {
        if (g.indegree(v) == 0) queue.add(v)
        inDegree[v] = g.indegree(v)
    }

    while (queue.isNotEmpty()) {
        val v = queue.pop()
        for (n in g.adj(v)) {
            inDegree[n] -= 1
            if (inDegree[n] == 0) {
                queue.add(n)
            }
        }
        order.add(v)
    }
    return if (order.size < numCourses) intArrayOf() else order.toIntArray()
}
