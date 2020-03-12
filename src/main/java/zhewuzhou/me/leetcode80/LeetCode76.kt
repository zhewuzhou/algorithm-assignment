package zhewuzhou.me.leetcode80

import java.util.*

fun minWindow(src: String, t: String): String {
    if (t.length > src.length) return ""
    val target = t.associate { key -> Pair(key, t.count { it == key }) }.toMap()
    val count = mutableMapOf<Char, Int>()
    val queue = LinkedList<Char>()
    var res = "$src "
    for (i in src.indices) {
        if (count.isNotEmpty() || (count.isEmpty() && t.contains(src[i]))) {
            queue.add(src[i])
        }
        if (t.contains(src[i])) {
            count[src[i]] = (count[src[i]] ?: 0) + 1
            if (target.all { (count[it.key] ?: 0) >= it.value }) {
                res = if (res.length > queue.size) queue.joinToString("") else res
                val first = queue.pop()!!
                count[first] = (count[first]!! - 1)
                while ((queue.isNotEmpty()) &&
                    (!t.contains(queue.peek()) ||
                        (t.contains(queue.peek()) && count[queue.peek()]!! > target[queue.peek()]!!) ||
                        (target.all { (count[it.key] ?: 0) >= it.value } && queue.size >= res.length))) {
                    if (t.contains(queue.peek())) {
                        count[queue.peek()] = count[queue.peek()]!! - 1
                    }
                    queue.pop()
                }
                if (target.all { (count[it.key] ?: 0) >= it.value } && queue.size < res.length) {
                    res = queue.joinToString("")
                }
            }
        }
    }
    return if (res.length > src.length) "" else res
}
