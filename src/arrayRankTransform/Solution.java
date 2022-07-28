package arrayRankTransform;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2022/7/28 上午10:43
 */
public class Solution {

    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        if (n == 0) return res;
        int[] tmp = Arrays.copyOf(arr, n);
        Arrays.sort(tmp);

        Map<Integer, Integer> map = new HashMap<>();
        map.put(tmp[0], 1);
        int rank = 2;
        for (int i = 1; i < n; i++) {
            if (tmp[i] == tmp[i-1]) continue;
            map.put(tmp[i], rank++);
        }

        for (int i = 0; i < n; i++) {
            res[i] = map.get(arr[i]);
        }
        return res;
    }

}
