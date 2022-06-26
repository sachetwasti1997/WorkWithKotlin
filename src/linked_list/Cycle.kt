package linked_list

fun hasCycle(head: ListNode?): Boolean {
    var pointer = head
    var fast = head
    while (fast != null && fast.next != null){
        pointer = pointer?.next
        fast = fast.next?.next
        if (pointer == fast)return true
    }
    return false
}