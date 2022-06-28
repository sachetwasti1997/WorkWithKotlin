package graphs

import java.util.LinkedList

class CloneGraph {
    fun cloneGraph(node: Node?): Node? {
        if (node == null)return null
        val visited = HashMap<Int?, Node?>()
        var que = LinkedList<Node?>()
        que.add(node)
        while (!que.isEmpty()){
            val temp = que.poll()
            if (visited[temp?.`val`] == null)visited[temp?.`val`] = temp?.`val`?.let { Node(it) }
            for (i in temp?.neighbors.orEmpty()){
                if (visited[i?.`val`] == null) {
                    val n = i?.`val`?.let { Node(it) }
                    visited[i?.`val`] = n
                    que.add(i)
                }
                visited[temp?.`val`]?.neighbors?.add(visited[i?.`val`])
            }
        }
        return visited[node.`val`]
    }
}

fun main(){
    var n1 = Node(1)
    var n2 = Node(2)
    var n3 = Node(3)
    var n4 = Node(4)
    n1.neighbors.add(n2)
    n1.neighbors.add(n4)
    n2.neighbors.add(n1)
    n2.neighbors.add(n3)
    n3.neighbors.add(n4)
    n3.neighbors.add(n2)
    n4.neighbors.add(n1)
    n4.neighbors.add(n3)
    val c = CloneGraph()
    val n = c.cloneGraph(n1)
    println(n)
}