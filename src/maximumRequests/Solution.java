package maximumRequests;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/2/28 上午8:17
 */
public class Solution {

    public int maximumRequests(int n, int[][] requests) {
        int[] num = new int[n];
        int res = 0, m = requests.length;

        for (int mask = (1 << m) - 1; mask > 0; mask--) {
            int cnt = Integer.bitCount(mask);
            if (cnt <= res) continue;

            Arrays.fill(num, 0);
            for (int i = 0; i < m; i++) {
                if ((mask & (1 << i)) != 0) {
                    ++num[requests[i][0]];
                    --num[requests[i][1]];
                }
            }

            boolean flag = true;
            for (int i : num) {
                if (i != 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) res = cnt;
        }
        return res;
    }

}
