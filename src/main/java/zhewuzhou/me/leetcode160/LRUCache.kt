package zhewuzhou.me.leetcode160


class LRUCache(capacity: Int) {
    internal val cap = capacity
    internal val head = Node(1, 1)
    internal val tail = Node(1, 1)
    private val cache = mutableMapOf<Int, Node>()

    init {
        head.next = tail
        tail.pre = head
    }

    fun get(key: Int): Int {
        if (cache.containsKey(key)) {
            val node = cache[key]!!
            deleteNode(node)
            addToHead(node)
            return node.value
        }
        return -1
    }

    fun put(key: Int, value: Int) {
        if (cache.containsKey(key)) {
            val node = cache[key]!!
            node.value = value
            deleteNode(node)
            addToHead(node)
        } else {
            val node = Node(key, value)
            if (cache.size == cap) {
                cache.remove(tail.pre?.key)
                deleteNode(tail.pre)
            }
            addToHead(node)
            cache[key] = node
        }
    }

    private fun deleteNode(node: Node?) {
        node?.pre?.next = node?.next
        node?.next?.pre = node?.pre
    }

    private fun addToHead(node: Node) {
        head.next?.pre = node
        node.next = head.next
        node.pre = head
        head.next = node
    }

    inner class Node(val key: Int, var value: Int) {
        var pre: Node? = null
        var next: Node? = null
    }
}
