package minAbsoluteSumDiff;

import java.util.Arrays;

import static java.util.Arrays.binarySearch;

/**
 * @author: ffzs
 * @Date: 2021/7/14 上午6:54
 */
public class Solution {

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int mod = 1000000007;
        int n = nums1.length;
        int[] tmp = new int[n];
        System.arraycopy(nums1, 0, tmp, 0, n);

        Arrays.sort(tmp);
        int sum = 0, max = 0;

        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + diff) % mod;
            int j = binarySearch(tmp, nums2[i]);
            if (j < n) max = Math.max(max, diff - (tmp[j] - nums2[i]));
            if (j > 0) max = Math.max(max, diff - (nums2[i] - tmp[j-1]));
        }
        return (sum - max + mod) % mod;
    }


    private int binarySearch(int[] tmp, int i) {
        int l = 0, r = tmp.length - 1;
        if (tmp[r] < i) return tmp.length;

        while (l < r) {
            int mid = (l + r) >>> 1;

            if (tmp[mid] < i) l = mid + 1;
            else r = mid;
        }
        return l;
    }

}
