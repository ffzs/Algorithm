package minSwap;

/**
 * @author: ffzs
 * @Date: 2022/10/10 下午6:19
 */
public class Solution {

    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length, a = 0, b = 1;
        for (int i = 1; i < n; i++) {
            int aa = n, bb = n;
            if (nums1[i] > nums1[i-1] && nums2[i] > nums2[i-1]) {
                aa = a;
                bb = b + 1;
            }
            if (nums1[i] > nums2[i-1] && nums2[i] > nums1[i-1]) {
                aa = Math.min(aa, b);
                bb = Math.min(bb, a + 1);
            }
            a = aa;
            b = bb;
        }
        return Math.min(a, b);
    }

}
