package intersection2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: ffzs
 * @Date: 2020/11/2 上午11:49
 */
public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> tmp = new HashSet<>();
        for (int i : nums1) {
            for (int i1 : nums2) {
                if (i==i1) tmp.add(i);
            }
        }
        int[] res = new int[tmp.size()];
        int i = 0;
        for (Integer integer : tmp) {
            res[i++] = integer;
        }
        return res;
    }

}
