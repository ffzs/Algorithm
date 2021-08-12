package countDigitOne;

/**
 * @author: ffzs
 * @Date: 2021/8/13 上午7:01
 */
public class Solution {

    public int countDigitOne(int n) {
        long m = 1;
        int res = 0;
        while (n >= m) {
            res += (n / (m * 10)) * m + Math.min(Math.max(n % (m * 10) - m + 1, 0), m);
            m *= 10;
        }
        return res;
    }

}
