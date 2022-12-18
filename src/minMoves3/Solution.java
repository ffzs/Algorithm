package minMoves3;

/**
 * @author: ffzs
 * @Date: 2022/12/18 上午9:26
 */
public class Solution {

    public int minMoves(int[] nums, int k) {
        int n = nums.length;
        int[] ones = new int[n];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) ones[idx++] = i;
        }

        int cnt = 0;
        for (int i = 1; i < k; i++) {
            cnt += (ones[i] - ones[i-1] - 1) * Math.min(i, k - i);
        }

        int res = cnt, mid = k / 2;
        for (int i = k; i < idx; i++) {
            cnt -= ones[i-k+mid] - ones[i-k];
            cnt += ones[i] - ones[i-mid];
            res = Math.min(res, cnt);
        }
        return res;
    }

}
