package graphs

class GraphValidTree {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        if(n == 1)return true
        val parent = IntArray(n){i -> i}
        val rank = IntArray(n){1}
        var count = n
        fun find(i: Int): Int{
            if(i != parent[i])parent[i] = find(parent[i])
            return parent[i]
        }
        fun union(i: Int, j: Int): Boolean{
            val pi = find(i)
            val pj = find(j)
            if(pi == pj)return false
            if(rank[pi] > rank[pj])parent[pj] = pi
            else if(rank[pi] < rank[pj])parent[pi] =pj
            else{
                rank[pi] += 1
                parent[pj] = pi
            }
            count --
            return true
        }
        for(i in edges){
            if(!union(i[0], i[1]))return false
        }
        return count == 1
    }
}