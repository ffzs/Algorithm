package findClosestElements;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2022/8/25 下午12:23
 */
public class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int idx = arr.length-1, minV = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i] - x) < minV) {
                minV = Math.abs(arr[i] - x);
                idx = i;
            }
            else if (Math.abs(arr[i] - x) > minV) break;
        }
        int l = idx-1, r = idx+1;
        List<Integer> res = new ArrayList<>();
        k -= 1;
        while (k > 0) {
            if (l < 0) {
                r += k;
                break;
            }
            if (r > arr.length - 1) {
                l -= k;
                break;
            }
            if (x - arr[l] <= arr[r] - x) l -= 1;
            else r += 1;
            k -= 1;
        }
        for (int i = l+1; i <= r-1; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        int l = 0, r = arr.length - k;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (x - arr[mid] > arr[mid + k] - x) l = mid + 1;
            else r = mid;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(arr[l + i]);
        }
        return res;
    }
}
