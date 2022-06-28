package wiggleSort;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/6/28 下午3:02
 */
public class Solution {

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] tmps = Arrays.copyOf(nums, n);
        int i = 0;
        for (int j = n % 2==0? n-2 : n-1; j >= 0; j-=2) {
            nums[j] = tmps[i++];
        }
        for (int j = n % 2==1? n-2 : n-1; j >= 0; j-=2) {
            nums[j] = tmps[i++];
        }
    }

}
