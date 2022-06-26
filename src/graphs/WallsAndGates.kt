package graphs

import java.util.*

class WallsAndGates {
    data class Pos(val i: Int, val j: Int, val time: Int)
    fun wallsAndGates(rooms: Array<IntArray>): Unit {
        val r = rooms.size
        val c = rooms[0].size
        val que = LinkedList<Pos>()
        for(i in 0 until r){
            for(j in 0 until c){
                if(rooms[i][j] == 0)que.add(Pos(i, j, 0))
            }
        }
        val dir = arrayOf(intArrayOf(0,1),intArrayOf(1,0),intArrayOf(-1,0),intArrayOf(0,-1))
        while(!que.isEmpty()){
            val t = que.removeFirst()
            for(d in dir){
                val row = d[0]+t.i
                val col = d[1]+t.j
                if(row >= 0 && col >= 0 && row < r && col < c && rooms[row][col] > t.time + 1){
                    rooms[row][col] = t.time + 1
                    que.add(Pos(row, col, t.time + 1))
                }
            }
        }
    }
}

fun main(){
    val rooms = arrayOf(
        intArrayOf(Int.MAX_VALUE, -1, 0, Int.MAX_VALUE),
        intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE, Int.MAX_VALUE, -1),
        intArrayOf(Int.MAX_VALUE, -1, Int.MAX_VALUE, -1),
        intArrayOf(0, -1, Int.MAX_VALUE, Int.MAX_VALUE)
    )
    val w = WallsAndGates()
    println(w.wallsAndGates(rooms))
    rooms.forEach{
        println(it.contentToString())
    }
}