package linked_list

class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val head = ListNode(0)
        var p = l1
        var q = l2
        var cur: ListNode? = head
        var carry = 0
        while(p != null || q != null) {
            val x = p?.`val` ?: 0
            val y = q?.`val` ?: 0
            val total = x + y + carry
            carry = total / 10
            cur?.next = ListNode(total % 10)
            cur = cur?.next
            p = p?.next
            q = q?.next
        }
        if(carry > 0) cur?.next = ListNode(carry)
        return head.next
    }
}

fun main(){

}