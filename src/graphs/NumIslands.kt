package graphs

class NumIslands {
    fun numIslands(grid: Array<CharArray>): Int {
        var newGrid = grid
        val R = grid.size
        val C = grid[0].size
        val dir = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(0, -1))

        fun dfs(i: Int, j: Int){
            if (i >= 0 && j >= 0 && i < R && j < C){
                if (newGrid[i][j] == '0')return
                newGrid[i][j] = '0'
                for (d in dir){
                    dfs(i + d[0], j + d[1])
                }
            }
        }

        var comps = 0
        for (i in 0 until  R){
            for (j in 0 until C){
                if (newGrid[i][j] == '1'){
                    comps++
                    dfs(i, j)
                }
            }
        }

        return comps
    }
}