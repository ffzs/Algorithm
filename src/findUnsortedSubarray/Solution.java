package findUnsortedSubarray;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/8/3 上午6:54
 */
public class Solution {

    public int findUnsortedSubarray(int[] nums) {
        int[] tmp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(tmp);
        int i = 0, j = nums.length - 1;
        while (i < nums.length && tmp[i] == nums[i]) i++;
        while (j > i && tmp[j] == nums[j]) j--;
        return j - i + 1;
    }


    public int findUnsortedSubarray2(int[] nums) {
        int n = nums.length;
        int max = nums[0], min = nums[n - 1];
        int begin = 0, end = -1;

        for (int i = 0, j = n - 1; i < n; i++, j--) {
            if (nums[i] < max) end = i;
            else max = nums[i];
            if (nums[j] > min) begin = j;
            else min = nums[j];
        }
        return end - begin + 1;
    }

}
