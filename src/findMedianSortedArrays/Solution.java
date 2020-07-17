package findMedianSortedArrays;

import javax.xml.stream.XMLInputFactory;
import java.util.Arrays;

/**
 * @author ffzs
 * @describe
 * @date 2020/5/24
 */
public class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len==1) return nums1.length==0? nums2[0]:nums1[0];
        int[] mid = new int[2];
        int i1 = 0, i2 = 0, ia = 0;
        int num;
        while (ia <= (len+1)/2){
            if(i1<nums1.length && i2<nums2.length){
                if (nums1[i1] < nums2[i2]) {
                    num = nums1[i1];
                    i1++;
                } else {
                    num = nums2[i2];
                    i2++;
                }
            } else {
                if (i1<nums1.length) {
                    num = nums1[i1];
                    i1++;
                } else {
                    num = nums2[i2];
                    i2++;
                }
            }
            if (ia==(len+1)/2-1) mid[0] = num;
            else if (ia==(len+1)/2) mid[1] = num;
            ia++;
        }
        return (len&1)==1? (double) mid[0]:(mid[0]+mid[1])/2.0D;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3}, nums2 = {2,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
