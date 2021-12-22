package repeatedStringMatch;

/**
 * @author: ffzs
 * @Date: 2021/12/22 上午7:31
 */

public class Solution {

    public int repeatedStringMatch(String a, String b) {
        int m = a.length(), n = b.length();
        boolean[] haveLetters = new boolean[26];
        for (int i = 0; i < m; i++) {
            haveLetters[a.charAt(i) - 'a'] = true;
        }

        for (int i = 0; i < n; i++) {
            if (!haveLetters[b.charAt(i) - 'a']) return -1;
        }

        int res = (m + n - 1) / m;
        if (isIn(a.repeat(res), b)) return res;
        res ++;
        if (isIn(a.repeat(res), b)) return res;
        return -1;
    }

    private boolean isIn (String a, String b) {
        char[] ca = a.toCharArray(), cb = b.toCharArray();
        int m = ca.length, n = cb.length;
        boolean flag = true;
        for (int i = 0; i <= m - n; i++) {
            for (int j = 0; j < n; j++) {
                if (cb[j] != ca[j + i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) return true;
            flag = true;
        }
        return false;
    }

}
