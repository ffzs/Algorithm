package longestWPI;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2023/2/14 上午6:24
 */
public class Solution {

    public int longestWPI(int[] hours) {
        int n = hours.length, res = 0;
        int[] cumSum = new int[n + 1];
        int idx = 0;
        int[] stk = new int[n+1];
        for (int i = 0; i < n; i++) {
            cumSum[i+1] = cumSum[i] + (hours[i] > 8?1:-1);
            if (cumSum[i+1] < cumSum[stk[idx]]) stk[++idx] = i + 1;
        }
        for (int r = n; r >= 1; r--) {
            while (idx >= 0 && cumSum[stk[idx]] < cumSum[r]) {
                res = Math.max(res, r - stk[idx]);
                idx--;
            }
        }
        return res;
    }

}
