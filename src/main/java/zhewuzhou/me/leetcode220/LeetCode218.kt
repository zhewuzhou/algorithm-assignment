package zhewuzhou.me.leetcode220

import java.util.*


fun getSkyline(buildings: Array<IntArray>): List<List<Int>> {
    val points = TreeMap<Int, MutableList<IntArray>>()
    for (building in buildings) {
        points.putIfAbsent(building[0], mutableListOf())
        points.putIfAbsent(building[1], mutableListOf())
        points[building[0]]!!.add(building)
        points[building[1]]!!.add(building)
    }
    val sweepLine = PriorityQueue<IntArray> { x, y -> y[2].compareTo(x[2]) }
    val res = mutableListOf<List<Int>>()
    for ((criticalX, building) in points) {
        for (b in building) {
            if (criticalX == b[0]) {
                sweepLine.add(b)
            } else {
                sweepLine.remove(b)
            }
        }
        if (sweepLine.isEmpty()) {
            res.add(listOf(criticalX, 0))
        } else {
            val h = sweepLine.peek()[2]
            if (res.isEmpty() || res.last()[1] != h) {
                res.add(listOf(criticalX, h))
            }
        }
    }
    return res
}
