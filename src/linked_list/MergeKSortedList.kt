package linked_list

import java.util.Arrays
import java.util.ListResourceBundle

data class PrioQue(val data: Int?, val position: Int, val next: ListNode?)

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    if (lists.isEmpty())return null
    val pq = arrayOfNulls<PrioQue>(lists.size)
    val capacity = lists.size
    var size = 0

    fun swap(i: Int, j: Int){
        val temp = pq[i]
        pq[i] = pq[j]
        pq[j] = temp
    }

    fun insert(ele: PrioQue){
        if (size == 0){
            pq[size++] = ele
            return
        }
        pq[size] = ele
        var k = size
        while (k > 0){
            val indx = (k-1)/2
            if ((pq[k]?.data ?: 0) < (pq[indx]?.data ?: 0)){
                swap(k, indx)
            }
            k = indx
        }
        size++
    }

    fun precolateDown(indx: Int){
        var larg = indx
        var left = 2 * indx + 1
        if (left <= size && (pq[left]?.data ?: 0) < (pq[larg]?.data ?: 0)){
            larg = left
        }
        var right = 2 * indx + 2
        if (right <= size && (pq[right]?.data ?: 0) < (pq[larg]?.data ?: 0)){
            larg = right
        }
        if (larg != indx){
            swap(larg, indx)
            precolateDown(larg)
        }
    }

    fun pop(): PrioQue?{
        if (size == 1){
            val temp = pq[0]
            size = 0
            return temp
        }
        val temp = pq[0]
        pq[0] = pq[size-1]
        size--
        precolateDown(0)
        return temp
    }
    for (i in 0 until capacity){
        if (lists[i] == null)continue
        insert(PrioQue(lists[i]?.`val`, i, lists[i]?.next))
    }
    if (pq.size == 0)return null
    var resList: ListNode? = null
    var tail : ListNode? = null
    while (size > 0){
        var pqTemp = pop()
        if (pqTemp!= null){
            if (resList == null){
                resList = pqTemp.data?.let { ListNode(it) }
                tail = resList
            }
            else {
                tail?.next = pqTemp.data?.let { ListNode(it) }
                tail = tail?.next
            }
            if (pqTemp.next != null)insert(PrioQue(pqTemp.next?.`val`, -1, pqTemp.next?.next))
        }
    }
    return resList
}

fun main(){
    val l1 = ListNode(1)
    var l2 = ListNode(4)
    var l3 = ListNode(5)

    val l4 = ListNode(1)
    val l5 = ListNode(3)
    val l6 = ListNode(4)

    val l7 = ListNode(2)
    val l8 = ListNode(6)

    l1.next = l2
    l2.next = l3

    l4.next = l5
    l5.next = l6

    l7.next = l8

    var res = mergeKLists(arrayOf(l1, l4, l7))

    while (res != null){
        println(res.`val`)
        res = res.next
    }
}