package linked_list

fun reverseList(head: ListNode?): ListNode? {
    if (head == null)return null
    var prev: ListNode? = null
    var current = head
    var next = head.next
    while (next != null){
        current?.next = prev
        prev = current
        current = next
        next = next.next
    }
    current?.next = prev
    return current
}

fun main(){}