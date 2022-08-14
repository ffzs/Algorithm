package maxScore2;

/**
 * @author: ffzs
 * @Date: 2022/8/14 下午1:17
 */
public class Solution {

    public int maxScore(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int a = cs[0] == '0' ? 1 : 0;
        int b = 0;
        for (int i = 1; i < n; i++) {
            b += cs[i] - '0';
        }
        int res = a + b;
        for (int i = 1; i < n-1; i++) {
            if (cs[i] == '0') a += 1;
            else b -= 1;
            res = Math.max(res, a + b);
        }
        return res;
    }

}
