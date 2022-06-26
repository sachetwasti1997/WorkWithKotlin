package graphs

import java.util.*

class RedundantConn {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val num = edges.size
        val parent = IntArray(num){i -> i}
        val rank = IntArray(num){1}

        fun find(i: Int): Int{
            if(parent[i] != i){
                parent[i] = find(parent[i])
            }
            return parent[i]
        }

        fun union(i: Int, j: Int): Boolean{
            val pI = find(i)
            val pJ = find(j)
            if(pI == pJ)return false
            if(rank[pI] < rank[pJ])parent[pI] = pJ
            else if(rank[pI] > rank[pJ])parent[pJ] = pI
            else{
                parent[pJ] = pI
                rank[pI] += 1
            }
            return true
        }

        for(i in edges)
            if(!union(i[0], i[1]))return intArrayOf(i[0], i[1])

        return IntArray(0)
    }
}

fun main(){
    val edgs = arrayOf(intArrayOf(1,2),intArrayOf(1,3),intArrayOf(2,3))
    val r = RedundantConn()
    println(r.findRedundantConnection(edgs))
}