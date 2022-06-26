package linked_list

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    if (head == null)return head
    if (head.next == null){
        if (n >= 1)return null
    }
    var prev: ListNode? = null
    var newHead = head
    for (i in 0 until n){
       newHead = newHead?.next
    }
    while (newHead != null){
        prev = prev?.next ?: head
        newHead = newHead.next
    }
    prev?.next = prev?.next?.next
    return head
}

fun main(){
    val l1 = ListNode(1)
    val l2 = ListNode(2)
    val l3 = ListNode(3)
    val l4 = ListNode(4)
    val l5 = ListNode(5)
//    l1.next = l2
//    l2.next = l3
//    l3.next = l4
//    l4.next = l5
    println(removeNthFromEnd(l1, 1))
    println(l1)
}