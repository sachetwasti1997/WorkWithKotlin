package linked_list

data class Node(var `val`: Int, var next: Node? = null, var random: Node? = null)

fun copyRandomList(node: Node?): Node? {
    if (node == null)return null
    val nodeMap = HashMap<Node, Node>()
    var head = node
    while (head != null){
        nodeMap[head] = Node(head.`val`)
        head = head.next
    }
    head = node
    while (head != null){
        nodeMap[head]?.random = nodeMap[head.random]
        nodeMap[head]?.next = nodeMap[head.next]
        head = head.next
    }
    return nodeMap[node]
}

fun main(){}
