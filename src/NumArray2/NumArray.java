package NumArray2;

import javax.lang.model.util.Elements;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author: ffzs
 * @Date: 2022/4/4 上午8:31
 */
public class NumArray {
    int[] nums, tree;
    int sum = 0;
    public NumArray(int[] nums) {
        this.nums = nums;
        tree = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            add(i + 1, nums[i]);
        }
    }

    private int lowBit(int x) {
        return x & -x;
    }

    private void add (int idx, int val) {
        while (idx < tree.length) {
            tree[idx] += val;
            idx += lowBit(idx);
        }
    }

    public void update(int index, int val) {
        add(index + 1, val - nums[index]);
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return preSum(right + 1) - preSum(left);
    }

    private int preSum (int idx) {
        sum = 0;
        while (idx > 0) {
            sum += tree[idx];
            idx -= lowBit(idx);
        }
        return sum;
    }

}
