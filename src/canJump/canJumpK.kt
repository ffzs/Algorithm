package canJump

class canJumpK {
    fun canJump(nums: IntArray): Boolean {
        // 双指针
        if (nums.size <= 1) return true
        val len = if (nums[nums.size - 1] == 0) nums.size - 1 else nums.size
        for (i in 0 until len) {
            if (nums[i] == 0) {
                for (j in i - 1 downTo 0) {
                    println(nums[j])
                    if (nums[j] - (i - j) > 0) break
                }
                return false
            }
        }
        return true
    }
}