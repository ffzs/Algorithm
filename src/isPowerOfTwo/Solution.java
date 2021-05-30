package isPowerOfTwo;

import kotlin.reflect.jvm.internal.impl.types.UnresolvedType;

/**
 * @author: ffzs
 * @Date: 2021/5/30 上午8:07
 */
public class Solution {

    public boolean isPowerOfTwo(int n) {

        while (n > 1) {
            if ((n & 1) == 1) return false;
            n >>= 1;
        }
        return n == 1;
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPowerOfTwo(-1));
    }
}
