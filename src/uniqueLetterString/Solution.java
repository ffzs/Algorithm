package uniqueLetterString;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/9/6 下午8:03
 */
public class Solution {

    public int uniqueLetterString(String s) {
        char[] cs = s.toCharArray();
        int[] back = new int[26], pre = new int[26];
        Arrays.fill(back, -1);
        Arrays.fill(pre, -1);

        int res = 0;
        for (int i = 0; i < cs.length; i++) {
            int idx = cs[i] - 'A';
            if (pre[idx] != -1) {
                res += (pre[idx] - back[idx]) * (i - pre[idx]);
                back[idx] = pre[idx];
            }
            pre[idx] = i;
        }

        for (int i = 0; i < 26; i++) {
            if (pre[i] != -1) res += (pre[i] - back[i]) * (cs.length - pre[i]);
        }
        return res;
    }
}
