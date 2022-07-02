package minRefuelStops;

/**
 * @author: ffzs
 * @Date: 2022/7/2 下午2:08
 */
public class Solution {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        int[] dp = new int[n + 1];
        dp[0] = startFuel;

        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (dp[j] >= stations[i][0]) {
                    dp[j + 1] = Math.max(dp[j + 1], dp[j] + stations[i][1]);
                }
            }
        }

        for (int i = 1; i < dp.length; i++) {
            if (dp[i] >= target) return i;
        }
        return -1;
    }
    public int minRefuelStops2(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        boolean[] step = new boolean[n];
        int res = 0, maxFuel = 0, idx = 0;

        while (startFuel < target) {
            for (int i = 0; i < n; i++) {
                if (startFuel < stations[i][0]) break;
                if (!step[i] && maxFuel < stations[i][1]) {
                    maxFuel = stations[i][1];
                    idx = i;
                }
            }
            if (maxFuel == 0) return -1;

            startFuel += maxFuel;
            step[idx] = true;
            res += 1;
            maxFuel = 0;
        }
        return res;
    }

}
