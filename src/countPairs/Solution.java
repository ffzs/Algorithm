package countPairs;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2021/7/7 上午6:54
 */
public class Solution {

    public int countPairs(int[] deliciousness) {
        int MOD = 1_000_000_000 + 7;
        int max = deliciousness[0], min = deliciousness[1];
        for (int i : deliciousness) {
            if (i > max) max = i;
            else if (i < min) min = i;
        }

        int[] map = new int[max - min + 1];
        int res = 0;
        for (int v : deliciousness) {
            for (int i = 1; ; i <<= 1) {
                int x = i - v;
                if (x > max) break;
                if (x < min) continue;
                res = (res + map[x - min]) % MOD;
            }
            map[v - min] ++;
        }
        return res;
    }
}
