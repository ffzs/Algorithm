package maxNumber;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2020/12/2 上午7:18
 */
public class Solution {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        int[][] tmp = new int[k][2];
        for (int i = 0; i < nums1.length; i++) {
            if (!map.containsKey(nums1[i])) map.put(nums1[i], new ArrayList<>());
            map.get(nums1[i]).add(new int[]{0, i});
        }
        for (int i = 0; i < nums2.length; i++) {
            if (!map.containsKey(nums2[i])) map.put(nums2[i], new ArrayList<>());
            map.get(nums2[i]).add(new int[]{1, i});
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        keys.sort(Comparator.reverseOrder());
        int i = 0;
        int[] idx = new int[]{-1, -1};
        out: for (int key : keys) {
            for (int[] ints : map.get(key)) {
                if (i >= k) break out;
                else {
                    if (ints[1] > idx[ints[0]]) {
                        tmp[i++] = new int[]{key, ints[1]};
                        idx[ints[0]] = ints[1];
                    }
                }
            }
            map.remove(key);
        }

//        Arrays.sort(tmp, Comparator.comparingInt(a -> a[1]));

        int[] res = new int[k];
        for (int j = 0; j < tmp.length; j++) {
            res[j] = tmp[j][0];
        }

        return res;
    }
}
