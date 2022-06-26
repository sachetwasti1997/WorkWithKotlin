package linked_list

fun findDuplicate(nums: IntArray): Int {
    var slow = 0
    var fast = 0
    while (true){
        slow = nums[slow]
        fast = nums[nums[fast]]
        if (slow == fast)break
    }
    var new = 0
    while (new != slow){
        slow = nums[slow]
        new = nums[new]
    }
    return new
}