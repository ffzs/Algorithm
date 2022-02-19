package pancakeSort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2022/2/19 上午8:33
 */
public class Solution {

    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int n = arr.length;
        for (int i = n; i > 1; --i) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                if (arr[j] >= arr[max]) max = j;
            }
            if (max == i - 1) continue;
            reverse(arr, max);
            res.add(max+1);
            reverse(arr, i - 1);
            res.add(i);
        }
        return res;
    }

    private void reverse(int[] arr, int max) {
        int l = 0, r = max;
        while(l < r) {
            int tmp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = tmp;
        }
    }

}
