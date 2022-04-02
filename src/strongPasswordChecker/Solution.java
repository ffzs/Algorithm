package strongPasswordChecker;

/**
 * @author: ffzs
 * @Date: 2022/4/2 上午8:54
 */
public class Solution {

    public int strongPasswordChecker(String password) {
        char[] cs = password.toCharArray();
        int n = cs.length;

        int lower = 0, upper = 0, digit = 0;
        for (char c : cs) {
            if (c >= 'A' && c <= 'Z') upper = 1;
            else if (c >= 'a' && c <= 'z') lower = 1;
            else if (c >= '0' && c <= '9') digit = 1;
        }

        int label = lower + upper + digit;

        if (n < 6) {
            return Math.max(6 - n, 3 - label);
        }
        else if (n <= 20) {
            int change = 0, cnt = 0;
            char pre = cs[0];
            for (char c : cs) {
                if (c == pre) ++cnt;
                else {
                    change += cnt / 3;
                    cnt = 1;
                    pre = c;
                }
            }
            change += cnt/3;
            return Math.max(change, 3 - label);
        }
        else {
            int change = 0, cnt = 0;
            int[] remain = new int[3];
            char pre = cs[0];
            for (char c : cs) {
                if (pre == c) ++cnt;
                else {
                    if (cnt >= 3) {
                        change += cnt / 3;
                        remain[cnt % 3]++;
                    }
                    cnt = 1;
                    pre = c;
                }
            }
            if (cnt >= 3) {
                change += cnt /3;
                remain[cnt % 3]++;
            }
            int rm = n - 20, cur = rm;
            for (int i = 0; i < 3; i++) {
                if (i == 2) remain[2] = change;
                if (remain[i] != 0 && cur > 0) {
                    int t = Math.min(remain[i] * (i + 1), cur);
                    cur -= t;
                    change -= t / (i + 1);
                }
            }
            return rm + Math.max(change, 3 - label);
        }
    }

}
