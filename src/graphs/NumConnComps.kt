package graphs

class NumConnComps {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        var num = n
        val parent = IntArray(n){i -> i}
        val rank = IntArray(n){1}
        fun find(i: Int): Int{
            if(parent[i] != i){
                parent[i] = find(parent[i])
            }
            return parent[i]
        }
        fun union(i: Int, j: Int){
            val pI = find(i)
            val pJ = find(j)
            if(pI == pJ){
                return
            }
            if(rank[pI] > rank[pJ])parent[pJ] = pI
            if(rank[pJ] > rank[pJ])parent[pI] = pJ
            else{
                parent[pI] = pJ
                rank[pI] += 1
            }
            num -= 1
        }
        for(e in edges){
            union(e[0], e[1])
        }
        return num
    }
}