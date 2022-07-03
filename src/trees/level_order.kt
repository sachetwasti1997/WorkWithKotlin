package trees

import java.util.*

fun levelOrder(root: TreeNode?): List<List<Int?>> {
    if(root == null) return arrayListOf()
    val q = LinkedList<TreeNode?>()
    val res = mutableListOf<List<Int?>>()
    q.add(root)
    var size = q.size
    while(!q.isEmpty()){
        val tempList = mutableListOf<Int?>()
        for(i in 0 until size){
            val temp = q.pop()
            tempList.add(temp?.`val`)
            if(temp?.left != null) q.add(temp.left)
            if(temp?.right != null) q.add(temp.right)
        }
        size = q.size
        res.add(tempList)
    }
    return res
}