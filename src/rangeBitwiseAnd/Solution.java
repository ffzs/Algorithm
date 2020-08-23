package rangeBitwiseAnd;

/**
 * @author: ffzs
 * @Date: 2020/8/23 上午10:04
 */

public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        for (int i = m+1; i <= n&& i>=0; i++) {
            if (m == 0) return 0;
            m &= i;
        }
        return m;
    }
}

class Test {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.rangeBitwiseAnd(5, 7));
    }
}