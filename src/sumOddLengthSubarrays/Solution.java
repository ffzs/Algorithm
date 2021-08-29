package sumOddLengthSubarrays;

/**
 * @author: ffzs
 * @Date: 2021/8/29 上午8:24
 */
public class Solution {

    public int sumOddLengthSubarrays(int[] arr) {
        int res = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int l = i + 1, r = n - i;
            int l_even = (l + 1) / 2, r_even = (r + 1) /2;
            int l_odd = l/2, r_odd = r/2;
            res += (l_even * r_even + l_odd * r_odd) * arr[i];
        }
        return res;
    }

}
