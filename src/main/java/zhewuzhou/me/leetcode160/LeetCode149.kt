package zhewuzhou.me.leetcode160

import java.util.*


internal data class Point(val x: Int, val y: Int) : Comparable<Point> {
    override fun compareTo(other: Point): Int {
        return if (x == other.x && y == other.y) {
            0
        } else {
            if (y < other.y || y == other.y && x < other.x) -1 else 1
        }
    }

    private fun slopeTo(other: Point): Double {
        return when {
            this.compareTo(other) == 0 -> {
                Double.NEGATIVE_INFINITY
            }
            x == other.x -> {
                Double.POSITIVE_INFINITY
            }
            else -> {
                val result = (other.y - y) * 1000.0 / (other.x - x)
                return if (result == -0.0) 0.0 else result
            }
        }
    }

    fun slopeOrder(): Comparator<Point> {
        return Comparator { p1, p2 ->
            java.lang.Double.compare(slopeTo(p1), slopeTo(p2))
        }
    }
}

fun maxPoints(points: Array<IntArray>): Int {
    if (points.isEmpty() || !points.all { it.size == 2 }) return 0
    if (points.size <= 2) return points.size
    val pointList = points.map { Point(it[0], it[1]) }
    val count = pointList.associateWith { pointList.count { item -> item == it } }
    val original = count.keys.toTypedArray()
    val pointsArray = count.keys.toTypedArray()
    Arrays.sort(pointsArray)
    var max = 0
    for (i in original.indices) {
        val slopeOrder = original[i].slopeOrder()
        Arrays.sort(pointsArray, slopeOrder)
        val maxPoint = maxPoints(pointsArray, slopeOrder, original[i], count)
        max = if (max < maxPoint) maxPoint else max
    }
    return max
}

private fun maxPoints(points: Array<Point>, slopOrder: Comparator<Point>, cur: Point, count: Map<Point, Int>): Int {
    if (points.size == 1) return count[points[0]] ?: error("Should have value in map")
    var result = 0
    var j = 1
    while (j < points.size) {
        val p = points[j++]
        var c = (count[cur] ?: error("Should have value in map")) + (count[p] ?: error("Should have value in map"))
        while (j < points.size && slopOrder.compare(p, points[j]) == 0) {
            c += count[points[j]] ?: error("Should have value in map")
            j += 1
        }

        if (result < c) {
            result = c
        }
    }
    return result
}


