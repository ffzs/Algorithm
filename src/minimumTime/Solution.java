package minimumTime;

import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2024/1/19 下午8:10
 */
public class Solution {

    public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
        int n = nums1.size();
        int s1 = 0, s2 = 0;
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            int a = nums1.get(i), b = nums2.get(i);
            nums[i][0] = b;
            nums[i][1] = a;
            s1 += a;
            s2 += b;
        }

        Arrays.sort(nums, (a, b) -> a[0] - b[0]);

        int[][] dp = new int[n + 1][n + 1];

        for (int j = 1; j < n + 1; j++) {
            int b = nums[j-1][0], a = nums[j-1][1];
            for (int i = j; i > 0; i--) {
                dp[j][i] = Math.max(dp[j-1][i], dp[j-1][i-1] + i * b + a);
            }
        }

        for (int i = 0; i <= n; i++) {
            if (s2 * i + s1 - dp[n][i] <= x) return i;
        }

        return -1;
    }

}
