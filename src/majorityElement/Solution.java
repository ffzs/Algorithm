package majorityElement;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/7/9 上午7:02
 */
public class Solution {

    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        Arrays.sort(nums);
        int aim = nums.length/2;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) count++;
            else count = 1;
            if (count>aim) return nums[i];
        }
        return -1;
    }

    public int majorityElement2(int[] nums) {
        int n = nums.length;
        int pre = -1, count = 0;
        for (int num : nums) {
            if (count == 0) {
                count ++;
                pre = num;
            }
            else if (pre == num) count++;
            else count --;
        }

        if (count>0) {
            int c = 0;
            for (int num : nums) {
                if (num == pre) c++;
            }

            if (c > nums.length /2) return pre;
        }
        return -1;
    }

}
