package splitArray2;

/**
 * @author: ffzs
 * @Date: 2024/1/21 上午10:28
 */
public class Solution {

    public int splitArray(int[] nums, int k) {
        int l = 0, r = 0;
        for (int num : nums) {
            r += num;
            l = Math.max(l, num);
        }
        l = Math.max(l, r/k);
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (isMatch(nums, mid, k)) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    private boolean isMatch(int[] nums, int target, int k) {
        int sum = 0, cnt = 1;
        for (int num : nums) {
            if (sum + num > target) {
                sum = num;
                cnt += 1;
            }
            else {
                sum += num;
            }
        }
        return cnt <= k;
    }

}
