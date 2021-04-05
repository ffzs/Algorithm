package merge2;

/**
 * @author: ffzs
 * @Date: 2021/4/5 下午2:48
 */
public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[m + n];
        int mi = 0, ni = 0;

        for (int i = 0; i < tmp.length; i++) {
            if (mi > m- 1) tmp[i] = nums2[ni++];
            else if (ni > n - 1) tmp[i] = nums1[mi++];
            else tmp[i] = nums1[mi] > nums2[ni] ? nums2[ni++] : nums1[mi++];
        }

        System.arraycopy(tmp, 0, nums1, 0, tmp.length);
    }

}
