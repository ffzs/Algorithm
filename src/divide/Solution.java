package divide;

/**
 * @author: ffzs
 * @Date: 2021/10/12 上午6:50
 */
public class Solution {

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) return Integer.MAX_VALUE;
            if (divisor == 1) return Integer.MIN_VALUE;
        }

        long res = 0;
        long m = Math.abs((long)dividend), n = Math.abs((long)divisor);
        boolean sign = false;
        if ((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)) sign = true;

        while (m >= n) {
            long d = n, c = 1;
            while (m >= (d << 1)){
                d <<= 1;
                c <<= 1;
            }
            res += c;
            m -= d;
        }
        return sign?(int)res:(int)-res;
    }

}
