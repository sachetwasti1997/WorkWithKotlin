package graph_adv

import java.util.*

class CheapestFlights {

    data class DesK(val src: Int, val des: Int, val k: Int, val dis: Int)

    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int? {
        val que = LinkedList<DesK>()
        val graph = HashMap<Int, ArrayList<DesK>>(n)
        val minDis = HashMap<Int, Int?>(n)
        for(i in flights){
            if(graph[i[0]] == null)graph[i[0]] = ArrayList()
            graph[i[0]]?.add(DesK(i[0], i[1], 0, i[2]))
            minDis[i[0]] = Int.MAX_VALUE
            minDis[i[1]] = Int.MAX_VALUE
        }
        for(i in graph[src] ?: ArrayList()){
            que.add(i)
            minDis[i.des] = i.dis;
        }
        minDis[src] = 0
        while(!que.isEmpty()){
            var temp = que.removeFirst();
//            if(temp.k >= k - 1)continue
            for(i in graph[temp.des] ?: ArrayList()){
                if((minDis[i.des] ?: 0) > (minDis[temp.des] ?: 0) + i.dis ){
                    minDis[i.des] = minDis[temp.des]?.plus(i.dis)
                    minDis[i.des]?.let { que.add(DesK(temp.src, i.des, temp.k + 1, it)) }
                }
            }
        }
        return if(minDis[dst] == Int.MAX_VALUE) -1 else minDis[dst]
    }

}

fun main(){
    val k = CheapestFlights()
    val graph = arrayOf(intArrayOf(0,1,1),intArrayOf(0,2,5),intArrayOf(1,2,1),intArrayOf(2,3,1))
    println(k.findCheapestPrice(4, graph, 0, 3, 1))
}