package maxPower;

/**
 * @author: ffzs
 * @Date: 2021/12/1 上午7:33
 */
public class Solution {

    public int maxPower(String s) {
        if (s.length() == 0)
            return 0;
        int cnt = 1;
        int res = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) cnt++;
            else {
                res = Math.max(res, cnt);
                cnt = 1;
            }
        }

        res = Math.max(res, cnt);
        return res;
    }

}
