package NumArray;

/**
 * @author: ffzs
 * @Date: 2021/3/1 上午9:19
 */
public class NumArray {
    private int[] res;

    public NumArray(int[] nums) {
        if (nums.length == 0) return;
        this.res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) return res[j];
        return res[j] - res[i-1];
    }
}
