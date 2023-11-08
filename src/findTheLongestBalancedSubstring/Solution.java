package findTheLongestBalancedSubstring;

/**
 * @author: ffzs
 * @Date: 2023/11/8 上午8:30
 */
public class Solution {

    public int findTheLongestBalancedSubstring(String s) {
        int res = 0;
        char[] cs = s.toCharArray();
        int n = cs.length;
        int i = 0;
        while (i < n && cs[i] == '1') i++;

        int zero, one;
        while (i < n) {
            zero = 0;
            one = 0;
            while (i < n && cs[i] == '0') {
                i++;
                zero++;
            }
            while (i<n && cs[i] == '1') {
                i++;
                one++;
            }
            res = Math.max(res, Math.min(zero, one));
        }

        return res*2;
    }

}
