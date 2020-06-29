package findKthLargest;

import java.util.Arrays;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/29
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
