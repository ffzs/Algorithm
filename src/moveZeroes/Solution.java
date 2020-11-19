package moveZeroes;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2020/11/19 下午6:29
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while (i<nums.length) {
            if(nums[i] != 0) {
                nums[j++] = nums[i];
            }
            i++;
        }
        while (j<nums.length) {
            nums[j++] = 0;
        }
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0, 0, 1};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
