package linked_list

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null)return list2
    if (list2 == null)return list1
    var l1 = list1
    var l2 = list2
    var newHead: ListNode? = null
    var tail: ListNode? = null
    while (l1 != null && l2 != null){
        var listVal: ListNode? = null
        if (l1.`val` < l2.`val`){
            listVal = ListNode(l1.`val`)
            l1 = l1.next
        }else{
            listVal = ListNode(l2.`val`)
            l2 = l2.next
        }
        if (newHead == null){
            newHead = listVal
            tail = newHead
        }
        else {
            tail?.next = listVal
            tail = tail?.next
        }
    }
    while (l1 != null){
        tail?.next = l1
        l1 = l1.next
        tail = tail?.next
    }
    while (l2 != null){
        tail?.next = l2
        l2 = l2.next
        tail = tail?.next
    }
    return newHead
}