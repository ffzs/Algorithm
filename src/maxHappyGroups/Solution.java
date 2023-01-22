package maxHappyGroups;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2023/1/22 上午11:47
 */
public class Solution {

    Map<Integer, Integer> memo = new HashMap<>();
    int batchSize;
    final int WIDTH = 5, WIDTH_M = (1 << WIDTH) - 1;
    int[] remain;
    public int maxHappyGroups(int batchSize, int[] groups) {
        this.batchSize = batchSize;
        int[] cnt = new int[batchSize];
        int res = 0;
        for (int group : groups) {
            group %= batchSize;
            if (group == 0) res += 1;
            else if (cnt[batchSize - group] > 0) {
                res += 1;
                cnt[batchSize - group] -= 1;
            }
            else cnt[group] += 1;
        }

        int mask = 0, n = 0;
        for (int i : cnt) {
            if (i > 0) n += 1;
        }
        remain = new int[n];
        for (int i = 1; i < batchSize; i++) {
            if (cnt[i] > 0) {
                remain[--n] = i;
                mask = (mask << WIDTH) | cnt[i];
            }
        }

        return res + dfs(mask);
    }

    private int dfs (int mask) {
        if (memo.containsKey(mask)) return memo.get(mask);
        int left = mask >> 20, mk = mask & ((1<<20)-1), ret = 0;
        for (int i = 0, j = 0; i < remain.length; i++, j += 5) {
            if((mk>>j & WIDTH_M) > 0) {
                ret = Math.max(ret, (left == 0? 1:0) + dfs(((left + remain[i]) % batchSize) << 20 | mk - (1 << j)));
            }
        }
        memo.put(mask, ret);
        return ret;
    }

}
