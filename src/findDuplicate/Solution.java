package findDuplicate;

/**
 * @author ffzs
 * @describe
 * @date 2020/5/26
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        boolean[] tmp = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (!tmp[nums[i]]) tmp[nums[i]]=true;
            else return nums[i];
        }

        return nums[0];
    }
}


class Solution2 {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (fast != slow);

        slow = nums[0];
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}