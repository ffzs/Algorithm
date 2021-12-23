package longestDupSubstring;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: ffzs
 * @Date: 2021/12/23 上午8:02
 */
public class Solution {

    long[] p, h;
    static int P = 131;
    public String longestDupSubstring(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a'] ++;
        }
        boolean flag = true;
        for (int i : cnt) {
            if (i > 1) {
                flag = false;
                break;
            }
        }
        if (flag) return "";

        int n = s.length();
        p = new long[n+1];
        h = new long[n+1];

        s = " " + s;
        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            p[i] = p[i-1] * P;
            h[i] = h[i-1] * P + s.charAt(i);
        }

        int l = 0, r = n - 1;
        String res = "";
        while (l < r) {
            int mid = (l + r + 1) >>> 1;
            String cur = check(s, mid);
            if (cur.length() != 0) {
                l = mid;
                if (cur.length() > res.length()) res = cur;
            }
            else r = mid - 1;
        }
        return res;
    }

    private String check (String s, int len) {
        Set<Long> set = new HashSet<>();
        for (int i = 1; i + len - 1 < s.length(); i++) {
            long hash = getHash(i, i + len -1);
            if(set.contains(hash)) {
                return s.substring(i, i+len);
            }
            set.add(hash);
        }
        return "";
    }

    private long getHash (int l, int r) {
        return h[r] - h[l-1] * p[r-l+1];
    }
}


class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestDupSubstring("aa"));
    }
}
