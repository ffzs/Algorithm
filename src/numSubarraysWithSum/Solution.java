package numSubarraysWithSum;

/**
 * @author: ffzs
 * @Date: 2021/7/8 上午6:54
 */
public class Solution {

    public int numSubarraysWithSum(int[] nums, int goal) {
        return mostK(nums, goal) - mostK(nums, goal-1);
    }

    private int mostK(int[] nums, int k) {
        if (k < 0) return 0;
        int i = 0, ret = 0;

        for (int j = 0; j < nums.length; j++) {
            k -= nums[j];
            while (k < 0){
                k += nums[i++];
            }
            ret += j-i+1;
        }
        return ret;
    }

}
