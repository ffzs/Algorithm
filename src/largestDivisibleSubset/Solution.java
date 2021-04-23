package largestDivisibleSubset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2021/4/23 上午9:05
 */
public class Solution {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.sort(nums);
        int maxSize = 0, maxValue = 1;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i]%nums[j] == 0) dp[i] = Math.max(dp[j]+1, dp[i]);
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxValue = nums[i];
            }
        }
        List<Integer> res = new ArrayList<>();
        if (maxSize == 1) {
            res.add(nums[0]);
            return res;
        }

        for (int i = n - 1; i >= 0 && maxSize > 0; i--) {
            if (dp[i] == maxSize && maxValue % nums[i] == 0) {
                maxValue = nums[i];
                res.add(maxValue);
                maxSize--;
            }
        }

        return res;
    }

}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3};
        System.out.println(solution.largestDivisibleSubset(nums));
    }
}