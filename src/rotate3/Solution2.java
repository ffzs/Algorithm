package rotate3;

/**
 * @author: ffzs
 * @Date: 2021/1/8 下午10:26
 */
public class Solution2 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int[] tmp = new int[k];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = nums[n-k+i];
        }
        for (int i = n-k-1; i >=0; --i) {
            nums[i+k] = nums[i];
        }
        System.arraycopy(tmp, 0, nums, 0, tmp.length);
    }
}
