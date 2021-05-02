package leastBricks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2021/5/2 上午7:58
 */
public class Solution {

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> list : wall) {
            int sum = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                sum += list.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int res = 0;
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            int v = item.getValue();
            if (v != 0 && v > res) res = v;
        }

        return wall.size() - res;
    }
}
