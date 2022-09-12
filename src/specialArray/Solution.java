package specialArray;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: ffzs
 * @Date: 2022/9/12 下午1:10
 */
public class Solution {

    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = n-1, j = 1; i > 0; i-=1, j+=1) {
            if ((nums[i] == j && nums[i] != nums[i-1]) || (nums[i] > j && nums[i-1] < j)) return j;
        }
        if (nums[0] >= n) return n;
        return -1;
    }
}
