package zhewuzhou.me.leetcode40

fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
    if (k == 1) return head
    val length = listNodeLength(head)
    if (k > length) return head
    var kRangeStart = head
    var start = nthEleInList(head, k)
    var preStartEnd: Pair<ListNode?, ListNode?>? = null
    var kRangeEndOneMore = nthEleInList(head, k + 1)
    var kTimes = k
    while (kTimes <= length) {
        val currentStartEnd = reverse(kRangeStart, k)
        when (preStartEnd == null) {
            true -> preStartEnd = currentStartEnd
            false -> {
                preStartEnd.second?.next = currentStartEnd.first
                preStartEnd = currentStartEnd
            }
        }
        when (kTimes + k > length) {
            true -> {
                currentStartEnd.second?.next = kRangeEndOneMore
                kTimes = length + 1
            }
            false -> {
                kRangeStart = kRangeEndOneMore
                kRangeEndOneMore = nthEleInList(kRangeEndOneMore, k + 1)
                kTimes += k
            }
        }

    }
    return start
}

fun listNodeLength(head: ListNode?): Int {
    var nh = head
    var length = 1
    while (nh?.next != null) {
        nh = nh.next
        length += 1
    }
    return length
}

fun reverse(head: ListNode?, k: Int): Pair<ListNode?, ListNode?> {
    val start = nthEleInList(head, k)
    var pointer = start
    var swapTimes = 1
    while (swapTimes < k) {
        val prePointer = nthEleInList(head, k - swapTimes)
        pointer?.next = prePointer
        pointer = prePointer
        swapTimes += 1
    }
    return Pair(start, head)
}

fun nthEleInList(head: ListNode?, n: Int): ListNode? {
    var i = 1
    var nth = head
    while (i < n) {
        nth = nth?.next
        i += 1
    }
    return nth
}
