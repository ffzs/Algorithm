package fourSumCount;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2020/11/27 上午7:24
 */
public class Solution {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n = A.length;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>(n * n, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cur = A[i] + B[j];
                map.merge(cur, 1, Integer::sum);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cur = C[i] + D[j];
                if (map.containsKey(-cur)) res += map.get(-cur);
            }
        }

        return res;
    }
}
