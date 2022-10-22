package jobScheduling;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/10/22 下午2:49
 */
public class Solution {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] infos = new int[n][3];
        for (int i = 0; i < n; i++) {
            infos[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(infos, (a, b) -> a[1] - b[1]);
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
//            int k = binarySearch(infos, i - 1, infos[i-1][0]);
            int k = 0;
            for (int j = i - 1; j > 0; j--) {
                if (infos[j-1][1] <= infos[i-1][0]) {
                    k = j;
                    break;
                }
            }
            dp[i] = Math.max(dp[i-1], dp[k] + infos[i-1][2]);
        }
        return dp[n];
    }

    private int binarySearch(int[][] infos, int r, int aim) {
        int l = 0;
        while (l < r) {
            int mid = (r + l) >> 1;
            if (infos[mid][1] > aim) {
                r = mid;
            }
            else l = mid + 1;
        }
        return l;
    }

}
