package nextPermutation;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2020/11/10 上午9:14
 */

public class Solution {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i>=0 && nums[i] >= nums[i+1]) {
            i--;
        }
        if (i>=0){
            int j = nums.length - 1;
            while (j > i && nums[i] >= nums[j]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i+1, nums.length-1);
    }

    private void swap (int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l++, r--);
        }
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,3,1};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}