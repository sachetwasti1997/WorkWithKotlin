package graphs

import java.util.*

class RottenOranges {
    data class pos(val i: Int, val j: Int, val time: Int)
    fun orangesRotting(grid: Array<IntArray>): Int {
        val r = grid.size
        val c = grid[0].size
        val que = LinkedList<pos>()
        var oneCount = 0
        val newGrid = grid.clone()
        for(i in 0 until r){
            for(j in 0 until c){
                if(grid[i][j] == 2){
                    newGrid[i][j] = 0
                    que.add(pos(i, j, 0))
                }
                else if(grid[i][j] == 1){
                    newGrid[i][j] = Int.MAX_VALUE
                    oneCount++
                }
            }
        }
        val dir = arrayOf(intArrayOf(1, 0),intArrayOf(0, 1),intArrayOf(0, -1),intArrayOf(-1, 0))
        var maxTime = 0
        while(!que.isEmpty()){
            val t = que.removeFirst()
            for(d in dir){
                val row = t.i + d[0]
                val col = t.j + d[1]
                if(row >=0 && col >= 0 && row < r && col < c && newGrid[row][col] > t.time + 1){
                    newGrid[row][col] = t.time+1
                    oneCount --
                    maxTime = maxTime.coerceAtLeast(t.time + 1)
                    que.add(pos(row, col, t.time + 1))
                }
            }
        }
        newGrid.forEach{
            println(it.contentToString())
        }
        return if(oneCount == 0)maxTime else -1
    }
}

fun main(){
    val grid = arrayOf(
        intArrayOf(0, 2),
//        intArrayOf(1, 1, 0),
//        intArrayOf(1, 0, 1)
    )
    val r = RottenOranges()
    println(r.orangesRotting(grid))
}