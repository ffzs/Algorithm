package baseNeg2;

/**
 * @author: ffzs
 * @Date: 2023/4/6 上午8:55
 */
public class Solution {

    public String baseNeg2(int n) {
        if (n == 0 || n == 1) return "" + n;

        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int remain = n & 1;
            sb.append((char)(remain + '0'));
            n -= remain;
            n /= -2;
        }
        return sb.reverse().toString();
    }

}
