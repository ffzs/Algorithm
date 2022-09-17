package maxLengthBetweenEqualCharacters;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/9/17 下午2:36
 */
public class Solution {

    public int maxLengthBetweenEqualCharacters(String s) {
        int[] idx = new int[26];
        Arrays.fill(idx, -1);
        int res = -1;
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            int cur = cs[i] - 'a';
            if (idx[cur] == -1) idx[cur] = i;
            else res = Math.max(res, i - idx[cur] - 1);
        }
        return res;
    }
}
