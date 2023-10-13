package avoidFlood;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author: ffzs
 * @Date: 2023/10/13 上午9:47
 */
public class Solution {

    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] res = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> blank = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                blank.add(i);
            }
            else {
                int pool = rains[i];
                res[i] = -1;
                if (map.containsKey(pool)) {
                    Integer idx = blank.ceiling(map.get(pool));
                    if (idx == null) return new int[0];
                    res[idx] = pool;
                    blank.remove(idx);
                }
                map.put(pool, i);
            }
        }

        for (int i = 0; i < n; i++) {
            if (res[i] == 0) res[i] = 1;
        }

        return res;
    }

}
