package threeSumClosest;

import java.util.Arrays;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/24
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int left, right;
        int min = Integer.MAX_VALUE;
        int res = target;
        Arrays.sort(nums);
        for (int i = 0; i < len-2; ++i) {
            left = i+1;
            right = len-1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > target) {
                    if ((sum - target) < min) {
                        min = sum - target;
                        res = sum;
                    }
                    right --;
                }
                else if (sum == target) return target;
                else {
                    if ((target - sum) < min) {
                        min = target - sum;
                        res = sum;
                    }
                    left ++;
                }
            }
        }
        return res;
    }
}
