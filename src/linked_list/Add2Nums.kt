package linked_list

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null)return l2
    if (l2 == null)return l1
    var res = l1.`val` + l2.`val`
    var rl1 = l1
    var rl2 = l2
    var carry = res / 10
    var resHead: ListNode? = ListNode(res%10)
    val result = resHead
    rl1 = rl1.next
    rl2 = rl2.next
    while (rl1 != null && rl2 != null){
        res = rl1.`val` + rl2.`val`+carry
        carry = res / 10
        res %= 10
        resHead?.next = ListNode(res)
        rl1 = rl1.next
        rl2 = rl2.next
        resHead = resHead?.next
        // error is thrown here if type for resHead is not defined
        //it's because of it being var (not guaranteed to be not-null after the assignment)
        //but resHead is not-null
    }
    while (rl1 != null){
        res = rl1.`val` + carry
        carry = res / 10
        res %= 10
        resHead?.next = ListNode(res)
        resHead = resHead?.next
        rl1 = rl1.next
    }
    while (rl2 != null){
        res = rl2.`val` + carry
        carry = res / 10
        res %= 10
        resHead?.next = ListNode(res)
        resHead = resHead?.next
        rl2 = rl2.next
    }
    if(carry == 1){
        resHead?.next = ListNode(1)
    }
    return result
}