package graph_adv

class Solution{
    fun isAlienSorted(words: Array<String>, order: String): Boolean {
        val mapChar = HashMap<Char?, Int?>(order.length)
        var k = 0
        for(i in order) mapChar[i] = k++
        for(i in IntRange(0, order.length-1)){
            val w1 = words[i]; val w2 = words[i+1]
            for(j in IntRange(i, w1.length)){
                if(j == w2.length)return false
                if(w1[j] != w2[j]){
                    val t = compareValues(mapChar[w1[j]], mapChar[w2[j]])
                    if(t > 0)return false
                }
            }
        }
        return true
    }
}