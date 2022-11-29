package minOperations3;

/**
 * @author: ffzs
 * @Date: 2022/11/29 下午8:38
 */
public class Solution {

    public int minOperations(String s) {
        int res = 0;
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] - '0' == (i & 1)) res += 1;
        }
        return Math.min(res, cs.length - res);
    }

}
