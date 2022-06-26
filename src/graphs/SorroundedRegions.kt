package graphs

class SorroundedRegions {
    fun solve(board: Array<CharArray>): Unit {
        val r = board.size
        val c = board[0].size
        val dir = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(0, -1))

        fun mrkUnSorrounded(i: Int, j: Int){
            if (i >= 0 && j >= 0 && i < r && j < c && board[i][j] == 'O'){
                board[i][j] = 'T'
                for(d in dir){
                    mrkUnSorrounded(i+d[0], j+d[1])
                }
            }
        }

        for(i in 0 until r){
            for(j in 0 until c){
                if((i == 0 || j == 0 || i == r-1 || j == c-1) && board[i][j] == 'O')mrkUnSorrounded(i, j)
            }
        }

        for(i in 0 until r){
            for(j in 0 until c){
                if(board[i][j] == 'O')board[i][j] = 'X'
                else if(board[i][j] == 'T')board[i][j] = 'O'
            }
        }
    }
}