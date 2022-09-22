package canFormArray;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2022/9/22 下午8:07
 */
public class Solution {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < pieces.length; i++) {
            map.put(pieces[i][0], i);
        }
        int i = 0, n = arr.length;
        while (i < n) {
            if (!map.containsKey(arr[i])) return false;
            int[] cur = pieces[map.get(arr[i])];
            for (int value : cur) {
                if (arr[i++] != value) return false;
            }
        }
        return true;
    }

}
