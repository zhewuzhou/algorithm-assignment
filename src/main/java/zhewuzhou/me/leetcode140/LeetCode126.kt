package zhewuzhou.me.leetcode140

fun findLadders(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
    if (beginWord.isEmpty() ||
        endWord.isEmpty() ||
        wordList.isEmpty() ||
        !wordList.contains(endWord)) return listOf()
    val res = mutableListOf<List<String>>()
    doFindLadders(res, mutableListOf(beginWord), wordList, endWord, listOf())
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
