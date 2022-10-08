package advantageCount;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/10/8 下午1:09
 */
public class Solution {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] res = new int[n];
        int[][] tmp = new int[n][2];
        for (int i = 0; i < n; i++) {
            tmp[i] = new int[] {nums2[i], i};
        }
        Arrays.sort(tmp, (a, b)-> a[0] - b[0]);
        Arrays.sort(nums1);
        int h = 0, t = n - 1;
        for (int i = 0; i < n; i++) {
            if (nums1[i] > tmp[h][0]) {
                res[tmp[h][1]] = nums1[i];
                h += 1;
            }
            else {
                res[tmp[t][1]] = nums1[i];
                t -= 1;
            }
        }
        return res;
    }
}
