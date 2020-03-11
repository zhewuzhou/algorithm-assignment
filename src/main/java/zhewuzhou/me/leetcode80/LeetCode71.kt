package zhewuzhou.me.leetcode80

import java.util.*

fun simplifyPath(path: String): String {
    val folders = path.split("/").filter { it != "" && it != "." }
    var s = Stack<String>()
    for (i in folders.indices) {
        when (folders[i]) {
            ".." -> if (s.isNotEmpty()) s.pop()
            else -> s.push(folders[i])
        }
    }
    return "/" + s.toList().joinToString("/")
}
