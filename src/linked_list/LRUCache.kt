package linked_list

class LRUCache(var capacity: Int) {

    class LRU(val key: Int, var data: Int, var next: LRU? = null, var prev: LRU ?= null)

    private val mapNode = HashMap<Int, LRU>(capacity);
    var head: LRU ?= null
    private var tail: LRU ?= null
    private var size = 0

    private fun moveToTop(node: LRU?){
        if (node == head)return
        if (node == tail){
            tail = tail?.prev
            tail?.next = node?.next
            node?.next = head
            head?.prev = node
            head = node
            return
        }
        node?.prev?.next = node?.next
        node?.next?.prev = node?.prev
        node?.prev = null
        node?.next = head
        head?.prev = node
        head = node
    }

    fun get(key: Int): Int? {
        if (mapNode[key] == null)return -1
        val h = mapNode[key]
        moveToTop(h)
        return h?.data
    }

    fun put(key: Int, value: Int) {
        if (mapNode[key] != null){
            mapNode[key]?.data = value
            moveToTop(mapNode[key])
            return
        }
        mapNode[key] = LRU(key, value)
        if (head == null){
            head = mapNode[key]
            tail = head
            size++
            return
        }
        if (capacity == 1){
            mapNode.remove(head?.key)
            head = mapNode[key]
            tail = head
            return
        }
        if (size == capacity){
            mapNode.remove(tail?.key)
            tail = tail?.prev
            tail?.next = null
        }else{
            size++
        }
        val newHead = mapNode[key]
        newHead?.next = head
        head?.prev = newHead
        head = newHead
    }

}

fun main(){
    val l = LRUCache(1)
//    l.put(1, 1)
//    println(l.head)
    l.put(2, 1)
//    println(l.head)
    println(l.get(2))
//    println(l.head)
    l.put(3, 2)
//    println(l.head)
    println(l.get(2))
//    println(l.head)
//    l.put(4, 4)
//    println(l.head)
//    println(l.get(1))
//    println(l.head)
    println(l.get(3))
//    println(l.head)
//    println(l.get(4))
//    println(l.head)
}