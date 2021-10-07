package findRepeatedDnaSequences;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2021/10/8 上午6:40
 */
public class Solution {

    public List<String> findRepeatedDnaSequences(String s) {
        final int len = 10;
        int[] bin = new int[128];
        bin['A'] = 0;
        bin['T'] = 1;
        bin['G'] = 2;
        bin['C'] = 3;
        char[] cs = s.toCharArray();
        int n = cs.length;
        
        int tmp = 0;

        Set<String> set = new HashSet<>();
        Set<Integer> cnt = new HashSet<>();

        for (int i = 0; i <= (n - len); i++) {
            if (i == 0) {
                for (int j = 0; j < len; j++) {
                    tmp = (tmp << 2) | bin[cs[j]];
                }
            }
            else tmp = ((tmp << 2) | bin[cs[i + len - 1]]) & (( 1 << (len * 2)) - 1);
            if (cnt.contains(tmp)) set.add(s.substring(i, i + len));
            cnt.add(tmp);
        }
        return new ArrayList<>(set);
    }

}
