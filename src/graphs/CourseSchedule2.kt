package graphs

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class CourseSchedule2 {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        if(prerequisites.isEmpty())return IntArray(numCourses){ i -> i}
        val graph = HashMap<Int, ArrayList<Int>>(numCourses)
        val visited = HashSet<Int>(numCourses)
        val isBeingVisited = HashSet<Int>(numCourses)
        val stk = Stack<Int>()

        for(i in prerequisites){
            if(graph[i[0]] == null)graph[i[0]] = ArrayList()
            graph[i[0]]?.add(i[1])
        }

        fun dfsCycle(node: Int): Boolean{
            visited.add(node)
            isBeingVisited.add(node)
            for(i in graph[node] ?: ArrayList()){
                if(!visited.contains(i) && dfsCycle(i))return true
                else if(isBeingVisited.contains(i))return true
            }
            isBeingVisited.remove(node)
            stk.add(node)
            return false
        }

        for(i in graph)
            if(!visited.contains(i.key) && dfsCycle(i.key))return IntArray(0)

        val sett = stk.toSet()

        for (i in 0 until numCourses)if (!sett.contains(i))stk.add(i)

        return stk.toIntArray();
    }
}

fun main(){
//    val cou = Array<IntArray>(0, )
    val c = CourseSchedule2()
//    c.findOrder(1, cou)
}