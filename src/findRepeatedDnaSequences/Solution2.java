package findRepeatedDnaSequences;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2023/11/5 上午5:42
 */
public class Solution2 {
    static final int len = 10;
    public List<String> findRepeatedDnaSequences(String s) {
        int[] map = new int[26];
        map['A'-'A'] = 0;
        map['T'-'A'] = 1;
        map['G'-'A'] = 2;
        map['C'-'A'] = 3;

        char[] cs = s.toCharArray();

        List<String> res = new ArrayList<>();
        if (cs.length < len) return res;
        Map<Integer, Integer> cnt = new HashMap<>();

        int v = 0;
        for (int i = 0; i < len; i++) {
            v = (v << 2) | map[cs[i]-'A'];
        }
        cnt.put(v, 1);

        for (int i = len; i < cs.length; i++) {
            v = ((v << 2) | map[cs[i]-'A'] ) & 0xfffff;
            if (cnt.getOrDefault(v, 0) == 1) res.add(s.substring(i-len+1, i+1));
            cnt.put(v, cnt.getOrDefault(v, 0) + 1);
        }

        return res;
    }

}
