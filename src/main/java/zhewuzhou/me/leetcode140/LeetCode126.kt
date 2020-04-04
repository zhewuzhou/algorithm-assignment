package zhewuzhou.me.leetcode140

import java.util.*


fun findLaddersCur(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
    if (beginWord.isEmpty() ||
        endWord.isEmpty() ||
        wordList.isEmpty() ||
        !wordList.contains(endWord)) return listOf()
    val res = mutableListOf<List<String>>()
    doFindLadders(res, mutableListOf(beginWord), wordList, endWord, listOf())
    return res
}

fun findLadders(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
    val wordSet: MutableSet<String> = HashSet(wordList)
    if (!wordSet.contains(endWord)) return ArrayList()
    var layer = mutableMapOf(
        beginWord to mutableListOf(mutableListOf(beginWord))
    )
    while (layer.isNotEmpty()) {
        val newLayer = mutableMapOf<String, MutableList<MutableList<String>>>()
        for (word in layer.keys) {
            if (word == endWord) {
                return layer[word]!!
            }
            for (i in word.indices) {
                for (c in 'a'..'z') {
                    val newWord = word.substring(0, i) + c + word.substring(i + 1)
                    if (!wordSet.contains(newWord)) continue
                    if (!newLayer.containsKey(newWord)) {
                        newLayer[newWord] = mutableListOf()
                    }
                    for (list in layer[word]!!) {
                        val newList = mutableListOf(*list.toTypedArray())
                        newList.add(newWord)
                        newLayer[newWord]!!.add(newList)
                    }
                }
            }
        }
        layer = newLayer
        for (str in newLayer.keys) {
            wordSet.remove(str)
        }
    }
    return ArrayList()
}

fun findLaddersNotWorks(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
    if (beginWord.isEmpty() ||
        endWord.isEmpty() ||
        wordList.isEmpty() ||
        !wordList.contains(endWord)) return listOf()
    val dict = wordList.toSet()
    val startQueue = LinkedList<String>()
    val from = mutableMapOf(
        beginWord to ""
    )
    startQueue.add(beginWord)
    val endQueue = LinkedList<String>()
    val to = mutableMapOf(
        endWord to ""
    )
    endQueue.add(endWord)
    val res = mutableSetOf<List<String>>()
    val pre = mutableListOf<String>()
    var level = 0
    var shortest = Int.MAX_VALUE
    while (startQueue.isNotEmpty() || endQueue.isNotEmpty()) {
        level += 1
        val middle = getMiddle(from, to, pre)
        if (middle.isNotEmpty()) {
            shortest = getShortestPaths(middle, from, to, res)
        }
        if (level + 1 > shortest) {
            break
        }
        travelNextLevel(startQueue, dict, from)
        travelNextLevel(endQueue, dict, to)
        pre.addAll(middle)
    }
    return res.toList()
}

private fun getMiddle(from: MutableMap<String, String>, to: MutableMap<String, String>, pre: List<String>): List<String> {
    return from.keys.filter { to.containsKey(it) && !pre.contains(it) }
}

private fun getShortestPaths(middle: List<String>,
                             from: MutableMap<String, String>,
                             to: MutableMap<String, String>,
                             res: MutableSet<List<String>>): Int {
    var shortest = Int.MAX_VALUE
    middle.forEach {
        val p = calculatePath(it, from, to)
        if (p.size < shortest) shortest = p.size
        res.add(p)
    }
    res.removeIf { it.size > shortest }
    return shortest
}

fun calculatePath(mid: String, from: Map<String, String>, to: Map<String, String>): List<String> {
    val path = mutableListOf(mid)
    var cur = from[mid]
    while (cur != null && cur.isNotEmpty()) {
        path.add(cur)
        cur = from[cur]
    }
    path.reverse()
    cur = to[mid]
    while (cur != null && cur.isNotEmpty()) {
        path.add(cur)
        cur = to[cur]
    }
    return path
}

private fun travelNextLevel(curLevel: LinkedList<String>, dict: Set<String>, path: MutableMap<String, String>) {
    val nextLevel = mutableListOf<String>()
    while (curLevel.isNotEmpty()) {
        val cur = curLevel.pop()
        val neighbours = nextLevel(cur, dict, path.keys)
        neighbours.forEach {
            path[it] = cur
        }
        nextLevel.addAll(neighbours)
    }
    curLevel.addAll(nextLevel)
}

fun nextLevel(cur: String, wordList: Set<String>, path: Set<String>): List<String> {
    val res = mutableListOf<String>()
    val p = cur.toCharArray()
    for (i in cur.indices) {
        for (c in 'a'..'z') {
            if (p[i] == c) continue
            val old = p[i]
            p[i] = c
            val ps = p.joinToString("")
            if (wordList.contains(ps) && !path.contains(ps)) {
                res.add(ps)
            }
            p[i] = old
        }
    }
    return res
}

private fun doFindLadders(res: MutableList<List<String>>,
                          comb: MutableList<String>,
                          wordList: List<String>,
                          endWord: String,
                          curShortest: List<String>) {
    if (comb.isNotEmpty() && comb.last() == endWord) {
        if (curShortest.isEmpty() || curShortest.size >= comb.size) {
            res.add(listOf(*comb.toTypedArray()))
            res.removeIf { it.size > comb.size }
        }
    } else {
        val possibles =
            if (comb.isNotEmpty() && curShortest.isNotEmpty() && comb.size >= curShortest.size)
                listOf()
            else if (oneCharDiff(comb.last(), endWord))
                listOf(endWord)
            else wordList
                .filter { oneCharDiff(comb.last(), it) && !comb.contains(it) }
        for (s in possibles) {
            comb.add(s)
            val shortest = if (res.isNotEmpty()) res[0] else listOf()
            doFindLadders(res, comb, wordList, endWord, shortest)
            comb.removeAt(comb.lastIndex)
        }
    }
}

private fun oneCharDiff(cur: String, target: String): Boolean =
    cur.mapIndexed { index, v -> target[index] == v }.filter { !it }.size == 1
