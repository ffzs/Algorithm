package isPowerOfThree;

/**
 * @author: ffzs
 * @Date: 2021/9/23 上午6:50
 */
public class Solution {

    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

}
