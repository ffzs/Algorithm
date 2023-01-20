package findingUsersActiveMinutes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: ffzs
 * @Date: 2023/1/20 下午3:09
 */
public class Solution {

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] res = new int[k];
        for(int[] log : logs) {
            int id = log[0], time = log[1];
            if (!map.containsKey(id)) map.put(id, new HashSet<>());
            map.get(id).add(time);
        }
        for (Map.Entry<Integer, Set<Integer>> entry: map.entrySet()) {
            int size = entry.getValue().size();
            res[size-1] += 1;
        }

        return res;
    }

}
