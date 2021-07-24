package restoreArray;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2021/7/25 上午6:46
 */
public class Solution {

    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length;
        if (n == 1) return adjacentPairs[0];

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] adjacentPair : adjacentPairs) {
            int a = adjacentPair[0], b = adjacentPair[1];
            if (!map.containsKey(a)) map.put(a, new ArrayList<>());
            if (!map.containsKey(b)) map.put(b, new ArrayList<>());
            map.get(a).add(b);
            map.get(b).add(a);
        }

        int start = 0;
        for (Map.Entry<Integer, List<Integer>> it : map.entrySet()) {
            if (it.getValue().size() == 1) {
                start = it.getKey();
                break;
            }
        }


        int[] res = new int[n+1];
        res[0] = start;
        res[1] = map.get(res[0]).get(0);
        for (int i = 2; i < res.length; i++) {
            List<Integer> l = map.get(res[i-1]);
            res[i] = l.get(0) == res[i-2] ? l.get(1) : l.get(0);
        }
        return res;
    }

}
