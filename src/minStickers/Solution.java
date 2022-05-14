package minStickers;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2022/5/14 上午8:32
 */
public class Solution {

    int[][] counter;
    int[] memo;
    int n;
    public int minStickers(String[] stickers, String target) {
        n = target.length();
        memo = new int[1 << n];
        Arrays.fill(memo, n);
        memo[0] = 0;

        counter = new int[stickers.length][26];
        Map<Character, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < stickers.length; i++) {
            int[] cnt = counter[i];
            for (char c : stickers[i].toCharArray()) {
                ++cnt[c - 'a'];
                if (!map.containsKey(c)) map.put(c, new HashSet<>());
                map.get(c).add(i);
            }
        }

        for (int mask = 0; mask < (1 << n) - 1; mask++) {
            if (memo[mask] == n) continue;

            int ci = -1;
            for (int i = 0; i < n; i++) {
                if (((1 << i) & mask)==0) {
                    ci = i;
                    break;
                }
            }
            if (ci == -1) break;
            char c = target.charAt(ci);
            if (!map.containsKey(c)) return -1;

            Set<Integer> set = map.get(c);
            for (int it : set) {
                int[] cnt = Arrays.copyOf(counter[it], 26);
                int next = mask;
                for (int i = 0; i < n; i++) {
                    if (((1 << i) & mask) == 0) {
                        int j = target.charAt(i) - 'a';
                        if (cnt[j] > 0) {
                            --cnt[j];
                            next |= (1 << i);
                        }
                    }
                }
                memo[next] = Math.min(memo[next], memo[mask] + 1);
            }

        }
        return memo[(1 << n) - 1];
    }

}
