package productExceptSelf;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/4
 */
public class Solution2 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        res[0] = 1;
        for (int i = 1; i < len; i++) {
            res[i] = res[i-1] * nums[i-1];
        }
        int tmp = 1;
        for (int i = len-1; i >= 0 ; i--) {
            res[i] *= tmp;
            tmp *= nums[i];
        }
        return res;
    }
}
