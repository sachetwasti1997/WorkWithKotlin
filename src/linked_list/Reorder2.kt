package linked_list

fun reorderList2(head: ListNode?){
    if (head?.next == null)return
    fun reverse(head: ListNode?): ListNode?{
        if (head?.next == null)return head
        var prev: ListNode? = null
        var slow = head
        var next = head.next
        while (next != null){
            slow?.next = prev
            prev = slow
            slow = next
            next = next.next
        }
        slow?.next = prev
        return slow
    }

    var prev:ListNode? = null
    var slow = head
    var fast = head
    while (fast?.next != null){
        prev = slow
        slow = slow?.next
        fast = fast.next?.next
    }
    slow = reverse(slow)
    prev?.next = null
    var l1 = head
    var tail = l1
    var isHead = false
    l1 = l1.next
    while (l1 != null && slow != null){
        if (isHead){
            tail?.next = l1
            isHead = false
            l1 = l1.next
        }else{
            tail?.next = slow
            isHead = true
            slow = slow?.next
        }
        tail = tail?.next
    }
    if (l1 != null)tail?.next = l1
    else if (slow != null)tail?.next = slow
}

fun main(){
    var l1 = ListNode(1)
    var l2 = ListNode(2)
    var l3 = ListNode(3)
    var l4 = ListNode(4)
    var l5 = ListNode(5)
    l1.next = l2
    l2.next = l3
    l3.next = l4
    l4.next = l5
    println(reorderList(l1))
    println(l1)
}