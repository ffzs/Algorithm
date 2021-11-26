package Solution2;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2021/11/27 上午7:30
 */
public class Solution {
    private int l;
    private Random random;
    Map<Integer, Integer> map;
    int m, n;
    public Solution(int m, int n) {
        this.m = m;
        this.n = n;
        l = m * n;
        random = new Random();
        map = new HashMap<>();
    }

    public int[] flip() {
        int idx = random.nextInt(l--);
        int cur = map.getOrDefault(idx, idx);
        map.put(idx, map.getOrDefault(l, l));
        return new int[]{cur/n, cur%n};
    }

    public void reset() {
        map.clear();
        l = m * n;
    }
}