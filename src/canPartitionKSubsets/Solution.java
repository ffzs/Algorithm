package canPartitionKSubsets;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/9/20 上午10:57
 */
public class Solution {

    int aim, n;
    int[] nums;
    boolean[] visited;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) return false;
        aim = sum / k;
        n = nums.length;
        Arrays.sort(nums);
        if (nums[n-1] > aim) return false;
        this.nums = nums;
        visited = new boolean[1<<n];
        return dfs((1 << n) - 1, aim);
    }

    private boolean dfs (int mask, int r) {
        if (mask == 0) return true;
        if (visited[mask]) return false;
        visited[mask] = true;
        for (int i = 0; i < n; i++) {
            if (nums[i] > r) break;
            if (((mask>>i) & 1) == 1) {
                int nextMask = mask ^ (1 << i), nr = r - nums[i];
                if (dfs(nextMask, nr == 0?aim:nr)) return true;
            }
        }
        return false;
    }

}
