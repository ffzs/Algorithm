package canReorderDoubled;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2022/4/1 上午8:12
 */
public class Solution {

    public boolean canReorderDoubled(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i : arr) {
            if (!map.containsKey(i)) continue;
            if (map.containsKey(i * 2)) {
                pick(map, i, i * 2);
            }
            else if (i % 2 == 0 && map.containsKey(i / 2)) {
                pick(map, i, i / 2);
            }
            else return false;
        }
        return map.size() == 0;
    }

    private void pick (Map<Integer, Integer> map, int i, int it) {
        int v1 = map.get(it), v2 = map.get(i);
        if (v1 == 1) map.remove(it);
        else map.put(it, v1 - 1);
        if (v2 == 1) map.remove(i);
        else map.put(i, v2 - 1);
    }

}
