package canCross;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: ffzs
 * @Date: 2021/4/29 下午3:35
 */
public class Solution {
    Set<Integer> mark;
    Map<Integer, Integer> map;
    int[] stones;
    public boolean canCross(int[] stones) {
        if (stones[1] != 1) return false;
        this.stones = stones;
        map = new HashMap<>();
        mark = new HashSet<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], i);
        }
        return dfs(1, 1);
    }

    private boolean dfs (int index, int k) {
        if (index == stones.length - 1) return true;
        else if (index >= stones.length) return false;

        int cur = stones[index];
        int label = index * 1000 + k;
        if (mark.contains(label)) return false;
        else mark.add(label);

        for (int i = cur + k - 1; i <= cur + k + 1; i++) {
            if (map.containsKey(i) && i > cur && dfs (map.get(i), i - cur)) return true;
        }
        return false;
    }

}
