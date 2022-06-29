package linked_list

class CpyList {
    fun copyRandomList(node: Node?): Node? {
        if(node == null)return node
        var newNode = node
        while(newNode != null){
            val temp = newNode.next
            newNode.next = Node(newNode.`val`)
            newNode.next?.next = temp
            newNode = newNode.next?.next
        }
        newNode = node
        while(newNode != null){
            newNode.next?.random = newNode.random?.next
            newNode = newNode.next?.next
        }
        val head = node.next
        newNode = node
        while(newNode?.next != null){
            val temp = newNode.next
            newNode.next = newNode.next?.next
            newNode = temp
        }
        return head
    }
}