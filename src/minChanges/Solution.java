package minChanges;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2021/5/25 上午7:50D
 */
public class Solution {

    public int minChanges(int[] nums, int k) {
        int len = 1 << 10, INF = Integer.MAX_VALUE >> 1;

        int n = nums.length;
        int[] f = new int[len];
        Arrays.fill(f, INF);

        f[0] = 0;

        for (int i = 0; i < k; i++) {
            Map<Integer, Integer> counter = new HashMap<>();
            int size = 0;
            for (int j = i; j < n; j+=k) {
                counter.put(nums[j], counter.getOrDefault(nums[j], 0) + 1);
                size++;
            }

            int min = INF;
            for (int j : f) {
                min = Math.min(j, min);
            }
            int[] g = new int[len];

            Arrays.fill(g, min + size);

            for (int j = 0; j < len; j++) {
                for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
                    int x = entry.getKey(), c = entry.getValue();
                    g[j] = Math.min(g[j], f[j ^ x] - c + size);
                }
            }
            f = g;
        }
        return f[0];
    }

}
