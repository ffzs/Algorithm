package firstMissingPositive;

import java.util.Arrays;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/27
 */
public class Solution3 {
    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) nums[i] = nums.length + 1;
        }
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (num <= nums.length){
                nums[num-1] = -Math.abs(nums[num-1]);
            }
        }
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) return i+1;
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[] num = {3, 4, -1, 1};
        System.out.println(firstMissingPositive(num));
    }
}
