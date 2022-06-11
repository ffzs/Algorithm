package minFlipsMonoIncr;

/**
 * @author: ffzs
 * @Date: 2022/6/11 上午9:33
 */
public class Solution {

    public int minFlipsMonoIncr(String s) {
        char[] cs = s.toCharArray();
        int one = 0, dp = 0;
        for (char c : cs) {
            if (c == '1') one += 1;
            else dp = Math.min(dp + 1, one);
        }
        return dp;
    }
}
