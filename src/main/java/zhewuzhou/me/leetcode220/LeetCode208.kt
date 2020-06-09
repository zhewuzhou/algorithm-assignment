package zhewuzhou.me.leetcode220

class Trie() {
    private data class TrieNode(val value: Char) {
        val children: Array<TrieNode?> = Array(26) { null }
        var isWord: Boolean = false
    }

    private val root = TrieNode(' ')

    fun insert(word: String) {
        var cur = root
        for (c in word) {
            if (cur.children[c - 'a'] != null) {
                cur = cur.children[c - 'a']!!
            } else {
                val t = TrieNode(c)
                cur.children[c - 'a'] = t
                cur = t
            }
        }
        cur.isWord = true
    }

    fun search(word: String): Boolean {
        val node = findNode(word)
        return node?.isWord ?: false
    }

    fun startsWith(prefix: String): Boolean {
        return findNode(prefix) != null
    }

    private fun findNode(prefix: String): TrieNode? {
        var cur: TrieNode = root
        for (c in prefix) {
            if (cur.children[c - 'a'] == null) {
                return null
            } else {
                cur = cur.children[c - 'a']!!
            }
        }
        return cur
    }
}
