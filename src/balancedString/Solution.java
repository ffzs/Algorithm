package balancedString;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2023/2/13 上午11:29
 */
public class Solution {
    static final char[] items = {'Q', 'W', 'E', 'R'};
    public int balancedString(String s) {
        char[] cs = s.toCharArray();
        int cut = s.length() / 4;
        int[] cnt = new int[128];
        for (char c : cs) {
            cnt[c] += 1;
        }
        int more = 0;
        int[] bal = new int[3];
        int idx = 0;
        for (char c : items) {
            if (cnt[c] > cut) {
                bal[idx++] = c;
                more += cnt[c] - cut;
            }
        }
        if (more == 0) return 0;
        int l = 0, r = 0, res = s.length();
        while (l + more <= cs.length) {
            while (r < cs.length && !check(cnt, bal, cut, idx)) {
                cnt[cs[r++]] -= 1;
            }
            if (r == cs.length && !check(cnt, bal, cut, idx)) {
                break;
            }
            res = Math.min(res, r - l);
            cnt[cs[l++]] += 1;
        }
        return res;
    }

    private boolean check (int[] cnt, int[] bal, int cut, int idx) {
        for (int i = 0; i < idx; i++) {
            if (cnt[bal[i]] > cut) return false;
        }
        return true;
    }

}
