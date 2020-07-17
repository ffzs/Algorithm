package findMedianSortedArrays;

/**
 * @author ffzs
 * @describe
 * @date 2020/5/24
 */
public class Solution2 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length, len = len1+len2;
        if (len<=1) return len1==0? nums2[0]:nums1[0];
        boolean odd = (len&1)==0;
        int i1=0, i2=0, k=(len+1)/2;
        while (true) {
            if (i1 == len1) return odd ? (nums2[i2+k-1] + nums2[i2+k])/2D : nums2[i2+k-1];
            if (i2 == len2) return odd ? (nums1[i1+k-1] + nums1[i1+k])/2D : nums1[i1+k-1];
            if (k ==1){
                if (odd) {
                    if (nums1[i1]<nums2[i2]) {
                        return i1 == len1-1 ? (nums1[i1]+nums2[i2])/2D:(nums1[i1] + Math.min(nums2[i2], nums1[i1+1]))/2D;
                    }else{
                        return i2 == len2-1 ? (nums1[i1]+nums2[i2])/2D:(nums2[i2] + Math.min(nums2[i2+1], nums1[i1]))/2D;
                    }
                }else{
                    return Math.min(nums1[i1], nums2[i2]);
                }
            }
            int mid = k/2;
            int n1 = Math.min(i1 + mid, len1) -1;
            int n2 = Math.min(i2 + mid, len2) -1;
            if (nums1[n1] <= nums2[n2]) {
                k -= n1 - i1 + 1;
                i1 = n1 + 1;
                while (nums2[i2]<nums1[n1]){
                    i2++;
                    k--;
                }
            } else {
                k -= n2 - i2 + 1;
                i2 = n2 + 1;
                while (nums1[i1]<nums2[n2]){
                    i1++;
                    k--;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,6,7}, nums2 = {1,3,4,5};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
