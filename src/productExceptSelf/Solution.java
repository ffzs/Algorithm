package productExceptSelf;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/4
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len], right = new int[len], res = new int[len];
        left[0] = nums[0];
        right[len-1] = nums[len-1];
        for (int i = 1; i < len; ++i) {
            left[i] = left[i-1]*nums[i];
            right[len-1-i] = right[len-i]*nums[len-1-i];
        }
        res[0] = right[1];
        res[len-1] = left[len-2];
        for (int i = 1; i < len-1; i++) {
            res[i] = left[i-1]*right[i+1];
        }
        return res;
    }
}
