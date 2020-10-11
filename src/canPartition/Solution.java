package canPartition;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2020/10/11 上午8:52
 */

public class Solution {
    boolean[] tmp;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if ((sum&1)==1) return false;
        sum /= 2;
        tmp = new boolean[sum*100+nums.length];
        return dfs(0, sum, nums);
    }

    private boolean dfs (int idx, int sum, int[] nums) {
        if (sum == 0) return true;
        if (sum < 0 || idx > nums.length-1) return false;
        if (tmp[sum*100+idx]) return false;
        if (dfs(idx+1, sum-nums[idx], nums) || dfs(idx+1, sum, nums)) return true;
        else {
            tmp[sum*100+idx] = true;
            return false;
        }
    }
}
