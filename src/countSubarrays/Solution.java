package countSubarrays;

/**
 * @author: ffzs
 * @Date: 2023/3/16 下午5:17
 */
public class Solution {

    public int countSubarrays(int[] nums, int k) {
        int i = 0;
        while (nums[i] != k) i += 1;
        int n = nums.length;
        int[] cnt = new int[2 * n + 1];
        int diff = 0, res = 1;
        for (int j = i + 1; j < n; j++) {
            diff += nums[j] > k ? 1 : -1;
            if (diff == 0 || diff == 1) res += 1;
            cnt[diff + n] += 1;
        }
        diff = 0;
        for (int j = i-1; j >= 0; j--) {
            diff += nums[j] > k ? 1 : -1;
            if (diff == 0 || diff == 1) res += 1;
            res += cnt[n-diff] + cnt[n-diff + 1];
        }
        return res;
    }

}
