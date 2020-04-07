package zhewuzhou.me.leetcode140

fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
    val totalStations = gas.size
    if (gas.sum() < cost.sum()) return -1
    if (gas.size == 1) return 0
    val startStation = gas.mapIndexed { index, v -> Pair(index, v) }
        .associateBy { it.first }
        .mapValues { it.value.second }
        .filter { it.value > cost[it.key] }
        .toMutableMap()
    while (startStation.isNotEmpty()) {
        val start = startStation.maxBy { it.value - cost[it.key] }!!.key
        var next = (start + 1) % totalStations
        var remaining = gas[start] - cost[start] + gas[next]
        while (next != start) {
            remaining -= cost[next]
            next = (next + 1) % totalStations
            if (remaining < 0) break
            else if (remaining >= 0 && next == start) {
                return start
            }
            remaining += gas[next]
        }
        startStation.remove(start)
    }
    return -1
}
