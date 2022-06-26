package graphs

class PacificAtlantic {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val r = heights.size
        val c = heights[0].size
        val pacific = Array(r){BooleanArray(c){false}}
        val atlantic = Array(r){BooleanArray(c){false}}

        val dir = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(0, -1))
        fun markArrays(i: Int, j: Int, prev: Int, ocean: Array<BooleanArray>){
            if (i >= 0 && j >= 0 && i < r && j < c && prev <= heights[i][j] && !ocean[i][j]){
                ocean[i][j] = true
                for (d in dir)markArrays(i+d[0], j+d[1], heights[i][j], ocean)
            }
        }

        for (i in 0 until r) {
            markArrays(i, 0, Int.MIN_VALUE, pacific)
            markArrays(i, c-1, Int.MIN_VALUE, atlantic)
        }

        for (i in 0 until c){
            markArrays(0, i, Int.MIN_VALUE, pacific)
            markArrays(r-1, i, Int.MIN_VALUE, atlantic)
        }
        val resList = mutableListOf<ArrayList<Int>>()
        for (i in heights.indices){
            for (j in heights[0].indices){
                if (pacific[i][j] && atlantic[i][j])resList.add(arrayListOf(i, j))
            }
        }
        return resList
    }
}

fun main(){
    val p = PacificAtlantic()
    val grid = arrayOf(
        intArrayOf(1,2,2,3,5),
        intArrayOf(3,2,3,4,4),
        intArrayOf(2,4,5,3,1),
        intArrayOf(6,7,1,4,5),
        intArrayOf(5,1,1,2,4)
    )
    println(p.pacificAtlantic(grid))
}