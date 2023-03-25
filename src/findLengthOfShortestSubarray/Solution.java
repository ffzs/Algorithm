package findLengthOfShortestSubarray;

/**
 * @author: ffzs
 * @Date: 2023/3/25 上午8:05
 */
public class Solution {

    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int l = 0, r = n - 1;
        while (l + 1 < n && arr[l + 1] >= arr[l]) l += 1;
        if (l == n - 1) return 0;
        while (r - 1 >= 0 && arr[r] >= arr[r-1]) r-=1;
        if (arr[r] >= arr[l]) return r - l - 1;
        if (arr[n-1] < arr[0]) return Math.min(r, n-l-1);
        int res = r;
        for (int i = 0; i < r; i++) {
            while (r < n && arr[r] < arr[i]) r += 1;
            res = Math.min(r - i - 1, res);
            if (arr[i+1] < arr[i]) break;
        }
        return res;
    }
}
