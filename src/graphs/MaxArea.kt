package graphs

class MaxArea {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        val R = grid.size
        val C = grid[0].size
        val dir = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(0, -1))
        fun dfsFind(i: Int, j: Int): Int{
            if (i >= 0 && j >= 0 && i < R && j < C && grid[i][j] == 1){
                grid[i][j] = 0
                var res = 1
                for (d in dir){
                    res += dfsFind(i+d[0], j+d[1])
                }
                return res
            }else{
                return 0
            }
        }
        var max = 0
        for (i in grid.indices){
            for (j in grid[0].indices){
                if (grid[i][j] == 1) max = max.coerceAtLeast(dfsFind(i, j))
            }
        }
        return max
    }
}

fun main(){
    val grid = arrayOf(
        intArrayOf(0,0,1,0,0,0,0,1,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,1,1,1,0,0,0),
        intArrayOf(0,1,1,0,1,0,0,0,0,0,0,0,0),
        intArrayOf(0,1,0,0,1,1,0,0,1,0,1,0,0),
        intArrayOf(0,1,0,0,1,1,0,0,1,1,1,0,0),
        intArrayOf(0,0,0,0,0,0,0,0,0,0,1,0,0),
        intArrayOf(0,0,0,0,0,0,0,1,1,1,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,1,1,0,0,0,0)
    )
    val m = MaxArea()
    println(m.maxAreaOfIsland(grid))
}