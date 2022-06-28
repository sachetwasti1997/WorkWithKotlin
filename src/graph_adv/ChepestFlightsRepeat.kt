package graph_adv

class ChepestFlightsRepeat {
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int? {
        var disMap = HashMap<Int, Int?>()
        for(i in 0 until n)disMap[i] = Int.MAX_VALUE
        disMap[src] = 0
        for(i in 0 .. k){
            val tempMap = disMap.toMutableMap()
            for(j in flights){
                if(disMap[j[0]] == Int.MAX_VALUE)continue
                if(compareValues(disMap[j[0]]?.plus(j[2]), tempMap[j[1]]) < 1)
                    tempMap[j[1]] = disMap[j[0]]?.plus(j[2])
            }
            disMap = tempMap.toMutableMap() as HashMap<Int, Int?>
        }
        return disMap[dst]
    }
}

fun main(){
    val k = ChepestFlightsRepeat()
    val graph = arrayOf(intArrayOf(0,1,100),intArrayOf(1,2,100),intArrayOf(2,0,100),intArrayOf(1,3,600))
    println(k.findCheapestPrice(4, graph, 0, 3, 1))
}