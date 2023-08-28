package numFactoredBinaryTrees;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2023/8/29 上午6:13
 */
public class Solution {
    static final int MOD = (int)1e9 + 7;
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, Long> map = new HashMap<>();
        int n = arr.length;
        int max = arr[n-1];
        for (int i : arr) {
            map.put(i, 1L);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if ((long)arr[i]*arr[j] > max) break;
                int k = arr[i]*arr[j];
                if(map.containsKey(k)) {
                    long v = map.get(arr[i])*map.get(arr[j]);
                    if (i != j) v *= 2;
                    map.merge(k, v % MOD, Long::sum);
                }
            }
        }
        long res = 0;
        for (Map.Entry<Integer, Long> e : map.entrySet()) {
            res += e.getValue();
            if (res >= MOD) res %= MOD;
        }
        return (int)res;
    }
}
