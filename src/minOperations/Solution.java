package minOperations;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2021/7/26 上午6:07
 */
public class Solution {

    public int minOperations(int[] target, int[] arr) {
        int n = target.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(target[i], i);

        List<Integer> lst = new ArrayList<>();
        int[] tmp = new int[n];
        int len = 0;
        for (int i : arr) {
            if (map.containsKey(i)) {
                int idx = map.get(i);
                if (len == 0 || tmp[len-1] < idx) {
                    tmp[len++] = idx;
                }
                else {
                    tmp[binarySearch(tmp, idx, len)] = idx;
                }
            }
        }
        return n - len;
    }


    private int binarySearch (int[] tmp, int target, int len) {
        int l = 0, h = len-1;
        while (l < h) {
            int mid = (l + h) >>> 1;
            if (tmp[mid] < target) l = mid + 1;
            else h = mid;
        }
        return l;
    }
}
