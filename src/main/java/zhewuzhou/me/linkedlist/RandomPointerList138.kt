package zhewuzhou.me.linkedlist

class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}

fun copyRandomList(node: Node?): Node? {
    if (node == null) return null

    var head = node
    while (head != null) {
        val copy = Node(head.`val`)
        val next = head.next
        head.next = copy
        copy.next = next
        head = next
    }

    var pre = node
    var cp = pre.next
    while (cp != null) {
        cp.random = pre?.random?.next
        pre = cp.next
        cp = cp.next?.next
    }

    var preAgain = node
    var cpAgain = node.next
    val result = node.next
    while (cpAgain != null) {
        preAgain?.next = cpAgain.next
        preAgain = preAgain?.next
        cpAgain.next = cpAgain.next?.next
        cpAgain = cpAgain.next
    }
    return result
}
