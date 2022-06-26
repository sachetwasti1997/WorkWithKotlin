package linked_list

fun reorderList(head: ListNode?){
    if (head == null)return
    if (head.next == null)return
    fun reverseList(head: ListNode?): ListNode?{
        var prev: ListNode? = null
        var current = head
        var next = current?.next
        while (next != null){
            current?.next = prev
            prev = current
            current = next
            next = next.next
        }
        current?.next = prev
        return current
    }

    var prev: ListNode? = null
    var current: ListNode? = head
    var fast = head
    while (fast?.next != null){
        prev = current
        current = current?.next
        fast = fast.next?.next
    }
    prev?.next = null
    var revHead: ListNode? = reverseList(current)
    if (current == null)return
    var l1 = head.next
    var tail = head
    var isHead = false
    while (l1 != null && revHead != null){
        if (isHead){
            tail?.next = l1
            isHead = false
            l1 = l1.next
        }else{
            tail?.next = ListNode(revHead.`val`)
            isHead = true
            revHead = revHead.next
        }
        tail = tail?.next
    }
    if (l1 != null){
        tail?.next = l1
    }
    if (revHead != null){
        tail?.next = revHead
    }
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