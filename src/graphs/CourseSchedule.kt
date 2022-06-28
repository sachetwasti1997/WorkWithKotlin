package graphs

class CourseSchedule {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val graph = HashMap<Int, ArrayList<Int>>(numCourses)
        val visited = HashSet<Int>(numCourses)
        val isBeingVisited = HashSet<Int>(numCourses)
        for(i in prerequisites){
            if(graph[i[0]] == null)graph[i[0]] = ArrayList()
            graph[i[0]]?.add(i[1])
        }
        fun dfsCycle(node: Int): Boolean{
            visited.add(node)
            isBeingVisited.add(node)
            for(i in graph[node].orEmpty()){
                if(!visited.contains(i) && dfsCycle(i))return true
                else if(isBeingVisited.contains(i))return true
            }
            isBeingVisited.remove(node)
            return false
        }
        for(i in graph){
            if(!visited.contains(i.key)){
                if(dfsCycle(i.key))return false
            }
        }
        return true
    }
}