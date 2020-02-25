package zhewuzhou.me.leetcode40

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    return when (val l = lists.size) {
        0 -> null
        1 -> lists[0]
        2 -> mergeTwoLists(lists[0], lists[1])
        else -> {
            mergeTwoLists(
                mergeKLists(lists.copyOfRange(0, l / 2)),
                mergeKLists(lists.copyOfRange(l / 2, l)))
        }
    }
}
