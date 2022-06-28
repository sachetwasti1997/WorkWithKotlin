package graphs

import java.util.*
import kotlin.collections.HashMap

class Cloning {
    fun cloneGraph(node: Node?): Node? {
        if(node == null)return null
        val nodeMap = HashMap<Int?, Node?>()
        val que = LinkedList<Node?>()
        que.add(node)
        while(!que.isEmpty()){
            val temp = que.removeFirst()
            if(nodeMap[temp?.`val`] == null) nodeMap[temp?.`val`] = temp?.`val`?.let{Node(it)}
            for(i in temp?.neighbors ?: ArrayList()){
                if(nodeMap[i?.`val`] == null){
                    val n = i?.`val`?.let{Node(it)}
                    nodeMap[i?.`val`] = n
                    que.add(i)
                }
                nodeMap[temp?.`val`]?.neighbors?.add(nodeMap[i?.`val`])
            }
        }
        return nodeMap[node.`val`]
    }
}