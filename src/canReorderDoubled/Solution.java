package canReorderDoubled;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author: ffzs
 * @Date: 2022/4/1 上午8:12
 */
public class Solution {

    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int it = 0;
        Arrays.sort(arr);
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : arr) {
            if (!map.containsKey(i)) continue;
            if (i > 0) {
                if (map.get(i) > 0) it = map.get(i) * 2;
            }
            else {
                if (map.get(i) % 2 != 0) return false;
                it = map.get(i) / 2;
            }
            if (!map.containsKey(it)) return false;
            map.put(it, map.get(it) - map.get(i));
            if (map.get(it) < 0) return false;
        }
        return true;
    }
}
