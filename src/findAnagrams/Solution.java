package findAnagrams;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2021/11/28 上午7:29
 */
public class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) return new ArrayList<>();
        int[] cp = new int[26];
        int[] cs = new int[26];
        int n = p.length();
        for (char c : p.toCharArray()) {
            cp[c - 'a'] ++;
        }

        List<Integer> res = new ArrayList<>();
        int l = 0, r = 0;
        while (r < s.length()) {
            int cur = s.charAt(r) - 'a';
            cs[cur]++;
            while (cs[cur] > cp[cur]) cs[s.charAt(l++) - 'a'] --;
            if (r - l + 1 == n) res.add(l);
            r ++;
        }
        return res;
    }

}
