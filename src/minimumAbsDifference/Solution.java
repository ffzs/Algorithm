package minimumAbsDifference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2022/7/4 上午10:25
 */
public class Solution {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int diff = Integer.MAX_VALUE, n = arr.length;
        for (int i = 0; i < n-1; i++) {
            diff = Math.min(diff, arr[i+1]-arr[i]);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            if (arr[i+1] - arr[i] == diff) res.add(List.of(arr[i], arr[i+1]));
        }
        return res;
    }

}
