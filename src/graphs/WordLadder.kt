package graphs

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class WordLadder {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val patternMap = HashMap<String, ArrayList<String>>()
        for(i in wordList){
            for(j in i.indices){
                val pattern = "${i.slice(IntRange(0, j - 1))}*${i.slice(IntRange(j+1, i.length-1))}"
                if(patternMap[pattern] == null)patternMap[pattern] = ArrayList()
                patternMap[pattern]?.add(i)
            }
        }
        val visited = HashSet<String>()
        visited.add(beginWord)
        var res = 1
        val que = LinkedList<String>()
        que.add(beginWord)
        var size = 1
        while(!que.isEmpty()){
            for(j in 0 until size){
                val temp = que.removeFirst()
                if(temp == endWord)return res
                for(k in temp.indices){
                    val pattern = "${temp.slice(IntRange(0, k - 1))}*${temp.slice(IntRange(k+1, temp.length-1))}"
                    for(i in patternMap[pattern] ?: ArrayList()){
                        if(!visited.contains(i)){
                            que.add(i)
                            visited.add(i)
                        }
                    }
                }
            }
            size = que.size
            res++
        }
        return 0
    }
}

fun main(){
    val b = "hit"
    val e = "cog"
    val arr = listOf("hot","dot","dog","lot","log","cog")
//    val w = WordLadder()
//    println(w.ladderLength(b, e, arr))
    val s = e.slice(IntRange(0, -1))
    println(s.length)
    println(0..-1)//This is an emptyRange
}