package graph_adv

class AlienDict {
    data class Node(val chr: Char?, var length: Int = 1, var next: Node? = null)
    fun alienOrder(words: Array<String>): String {
        if(words.size == 1){
            var res = ""; val set = HashSet<Char>()
            for(i in 0 until words[0].length - 1)
                if(!set.contains(words[0][i]))res += !set.contains(words[0][i])
            return res
        }
        val charMap = HashMap<Char, Node>()
        for(word in words){
            for(i in word.indices){
                if(charMap[word[i]] == null)charMap[word[i]] = Node(word[i])
            }
        }
        for(i in 0 until words.size - 1){
            val w1 = words[i]; val w2 = words[i+1]
            for(k in w1.indices){
                if(k == w2.length)return ""
                if(k < w2.length && w1[k] != w2[k]){
                    charMap[w1[k]]?.next = charMap[w2[k]]
                    val l1 = charMap[w1[k]]?.length ?: 0
                    val l2 = charMap[w2[k]]?.length ?: 0
                    charMap[w1[k]]?.length = l1 + l2
                    break
                }
            }
        }
        var list = charMap[words[0][0]]
        val set = HashSet<Char?>()
        var res = ""
        while(list != null){
            if(!set.contains(list.chr)){
                res += list.chr
                set.add(list.chr)
            }else{
                res = ""
                break
            }
            list = list.next
        }
        println(charMap)
        return res
    }
}

fun main(){
    val a = AlienDict()
    val words = arrayOf("wrt","wrf","er","ett","rftt")
    println(a.alienOrder(words))
}