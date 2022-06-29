package linked_list

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null)return list2
    if (list2 == null)return list1
    var l1 = list1
    var l2 = list2
    var newHead: ListNode? = null
    var tail: ListNode? = null
    while (l1 != null || l2 != null){
        var listVal: ListNode? = null
        if (compareValues(l1?.`val` , l2?.`val`) > 0){
            listVal = l1?.`val`?.let{ListNode(it)}
            l1 = l1?.next
        }else{
            listVal = l2?.`val`?.let{ListNode(it)}
            l2 = l2?.next
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
    return newHead
}