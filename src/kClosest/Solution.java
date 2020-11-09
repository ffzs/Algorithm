package kClosest;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2020/11/9 上午7:15
 */
public class Solution {

    public int[][] kClosest(int[][] points, int K) {
        int[][] res = new int[K][2];
        long[] tmp = new long[points.length];
        Map<Long, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < tmp.length; i++) {
            long it = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            tmp[i] = it;
            if (!map.containsKey(it)) map.put(it, new ArrayList<>());
            map.get(it).add(i);
        }
        Arrays.sort(tmp);
        int i = 0;
        while (i < K) {
            List<Integer> lst = map.get(tmp[i]);
            for (Integer it : lst) {
                res[i++] = points[it];
            }
        }
        return res;
    }
}
