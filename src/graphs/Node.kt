package graphs

class Node(var `val`: Int, var neighbors: ArrayList<Node?> = ArrayList()){
    override fun toString(): String {
        var res = ""
        for (i in neighbors)res += "${i?.`val`} "
        return "Node(`val`=$`val`, neighbours=$res)"
    }
}