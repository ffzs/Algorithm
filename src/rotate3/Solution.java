package rotate3;

/**
 * @author: ffzs
 * @Date: 2021/1/8 下午10:25
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int[] res = new int[n];

        int i = 0;
        while (i < n) {
            res[k++] = nums[i];
            if (k>=n) k = 0;
            i++;
        }
        System.arraycopy(res, 0, nums, 0, res.length);
    }
}
