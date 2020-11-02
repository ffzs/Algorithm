package intersection2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: ffzs
 * @Date: 2020/11/2 下午12:36
 */
public class Solution2 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        if (nums1.length> nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        for (int i : nums1) set1.add(i);

        for (int i : nums2) {
            if (set1.contains(i)) set2.add(i);
        }
        int[] res = new int[set2.size()];
        int i = 0;
        for (Integer integer : set2) {
            res[i++] = integer;
        }
        return res;
    }
}
