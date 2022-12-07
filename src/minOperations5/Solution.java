package minOperations5;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/12/7 上午8:29
 */
public class Solution {

    public int minOperations(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if (n1 < n2) return minOperations(nums2, nums1);
        if (n1 > n2 * 6) return -1;

        int sum1 = 0, sum2 = 0;
        for (int i : nums1) {
            sum1 += i;
        }

        for (int i : nums2) {
            sum2 += i;
        }

        return helper(nums1, nums2, sum1, sum2);
    }

    private int helper(int[] nums1, int[] nums2, int sum1, int sum2) {
        if(sum1 == sum2) return 0;
        if (sum1 < sum2) return helper(nums2, nums1, sum2, sum1);
        int[] diff = new int[6];
        for (int value : nums1) {
            diff[value - 1] += 1;
        }

        for (int value : nums2) {
            diff[6 - value] += 1;
        }
        int ret = 0, total = sum1 - sum2;
        for (int i = 5; i > 0; i--) {
            for (int j = diff[i]; j > 0; j--) {
                total -= i;
                ret += 1;
                if (total <= 0) return ret;
            }
        }
        return -1;
    }

}
