package graph_adv

class AlienDict {
    fun alienOrder(words: Array<String>): String {
        val charMap = HashMap<Char, ArrayList<Char>>()
        for(word in words){
            for(i in word){
                charMap[i] = ArrayList()
            }
        }
        for(i in 0 until words.size - 1){
            val w1 = words[i]; val w2 = words[i+1]
            for(k in w1.indices){
                if(k == w2.length)return ""
                if(k < w2.length && w1[k] != w2[k]){
                    charMap[w1[k]]?.add(w2[k])
                    break
                }
            }
        }
        val visited = HashSet<Char>()
        val beingVisited = HashSet<Char>()
        var res = ""
        fun dfs(c: Char): Boolean{
            beingVisited.add(c)
            visited.add(c)
            for(i in charMap[c].orEmpty()){
                if(!visited.contains(i) && dfs(i)) return true
                else if(beingVisited.contains(i))return true
            }
            beingVisited.remove(c)
            res += c
            return false
        }
        for(i in charMap){
            if(!visited.contains(i.key)){
                if(dfs(i.key)) return ""
            }
        }
        return res.reversed()
    }
}

fun main(){
    val a = AlienDict()
    val words = arrayOf("z","z")
    println(a.alienOrder(words))
}