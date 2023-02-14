package isGoodArray;

/**
 * @author: ffzs
 * @Date: 2023/2/15 上午6:42
 */
public class Solution {

    public boolean isGoodArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = gcd(res, nums[i]);
            if (res == 1) break;
        }
        return res == 1;
    }

    private int gcd (int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

}
