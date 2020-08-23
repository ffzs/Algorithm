package rangeBitwiseAnd;

/**
 * @author: ffzs
 * @Date: 2020/8/23 上午10:45
 */
public class Solution2 {
    public int rangeBitwiseAnd(int m, int n) {
        while (m < n) {
            n &= n-1;
        }
        return n;
    }
}


